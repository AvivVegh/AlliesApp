package vegh.aviv.alliesapp.globals.managers

import com.google.gson.Gson
import com.google.gson.JsonElement
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import vegh.aviv.alliesapp.globals.entities.models.Token
import vegh.aviv.alliesapp.globals.entities.models.User
import java.util.concurrent.TimeUnit


/**
 * Created by avivvegh on 19/05/2017.
 */
object RestManager {

    const val BaseUrl = "https://hidden-earth-37442.herokuapp.com/api/"
    private var userApi: UserApi? = null
    private var tokenApi: TokenApi? = null

    private var gson: Gson? = null

    init {
        initializeRetrofit()
    }

    private fun initializeRetrofit() {
        gson = Gson()


        val retrofit = Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpClient.Builder()
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(60, TimeUnit.SECONDS).build())
                .build()

        userApi = retrofit.create(UserApi::class.java)
        tokenApi = retrofit.create(TokenApi::class.java)

    }

    fun register(email: String, password: String): Observable<User>? {
        return userApi?.register(email, password)
                ?.flatMap({ jsonElement: JsonElement ->
                    val user: User = gson?.fromJson(jsonElement, User::class.java)!!

                    DBManager.insertUser(user).map({
                        user
                    })
                })?.flatMap({ user ->
            auth(user)?.map({
                user
            })
        })
                ?.subscribeOn(Schedulers.newThread())
                ?.observeOn(AndroidSchedulers.mainThread())
    }

    fun login(email: String, password: String): Observable<User>? {
        return userApi?.login(email, password)
                ?.map({ jsonElement: JsonElement -> gson?.fromJson(jsonElement, User::class.java)!! })
                ?.subscribeOn(Schedulers.newThread())
                ?.observeOn(AndroidSchedulers.mainThread())
    }

    fun update(email: String): Observable<User>? {
        return refreshTokenIfNeeded()?.flatMap({ boolean ->
            userApi?.update(email)
                    ?.map({ jsonElement: JsonElement -> gson?.fromJson(jsonElement, User::class.java)!! })
        })?.subscribeOn(Schedulers.newThread())
                ?.observeOn(AndroidSchedulers.mainThread())
    }

    fun find(id: String): Observable<User>? {
        return refreshTokenIfNeeded()?.flatMap({ boolean ->
            userApi?.find(id)
                    ?.map({ jsonElement: JsonElement ->
                        val user: User = gson?.fromJson(jsonElement, User::class.java)!!
                        DBManager.insertUser(user)
                        user
                    })
        })?.subscribeOn(Schedulers.newThread())
                ?.observeOn(AndroidSchedulers.mainThread())
    }

    fun delete(id: String): Observable<User>? {
        return refreshTokenIfNeeded()?.flatMap({ boolean ->
            userApi?.delete(id)
                    ?.map({ jsonElement: JsonElement ->
                        gson?.fromJson(jsonElement, User::class.java)!!
                    })
        })?.subscribeOn(Schedulers.newThread())
                ?.observeOn(AndroidSchedulers.mainThread())
    }

    fun auth(user: User): Observable<Boolean>? {
        return tokenApi?.auth(user.email)?.map({ jsonElement: JsonElement ->
            val token = gson?.fromJson(jsonElement, Token::class.java)!!
            AppManager.token = token
            true
        })?.subscribeOn(Schedulers.newThread())
                ?.observeOn(AndroidSchedulers.mainThread())
    }

    fun refreshTokenIfNeeded(): Observable<Boolean>? {
        val expiresTime: Long? = AppManager.token?.expiresIn

        if (expiresTime != null && expiresTime < System.currentTimeMillis() + 3000) {
            return tokenApi?.auth("email")?.map({ jsonElement: JsonElement ->
                val token = gson?.fromJson(jsonElement, Token::class.java)!!
                AppManager.token = token
                true
            })?.subscribeOn(Schedulers.newThread())
                    ?.observeOn(AndroidSchedulers.mainThread())
        } else {
            return Observable.just(false)
        }
    }

    private interface UserApi {
        @FormUrlEncoded
        @POST("user/register")
        fun register(@Field("email") email: String, @Field("password") password: String): Observable<JsonElement>

        @FormUrlEncoded
        @POST("user/login")
        fun login(@Field("email") email: String, @Field("password") password: String): Observable<JsonElement>

        @FormUrlEncoded
        @POST("user/update")
        fun update(@Field("email") email: String): Observable<JsonElement>

        @GET("user/find/{id}")
        fun find(@Path("id") id: String): Observable<JsonElement>

        @DELETE("user/delete/{id}")
        fun delete(@Path("id") id: String): Observable<JsonElement>
    }

    private interface TokenApi {
        @FormUrlEncoded
        @POST("auth")
        fun auth(@Field("email") email: String): Observable<JsonElement>
    }
}
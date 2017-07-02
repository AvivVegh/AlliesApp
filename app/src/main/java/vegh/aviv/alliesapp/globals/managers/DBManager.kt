package vegh.aviv.alliesapp.globals.managers

import android.arch.persistence.room.Room
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import vegh.aviv.alliesapp.globals.AlliesApplication
import vegh.aviv.alliesapp.globals.entities.database.AlliesDatabase
import vegh.aviv.alliesapp.globals.entities.models.User


/**
 * Created by avivvegh on 20/05/2017.
 * Data base manager object
 */
object DBManager {

    var db: AlliesDatabase? = null

    init {
        db = Room.databaseBuilder(AlliesApplication.appContext, AlliesDatabase::class.java, "alliess-db").build()
    }

    fun getAllUsers(): Observable<List<User>?> {
        return Observable.just(true).map({
            db?.userDao()?.getAll()
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
    }

    fun getUser(id: String): Observable<User?> {
        return Observable.just(true).map({
            db?.userDao()?.loadById(id)
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
    }

    fun insertUser(user: User): Observable<Boolean> {
        return Observable.just(true).map({
            db?.userDao()?.insertAll(user)
            true
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
    }

    fun deleteUser(user: User): Observable<Boolean> {
        return Observable.just(true).map({
            db?.userDao()?.delete(user)
            true
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
    }
}
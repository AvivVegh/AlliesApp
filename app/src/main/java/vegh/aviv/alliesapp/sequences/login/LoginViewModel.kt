package vegh.aviv.alliesapp.sequences.login

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import vegh.aviv.alliesapp.globals.entities.models.User
import vegh.aviv.alliesapp.globals.managers.RestManager

/**
 * Created by aviv on 29/06/2017.
 */
class LoginViewModel : ViewModel() {
    private var user: MutableLiveData<User>? = null

    fun getUser(): LiveData<User>? {
        return user
    }

    fun login(email: String, password: String): Observable<User>? {
        return RestManager.login(email,password)
    }
}
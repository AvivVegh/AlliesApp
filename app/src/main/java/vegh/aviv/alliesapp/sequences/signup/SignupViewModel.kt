package vegh.aviv.alliesapp.sequences.signup

import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import vegh.aviv.alliesapp.globals.entities.models.User
import vegh.aviv.alliesapp.globals.managers.RestManager

/**
 * Created by aviv on 29/06/2017.
 */
class SignupViewModel : ViewModel() {
    fun register(email: String, password: String): Observable<User>? {
        return RestManager.register(email, password)
    }
}
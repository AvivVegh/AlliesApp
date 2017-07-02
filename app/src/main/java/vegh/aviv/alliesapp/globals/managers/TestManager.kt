package vegh.aviv.alliesapp.globals.managers

import android.util.Log

/**
 * Created by aviv on 20/06/2017.
 */
object TestManager {
    init {
        Log.d("test", "init")
    }

    fun foo() {
        Log.d("test", "test")
    }

    fun foo2() {
        Log.d("test", "foo2")
    }
}
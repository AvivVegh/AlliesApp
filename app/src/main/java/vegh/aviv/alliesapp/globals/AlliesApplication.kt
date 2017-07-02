package vegh.aviv.alliesapp.globals

import android.app.Application
import android.content.Context
import vegh.aviv.alliesapp.globals.managers.TestManager

/**
 * Created by avivvegh on 20/05/2017.
 * Allies application
 */
class AlliesApplication : Application() {

    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

        TestManager.foo()
        TestManager.foo()
    }
}
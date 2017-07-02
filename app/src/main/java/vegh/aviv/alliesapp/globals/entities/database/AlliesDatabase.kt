package vegh.aviv.alliesapp.globals.entities.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import vegh.aviv.alliesapp.globals.entities.daos.UserDao
import vegh.aviv.alliesapp.globals.entities.models.User

/**
 * Created by aviv on 29/06/2017.
 */
@Database(entities = arrayOf(User::class), version = 1)
abstract class AlliesDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
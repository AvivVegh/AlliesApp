package vegh.aviv.alliesapp.globals.entities.database

import android.arch.persistence.room.RoomDatabase
import vegh.aviv.alliesapp.globals.entities.daos.UserDao

/**
 * Created by aviv on 20/06/2017.
 */
//@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
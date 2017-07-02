package vegh.aviv.alliesapp.globals.entities.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import vegh.aviv.alliesapp.globals.entities.models.User

/**
 * Created by aviv on 20/06/2017.
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE id LIKE :arg0 LIMIT 1")
    fun loadById(userId: String): User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}
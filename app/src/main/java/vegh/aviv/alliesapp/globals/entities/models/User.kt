package vegh.aviv.alliesapp.globals.entities.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName


/**
 * Created by aviv on 20/06/2017.
 */
@Entity(tableName = "user")
class User constructor(id: String = "", firstName: String = "", lastName: String = "", email: String = "", imageUrl: String = "") {
    @SerializedName("_id")
    @PrimaryKey
    var id: String = id
    @ColumnInfo(name = "first_name")
    var firstName: String = firstName
    @ColumnInfo(name = "last_name")
    var lastName: String = lastName
    @ColumnInfo(name = "email")
    var email: String = email
    var imageUrl: String = imageUrl
}
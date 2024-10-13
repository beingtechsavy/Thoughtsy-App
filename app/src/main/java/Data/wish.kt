package Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wishTable")
data class wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "wish-title")
    val title: String = "",
    @ColumnInfo(name = "wish-desc")
    val Description: String = "",
)

object DummyList {
    val wishlist = listOf(
        wish(0, "PS5", "GTA6"),
        wish(1, "Headphones", "Boat"),
        wish(2, "Plane Ticket", "Germany")
    )
}

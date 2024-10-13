package Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
abstract class wishDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addWish(wishEntity: wish)

    @Query("Select * from `wishTable`")
    abstract fun getAllWish(): kotlinx.coroutines.flow.Flow<List<wish>>

    @Update
    abstract suspend fun updateWish(wishEntity: wish)

    @Delete
    abstract suspend fun DeleteWish(wishEntity: wish)

    @Query("Select * from `wishTable` where id=:id")
    abstract fun getAWish(id: Long): kotlinx.coroutines.flow.Flow<wish>
}
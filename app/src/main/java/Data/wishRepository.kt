package Data

class wishRepository(private val wishDAO: wishDAO) {
    suspend fun addAwish(wish: wish) {
        wishDAO.addWish(wish)
    }

    fun getwishes(): kotlinx.coroutines.flow.Flow<List<wish>> =
        wishDAO.getAllWish()

    fun getawish(id: Long): kotlinx.coroutines.flow.Flow<wish> {
        return wishDAO.getAWish(id)
    }

    suspend fun updatewish(wish: wish) {
        wishDAO.updateWish(wish)
    }

    suspend fun deleteawish(wish: wish) {
        wishDAO.DeleteWish(wish)
    }
}
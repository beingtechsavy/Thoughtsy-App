package Data

data class wish(
    val id: Long = 0L,
    val title: String = "",
    val Description: String = "",
)

object DummyList {
    val wishlist = listOf(
        wish(0, "PS5", "GTA6"),
        wish(1, "Headphones", "Boat"),
        wish(2, "Plane Ticket", "Germany")
    )
}

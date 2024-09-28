package asgarov.elchin.cryptocurrencyapp.data.repository.model

data class Coin(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)

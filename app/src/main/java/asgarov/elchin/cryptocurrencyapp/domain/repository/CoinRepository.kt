package asgarov.elchin.cryptocurrencyapp.domain.repository


import asgarov.elchin.cryptocurrencyapp.domain.model.Coin
import asgarov.elchin.cryptocurrencyapp.domain.model.CoinDetail

interface CoinRepository {

    suspend fun getCoins(): List<Coin>

    suspend fun getCoinById(coinId: String): CoinDetail
}
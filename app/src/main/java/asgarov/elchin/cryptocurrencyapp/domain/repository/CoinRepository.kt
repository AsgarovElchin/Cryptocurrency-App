package asgarov.elchin.cryptocurrencyapp.domain.repository

import asgarov.elchin.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import asgarov.elchin.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}
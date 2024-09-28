package asgarov.elchin.cryptocurrencyapp.data.repository

import asgarov.elchin.cryptocurrencyapp.data.remote.CoinPaprikaApi
import asgarov.elchin.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import asgarov.elchin.cryptocurrencyapp.data.remote.dto.CoinDto
import asgarov.elchin.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}
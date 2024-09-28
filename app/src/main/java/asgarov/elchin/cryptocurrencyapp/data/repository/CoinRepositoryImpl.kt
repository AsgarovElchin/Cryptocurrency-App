package asgarov.elchin.cryptocurrencyapp.data.repository

import asgarov.elchin.cryptocurrencyapp.data.remote.CoinPaprikaApi
import asgarov.elchin.cryptocurrencyapp.data.remote.dto.toCoin
import asgarov.elchin.cryptocurrencyapp.data.remote.dto.toCoinDetail
import asgarov.elchin.cryptocurrencyapp.domain.model.Coin
import asgarov.elchin.cryptocurrencyapp.domain.model.CoinDetail
import asgarov.elchin.cryptocurrencyapp.domain.repository.CoinRepository
import asgarov.elchin.cryptocurrencyapp.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<Coin> {
        return api.getCoins().map { it.toCoin() }
    }

    override suspend fun getCoinById(coinId: String): CoinDetail {
        return api.getCoinById(coinId).toCoinDetail()
    }

    override fun getCoinsFlow(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            emit(Resource.Success<List<Coin>>(getCoins()))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection."))
        }
    }

    override fun getCoinDetailFlow(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            emit(Resource.Success<CoinDetail>(getCoinById(coinId)))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}
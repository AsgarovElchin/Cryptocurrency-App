package asgarov.elchin.cryptocurrencyapp.domain.repository



import asgarov.elchin.cryptocurrencyapp.domain.model.Coin
import asgarov.elchin.cryptocurrencyapp.domain.model.CoinDetail
import asgarov.elchin.cryptocurrencyapp.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getCoins(): List<Coin>

    suspend fun getCoinById(coinId: String): CoinDetail

    fun getCoinsFlow(): Flow<Resource<List<Coin>>>

    fun getCoinDetailFlow(coinId: String): Flow<Resource<CoinDetail>>
}
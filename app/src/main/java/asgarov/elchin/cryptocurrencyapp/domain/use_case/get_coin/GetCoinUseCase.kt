package asgarov.elchin.cryptocurrencyapp.domain.use_case.get_coin

import asgarov.elchin.cryptocurrencyapp.domain.model.CoinDetail
import asgarov.elchin.cryptocurrencyapp.domain.repository.CoinRepository
import asgarov.elchin.cryptocurrencyapp.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> {
        return repository.getCoinDetailFlow(coinId)
    }
}
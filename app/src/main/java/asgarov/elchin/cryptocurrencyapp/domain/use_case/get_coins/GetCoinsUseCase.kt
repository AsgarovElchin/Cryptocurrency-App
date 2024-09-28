package asgarov.elchin.cryptocurrencyapp.domain.use_case.get_coins

import asgarov.elchin.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import asgarov.elchin.cryptocurrencyapp.domain.model.Coin
import asgarov.elchin.cryptocurrencyapp.domain.repository.CoinRepository
import asgarov.elchin.cryptocurrencyapp.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> {
        return repository.getCoinsFlow()
    }
}
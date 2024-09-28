package asgarov.elchin.cryptocurrencyapp.presentation.coin_detail

import asgarov.elchin.cryptocurrencyapp.domain.model.Coin
import asgarov.elchin.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)

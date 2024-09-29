package asgarov.elchin.cryptocurrencyapp.presentation.coin_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import asgarov.elchin.cryptocurrencyapp.domain.use_case.get_coin.GetCoinUseCase
import asgarov.elchin.cryptocurrencyapp.domain.use_case.get_coins.GetCoinsUseCase
import asgarov.elchin.cryptocurrencyapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase

) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state


    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    Log.d("data","$result")

                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value =
                        CoinListState(error = result.message ?: "An unexpected error occurred")

                }

                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}
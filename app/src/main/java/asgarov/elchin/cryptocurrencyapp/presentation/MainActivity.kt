package asgarov.elchin.cryptocurrencyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import asgarov.elchin.cryptocurrencyapp.presentation.ui.theme.CryptocurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppTheme {

            }
        }
    }
}


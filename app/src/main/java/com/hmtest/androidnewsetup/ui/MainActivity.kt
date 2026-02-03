package com.hmtest.androidnewsetup.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.hmtest.androidnewsetup.data.source.CountryCodeDao
import com.hmtest.androidnewsetup.ui.theme.AndroidNewSetupTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    companion object {
        private const val TAG = "@MainActivity"
    }

    @Inject
    lateinit var countryCodeDao: CountryCodeDao

    @SuppressLint("LogConditional")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        lifecycleScope.launch {
            val countryCodeByAlpha2 = countryCodeDao.getCountryCodeByAlpha2("SE")
            Log.d(TAG, "Country codes: $countryCodeByAlpha2")
            val countryCodeByAlpha3 = countryCodeDao.getCountryCodeByAlpha3("ISL")
            Log.d(TAG, "Country codes: $countryCodeByAlpha3")
            val countryCodeByNumeric3 = countryCodeDao.getCountryCodeByNumeric3("642")
            Log.d(TAG, "Country codes: $countryCodeByNumeric3")
        }

        setContent {
            AndroidNewSetupTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidNewSetupTheme {
        Greeting("Android")
    }
}

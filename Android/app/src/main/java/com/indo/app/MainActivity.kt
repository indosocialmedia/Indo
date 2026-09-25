package com.indo.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.indo.app.features.splash.IndoSplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val launchedFromHistory =
            (intent.flags and Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY) != 0

        setContent {
            var showSplash by remember {
                mutableStateOf(savedInstanceState == null && !launchedFromHistory)
            }

            MaterialTheme {
                Surface {
                    if (showSplash) {
                        IndoSplashScreen(
                            onFinished = { showSplash = false }
                        )
                    } else {
                        HomeScreenPlaceholder()
                    }
                }
            }
        }
    }
}

@androidx.compose.runtime.Composable
private fun HomeScreenPlaceholder() {
    Text("Indo")
}

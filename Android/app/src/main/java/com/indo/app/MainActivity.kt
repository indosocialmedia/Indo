package com.indo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface {
                    HomeScreenPlaceholder()
                }
            }
        }
    }
}

@androidx.compose.runtime.Composable
private fun HomeScreenPlaceholder() {
    Text("Indo")
}

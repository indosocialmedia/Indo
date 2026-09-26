package com.indo.app.features.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.indo.app.R
import kotlinx.coroutines.delay

private val IndoBackground = Color(0xFF020208)

@Composable
fun IndoSplashScreen(
    onFinished: () -> Unit,
    delayMillis: Long = 2500L
) {
    LaunchedEffect(Unit) {
        delay(delayMillis)
        onFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(IndoBackground),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.option8_icon),
            contentDescription = "Indo",
            modifier = Modifier.size(180.dp),
            contentScale = ContentScale.FillBounds
        )
    }
}

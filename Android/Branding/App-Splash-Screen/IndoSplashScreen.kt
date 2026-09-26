package com.indo.app.features.splash

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun IndoSplashScreen(
    onFinished: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(2500)
        onFinished()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(180.dp)
                .offset(x = (-8).dp)
        ) {
            val s = size.minDimension / 200f
            fun p(x: Float, y: Float) = Offset(x * s, y * s)

            drawCircle(
                color = Color.White,
                radius = 18f * s,
                center = p(63f, 43f)
            )

            drawLine(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFB64CFF), Color(0xFF8D21FF)),
                    start = p(63f, 72f),
                    end = p(63f, 158f)
                ),
                start = p(63f, 75f),
                end = p(63f, 158f),
                strokeWidth = 34f * s,
                cap = StrokeCap.Round
            )

            drawLine(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF2A2DFF), Color(0xFF8D21FF)),
                    start = p(68f, 72f),
                    end = p(148f, 116f)
                ),
                start = p(68f, 72f),
                end = p(148f, 116f),
                strokeWidth = 34f * s,
                cap = StrokeCap.Round
            )

            drawLine(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF2A2DFF), Color(0xFF8D21FF)),
                    start = p(148f, 116f),
                    end = p(68f, 160f)
                ),
                start = p(148f, 116f),
                end = p(68f, 160f),
                strokeWidth = 34f * s,
                cap = StrokeCap.Round
            )
        }
    }
}

package com.indo.app.features.splash

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

private val IndoPink = Color(0xFFFF2BC7)
private val IndoPurple = Color(0xFF8D21FF)
private val IndoBackground = Color(0xFF020208)

@Composable
fun IndoSplashScreen(
    onFinished: () -> Unit,
    delayMillis: Long = 2500L
) {
    val transition = rememberInfiniteTransition(label = "indo-splash")

    val progressX by transition.animateFloat(
        initialValue = -1.2f,
        targetValue = 4.3f,
        animationSpec = infiniteRepeatable(
            animation = tween(1600, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "progress"
    )

    val glowAlpha by transition.animateFloat(
        initialValue = 0.10f,
        targetValue = 0.22f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200),
            repeatMode = RepeatMode.Reverse
        ),
        label = "glow"
    )

    LaunchedEffect(Unit) {
        delay(delayMillis)
        onFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF03020A),
                        IndoBackground
                    )
                )
            )
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-70).dp)
                .size(260.dp)
                .alpha(glowAlpha)
                .blur(70.dp)
                .background(IndoPurple, CircleShape)
        )

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-12).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(112.dp)
                    .border(1.5.dp, IndoPink.copy(alpha = 0.82f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "ϟ",
                    color = Color.White,
                    fontSize = 78.sp,
                    fontWeight = FontWeight.Black,
                    modifier = Modifier.alpha(0.98f)
                )
            }

            Text(
                text = "Indo",
                color = Color.White,
                fontSize = 58.sp,
                fontWeight = FontWeight.Black,
                fontStyle = FontStyle.Italic,
                letterSpacing = (-5).sp,
                modifier = Modifier.offset(y = (-25).dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Share. Connect. ",
                color = Color(0xFFF5F2FA),
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )

            Text(
                text = "Grow.",
                color = IndoPink,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.offset(x = 60.dp, y = (-20).dp)
            )

            Box(
                modifier = Modifier
                    .offset(y = 42.dp)
                    .width(184.dp)
                    .height(4.dp)
                    .background(Color(0xFF5C4F70).copy(alpha = 0.25f), CircleShape)
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val segmentWidth = size.width * 0.28f
                    val x = progressX * size.width
                    drawRoundRect(
                        brush = Brush.horizontalGradient(
                            listOf(IndoPink, IndoPurple)
                        ),
                        topLeft = androidx.compose.ui.geometry.Offset(x, 0f),
                        size = androidx.compose.ui.geometry.Size(segmentWidth, size.height),
                        cornerRadius = androidx.compose.ui.geometry.CornerRadius(size.height)
                    )
                }
            }
        }

        Canvas(
            modifier = Modifier
                .size(170.dp)
                .align(Alignment.BottomStart)
                .offset(x = (-105).dp, y = 52.dp)
                .alpha(0.22f)
        ) {
            drawCircle(
                color = IndoPurple,
                radius = size.minDimension / 2f,
                style = Stroke(width = 1.dp.toPx())
            )
        }

        Canvas(
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.TopEnd)
                .offset(x = 88.dp, y = (-52).dp)
                .alpha(0.22f)
        ) {
            drawCircle(
                color = IndoPink,
                radius = size.minDimension / 2f,
                style = Stroke(width = 1.dp.toPx())
            )
        }
    }
}

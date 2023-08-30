package com.yoo.kaspiyipo.ui.functions.progresBar


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yoo.kaspiyipo.ui.theme.myColor
import kotlin.random.Random

@Composable
fun CircularProgressBar(
    percentage:Float,
    number:Int,
    fontSize:TextUnit=28.sp,
    radius: Dp =40.dp,
    color:Color= myColor,
    strokeWidth:Dp=8.dp,
    animationDuration:Int=1000,
    animDelay:Int=0
) {
    var animationPlayed by remember { mutableStateOf(false) }
    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animDelay
        )
    )
    LaunchedEffect(key1 = true){
        animationPlayed=true
    }
    Box(
        modifier=Modifier.size(radius*2f),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(radius*2f)){
            drawArc(
                color = color,
                -90f,
                360 * curPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(text = "$number%", fontSize = fontSize, fontWeight = FontWeight.Bold, color = myColor)
    }
    
}
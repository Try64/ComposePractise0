package com.try64.composepractise0

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import com.try64.composepractise0.ui.theme.*
import kotlin.math.min

@Composable
fun AnalogClockComponent(
    hour:Int,
    minute:Int,
    second:Int
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(fraction = 0.6f)
        .aspectRatio(1f)
        .clip(CircleShape)
        .background(AnalogClockOuterBoxColor)) {
        Box(modifier = Modifier.fillMaxSize(0.78f)
            .aspectRatio(1f)
            .clip(CircleShape)
            .background(AnalogClockInnerBoxColor)){
            Canvas(modifier = Modifier.fillMaxSize()){
                val diameter = min(size.width,size.height) * 0.9f
                val radius = diameter/2

                repeat(12){
                    val start = center - Offset(0F,radius)
                    val end = start + Offset(0F,radius/40F)
                    rotate(it/ 12f * 360){
                        drawLine(
                            color = Color.White,
                            start = start,
                            end = end,
                            strokeWidth = 5.dp.toPx(),
                            cap = StrokeCap.Round
                        )
                    }
                }

                val secondRatio = second /60F
                val minuteRatio = minute /60F
                val hourRatio = hour /12F

                rotate(hourRatio * 360, center){
                    drawLine(
                        color = AnalogClockHourHandColor,
                        start = center - Offset(0F,radius*0.4f),
                        end = center + Offset(0F,radius*0.1F),
                        strokeWidth = 3.8.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                }

                rotate(minuteRatio * 360, center){
                    drawLine(
                        color = AnalogClockMinuteHandColor,
                        start = center - Offset(0F,radius*0.6f),
                        end = center + Offset(0F,radius*0.1F),
                        strokeWidth = 3.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                }
                rotate(secondRatio * 360, center){
                    drawLine(
                        color = AnalogClockSecondHandColor,
                        start = center - Offset(0F,radius*0.7f),
                        end = center + Offset(0F,radius*0.1F),
                        strokeWidth = 3.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                }

                drawCircle(
                    color = AnalogClockSecondHandColor,
                    radius = 5.dp.toPx(),
                    center = center
                )
            }
        }

    }

}
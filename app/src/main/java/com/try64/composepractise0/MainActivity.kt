package com.try64.composepractise0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.try64.composepractise0.ui.theme.AlarmClockTheme
import com.try64.composepractise0.ui.theme.NavigationBarShadowColor
import kotlinx.coroutines.delay
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var hour by remember { mutableStateOf("0") }
            var minute by remember { mutableStateOf("0") }
            var second by remember { mutableStateOf("0") }
            var amOrPm by remember { mutableStateOf("0") }
            val place by remember { mutableStateOf("Dhaka,Bangladesh") }

            LaunchedEffect(Unit){
                while(true){
                    val cal = Calendar.getInstance()
                    hour = cal.get(Calendar.HOUR).run {
                        if(this.toString().length == 1) "0$this" else "$this"
                    }
                    minute = cal.get(Calendar.MINUTE).run {
                        if(this.toString().length == 1) "0$this" else "$this"
                    }
                    second = cal.get(Calendar.SECOND).run {
                        if(this.toString().length == 1) "0$this" else "$this"
                    }
                    amOrPm = cal.get(Calendar.AM_PM).run {
                        if(this == Calendar.AM) "AM" else "PM"
                    }
                    delay(1000)
                }
            }

            AlarmClockTheme {
                Scaffold(bottomBar = { NavigationBarComponent() }) {
                    Box(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            HeaderComponent()
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .fillMaxHeight(fraction = 0.8f),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    AnalogClockComponent()
                                    Spacer(modifier = Modifier.height(24.dp))
                                    DigitalCLockComponent(
                                        hour = hour,
                                        minute = minute,
                                        amOrPm = amOrPm,
                                        place = place
                                    )
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationBarComponent() {
    BottomNavigation(
        modifier = Modifier
            .shadow(ambientColor = NavigationBarShadowColor, elevation = 50.dp, clip = true)
            .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
    ){
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_alarm_24),
                    contentDescription = null
                )
            },
            selected = false, onClick = { }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_hourglass_bottom_24),
                    contentDescription = null
                )
            },
            selected = false, onClick = { }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_access_time_24),
                    contentDescription = null
                )
            },
            selected = true, onClick = { }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_timer_24),
                    contentDescription = null
                )
            },
            selected = false, onClick = { }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_hotel_24),
                    contentDescription = null
                )
            },
            selected = false, onClick = { }
        )
    }
}

@Composable
fun HeaderComponent() {
    Box(modifier = Modifier.padding(vertical = 16.dp)) {
        Text("Clock", style = MaterialTheme.typography.h2)
    }
}

@Composable
fun AnalogClockComponent() {

}

@Composable
fun DigitalCLockComponent(
    hour:String,
    minute:String,
    amOrPm:String,
    place:String
) {
    Text(text = "$hour:$minute $amOrPm",
    style = MaterialTheme.typography.h1)

    Text(text = "$place",
    style = MaterialTheme.typography.h2.merge(
        TextStyle(
            color = MaterialTheme.colors.onBackground.copy(
                alpha = 0.6f
            )
        )
    ))
}


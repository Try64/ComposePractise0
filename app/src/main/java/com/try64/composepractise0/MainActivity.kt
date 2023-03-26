package com.try64.composepractise0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.try64.composepractise0.ui.theme.AlarmClockTheme
import com.try64.composepractise0.ui.theme.NavigationBarShadowColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlarmClockTheme {
                Scaffold(bottomBar = { NavigationBarComponent() }) {
                    Box(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize()
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            HeaderComponent()
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .fillMaxHeight(fraction = 0.8f)
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    AnalogClockComponent()
                                    Spacer(modifier = Modifier.height(24.dp))
                                    DigitalCLockComponent()
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
        modifier = Modifier.shadow(ambientColor = NavigationBarShadowColor, elevation = 50.dp, clip = true)
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
fun DigitalCLockComponent() {

}


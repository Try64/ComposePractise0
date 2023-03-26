package com.try64.composepractise0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.try64.composepractise0.ui.theme.AlarmClockTheme

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
    Text("Hello")
}

@Composable
fun HeaderComponent() {
    Text("Hello")
}

@Composable
fun AnalogClockComponent() {

}

@Composable
fun DigitalCLockComponent() {

}


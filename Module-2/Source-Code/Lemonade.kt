package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LemonadeApp()
        }
    }
}

@Composable
fun LemonadeApp() {
    var step by remember { mutableStateOf(1) }

    Column(modifier = Modifier.padding(24.dp)) {
        Text("Benat's Lemonade App")

        Button(
            onClick = {
                step++
                if (step > 4) {
                    step = 1
                }
            }
        ) {
            Text("Next")
        }

        Text("Step: $step")
    }
}

package com.example.test_app



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView

class YourKotlinActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_kotlin)

        // Set up Jetpack Compose content using ComposeView
        val composeView = ComposeView(this)
        composeView.setContent {
            MaterialTheme {
                Surface {
                    Greeting("Hello from Jetpack Compose!")
                }
            }
        }

        // Replace the content view with the ComposeView
        setContentView(composeView)
    }
}

@Composable
fun Greeting(message: String) {
    Column {
        Text(text = message)
    }
}

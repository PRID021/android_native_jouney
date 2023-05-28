package com.example.test_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.annotation.CallSuper
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView



abstract class BaseComposeActivity: ComponentActivity() {
    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val composeView = ComposeView(this)

        composeView.setContent{
            SetView()
        }
        setContentView(composeView)
    }

    @Composable
    abstract fun SetView()
}
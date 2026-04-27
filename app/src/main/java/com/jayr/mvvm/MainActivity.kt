package com.jayr.mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jayr.mvvm.ui.screens.home.HomeScreen
import com.jayr.mvvm.ui.screens.student_dashboard.StudentScreen
import com.jayr.mvvm.ui.theme.MvvmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MvvmTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StudentScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

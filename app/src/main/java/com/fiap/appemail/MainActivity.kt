package com.fiap.appemail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.fiap.appemail.screen.MainScreen
import com.fiap.appemail.ui.theme.GmailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GmailTheme {
                val navController = rememberNavController()
                MainScreen(
                    navController = navController
                )
            }
        }
    }
}

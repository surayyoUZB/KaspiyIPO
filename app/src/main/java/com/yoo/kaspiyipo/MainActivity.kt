package com.yoo.kaspiyipo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.yoo.kaspiyipo.ui.navigation.RootNavigation
import com.yoo.kaspiyipo.ui.theme.KaspiyIPOTheme

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KaspiyIPOTheme(
                darkTheme = false
            ) {
                val navController= rememberNavController()
                RootNavigation(
                    close = {
                           finish()
                    },
                    navHostController = navController)
                }
            }
    }
}

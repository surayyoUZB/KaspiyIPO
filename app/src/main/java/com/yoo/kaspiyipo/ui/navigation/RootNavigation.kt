package com.yoo.kaspiyipo.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.yoo.kaspiyipo.ui.screens.main.MainScreen
import com.yoo.kaspiyipo.ui.screens.splash.SplashScreen
import com.yoo.kaspiyipo.ui.util.Graph

@Composable
fun RootNavigation(
    close:()->Unit,
    navHostController: NavHostController) {

    NavHost(
        route = Graph.ROOT,
        navController = navHostController,
        startDestination = Graph.SPLASH
    ) {
        splashGraph(navHostController = navHostController)
        composable(route=Graph.MAIN){
            MainScreen(close=close)
        }

    }

}


fun NavGraphBuilder.splashGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.SPLASH,
        startDestination = "splash"
    ) {
        composable(route = "splash") {
            SplashScreen(navHostController)
        }
    }
}
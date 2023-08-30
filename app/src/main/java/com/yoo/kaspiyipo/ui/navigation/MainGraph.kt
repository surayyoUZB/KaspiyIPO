package com.yoo.kaspiyipo.ui.navigation


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yoo.kaspiyipo.ui.functions.drawer.Drawer
import com.yoo.kaspiyipo.ui.screens.analise.AnaliseScreen
import com.yoo.kaspiyipo.ui.screens.dynamic.DynamicScreen
import com.yoo.kaspiyipo.ui.screens.market.MarketScreen
import com.yoo.kaspiyipo.ui.screens.portfolio.PortfolioScreen

@Composable
fun MainGraph(
    modifier: Modifier,
    navHostController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Drawer.portfolio.route
    ) {
        composable(route = Drawer.portfolio.route) {
            PortfolioScreen()
        }
        composable(route = Drawer.market.route) {
            MarketScreen()
        }
        composable(route = Drawer.analise.route) {
            AnaliseScreen()
        }
        composable(route = Drawer.dynamic.route) {
            DynamicScreen()
        }

    }

}
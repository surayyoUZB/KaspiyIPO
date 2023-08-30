package com.yoo.kaspiyipo.ui.functions.drawer

import com.yoo.kaspiyipo.R
import com.yoo.kaspiyipo.ui.util.Graph

sealed class Drawer(
    val icon:Int,
    val route: String
){

    object portfolio:Drawer(
        R.drawable.briefcase,
        Graph.PORTFOLIO
    )
    object market:Drawer(
        R.drawable.baseline_shopping_cart_24,
        Graph.MARKET
    )
    object analise:Drawer(
        R.drawable.baseline_stacked_bar_chart_24,
        Graph.ANALISE
    )
    object dynamic:Drawer(
        R.drawable.graph,
        Graph.DYNAMIC
    )

}
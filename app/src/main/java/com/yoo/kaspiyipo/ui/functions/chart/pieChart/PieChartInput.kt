package com.yoo.kaspiyipo.ui.functions.chart.pieChart

data class PieChartInput(
    val color: androidx.compose.ui.graphics.Color,
    val value:Int,
    val description:String,
    val isTapped:Boolean=false
)

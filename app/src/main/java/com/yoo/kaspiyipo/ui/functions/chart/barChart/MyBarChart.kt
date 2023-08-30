package com.yoo.kaspiyipo.ui.functions.chart.barChart

import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.axis.DataCategoryOptions
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.barchart.BarChart
import co.yml.charts.ui.barchart.models.BarChartData
import co.yml.charts.ui.barchart.models.BarChartType
import com.yoo.kaspiyipo.ui.theme.myColor

@Composable
fun MyBarChart() {

    val stepSize=5
    val barsData= DataUtils.getBarChartData(
        listSize = 8,
        maxRange = 8,
        barChartType = BarChartType.VERTICAL,
        dataCategoryOptions = DataCategoryOptions()
    )

    val xAxisData= AxisData.Builder()
        .axisStepSize(100.dp)
        .backgroundColor(Color.Transparent)
        .steps(barsData.size-1)
        .bottomPadding(40.dp)
        .axisLabelAngle(20f)
        .labelData { index-> "M$index" }
        .axisLineColor(myColor)
        .axisLabelColor(myColor)
        .build()
    val yAxisData= AxisData.Builder()
        .steps(barsData.size-1)
        .labelAndAxisLinePadding(20.dp)
        .axisOffset(20.dp)
        .labelData { index-> (index*(100 / stepSize)).toString() }
        .axisLineColor(myColor)
        .axisLabelColor(myColor)
        .build()

    val barCharData=BarChartData(
        chartData = barsData,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        backgroundColor = MaterialTheme.colorScheme.surface
    )
    BarChart(
        modifier = Modifier.height(350.dp),
        barChartData = barCharData
    )
    
}
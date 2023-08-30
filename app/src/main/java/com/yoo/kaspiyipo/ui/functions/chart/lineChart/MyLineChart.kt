package com.yoo.kaspiyipo.ui.functions.chart.lineChart


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.*
import com.yoo.kaspiyipo.ui.theme.myColor
@Composable
fun MyLineChart(
    steps:Int,
    pointsData:List<Point>
) {
    val xAxisData=AxisData.Builder()
        .axisStepSize(100.dp)
        .backgroundColor(Color.Transparent)
        .steps(pointsData.size-1)
        .labelData { i-> i.toString() }
        .labelAndAxisLinePadding(15.dp)
        .axisLineColor(Color.Black)
        .axisLabelColor(Color.Black)
        .build()

    val yAxisData=AxisData.Builder()
        .steps(steps)
        .backgroundColor(Color.Transparent)
        .labelAndAxisLinePadding(20.dp)
        .labelData { i->
            val yScale=100 / steps
            (i*yScale).toString()
        }
        .axisLineColor(Color.Black)
        .axisLabelColor(Color.Black)
        .build()

    val lineChartData=LineChartData(
        linePlotData = LinePlotData(
            lines= listOf(
                Line(
                    dataPoints = pointsData,
                    LineStyle(
                        color = myColor,
                        lineType = LineType.SmoothCurve(isDotted = false)
                    ),
                    IntersectionPoint(
                        color = myColor
                    ),
                    SelectionHighlightPoint(
                        color = Color.Black
                    ),
                    ShadowUnderLine(
                        alpha = 0.5f,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                myColor,
                                Color.Transparent
                            )
                        )
                    ),
                    SelectionHighlightPopUp()
                )
            ),
        ),
        backgroundColor = MaterialTheme.colorScheme.surface,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(
            color = Color.Black
        )
    )

    LineChart(
        modifier=Modifier.fillMaxWidth().height(300.dp),
        lineChartData=lineChartData
    )
    
}
package com.yoo.kaspiyipo.ui.screens.market


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.AccessibilityConfig
import co.yml.charts.common.model.PlotType
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData

@Composable
fun MarketScreen() {
        val itemList1 = listOf(
            "TRRX",
            "REWO",
            "YDX",
            "QWRS",
            "ZOX",
            "SOL",
            "ADTL"
        )
        val itemList2 = listOf(
            "ZOX",
            "ADTL",
            "SOL",
            "TRRX",
            "YDX",
            "QWRS",
            "REWO"
        )
        val itemList3 = listOf(
            "YDX",
            "TRRX",
            "REWO",
            "ZOX",
            "SOL",
            "ADTL",
            "QWRS"
        )
        val itemList4 = listOf(
            "ADTL",
            "SOL",
            "YDX",
            "ZOX",
            "REWO",
            "TRRX"
        )
        var itemList by remember { mutableStateOf(itemList1) }
        var nameIndex by remember { mutableStateOf(0) }
        val price = (111111..999999).random().toDouble()
        val height = (111..999).random().toDouble()
        val vol = (1111111..9999999).random().toDouble()
        val selectedIndex = remember { mutableStateOf(0) }
        val categoryList = listOf(
            "ALL",
            "ACTIVE",
            "NEW",
            "TOP"
        )

        if (selectedIndex.value == 0) {
            itemList = itemList1
        }
        if (selectedIndex.value == 1) {
            itemList = itemList2
        }
        if (selectedIndex.value == 2) {
            itemList = itemList3
        }
        if (selectedIndex.value == 3) {
            itemList = itemList4
        }

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(start = 10.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(
                    items = categoryList
                ) { index, item ->
                    AssistChip(
                        onClick = {
                            selectedIndex.value = index
                        },
                        label = {
                            Text(text = item)
                        },
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = if (selectedIndex.value == index) Color.Red else Color.Gray.copy(
                                0.5f
                            )
                        )
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(top = 10.dp)
            ) {
                Text(modifier = Modifier.weight(2.2f), text = "Company")
                Text(modifier = Modifier.weight(1f), text = "Price")
                Text(modifier = Modifier.weight(1f), text = "Hight")
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(items = itemList) { index, item ->
                    nameIndex=index
                    Items(
                        name = item,
                        price,
                        height,
                        vol,
                        onItemClick = {

                        }
                    )
                }
            }
        }
}

@Composable
fun Items(
    name: String,
    price: Double,
    height: Double,
    vol: Double,
    onItemClick: () -> Unit
) {


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp)
            .background(Color.White)
            .clickable {
                onItemClick()
            },
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 2.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = name, fontSize = 18.sp)
                Text(text = "val $vol", fontSize = 8.sp, maxLines = 1)
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                 Line()
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = price.toString(), fontSize = 18.sp)
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(vertical = 20.dp, horizontal = 2.dp)
                    .background(Color.Green, RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "+$height%", fontSize = 13.sp, maxLines = 1)
            }

        }
    }
}


@Composable
fun Line() {
    val pointData = listOf(
        Point(0f, (3..100).random().toFloat()),
        Point(1f, (3..100).random().toFloat()),
        Point(2f, (3..100).random().toFloat()),
        Point(3f, (3..100).random().toFloat()),
        Point(4f, (3..100).random().toFloat()),
    )
    LineChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        lineChartData = co.yml.charts.ui.linechart.model.LineChartData(
            linePlotData = LinePlotData(plotType = PlotType.Line, lines = listOf(co.yml.charts.ui.linechart.model.Line(dataPoints = pointData))),
            xAxisData = AxisData.Builder()
                .axisLineColor(Color.White)
                .build(),
            yAxisData = AxisData.Builder()
                .axisLineColor(Color.Blue)
                .build(),
            isZoomAllowed = true,
            paddingTop = 10.dp,
            bottomPadding = 10.dp,
            paddingRight = 10.dp,
            containerPaddingEnd = 15.dp,
            backgroundColor = Color.White,
            accessibilityConfig = AccessibilityConfig()
        )
    )
}
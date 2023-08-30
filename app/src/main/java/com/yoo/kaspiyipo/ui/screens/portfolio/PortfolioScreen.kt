package com.yoo.kaspiyipo.ui.screens.portfolio

import android.graphics.Paint
import android.os.Build
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import com.yoo.kaspiyipo.ui.functions.chart.lineChart.MyLineChart
import com.yoo.kaspiyipo.ui.functions.chart.pieChart.PieChart
import com.yoo.kaspiyipo.ui.functions.chart.pieChart.PieChartInput
import com.yoo.kaspiyipo.ui.functions.progresBar.CircularProgressBar

@Composable
fun PortfolioScreen() {

    val number=(1..100).random()
    val percentage=number.toFloat()/100f

    var pointData = listOf(
        Point(0f, (1..100).random().toFloat()),
        Point(1f, (1..100).random().toFloat()),
        Point(2f, (1..100).random().toFloat()),
        Point(3f, (1..100).random().toFloat()),
        Point(4f, (1..100).random().toFloat()),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(15.dp)
        ){
            Text(modifier = Modifier.weight(2f),text = "Graphic stack", fontSize = 15.sp)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Gray.copy(0.2f), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ){
                Text(text = "M1")
            }
        }

        MyLineChart(
            steps = 6,
            pointsData = pointData
        )
        Text(modifier = Modifier.padding(5.dp),text = "Nachalniy bklad: 87737,26")
        Text(modifier = Modifier.padding(5.dp),text = "Kolichestva kompromis: 1956.23")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(start = 10.dp)
        ) {
            CircularProgressBar(percentage = percentage, number = number)
            Column(
                modifier = Modifier.padding(start = 5.dp)
            ) {
                Text(modifier = Modifier.padding(5.dp),text = "successful actions")
                Text(modifier = Modifier.padding(5.dp),text = "13/27 completed")
                Text(modifier = Modifier.padding(5.dp),text = "updated 3 days before")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(20.dp)
        ) {
           Column(
               modifier = Modifier.weight(1.5f)
           ) {
               Text(modifier = Modifier.padding(5.dp),text = "review")
               Text(modifier = Modifier.padding(5.dp),text = "01 June 2023 - 21 Jule 2023")
               Text(modifier = Modifier.padding(5.dp),text = "65399,13")
           }
            PieChart(
                modifier = Modifier
                    .padding(10.dp)
                    .weight(1f),
                input = listOf(
                    PieChartInput(
                        color = Color.Blue,
                        value = 30,
                        description = "business"
                    ),
                    PieChartInput(
                        color = Color.Red,
                        value = 28,
                        description = "veksel"
                    ),
                    PieChartInput(
                        color = Color.Green,
                        value = 42,
                        description = "financial ovation"
                    )
                ),
                contentText = "100%"
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        ){
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(3.dp)
                    .background(Color.Red, RoundedCornerShape(10.dp))
            ) {
                Text(text = "28% business")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(3.dp)
                    .background(Color.Green, RoundedCornerShape(10.dp))
            ) {
                Text(text = "42% veksel")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(3.dp)
                    .background(Color.Blue, RoundedCornerShape(10.dp))
            ) {
                Text(text = "30% financial ovation")
            }
        }

    }

}
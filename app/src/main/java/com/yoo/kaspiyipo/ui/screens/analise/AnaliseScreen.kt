package com.yoo.kaspiyipo.ui.screens.analise

import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import co.yml.charts.common.model.Point
import com.yoo.kaspiyipo.ui.functions.chart.lineChart.MyLineChart

@Composable
fun AnaliseScreen() {
    val context= LocalContext.current
    var pointData by remember { mutableStateOf(
        listOf(
        Point(0f, (1..100).random().toFloat()),
        Point(1f, (1..100).random().toFloat()),
        Point(2f, (1..100).random().toFloat()),
        Point(3f, (1..100).random().toFloat()),
        Point(4f, (1..100).random().toFloat()),
    )
    ) }
    val selectedIndex = rememberSaveable { mutableStateOf(0) }
    val categoryList = listOf(
        "1D",
        "5D",
        "1M",
        "3M",
        "6M",
        "1G",
        "5L",
    )
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
                        pointData = listOf(
                            Point(0f, (1..100).random().toFloat()),
                            Point(1f, (1..100).random().toFloat()),
                            Point(2f, (1..100).random().toFloat()),
                            Point(3f, (1..100).random().toFloat()),
                            Point(4f, (1..100).random().toFloat()),
                        )
                    },
                    label = {
                        Text(text = item)
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (selectedIndex.value == index) Color.Blue else Color.Gray.copy(0.5f)
                    )
                )
            }
        }

        MyLineChart(
            steps = 6,
            pointsData = pointData
        )
        
        
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(10.dp)
                .background(Color.Gray.copy(0.3f)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "ASR")
                Text(text = "25.06.23")
                Text(text = "73")

            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "business")
                Text(text = "Data")
                Text(text = "Amount")

            }
            
        }

        Text(text = "  Statistics:")

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Open")
                    Text(text = "36.800")
                }
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Volume")
                    Text(text = "79")
                }
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Difference")
                    Text(text = "3678,00")
                }
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "average volume")
                    Text(text = "152")
                }
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "salary percentage")
                    Text(text = "65,73")
                }
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Dn. range")
                    Text(text = "36.711,3-36.966")
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(5.dp)
        ){
              Box(
                  modifier = Modifier
                      .weight(1f)
                      .fillMaxSize()
                      .padding(4.dp)
                      .background(Color.Blue, RoundedCornerShape(15.dp))
                      .clickable {
                          Toast
                              .makeText(context, "Starting", Toast.LENGTH_SHORT)
                              .show()
                      },
                  contentAlignment = Alignment.Center
              ) {
                  Text(
                      text = "START",
                      color = Color.White
                  )
              }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(4.dp)
                    .background(Color.Blue, RoundedCornerShape(15.dp))
                    .clickable {
                        Toast
                            .makeText(context, "Stopping", Toast.LENGTH_SHORT)
                            .show()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "STOP",
                    color = Color.White
                )
            }
        }






    }

}
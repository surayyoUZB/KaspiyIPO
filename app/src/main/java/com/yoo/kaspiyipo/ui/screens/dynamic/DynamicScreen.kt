package com.yoo.kaspiyipo.ui.screens.dynamic


import android.os.Build
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yoo.kaspiyipo.R
import com.yoo.kaspiyipo.ui.functions.chart.barChart.MyBarChart

@Composable
fun DynamicScreen() {
    var isOpen by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

       Row(
           modifier = Modifier.fillMaxWidth()
       ) {
           Column(
               modifier = Modifier
                   .fillMaxWidth()
                   .weight(2f)
           ) {
               Row(
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(start = 10.dp, end = 10.dp, top = 10.dp),
                   horizontalArrangement = Arrangement.Start
               ) {
                   Icon(painter = painterResource(id = com.yoo.kaspiyipo.R.drawable.baseline_analytics_24), contentDescription = "dynamic")
                   Text(text = "Dynamic", fontSize = 18.sp, fontWeight = FontWeight.Bold)
               }
               Row(
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(start = 10.dp, top = 5.dp),
                   horizontalArrangement = Arrangement.Start
               ) {
                   Text(text = "Height behind august 2023")
               }
           }

           Box(
               modifier = Modifier
                   .weight(1f)
                   .fillMaxWidth()
                   .height(30.dp)
                   .padding(top = 5.dp)
                   .background(Color.Gray.copy(0.2f), RoundedCornerShape(10.dp)),
               contentAlignment = Alignment.Center
           ){
               Text(text = "M1")
           }
       }

        MyBarChart()


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(20.dp)
        ) {
            Icon(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                painter = painterResource(id = R.drawable.profile),
                contentDescription = ""
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(3f)
            ) {

                Text(text = "User #4567")
                Text(text = "Privacy police", color = Color.Blue, fontStyle = FontStyle.Italic)


            }

        }



    }

}
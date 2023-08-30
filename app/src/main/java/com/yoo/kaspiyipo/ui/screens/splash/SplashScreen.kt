package com.yoo.kaspiyipo.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.yoo.kaspiyipo.R
import com.yoo.kaspiyipo.ui.util.Graph
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navHostController: NavHostController,
//    vm:ViewModel= hiltViewModel()
) {
    LaunchedEffect(key1 = Unit){
        delay(2000)
//        if (vm.id.value==0){
//            navHostController.navigate(Graph.REGISTER)
//        }else{
            navHostController.navigate(Graph.MAIN)
//        }
    }
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.splash),
            contentDescription = "splash",
            contentScale = ContentScale.Crop
        )
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 100.dp), contentAlignment = Alignment.BottomCenter){
        CircularProgressIndicator(color = Color.White)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 70.dp), contentAlignment = Alignment.BottomCenter){
        Text(text = "Loading....", color = Color.White)
    }

}
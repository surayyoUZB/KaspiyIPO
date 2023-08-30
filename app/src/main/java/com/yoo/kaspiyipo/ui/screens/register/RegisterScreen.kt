package com.yoo.kaspiyipo.ui.screens.register

//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.platform.LocalSoftwareKeyboardController
//import androidx.compose.ui.text.ExperimentalTextApi
//import androidx.compose.ui.text.font.FontStyle
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.navigation.NavHostController
//import com.yoo.kaspiyipo.ui.theme.myColor
//import com.yoo.kaspiyipo.ui.util.Graph
//
//@OptIn(ExperimentalComposeUiApi::class, ExperimentalTextApi::class)
//@Composable
//fun RegisterScreen(
//    navHostController: NavHostController,
//    vm:ViewModel= hiltViewModel()
//) {
//    var name  by remember { mutableStateOf("") }
//    var gmail  by remember { mutableStateOf("") }
//    var isBottomVisible by remember { mutableStateOf(false) }
//    val keyboard = LocalSoftwareKeyboardController.current
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(color = myColor.copy(.2f)),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        Text(
//            text = "REGISTER",
//            fontStyle = FontStyle.Italic,
//            fontSize = 40.sp,
//            style = LocalTextStyle.current.copy(brush = Brush.horizontalGradient(listOf(myColor.copy(0.4f), myColor)))
//        )
//        Spacer(modifier = Modifier.height(20.dp))
//
//        OutlinedTextField(
//            value = name,
//            onValueChange = {
//                name=it
//            },
//            label = {
//                Text(text = "Name")
//            }
//        )
//        Spacer(modifier = Modifier.height(20.dp))
//        OutlinedTextField(
//            value = gmail,
//            onValueChange = {
//                gmail=it
//            },
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Email
//            ),
//            label = {
//                Text(text = "Gmail")
//            }
//        )
//        Text(text = "Gmail should end with @gmail.com")
//        Spacer(modifier = Modifier.height(20.dp))
//
//
//        if (name.trim().isNotBlank() && gmail.trim().isNotBlank() && gmail.trim().endsWith("@gmail.com")){
//            isBottomVisible=true
//            keyboard?.hide()
//        }
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//
//        AnimatedVisibility(visible = isBottomVisible) {
//            Button(
//                colors = ButtonDefaults.buttonColors(myColor),
//                onClick = {
//                    vm.saveId(1)
//                    navHostController.navigate(Graph.MAIN)
//                }) {
//                Text(text = "REGISTER")
//            }
//        }
//        Spacer(modifier = Modifier.height(30.dp))
//
//    }
//
//
//
//}
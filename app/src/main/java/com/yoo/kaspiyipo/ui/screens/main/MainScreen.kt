package com.yoo.kaspiyipo.ui.screens.main


import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.*
import androidx.compose.material3.R
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yoo.kaspiyipo.ui.functions.drawer.Drawer
import com.yoo.kaspiyipo.ui.functions.drawer.MyDrawer
import com.yoo.kaspiyipo.ui.navigation.MainGraph
import com.yoo.kaspiyipo.ui.theme.myColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    close:()->Unit,
    navHostController: NavHostController = rememberNavController(),
//    vm:ViewModel= hiltViewModel()
) {
    var title by remember { mutableStateOf("Kaspiy IPO") }

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(myColor),
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(start = 30.dp, top = 10.dp),
                        painter = painterResource(id = com.yoo.kaspiyipo.R.drawable.profile),
                        contentDescription = "profile",
                        tint = Color.White
                    )

                    Text(modifier = Modifier.padding(start = 30.dp, top = 10.dp, bottom = 10.dp), text = "user #4568", fontSize = 20.sp)
                    Text(modifier = Modifier.padding(start = 30.dp, bottom = 10.dp), text = "user.@gmail.com", fontSize = 20.sp)
                }
                MyDrawer(
                    navHostController = navHostController,
                    title = { title=it },
                    onClick = {
                        scope.launch {
                            drawerState.close()
                        }
                    }
                )
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .height(1.dp)
                    .background(Color.Black))

                Text(text = "  Application")

              Row() {
                  IconButton(onClick = {
                      close()
                  }) {
                      Icon(imageVector = Icons.Outlined.ExitToApp, contentDescription = "close")
                  }
                  Text(modifier = Modifier.padding(top = 12.dp),text = "  Close")
              }

            }
        }) {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.smallTopAppBarColors(Color.Gray.copy(0.2f)),
                    title = { Text(text = title)},
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Outlined.Menu, contentDescription ="menu")
                        }
                    }
                )
            }
        ) { padding ->
            MainGraph(
                modifier = Modifier.padding(padding),
                navHostController = navHostController
            )
        }
    }
}
package com.yoo.kaspiyipo.ui.functions.drawer

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDrawer(
    navHostController: NavHostController,
    title:(String)->Unit,
    onClick:()->Unit
) {
    val screens= listOf(
        Drawer.portfolio,
        Drawer.market,
        Drawer.analise,
        Drawer.dynamic
    )
    val currentDestination by navHostController.currentBackStackEntryAsState()
    val isBottomBarVisible=screens.any{it.route==currentDestination?.destination?.route}

            screens.forEach{screen ->
                NavigationDrawerItem(
                    selected = screen.route==currentDestination?.destination?.route,
                    onClick = {
                        onClick()
                        navHostController.navigate(screen.route){
                            popUpTo(navHostController.graph.findStartDestination().id){
                                inclusive=true
                            }
                            title(screen.route)
                        }

                    },
                    label = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start,
                        ) {
                            Icon(
                                modifier = Modifier.padding(top = 10.dp, end = 10.dp).size(25.dp),
                                painter = painterResource(id = screen.icon),
                                contentDescription = "icon"
                            )
                            Text(modifier = Modifier.padding(10.dp), text = screen.route)
                        }
                    }
                )
            }
}
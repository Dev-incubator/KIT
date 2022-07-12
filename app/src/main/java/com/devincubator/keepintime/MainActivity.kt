package com.devincubator.keepintime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.devincubator.keepintime.presentation.navigation.NavigationItem
import com.devincubator.keepintime.presentation.screens.ContactsScreen
import com.devincubator.keepintime.presentation.screens.HomeScreen
import com.devincubator.keepintime.presentation.screens.MeetingsScreen
import com.devincubator.keepintime.presentation.screens.TasksScreen
import com.devincubator.keepintime.ui.theme.KeepInTimeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
private fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Navigation(navController = navController)
        it.calculateBottomPadding()
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navItems = listOf(
        NavigationItem.Home,
        NavigationItem.Meetings,
        NavigationItem.Contacts,
        NavigationItem.Tasks
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.DarkGray
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination?.route

        navItems.forEach { navigationItem ->
            BottomNavigationItem(
                icon = { Icon(imageVector = navigationItem.icon, contentDescription = null) },
                selectedContentColor = Color.Black,
                selected = currentDestination == navigationItem.route,
                onClick = {
                    navController.navigate(navigationItem.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Meetings.route) {
            MeetingsScreen()
        }
        composable(NavigationItem.Contacts.route) {
            ContactsScreen()
        }
        composable(NavigationItem.Tasks.route) {
            TasksScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KeepInTimeTheme {
        MainScreen()
    }
}
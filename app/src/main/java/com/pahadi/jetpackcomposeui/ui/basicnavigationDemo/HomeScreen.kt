package com.pahadi.jetpackcomposeui.ui.basicnavigationDemo

import android.util.Log
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

const val TAG = "Naviagtion_d"
enum class ScreenName(val title: String){
    SCREEN1("SCREEN1"),
    SCREEN2("SCREEN2"),
    SCREEN3("SCREEN3")
}

@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = ScreenName.valueOf(
        backStackEntry?.destination?.route ?: ScreenName.SCREEN1.name
    )
    Log.d(TAG, "ScreenName.SCREEN2.name = ${ScreenName.SCREEN2.name}, ScreenName.SCREEN2.title = ${ScreenName.SCREEN2.title}")

    Scaffold(
        topBar = {
        HomeAppBar(currentScreen =currentScreen,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() })
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ScreenName.SCREEN1.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())          // Allows the content inside NavHost to be scrollable vertically.
                .padding(innerPadding)
        ){
            composable(ScreenName.SCREEN1.name){
                val context = LocalContext.current
                Screen1(modifier = Modifier.fillMaxHeight(),
                    onNextClicked = {
                        navController.navigate(ScreenName.SCREEN2.name)
                    },
                    onBackClicked = {
                        Log.e(TAG, "HomeScreen: back clicked", )
                    }
                )
            }
            composable(ScreenName.SCREEN2.name){
            Screen2(
                modifier = Modifier.fillMaxHeight(),
                onNextClicked = {
                navController.navigate(ScreenName.SCREEN3.name)
                },
                onBackClicked = {
                    navController.navigateUp()
                }
            )
            }

            composable(ScreenName.SCREEN3.name){
            Screen3(
                modifier = Modifier.fillMaxHeight(),
                onBackClicked = {
                    navController.navigateUp()
                }
            )
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar(
    currentScreen: ScreenName,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(title = { currentScreen.title },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = { navigateUp }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription ="")
                }
            }
        }
        )
}
package com.bnyro.recorder.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bnyro.recorder.enums.Recorder
import com.bnyro.recorder.ui.screens.RecorderView

@Composable
fun AppNavHost(
    navController: NavHostController, modifier: Modifier = Modifier, initialRecorder: Recorder
) {
    NavHost(
        navController = navController, startDestination = Home.route, modifier = modifier
    ) {
        composable(route = Home.route) {
            RecorderView(initialRecorder, onNavigate = { destination ->
                navController.navigateTo(destination.route)
            })
        }
    }
}

fun NavHostController.navigateTo(route: String) = this.navigate(route) {
    launchSingleTop = true
    restoreState = true
}
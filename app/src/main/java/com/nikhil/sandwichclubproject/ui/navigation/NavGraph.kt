// NavGraph.kt

package com.nikhil.sandwichclubproject.ui.navigation

import MainScreen
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.nikhil.sandwichclubproject.data.model.Sandwich
import com.nikhil.sandwichclubproject.ui.screens.DetailScreen
import com.nikhil.sandwichclubproject.ui.viewmodel.SandwichViewModel

@Composable
fun NavGraph(viewModel: SandwichViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable(route = "main") {
            MainScreen(viewModel = viewModel, onSandwichClick = { sandwich ->
                val sandwichJson = Uri.encode(Gson().toJson(sandwich))
                navController.navigate("detail/$sandwichJson")
            })
        }

        composable(
            route = "detail/{sandwich}",
            arguments = listOf(navArgument("sandwich") { type = NavType.StringType })
        ) { backStackEntry ->
            val sandwichJson = backStackEntry.arguments?.getString("sandwich")
            val sandwich = Gson().fromJson(sandwichJson, Sandwich::class.java)

            DetailScreen(sandwich = sandwich)
        }
    }
}
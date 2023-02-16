package com.example.inventa_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.inventa_app.MainViewModel
import com.example.inventa_app.screens.*


sealed class NavRoute(val route: String){
    object StartScreen:NavRoute("start_screen")
    object PostmanInfoScreen:NavRoute("postman-info-screen")
    object InventaScreen:NavRoute("inventa_screen")
    object DocsScreen:NavRoute("docs_screen")
    object ItemsScreen:NavRoute("items_screen")
    object PostScreen:NavRoute("Post_screen")
    object AddPostScreen:NavRoute("add_post_screen")
    object AddItemScreen:NavRoute("add_item_screen")

}


@Composable
fun NoteNavHost(mViewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController =navController , startDestination =NavRoute.StartScreen.route ){
        composable(NavRoute.StartScreen.route){ startScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.PostmanInfoScreen.route){ PostmanInfoScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.InventaScreen.route){ InventaScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.DocsScreen.route){ DocsScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.ItemsScreen.route){ ItemsScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.PostScreen.route){ PostScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.AddPostScreen.route){ AddPostScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.AddItemScreen.route){ AddItemScreen(navController = navController, viewModel = mViewModel) }
    }
    
}
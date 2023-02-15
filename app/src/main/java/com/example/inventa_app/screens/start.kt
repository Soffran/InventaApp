package com.example.inventa_app.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inventa_app.MainViewModel
import com.example.inventa_app.MainViewModelFactory
import com.example.inventa_app.navigation.NavRoute
import com.example.inventa_app.ui.theme.InventaAppTheme

@Composable
fun startScreen (navController: NavHostController, viewModel: MainViewModel) {
    val context = LocalContext.current
    val mViewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = MainViewModelFactory(context.applicationContext as Application)
    ) as MainViewModel

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                elevation = 12.dp,
            ) {
                Text(text = "Inventa-App", fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, fontSize = 28.sp, modifier = Modifier.padding(horizontal = 5.dp))
            }
        }
    ) { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        )
        {
            Button(
                onClick = {
                    navController.navigate(route = NavRoute.InventaScreen.route)
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp, horizontal = 10.dp)
            ) {
                Text(text = "Инвентаризация", fontSize = 24.sp)
            }
            Button(
                onClick = {
                    navController.navigate(route = NavRoute.DocsScreen.route)
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp, horizontal = 10.dp)
            ) {
                Text(text = "Отчеты", fontSize = 24.sp)
            }
            Button(
                onClick = {
                    navController.navigate(route = NavRoute.ItemsScreen.route)
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp, horizontal = 10.dp)
            ) {
                Text(text = "Наименования", fontSize = 24.sp)
            }
            Button(
                onClick = {
                    navController.navigate(route = NavRoute.PostScreen.route)
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp, horizontal = 10.dp)
            ) {
                Text(text = "Поставщики", fontSize = 24.sp)
            }
            Button(
                onClick = {
                    navController.navigate(route = NavRoute.StaffScreen.route)
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp, horizontal = 10.dp)
            ) {
                Text(text = "Сотрудники", fontSize = 24.sp)
            }

        }
    }

}

//@Preview(showBackground = true)
//@Composable
//fun prevStartScreen(){
//    InventaAppTheme {
//        startScreen(navController = rememberNavController(), viewModel = mViewModel)
//
//    }
//}




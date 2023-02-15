package com.example.inventa_app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.inventa_app.MainViewModel
import com.example.inventa_app.model.Postman
import com.example.inventa_app.navigation.NavRoute

@Composable
fun AddPostScreen (navController: NavHostController, viewModel: MainViewModel){
    var title by remember { mutableStateOf("")}
    var isButtonEnabled by remember {mutableStateOf(false)}
    Scaffold(
        topBar = {TopAppBar(
            backgroundColor = Color.Blue,
            contentColor = Color.White,
            elevation = 12.dp){
            Row(modifier = Modifier.padding(horizontal = 5.dp), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { navController.navigate(NavRoute.PostScreen.route) }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription ="back to PostScreen" )
                }
                Text(text = "Добавить", fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, fontSize = 28.sp, modifier = Modifier.padding(horizontal = 5.dp))
            }
        }
        }) {padding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {
            Text(text = "Введите Поставщика",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
                )
            OutlinedTextField(
                value = title,
                onValueChange = {
                    title = it
                    isButtonEnabled = title.isNotEmpty()
                },
                isError = title.isEmpty()
            )
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .padding(horizontal = 54.dp),
                enabled = isButtonEnabled,
                onClick = {
                    viewModel.addPostman(postman = Postman(Title =title )){
                    }

                    navController.navigate(NavRoute.PostScreen.route)
                }
            ) {
                Text(text = "Сохранить")
            }

        }
        
    }
}
package com.example.inventa_app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.inventa_app.MainViewModel
import com.example.inventa_app.model.ItemDataModel
import com.example.inventa_app.navigation.NavRoute

@Composable
fun InventaScreen (navController: NavHostController, viewModel: MainViewModel){
    val Items = viewModel.readAllItem().observeAsState(listOf()).value
    Scaffold(
        topBar = {
            TopAppBar(
            backgroundColor = Color.Blue,
            contentColor = Color.White,
            elevation = 12.dp){
            Row(modifier = Modifier.padding(horizontal = 5.dp), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { navController.navigate(NavRoute.StartScreen.route) }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription ="back to StartScreen" )
                }
                Text(text = "Инвентаризация", fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, fontSize = 28.sp, modifier = Modifier.padding(horizontal = 5.dp) )
            }
        }
        },
        bottomBar = {
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Завершить")
            }
        }
        ) {padding ->
            LazyColumn(modifier = Modifier.padding(vertical = 5.dp)){items(Items) { item ->
                cardInventaItem(item = item, navController = navController, viewModel = viewModel)
            }
        }
    }
}
@Composable
fun cardInventaItem(item: ItemDataModel, navController: NavController, viewModel: MainViewModel  ) {
    var count by remember { mutableStateOf("") }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 10.dp)
            .height(80.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.CenterStart
        )
        {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = item.Title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 5.dp)
                )
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(0.3f).padding(end=15.dp)) {
                    TextField(value = count, onValueChange = { count = it },keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
                }
            }
        }
    }
}
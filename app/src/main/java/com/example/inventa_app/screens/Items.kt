package com.example.inventa_app.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inventa_app.MainViewModel
import com.example.inventa_app.model.ItemDataModel
import com.example.inventa_app.navigation.NavRoute
import com.example.inventa_app.ui.theme.InventaAppTheme

@Composable
fun ItemsScreen (navController: NavHostController, viewModel: MainViewModel){
    val Items = viewModel.readAllItem().observeAsState(listOf()).value
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                elevation = 12.dp) {
                Row(modifier = Modifier.padding(horizontal = 5.dp), verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { navController.navigate(NavRoute.StartScreen.route) }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription ="back to StartScreen" )
                    }
                    Text(text = "Наименования", fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, fontSize = 28.sp, modifier = Modifier.padding(horizontal = 5.dp))
                }
            }
        },

        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(route = NavRoute.AddItemScreen.route)
            }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add item", tint = Color.White)
            }
        }
    ) { padding ->
            LazyColumn(modifier = Modifier.padding(vertical = 5.dp)) {
                items(Items) { item ->
                    cardItem(item =item , navController = navController,viewModel = viewModel)

            }
        }
    }
}

@Composable
fun cardItem(item: ItemDataModel, navController:NavController, viewModel: MainViewModel  ){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 10.dp)
            .height(80.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.CenterStart)
        {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = item.Title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 5.dp)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = item.EdIzmer, modifier = Modifier.padding(end = 5.dp))
                    IconButton(
                        onClick = {viewModel.deleteItem(item = item){}},
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 5.dp),
                    ) {
                        Icon(imageVector = Icons.Filled.Delete , contentDescription = "delete")
                    }
                }

            }
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun prevItemsScreen(){
//    InventaAppTheme {
//        ItemsScreen(navController = rememberNavController(), viewModel = mViewModel)
//    }
//}
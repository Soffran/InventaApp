package com.example.inventa_app.screens

import androidx.compose.foundation.layout.*
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddItemScreen (navController: NavHostController, viewModel: MainViewModel) {
    var title by remember { mutableStateOf("") }
    var fulltitle by remember { mutableStateOf("") }
    var edizmer by remember { mutableStateOf("") }
    var postmanfor by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var expandedpost by remember { mutableStateOf(false) }
    val postmans = viewModel.readAllPosts().observeAsState(listOf()).value



    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                elevation = 12.dp
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.navigate(NavRoute.ItemsScreen.route) }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "back to ItemScreen"
                        )
                    }
                    Text(
                        text = "Добавить",
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 28.sp,
                        modifier = Modifier.padding(horizontal = 5.dp))
                }
            }
        }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Введите сокращённое название товара",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
            OutlinedTextField(
                value = title,
                onValueChange = {
                    title = it
                },
                isError = title.isEmpty()
            )
            Text(
                text = "Введите полное название товара",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
            OutlinedTextField(
                value = fulltitle,
                onValueChange = {
                    fulltitle = it
                },
                isError = fulltitle.isEmpty()
            )
            Text(
                text = "Выберите единицу измерения",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }) {
                OutlinedTextField(
                    value = edizmer,
                    onValueChange = {
                        expanded = true
                        edizmer = it
                    },
                    isError = edizmer.isEmpty()
                )
                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    DropdownMenuItem(onClick = {
                        edizmer = "Кг"
                        expanded = false
                    }) {
                        Text("Кг")
                    }
                    DropdownMenuItem(onClick = {
                        edizmer = "Шт"
                        expanded = false
                    }) {
                        Text(text = "Шт")
                    }
                }
            }
            Text(
                text = "Выберите поставщика",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
            ExposedDropdownMenuBox(
                expanded = expandedpost,
                onExpandedChange = { expandedpost = !expandedpost }) {
                OutlinedTextField(
                    value = postmanfor,
                    onValueChange = {
                        expanded = true
                        postmanfor = it
                    },
                    isError = edizmer.isEmpty()
                )
                ExposedDropdownMenu(
                    expanded = expandedpost,
                    onDismissRequest = { expandedpost = false }) {
                    postmans.forEach { postmanitem ->
                        DropdownMenuItem(onClick = {
                            postmanfor = postmanitem.Title
                            expandedpost = false
                        }) {
                            Text(postmanitem.Title)
                        }
                    }

                }
            }
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .padding(horizontal = 54.dp),
                enabled = title.isNotEmpty() && fulltitle.isNotEmpty() && edizmer.isNotEmpty() && postmanfor.isNotEmpty(),
                onClick = {
                    viewModel.addItem(
                        item = ItemDataModel(
                            Title = title,
                            FullTitle = fulltitle,
                            EdIzmer = edizmer,
                            PostmanFor = postmanfor
                        )
                    ) {}

                    navController.navigate(NavRoute.ItemsScreen.route)
                }
            ) {
                Text(text = "Сохранить")
            }

        }

    }
}


package com.example.inventa_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.inventa_app.MainViewModel
import com.example.inventa_app.navigation.NavRoute

@Composable
fun DocsScreen (navController: NavHostController, viewModel: MainViewModel){
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
                Text(text = "Отчеты", fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, fontSize = 28.sp, modifier = Modifier.padding(horizontal = 5.dp))
            }
        }
        }) {padding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()

        )
        {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(5.dp)
                    .background(color = Color.Gray)
                    .clip(CircleShape)
            )
            {
                Text("Docs screen!", style = TextStyle(fontSize = 22.sp))
            }    }
    }
}
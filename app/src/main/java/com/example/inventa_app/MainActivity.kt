package com.example.inventa_app

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.inventa_app.navigation.NavRoute
import com.example.inventa_app.navigation.NoteNavHost
import com.example.inventa_app.ui.theme.InventaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            InventaAppTheme {
                val context = LocalContext.current
                val mViewModel: MainViewModel = viewModel(
                    factory = MainViewModelFactory(context.applicationContext as Application)) as MainViewModel
                mViewModel.initDatabase()
                mViewModel.initItemDatabase()
                NoteNavHost(mViewModel)
            }
        }
    }
}





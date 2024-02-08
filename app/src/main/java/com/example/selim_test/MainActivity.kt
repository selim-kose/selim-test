package com.example.selim_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.selim_test.ui.theme.SelimtestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SelimtestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   AppNavigation()
                }
            }
        }
    }


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Settings.route) { SettingsScreen(navController) }
        composable(Screen.Images.route) { ImageScreen(navController)}
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    var number by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("")}
    val sum = remember { mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "HomeScreen", color = Color.Red )
        TextField(value = number,  visualTransformation = PasswordVisualTransformation(), label = { Text(text = "Numer 1")}, onValueChange = { userIput -> number = userIput })
        OutlinedTextField(value = number2,label = { Text(text = "Numer 1")}, onValueChange = { userIput -> number2 = userIput })

        Text(text = sum.value.toString())

        Row {
            Button(onClick = {navController.navigate(Screen.Settings.route) }) {
                Text(text = "Go Images")
            }
            Button(onClick = {navController.navigate(Screen.Images.route) }) {
                Text(text = "Go Settings")
            }
            Button(onClick = { sum.value = number + number2}) {
                Text(text = "Count")
            }
        }
        Image(
            painter = rememberAsyncImagePainter("https://www.google.com/url?sa=i&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FBarack_Obama&psig=AOvVaw3JUsM09lLJKJ1-c2TL40yi&ust=1707488012311000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCMCIrNX2m4QDFQAAAAAdAAAAABAE"),
            contentDescription = "Translated description of what the image contains",
            )

    }
}

@Composable
fun SettingsScreen(navController: NavController) {
    Column {
        Text(text = "SettingScreen")
        Button(onClick = {navController.navigate(Screen.Home.route) }) {
            Text(text = "Go Home")
        }
    }
}

@Composable
fun ImageScreen(navController: NavController) {
    Button(onClick = { navController.navigate(Screen.Home.route) }) {
        Text(text = "Go Home")
    }
}
}

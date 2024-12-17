package com.aire.listasjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aire.listasjetpack.ui.theme.ListasjetpackTheme

data class User(
    val name : String
)

val users = mutableListOf(
    User("Manueh"),
    User("Pepe"),
    User("Juan"),
    User("Alejandro")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                val navigationController = rememberNavController()
                NavHost(navController = navigationController, startDestination = "home"){
                    composable("home"){
                        HomeScreen(navigationCOntroller = navigationController)
                    }
                    composable("profile"){
                        ProfileScreen()
                    }
                }
                navigationController.navigate("home")
            }
        }
    }
}

@Composable
fun HomeScreen(navigationCOntroller: NavHostController){

}

@Composable
fun ProfileScreen(){

}

@Composable
fun Listas(){
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        val state = rememberLazyListState()
        LazyColumn(
            state = state,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(users){ user ->
                Text(text = user.name)
            }
        }

        HorizontalDivider(thickness = 2.dp, color = Color.Black, modifier = Modifier.fillMaxWidth())

        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(users){ user ->
                Text(text = user.name)
            }
        }

        HorizontalDivider(thickness = 2.dp, color = Color.Black, modifier = Modifier.fillMaxWidth())

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(users){ user ->
                Text(text = user.name)
            }
        }
    }
}

@Composable
fun CustomCard(){
    var expanded by remember {
        mutableStateOf(false)
    }
    Card() {
        Column(modifier = Modifier
            .width(200.dp)
            .clickable { expanded = !expanded }, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null, modifier = Modifier.size(40.dp))
            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Text(text = "Esto es una aplicación")
            }
        }
    }
}

@Composable
fun Tutorial(){
    var contador by remember {
        mutableStateOf(0)
    }
    Column {
        var value by remember {
            mutableStateOf("")
        }
        TextField(
            value = value ,
            onValueChange = {
                value = it
            }
        )
        Button(
            onClick = { contador ++}
        ) {
            Text(text = "$contador $value")
        }
        var checked by remember {
            mutableStateOf(false)
        }
        Switch(
            checked = checked ,
            onCheckedChange = {
                checked = it
            }
        )
        var checkedBox by remember {
            mutableStateOf(false)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkedBox,
                onCheckedChange = {
                    checkedBox = it
                }
            )
            Text(text = "Acepto los terminos")
        }


    }
}



package com.luismakeapp.navigationwithmvvm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import com.luismakeapp.navigationwithmvvm.ui.AppViewModel
//Package for viewmodel()
import androidx.lifecycle.viewmodel.compose.viewModel
//Package for NavHostController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
//Package for rememberNavController
import androidx.navigation.compose.rememberNavController
import com.luismakeapp.navigationwithmvvm.ui.firstScreen
import com.luismakeapp.navigationwithmvvm.ui.secondScreen
import com.luismakeapp.navigationwithmvvm.ui.thirdScreen

//Enum class that represents screen in app
enum class Screen{
    First(),
    Second(),
    Third()
}

@Composable
fun screenApp(
        viewModel: AppViewModel = viewModel(),
        navController: NavHostController = rememberNavController()
    ){
    //UiState for change values in the app
    val uiState by viewModel.uiState.collectAsState()


    //NavHost inform to the navgraph which screen is present
    NavHost(navController = navController, startDestination = Screen.First.name){
        composable(route = Screen.First.name){
            firstScreen(
                onButtonClicked = {name, age ->
                    viewModel.nameAge(name, age)
                    navController.navigate(Screen.Second.name)
                }
            )
        }
        composable(route = Screen.Second.name){
            secondScreen(
                uiState.name,
                uiState.age,
                onButtonClicked = {
                    navController.navigate(Screen.Third.name)
                }
            )
        }
        composable(route = Screen.Third.name){
            thirdScreen(
                uiState.result,
                onButtonClicked = {viewModel.makeCalc()},
                onCancelButtonClicked = {
                    viewModel.reset()
                    navController.popBackStack(Screen.First.name, inclusive = false)
                }
            )
        }
    }


}
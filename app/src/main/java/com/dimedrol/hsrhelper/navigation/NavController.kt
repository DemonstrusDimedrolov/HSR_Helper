package com.dimedrol.hsrhelper.navigation

import androidx.compose.foundation.layout.PaddingValues
import com.dimedrol.hsrhelper.data.MainMenuScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dimedrol.hsrhelper.data.AllCharactersScreen
import com.dimedrol.hsrhelper.data.AllConeScreen
import com.dimedrol.hsrhelper.data.AllRelicsScreen
import com.dimedrol.hsrhelper.ui.screens.AllCharacters
import com.dimedrol.hsrhelper.ui.screens.AllCone
import com.dimedrol.hsrhelper.ui.screens.AllRelics
import com.dimedrol.hsrhelper.ui.screens.MenuScreen

@Composable
fun MainApp(paddingValues: PaddingValues) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MainMenuScreen) {
        composable<MainMenuScreen> {
            MenuScreen(
                paddingValues,
                onNavigateToAllCharacters = { navController.navigate(AllCharactersScreen) },
                onNavigateToAllCone = { navController.navigate(AllConeScreen) },
                onNavigateToAllRelics = { navController.navigate(AllRelicsScreen) }
            )
        }

        composable<AllCharactersScreen> {
            AllCharacters()
        }

        composable<AllConeScreen> {
            AllCone()
        }

        composable<AllRelicsScreen> {
            AllRelics()
        }
    }
}
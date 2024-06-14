package com.fiap.appemail.navigation.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fiap.appemail.navigation.bottomNavigation.BottomBarScreens
import com.fiap.appemail.screen.MailScreen
import com.fiap.appemail.screen.MeetScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    onNavigationIconClick: () -> Unit,
    onShowUserDialog: () -> Unit,

    ) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreens.MailScreen.route,
    ) {
        composable(
            BottomBarScreens.MailScreen.route
        ) {
            MailScreen(
                onNavigationIconClick = onNavigationIconClick,
                onShowUserDialog = onShowUserDialog
            )
        }

        composable(
            BottomBarScreens.MeetScreen.route
        )
        {
            MeetScreen(
                onNavigationIconClick = onNavigationIconClick,
                onShowUserDialog = onShowUserDialog
            )

        }
    }
}
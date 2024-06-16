package com.fiap.appemail.navigation.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fiap.appemail.screen.MailScreen
import com.fiap.appemail.screen.SendScreen

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
            SendScreen(
                onNavigationIconClick = onNavigationIconClick,
                onShowUserDialog = onShowUserDialog
            )

        }
    }
}

@Preview
@Composable
fun BottomNavGraphPreview() { }
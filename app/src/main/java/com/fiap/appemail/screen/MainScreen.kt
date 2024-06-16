package com.fiap.appemail.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fiap.appemail.navigation.bottomNavigation.BottomBar
import com.fiap.appemail.navigation.bottomNavigation.BottomNavGraph
import com.fiap.appemail.navigation.drawer.DrawerBody
import kotlinx.coroutines.launch


@SuppressLint("RememberReturnType")
@Composable
fun MainScreen(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var isDialogOpen by remember {
        mutableStateOf(false)
    }
    var isSendEmailOpen by remember {
        mutableStateOf(false)
    }
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawerBody()
        }, bottomBar = {
            BottomBar(navController = navController)
        }) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues = paddingValues)) {
            BottomNavGraph(navController = navController,
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                },
                onShowUserDialog = { isDialogOpen = true }
            )

            if (isDialogOpen) {
                ShowUserDialog(onCloseUserDialog = { isDialogOpen = false })
            }

        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}
package com.fiap.appemail.navigation.drawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id: String,
    val title: String,
    val icon: ImageVector,
)

val navScreenItemList = listOf(
    MenuItem(
        id = "primary",
        title = "Primary",
        icon = Icons.Outlined.Inbox,
    ),
    )

val googleAppsItemList = listOf(
    MenuItem(
        id = "calendar",
        title = "Calendar",
        icon = Icons.Outlined.CalendarToday,
    ),
    MenuItem(
        id = "contacts",
        title = "Contacts",
        icon = Icons.Outlined.AccountCircle,
    ),

    )


val allLabelsItemList = listOf(
    MenuItem(
        id = "starred",
        title = "Starred",
        icon = Icons.Outlined.Star,
    ),
    )


val extraItemList = listOf(
    MenuItem(
        id = "settings",
        title = "Settings",
        icon = Icons.Outlined.Settings,
    ),
    MenuItem(
        id = "helpAndFeedBack",
        title = "Help and feedback",
        icon = Icons.Outlined.Help,
    ),

    )


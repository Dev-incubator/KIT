package com.devincubator.keepintime.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, var icon: ImageVector) {
    object Home: NavigationItem("home", Icons.Outlined.Home)
    object Meetings: NavigationItem("meetings", Icons.Outlined.ThumbUp)
    object Contacts: NavigationItem("contacts", Icons.Outlined.Person)
    object Tasks: NavigationItem("tasks",Icons.Outlined.Edit)
}

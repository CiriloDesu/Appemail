package com.fiap.appemail.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fiap.appemail.R

@Composable
fun SendScreen(
    onNavigationIconClick: () -> Unit,
    onShowUserDialog: () -> Unit,
) {
    Scaffold(modifier = Modifier.fillMaxSize(),

        topBar = {

            CenterAlignTopAppbar(
                onShowUserDialog = onShowUserDialog,
                onNavigationIconClick = onNavigationIconClick
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {

                EmailCalenScreen()

            }
        }
    }
}

@Composable
fun CenterAlignTopAppbar(
    onShowUserDialog: () -> Unit,
    onNavigationIconClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),

        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = { onNavigationIconClick() }, modifier = Modifier.size(42.dp)) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = null)
        }

        Text(
            modifier = Modifier.weight(1f),
            text = "Alpha 0.1.0",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Color.Yellow,
        )
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = null,
            modifier = Modifier
                .size(42.dp)
                .clickable { onShowUserDialog() }
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun MeetScreenPreview() {
    SendScreen(onNavigationIconClick = {}, onShowUserDialog = {})
}

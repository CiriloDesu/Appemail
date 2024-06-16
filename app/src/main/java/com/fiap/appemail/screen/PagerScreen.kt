package com.fiap.appemail.screen

import ReminderFormScreen
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.fiap.appemail.ui.theme.DarkBlue


@OptIn(ExperimentalPagerApi::class)
@Composable
fun EmailCalenScreen() {
    val pagerState = rememberPagerState()

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = 2,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            // Display the correct screen based on the position
            when (position) {
                0 -> PagerScreen(ScreenPagers = SendEmailScreen())
                1 -> PagerScreen(ScreenPagers = ReminderFormScreen())
            }
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f),
            pagerState = pagerState,
            activeColor = DarkBlue
        )
    }
}


@Composable
fun PagerScreen(ScreenPagers: Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun MeetPagerScreenPreview() {
    EmailCalenScreen()
}
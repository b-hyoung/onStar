package com.bobCompany.onstarMobileApp.ui
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(modifier: Modifier = Modifier, message: String) {
    Text(
        text = "서버 응답: $message",
        modifier = modifier
    )
}
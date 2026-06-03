package com.jabez.kazilink.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.ui.text.font.Font
import com.jabez.kazilink.R
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import com.jabez.kazilink.navigation.ROUTE_LOGIN

val CourierPrime = FontFamily(
    Font(R.font.courierprime_regular
    )
)

@Composable
fun SplashScreen(navController: androidx.navigation.NavHostController) {

    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate(ROUTE_LOGIN)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF00CFE8), // Cyan
                        Color(0xFF7EEBB2), // Mint Green
                        Color(0xFFECEFF1)  // Light Grey
                    )
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.kazilogo),
            contentDescription = "KaziLink Logo",
            modifier = Modifier.size(160.dp)
        )

        Text(
            text = "KaziLink",
            fontFamily = CourierPrime,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Connect. Task. Done.",
            fontFamily = CourierPrime,
            fontSize = 16.sp
        )
    }
}
package com.jabez.kazilink.screens.forgotpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.jabez.kazilink.R
import com.jabez.kazilink.screens.login.CourierPrime

@Composable
fun ForgotPasswordScreen(navController: NavHostController) {

    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF00CFE8),
                        Color(0xFF7EEBB2),
                        Color(0xFFECEFF1)
                    )
                )
            )
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.kazilogo),
            contentDescription = "KaziLink Logo",
            modifier = Modifier.size(140.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Enter to send password reset pin",
            fontFamily = CourierPrime,
            fontSize = 16.sp,
            fontWeight = FontWeight.Thin
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        Button(
            onClick = { }
        ) {
            Text("Send")
        }
        // Logo

        // FORGOT PASSWORD title

        // Description text

        // Email field

        // SEND PIN button

        // Back to Login button

    }
}
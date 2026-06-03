package com.jabez.kazilink.screens.resetpassword

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
import androidx.compose.material3.TextButton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavHostController

import com.jabez.kazilink.R
import com.jabez.kazilink.screens.login.CourierPrime

@Composable
fun ResetPasswordScreen(navController: NavHostController) {

    var pin by remember { mutableStateOf("") }
    var pinVerified by remember { mutableStateOf(false) }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

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
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "RESET PASSWORD",
            fontFamily = CourierPrime,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Enter the 6-digit PIN sent to your email",
            fontFamily = CourierPrime
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = pin,
            onValueChange = { pin = it },
            label = { Text("6-Digit PIN") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                if (pin == "000000") {
                    pinVerified = true
                }
            }
        ) {
            Text(
                text = "ENTER",
                fontFamily = CourierPrime
            )
        }

        if (!pinVerified) {

            Text(
                text = "Enter the 6-digit PIN sent to your email",
                fontFamily = CourierPrime
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = pin,
                onValueChange = { pin = it },
                label = { Text("6-Digit PIN") }
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    if (pin == "000000") {
                        pinVerified = true
                    }
                }
            ) {
                Text(
                    text = "ENTER",
                    fontFamily = CourierPrime
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextButton(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text(
                text = "Back to Login",
                fontFamily = CourierPrime
            )
        }
    }
}
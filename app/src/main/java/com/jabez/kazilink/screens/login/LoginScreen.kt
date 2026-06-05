package com.jabez.kazilink.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jabez.kazilink.R
import androidx.navigation.NavHostController
import com.jabez.kazilink.navigation.ROUTE_FORGOT_PASSWORD
import com.jabez.kazilink.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth


val CourierPrime = FontFamily(
    Font(R.font.courierprime_regular
    )
)

@Composable
fun LoginScreen(navController: NavHostController) {

    val auth = FirebaseAuth.getInstance()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
            text = "LOGIN",
            fontFamily = CourierPrime,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )

        TextButton(
            onClick = {
                navController.navigate(ROUTE_FORGOT_PASSWORD)
            }
        ) {
            Text(
                text = "Forgot Password?",
                fontFamily = CourierPrime
            )
        }
        Spacer(modifier = Modifier.height(4.dp))

        Button(
            onClick = {
                auth.signInWithEmailAndPassword(
                    email,
                    password
                ).addOnCompleteListener { task ->

                    if (task.isSuccessful) {
                        println("Login Successful")
                    } else {
                        println(task.exception?.message)
                    }
                }
            }
        ) {
            Text(
                text = "Login",
                fontFamily = CourierPrime
            )
        }
        TextButton(
            onClick = {
                navController.navigate(ROUTE_REGISTER)
            }
        ) {
            Text(
                text = "Create Account",
                fontFamily = CourierPrime,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginScreen()
}*/

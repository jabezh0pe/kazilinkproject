package com.jabez.kazilink.screens.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jabez.kazilink.screens.login.CourierPrime

data class Gig(
    val category: String,
    val title: String,
    val description: String,
    val client: String,
    val price: String,
    val date: String
)

@Composable
fun DashboardScreen() {

    val gigs = listOf(
        Gig(
            "TECH & CODING",
            "Python Assignment: Flask API Setup",
            "Looking for help debugging a Flask API project.",
            "Erick Otieno",
            "KES 1,500",
            "2026-05-27"
        ),
        Gig(
            "DESIGN & WRITING",
            "Graduation Photo Editing",
            "Need photos professionally edited.",
            "Mercy Wanjiku",
            "KES 2,000",
            "2026-05-28"
        ),
        Gig(
            "CULINARY & CRAFTS",
            "Birthday Cupcake Order",
            "Need custom cupcakes for a birthday event.",
            "Brian Kiprop",
            "KES 1,800",
            "2026-05-28"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0F1E))
            .padding(12.dp)
    ) {

        Text(
            text = "KAZILINK CORE",
            color = Color(0xFF00E5B0),
            fontFamily = CourierPrime,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = true,
                onClick = {},
                label = { Text("ALL") }
            )

            FilterChip(
                selected = false,
                onClick = {},
                label = { Text("ERRANDS") }
            )

            FilterChip(
                selected = false,
                onClick = {},
                label = { Text("ACADEMIC") }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(gigs) { gig ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF111827)
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = gig.category,
                            color = Color.Gray,
                            fontSize = 12.sp
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = gig.title,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = gig.description,
                            color = Color.LightGray
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement =
                                Arrangement.SpaceBetween
                        ) {

                            Text(
                                text = "Client: ${gig.client}",
                                color = Color.White
                            )

                            Text(
                                text = gig.price,
                                color = Color(0xFF00E5B0),
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = gig.date,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}
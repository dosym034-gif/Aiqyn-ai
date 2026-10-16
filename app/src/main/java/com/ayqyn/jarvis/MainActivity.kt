package kz.ayqyn.jarvis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFF080B12)
private val Accent = Color(0xFF65B8FF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JarvisScreen()
        }
    }
}

@Composable
fun JarvisScreen() {
    var message by remember { mutableStateOf("") }
    var response by remember {
        mutableStateOf("Сәлем! Мен AYQYN JARVIS.")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "AYQYN / JARVIS",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "✦",
            fontSize = 72.sp,
            color = Accent
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = response,
            color = Color.White,
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            placeholder = {
                Text("Сұрағыңызды жазыңыз...")
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            singleLine = false
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                if (message.isNotBlank()) {
                    response = "Сіз жаздыңыз: $message"
                    message = ""
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Accent,
                contentColor = Background
            )
        ) {
            Text("Жіберу")
        }
    }
}

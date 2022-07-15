package com.example.login_ui

import android.content.Context
import android.graphics.ColorSpace
import android.graphics.Paint
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.contextaware.ContextAware
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login_ui.ui.theme.Login_UITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                Login()
            }
        }
    }
}

@Composable
fun Login() {
    val inputvalue = remember { mutableStateOf(TextFieldValue()) }
    val inputvalue2 = remember { mutableStateOf(TextFieldValue()) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()

    ) {

        Column(
            modifier = Modifier
                .background(color = Color.White)
                .padding(20.dp), verticalArrangement = Arrangement.Center
        )
        {

            //background(color = Color.hsv(212F, 38.8F, 26.3F, 0F, colorSpace = ColorSpaces.Srgb
            Card(shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp), modifier = Modifier.padding(bottom = 25.dp)) {
                Column() {
                    TextField(
                        value = inputvalue.value, onValueChange = { inputvalue.value = it },
                        placeholder = { Text(text = "Email") },
                        textStyle = TextStyle(color = Color.White),
                        modifier = Modifier.fillMaxWidth()

                    )
                    TextField(
                        value = inputvalue2.value, onValueChange = { inputvalue2.value = it },
                        placeholder = { Text(text = "Password") },
                        textStyle = TextStyle(color = Color.White),
                        modifier = Modifier.fillMaxWidth()

                    )
                }
            }
            Card(shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp)) {
                Button(
                    onClick = {
                    }, modifier = Modifier
                        .fillMaxWidth()
                )
                {
                    Text(text = "Login")
                }
            }
            Text(
                text = "- OR -",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(0.dp, 25.dp, 0.dp, 0.dp)
                    .fillMaxWidth()
            )
            Card(shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp), modifier = Modifier.padding(top=25.dp)) {
                Button(
                    onClick = {
                    }, modifier = Modifier
                        .fillMaxWidth()

                )
                {
                    Text(text = "Sign in with Google")
                }
            }
            Text(
                text = "Need help? Call Us",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(0.dp, 25.dp, 0.dp, 0.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Login_UITheme {
        Login()
    }
}
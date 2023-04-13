package com.example.copiatext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.copiatext.ui.theme.CopiaTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CopiaTextTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    CopyText()
                }
            }
        }
    }
}

@Composable
fun CopyText(){
    var textoCopy by remember { mutableStateOf("")}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = textoCopy,
            onValueChange = { textoCopy = it },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = textoCopy,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(8.dp)
            )
        Button(onClick = { textoCopy = "" },
            modifier = Modifier.fillMaxWidth(),
            enabled = textoCopy.isNotEmpty(),
            
            ) {
            Text(text = "Clear")
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewCopytext(){
    CopyText()
}
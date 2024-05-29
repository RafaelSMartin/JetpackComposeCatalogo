package com.rsmartin.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rsmartin.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class ProgressBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MyProgress()
                        MyProgressAdvance()
                    }
                }
            }
        }
    }
}

@Composable
fun MyProgressAdvance() {
    var progressStatus by rememberSaveable { mutableStateOf(0f) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LinearProgressIndicator(progress = progressStatus)

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { if (progressStatus < 1) progressStatus += 0.1f }) {
                Text(text = "Incrementar")
            }
            Button(onClick = { if (progressStatus > 0) progressStatus -= 0.1f }) {
                Text(text = "Reducir")
            }
        }
    }
}

@Composable
fun MyProgress() {
    var showLoading by rememberSaveable { mutableStateOf(false) }

    Column(
        Modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 10.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                trackColor = Color.Green
            )
        }

        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "show/hide")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultProgressBarPreview() {
    JetpackComposeCatalogoTheme {
        Column {
            MyProgress()
            MyProgressAdvance()
        }
    }
}
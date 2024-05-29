package com.rsmartin.jetpackcomposecatalogo


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rsmartin.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class TextFieldsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var myText by remember { mutableStateOf("Aris") }

                    Column {
                        MyText()
                        MyTextField(myText) { myText = it }
                        MyTextFieldAdvance()
                        MyTextFieldOutlined()
                    }

                }
            }
        }
    }
}


@Composable
fun MyTextFieldOutlined() {
    var myText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Holita") },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Magenta,
            unfocusedIndicatorColor = Color.Blue
        )
    )
}

@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }

    TextField(
        value = myText,
        onValueChange = {
            myText =
                if (it.contains("a")) it.replace("a", "")
                else it
        },
        label = { Text(text = "Introduce tu nombre") })
}

@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChanged(it) })
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo Azul", color = Color.Blue)
        Text(text = "Esto es un ejemplo extra bold", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo light", fontWeight = FontWeight.Light)
        Text(
            text = "Esto es un ejemplo cursive",
            style = TextStyle(fontFamily = FontFamily.Cursive)
        )
        Text(
            text = "Esto es un ejemplo LineThrough",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es un ejemplo Underline",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Esto es un ejemplo combine", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline, TextDecoration.LineThrough)
                )
            )
        )
        Text(text = "Esto es un ejemplo", fontSize = 30.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultTextFieldsPreview() {
    JetpackComposeCatalogoTheme {
        MyTextFieldOutlined()
    }
}
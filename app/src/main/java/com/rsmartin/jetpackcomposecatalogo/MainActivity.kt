package com.rsmartin.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rsmartin.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyStateExample()
                }
            }
        }
    }
}

@Composable
fun MyStateExample() {
    var counter by rememberSaveable { mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text("Pulsar")
        }
        Text(text = "He sido pulsado ${counter} veces")
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MySampleComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1")
        }
        MySpacer(30)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 2")
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 3")
            }
        }
        MySpacer(80)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Magenta)
                .weight(1f),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 4")
        }
    }

}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan)
        ) {}
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Hola q dises")
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta)
        ) {

        }
    }
}

@Composable
fun MyRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "Ejemplo 1", modifier = Modifier
                .background(Color.Red)
                .width(100.dp)
        )
        Text(
            "Ejemplo 2", modifier = Modifier
                .background(Color.Black)
                .width(100.dp)
        )
        Text(
            "Ejemplo 3", modifier = Modifier
                .background(Color.Cyan)
                .width(100.dp)
        )

        Text(
            "Ejemplo 1", modifier = Modifier
                .background(Color.Red)
                .width(100.dp)
        )
        Text(
            "Ejemplo 2", modifier = Modifier
                .background(Color.Black)
                .width(100.dp)
        )
        Text(
            "Ejemplo 3", modifier = Modifier
                .background(Color.Cyan)
                .width(100.dp)
        )
    }
}

@Composable
fun MyColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "Ejemplo 1", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 2", modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            "Ejemplo 3", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
    }
}

@Composable
fun MyBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Esto es un ejemplo")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        MyStateExample()
    }
}
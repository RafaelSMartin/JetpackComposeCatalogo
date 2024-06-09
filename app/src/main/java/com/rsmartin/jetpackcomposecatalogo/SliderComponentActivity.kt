package com.rsmartin.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rsmartin.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class SliderComponentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        BasicSlider()
                        AdvanceSlider()
                        MyRangeSlider()
                    }
                }
            }
        }
    }
}

@Composable
fun MySlider() {
    BasicSlider()
}


@Preview(showBackground = true)
@Composable
fun DefaultSliderComponentsPreview() {
    JetpackComposeCatalogoTheme {

    }
}
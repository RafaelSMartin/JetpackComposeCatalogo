package com.rsmartin.jetpackcomposecatalogo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rsmartin.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class DialogComponentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    var show by remember { mutableStateOf(false) }
                    var showCustom by remember { mutableStateOf(false) }
                    var showCustomDialog by remember { mutableStateOf(false) }
                    var showConfirmationDialog by remember { mutableStateOf(false) }


                    Column(
                        Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = { show = true }) {
                            Text(text = "Mostrar Dialogo")
                        }
                        MyAlertDialog(
                            show = show,
                            onConfirm = { Log.i("PUTOTAG", "myDialog click confirm") },
                            onDismiss = { show = false },
                        )

                        Button(onClick = { showCustom = true }) {
                            Text(text = "Mostrar Custom Simple Dialogo")
                        }
                        MySimpleCustomDialog(
                            show = showCustom,
                            onConfirm = { Log.i("PUTOTAG", "mySimpleCustomDialog click confirm") },
                            onDismiss = { showCustom = false },
                        )

                        Button(onClick = { showCustomDialog = true }) {
                            Text(text = "Mostrar Custom Dialogo")
                        }
                        MyCustomDialog(
                            show = showCustomDialog,
                            onConfirm = { Log.i("PUTOTAG", "myCustomDialog click confirm") },
                            onDismiss = { showCustomDialog = false },
                        )

                        Button(onClick = { showConfirmationDialog = true }) {
                            Text(text = "Mostrar Confirmation Dialogo")
                        }
                        MyConfirmationDialog(
                            show = showConfirmationDialog,
                            onConfirm = { Log.i("PUTOTAG", "myConfirmationDialog click confirm") },
                            onDismiss = { showConfirmationDialog = false },
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultDialogComponentsPreview() {
    JetpackComposeCatalogoTheme {
        MyAlertDialog(true, {}, {})
    }
}
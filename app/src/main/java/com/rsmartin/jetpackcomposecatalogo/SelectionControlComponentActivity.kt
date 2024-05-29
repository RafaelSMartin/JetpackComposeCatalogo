package com.rsmartin.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rsmartin.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class SelectionControlComponentExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val myOptions = getOptions(
                        listOf("Aris", "Ejemplo", "Pikachu")
                    )

                    Column {
                        MySwitch()
                        MyCheckBox()
                        MyCheckBoxWithText()
                        myOptions.forEach {
                            MyCheckBoxWithTextCompleted(it)
                        }
                        MyTriStatusCheckBox()
                    }
                }
            }
        }
    }
}

@Composable
fun myRadioButton() {

}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    TriStateCheckbox(state = status, onClick = {
        when (status) {
            ToggleableState.On -> status = ToggleableState.Off
            ToggleableState.Off -> status = ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> status = ToggleableState.On
        }
    })
}


@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus }
        )
    }
}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
    Row(
        Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) },
        )
        Spacer(Modifier.width(8.dp))
        Text(text = checkInfo.title)
    }
}

@Composable
fun MyCheckBoxWithText() {
    var state by rememberSaveable { mutableStateOf(false) }

    Row(
        Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = state,
            onCheckedChange = { state = !state },
        )
        Spacer(Modifier.width(8.dp))
        Text(text = "Ejemplo 1")
    }
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(false) }

    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = false,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Green,
            checkmarkColor = Color.Yellow,
        )
    )

}

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(false) }
    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Cyan,
            uncheckedThumbColor = Color.Red,
            checkedTrackColor = Color.Green,
            uncheckedTrackColor = Color.Magenta,

            disabledCheckedTrackColor = Color.Blue.copy(0.3f),
            disabledCheckedThumbColor = Color.Blue.copy(0.8f),
            disabledUncheckedTrackColor = Color.Yellow.copy(0.3f),
            disabledUncheckedThumbColor = Color.Yellow.copy(0.8f),
        )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultSwitchPreview() {
    JetpackComposeCatalogoTheme {
        MySwitch()
    }
}
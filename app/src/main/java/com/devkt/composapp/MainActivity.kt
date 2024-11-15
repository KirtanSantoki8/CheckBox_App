package com.devkt.composapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devkt.composapp.ui.theme.ComposAppTheme
import androidx.compose.ui.graphics.RectangleShape

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CheckCheckBox(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CheckCheckBox(modifier: Modifier = Modifier){
    var checkedBlue by remember { mutableStateOf(true) }
    var checkedRed by remember { mutableStateOf(true) }
    var checkedGreen by remember { mutableStateOf(true) }
    Column {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 60.dp, start = 16.dp)) {
            Checkbox(
                checked = checkedBlue,
                onCheckedChange = { checkedBlue = it }
            )
            Text(
                text = "Blue Color",
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 16.dp)) {
            Checkbox(
                checked = checkedRed,
                onCheckedChange = { checkedRed = it }
            )
            Text(
                text = "Red Color",
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 16.dp)) {
            Checkbox(
                checked = checkedGreen,
                onCheckedChange = { checkedGreen = it }
            )
            Text(
                text = "Green Color",
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        Box {
            if (checkedBlue) RectangleShape(shape = RectangleShape, width = 300, height = 600, color = Color.Blue, value = 0)
            if (checkedRed) RectangleShape(shape = RectangleShape, width = 200, height = 400, color = Color.Red, value = 50)
            if (checkedGreen) RectangleShape(shape = RectangleShape, width = 100, height = 200, color = Color.Green, value = 50)
        }
    }
}

@Composable
fun RectangleShape(shape: Shape,width: Int,height: Int,color: Color,value: Int){
    Column(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)) {
        Box(
            modifier = Modifier.size(width.dp, height.dp).clip(shape).background(color).padding(top = value.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckCheckBoxPreview() {
    ComposAppTheme {
        CheckCheckBox()
    }
}
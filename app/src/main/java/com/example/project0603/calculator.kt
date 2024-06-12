package com.example.project0603

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview


class calculator : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            calculator1()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun calculatorPreview() {
    Text(text = "hello world")
}

//@Composable
//fun calculator1() {
//    var text by remember {
//        mutableIntStateOf(0)
//    }
//    Column {
//        TextField(
//            value = text,
//            onValueChange = { text = it },
//            label = { Text("환전할 금액을 알려주세요") }
//        )
//        val total: Int = (text.toInt() / 10000) * 1300
//        val hide by remember {
//            mutableStateOf(true)
//        }
//
//        Button(onClick = {
//            hide == !hide
//        }) {
//            if (hide == true)
//                Text("환전할 금액은 ${total}입니다.")
//        }
//    }
//}
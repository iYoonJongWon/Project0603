package com.example.project0603

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

class China : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                val context = LocalContext.current
                val assetManager = context.assets
                val extractedNumbers = Exchange(2, assetManager, "exchange2.csv")
                Column {
                    Column {
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "중국 위안화 환율 ${extractedNumbers.last()}원", fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(20.dp))
                        Row {
                            Text(text = "1년 최소가 ${extractedNumbers.min()}원", fontSize = 20.sp)
                            Spacer(Modifier.width(20.dp))
                            Text(text = "1년 최대가 ${extractedNumbers.max()}원", fontSize = 20.sp)
                        }
                        Spacer(modifier = Modifier.height(50.dp))

                        Uitext(R.drawable.china, "중국", "CNY", "1위안", "1")
                        Spacer(modifier = Modifier.height(20.dp))
                        Uitext(
                            R.drawable.korea,
                            "한국",
                            "KRW",
                            "${extractedNumbers.last().roundToInt()}원",
                            "${extractedNumbers.last().roundToInt()}"
                        )
                        Spacer(modifier = Modifier.height(50.dp))


                        LineChartCountry(2)

                        Spacer(modifier = Modifier.height(50.dp))

                        Row {
//                            ButtonCalculator()
                            Spacer(modifier = Modifier.width(60.dp))
                            ButtonCountrySubfinish(USA::class.java, "달러")
                            Spacer(modifier = Modifier.width(60.dp))
                            ButtonCountrySubfinish(Japan::class.java, "엔화")
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ChinaPreview1() {
    val context = LocalContext.current
    val assetManager = context.assets
    val extractedNumbers = Exchange(2, assetManager, "exchange2.csv")
    Column {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "중국 위안화 환율 ${extractedNumbers.last()}원", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(text = "1년 최소가 ${extractedNumbers.min()}원", fontSize = 20.sp)
                Spacer(Modifier.width(20.dp))
                Text(text = "1년 최대가 ${extractedNumbers.max()}원", fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(50.dp))

            Uitext(R.drawable.china, "중국", "CNY", "1위안", "1")
            Spacer(modifier = Modifier.height(20.dp))
            Uitext(
                R.drawable.korea,
                "한국",
                "KRW",
                "${extractedNumbers.last().roundToInt()}원",
                "${extractedNumbers.last().roundToInt()}"
            )
            Spacer(modifier = Modifier.height(50.dp))

            LineChartCountry(2)

            Spacer(modifier = Modifier.height(50.dp))

            Row {
//                ButtonCalculator()
                Spacer(modifier = Modifier.width(60.dp))
                ButtonCountrySubfinish(USA::class.java, "달러")
                Spacer(modifier = Modifier.width(60.dp))
                ButtonCountrySubfinish(Japan::class.java, "엔화")
            }
        }
    }
}
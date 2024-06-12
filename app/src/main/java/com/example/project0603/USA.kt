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
import kotlin.math.roundToLong

class USA : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val assetManager = context.assets
            val extractedNumbers = Exchange(1,assetManager, "exchange2.csv")

            Column {
                Column {
                    Row {
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "미국 달러 환율 ${extractedNumbers.last()}원", fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(20.dp))
                    Row {
                        Text(text = "1년 최소가 ${extractedNumbers.min()}원", fontSize = 20.sp)
                        Spacer(Modifier.width(20.dp))
                        Text(text = "1년 최대가 ${extractedNumbers.max()}원", fontSize = 20.sp)
                    }

                    Spacer(modifier = Modifier.height(50.dp))

                    Uitext(R.drawable.usa, "미국", "USD", "1 달러","1")
                    Spacer(modifier = Modifier.height(20.dp))
                    Uitext(R.drawable.korea, "한국", "KRW", "${extractedNumbers.last().roundToInt()}원","${extractedNumbers.last().roundToInt()}")

                    Spacer(modifier = Modifier.height(50.dp))

                    LineChartCountry(1)

                    Spacer(modifier = Modifier.height(50.dp))

                    Row {
//                        ButtonCalculator()
                        Spacer(modifier = Modifier.width(60.dp))
                        ButtonCountrySubfinish(Japan::class.java,"엔화")
                        Spacer(modifier = Modifier.width(60.dp))
                        ButtonCountrySubfinish(China::class.java,"위안화")
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun USAPreview1() {
    val context = LocalContext.current
    val assetManager = context.assets
    val extractedNumbers = Exchange(1,assetManager, "exchange2.csv")

    Column {
        Column {
            Row {
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "미국 달러 환율 ${extractedNumbers.last()}원", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(text = "1년 최소가 ${extractedNumbers.min()}원", fontSize = 20.sp)
                Spacer(Modifier.width(20.dp))
                Text(text = "1년 최대가 ${extractedNumbers.max()}원", fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.height(50.dp))

            Uitext(R.drawable.usa, "미국", "USD", "1 달러","1")
            Spacer(modifier = Modifier.height(20.dp))
            Uitext(R.drawable.korea, "한국", "KRW", "${extractedNumbers.last().roundToInt()}원","${extractedNumbers.last().roundToInt()}")

            Spacer(modifier = Modifier.height(50.dp))

            LineChartCountry(1)

            Spacer(modifier = Modifier.height(50.dp))

            Row {
//                        ButtonCalculator()
                Spacer(modifier = Modifier.width(60.dp))
                ButtonCountrySubfinish(Japan::class.java,"엔화")
                Spacer(modifier = Modifier.width(60.dp))
                ButtonCountrySubfinish(China::class.java,"위안화")
            }
        }
    }
}
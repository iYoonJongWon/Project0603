package com.example.project0603


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.example.project0603.ui.theme.Project0603Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project0603Theme {

                Column {
                    Spacer(modifier = Modifier.height(50.dp))
                    Image(painter = painterResource(id = R.drawable.main),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.FillBounds,
                    )


                    Row {
                        Spacer(modifier = Modifier.width(90.dp))
                        Textname(name = "환율 알리미 시작", size = 30, fColor = Color.Gray)
                    }
                    Row {
                        Spacer(modifier = Modifier.width(80.dp))
                        ButtonCountryMain(USA::class.java, "달러")
                        ButtonCountryMain(Japan::class.java, "엔화")
                        ButtonCountryMain(China::class.java, "위안화")
                        Spacer(modifier = Modifier.height(20.dp))
                    }


                    Row {
                        Spacer(modifier = Modifier.width(20.dp))
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Column {
        Spacer(modifier = Modifier.height(50.dp))
        Image(painter = painterResource(id = R.drawable.main),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.FillBounds,
        )


        Row {
            Spacer(modifier = Modifier.width(90.dp))
            Textname(name = "환율 알리미 시작", size = 30, fColor = Color.Gray)
        }
        Row {
            Spacer(modifier = Modifier.width(80.dp))
            ButtonCountryMain(USA::class.java, "달러")
            ButtonCountryMain(Japan::class.java, "엔화")
            ButtonCountryMain(China::class.java, "위안화")
            Spacer(modifier = Modifier.height(20.dp))
        }


        Row {
            Spacer(modifier = Modifier.width(20.dp))
        }
    }
}


@Composable
fun Textname(name: String, size: Int, fColor: Color) {
    Text(text = name, fontSize = size.sp, color = fColor)
}

@Composable
fun LineChartCountry(number: Int) {
    val context = LocalContext.current
    val assetManager = context.assets
    val extractedNumbers = Exchange(number, assetManager, "exchange2.csv")

    val steps = 8
    val pointcount = 22

    val pointsData = (1..pointcount - 1).map { i ->
        Point(i.toFloat(), extractedNumbers[extractedNumbers.size - pointcount + i].toFloat())
    }

    val stepSize = 120f / steps
    if (pointsData.isNotEmpty()) {

        val xAxisData = AxisData.Builder()
            .axisStepSize(stepSize.dp)
            .startDrawPadding(65.dp)
            .backgroundColor(Color.Blue)
            .steps(pointsData.size - 1)
            .labelData { i -> i.toString() }
            .labelAndAxisLinePadding(15.dp)
            .build()

        val yAxisData = AxisData.Builder()
            .steps(steps)
            .backgroundColor(Color.Red)
            .labelAndAxisLinePadding(10.dp)
            .labelData { i ->
                "%.1f".format(extractedNumbers.max() - ((extractedNumbers.max() - extractedNumbers.min()) / (i + 1)))  // 싱글 프리시전 포매팅
            }.build()

        val lineChartData = LineChartData(
            linePlotData = LinePlotData(
                lines = listOf(
                    Line(
                        dataPoints = pointsData,
                        LineStyle(),
                        IntersectionPoint(),
                        SelectionHighlightPoint(),
                        ShadowUnderLine(),
                        SelectionHighlightPopUp()
                    )
                ),
            ),
            xAxisData = xAxisData,
            yAxisData = yAxisData,
            gridLines = GridLines(),
            backgroundColor = Color.White
        )
        LineChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            lineChartData = lineChartData
        )
    } else {
        Text("데이터가 충분하지 않습니다.")
    }
}


@Composable
fun ButtonCountryMain(name: Class<*>, moneyname: String) {
    val context = LocalContext.current
    Button(onClick = {
        val intent = Intent(context, name)
        context.startActivity(intent)
    }) {
        Text(text = moneyname)
    }
}

@Composable
fun ButtonCountryMainfix(name: Class<*>, moneyname: String,) {
    val context = LocalContext.current
    Button(onClick = {
        val intent = Intent(context, name)
        context.startActivity(intent)
    }) {

        Text(text = moneyname)
    }
}

@Composable
fun ButtonCountrySubfinish(name: Class<*>, moneyname: String) {
    val activity = (LocalContext.current as? Activity)
    Button(onClick = {
        activity?.finish()
        val intent = Intent(activity, name)
        if (activity != null) {
            activity.startActivity(intent)
        }
    }) {
        Text(text = moneyname)
    }
}


@Composable
fun Imagecountry(country: Int) {
    Image(painterResource(id = country), contentDescription = null)
}

@Composable
fun Uitext(
    CountryImg: Int,
    Countryname: String,
    CountryMoneyCode: String,
    CountryMoneyKoreaName: String,
    Countrycost: String
) {
    Column {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .height(80.dp)
                .background(color = Color.LightGray)
        ) {
            Column {
                Spacer(modifier = Modifier.height(15.dp))
                Row {
                    Spacer(modifier = Modifier.width(20.dp))
                    Image(
                        painter = painterResource(id = CountryImg),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)
                    )
                    Column {
                        Row {
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(text = Countryname, fontSize = 18.sp)
                            Spacer(modifier = Modifier.width(220.dp))
                            Text(text = Countrycost, fontSize = 18.sp)
                        }
                        Row {
                            Spacer(modifier = Modifier.width(20.dp))
                            Text(text = CountryMoneyCode, fontSize = 18.sp, color = Color.Gray)
                            Spacer(modifier = Modifier.width(180.dp))
                            Text(text = CountryMoneyKoreaName, fontSize = 18.sp, color = Color.Gray)
                        }
                    }
                }
            }
        }
    }
}



package com.example.project0603

import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.opencsv.CSVReader
import java.io.BufferedReader
import java.io.InputStreamReader

class DataCsv : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val assetManager = this.assets
        val inputStream = assetManager.open("exchange2.csv")
        val reader = CSVReader(InputStreamReader(inputStream))
        val allcontent = reader.readAll()
        for (content in allcontent) {
            Log.i("blog", content.toList().toString())
        }
//        var nextLine: Array<String>? = arrayOf()
//        while (nextLine.apply {
//                nextLine = reader.readNext()
//            } != null) {
//            Log.i("blog", nextLine?.get(7)?.toList().toString())
//        }
    }
}

@Composable
fun Exchange(country: Int ,assetManager: AssetManager, fileName: String): List<Double> {
    val inputStream = assetManager.open(fileName)
    val reader = BufferedReader(InputStreamReader(inputStream))
    val numbers = mutableListOf<Double>()

    var line: String?
    while (reader.readLine().also { line = it } != null) {
        // CSV 파일에서 각 행의 첫 번째 숫자를 추출하여 리스트에 추가합니다.
        val parts = line?.split(",")
        parts?.get(country)?.toDoubleOrNull()?.let {
            numbers.add(it)
        }
    }
    return numbers
}


@Preview(showBackground = true)
@Composable
fun DataCsv1Preview() {
    val context = LocalContext.current
    val assetManager = context.assets
    val extractedNumbers = Exchange(1,assetManager, "exchange2.csv")

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Extracted Numbers:")

        // 추출된 숫자를 보여주는 Text 컴포넌트를 반복적으로 생성합니다.
        Text(text = extractedNumbers[3].toString())
}
}


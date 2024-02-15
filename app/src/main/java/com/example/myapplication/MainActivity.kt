
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.lang.NumberFormatException
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TimCalculator(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}


fun CalculateTip(billSize: Float, tipPercentage: Float = 0.15f) : String {
    val amount = billSize * tipPercentage;
    return NumberFormat.getCurrencyInstance().format(amount);
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimCalculator(modifier: Modifier = Modifier.fillMaxSize()) {
    Column(
        modifier = modifier.padding(16.dp)
        , verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var billAmount by remember { mutableStateOf(value = ""); }
        Text(
            modifier = Modifier.align(Alignment.Start)
            , text = stringResource(R.string.calculate_tip)
            , fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        EditNumberField(
            modifier = Modifier.fillMaxWidth()
            , fieldValue = billAmount
            , label = stringResource(R.string.bill_amount)
            , onValueChanged = { billAmount = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
            , fontSize = 32.sp
            , fontWeight = FontWeight.ExtraBold
            , text = stringResource(R.string.tip_amount
                , CalculateTip(billAmount.toFloatOrNull() ?: 0f))
            , style = MaterialTheme.typography.displaySmall
            )

    }
}

@ExperimentalMaterial3Api
@Composable
fun  EditNumberField(
    modifier: Modifier
    , fieldValue: String
    , onValueChanged: (String)->Unit = {}
    , label: String = "Some label"
) {
    println("Recomposition EditNumberField")

    TextField(
        value = fieldValue
        , modifier = modifier
        , onValueChange = onValueChanged
        , label = { Text(text = label) }
        , keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
            , autoCorrect = false)
        , singleLine = true
    );
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        TimCalculator(modifier = Modifier.fillMaxSize())
    }
}
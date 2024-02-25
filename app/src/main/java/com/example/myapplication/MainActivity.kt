
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
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
                    TimCalculator(modifier = Modifier.fillMaxSize(), app = this)
                }
            }
        }
    }

    public var mBillAmount = mutableStateOf<String>("");
    public var mTipPercentage = mutableStateOf<String>("");
    public var mRoundUpTip = mutableStateOf<Boolean>(false);
}


fun CalculateTip(billSize: Float, tipPercentage: Float = 0.15f, roundUpTip: Boolean = false) : String {
    val amount: Float = billSize * tipPercentage;
    return NumberFormat.getNumberInstance().format(if(!roundUpTip) amount else kotlin.math.ceil(amount));
}

@Composable
fun SwitchWithLabel(
    @StringRes label: Int
    , checked: Boolean = false
    , onCheckedChanged: ((Boolean)->Unit)?
    , modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
        , verticalAlignment = Alignment.CenterVertically
        , horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = stringResource(id = label));
        Switch(checked = checked, onCheckedChange = onCheckedChanged);
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimCalculator(modifier: Modifier = Modifier.fillMaxSize(), app: MainActivity? = null) {
    Column(
        modifier = modifier
            .statusBarsPadding()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
        , verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var billAmount by remember { app?.mBillAmount ?: mutableStateOf(""); };
        var tipPercentage by remember { app?.mTipPercentage ?: mutableStateOf(""); };
        var roundUpTip by remember { app?.mRoundUpTip ?: mutableStateOf<Boolean>(false); };
        Text(
            modifier = Modifier.align(Alignment.Start)
            , text = stringResource(R.string.calculate_tip)
            , fontSize = 24.sp)
        Spacer(modifier = Modifier.height(60.dp))
        EditNumberField(
            modifier = Modifier.fillMaxWidth()
            , fieldValue = billAmount
            , label = R.string.bill_amount
            , onValueChanged = { billAmount = it }
            , leadingIcon = R.drawable.money
        )
        Spacer(modifier = Modifier.height(60.dp))
        EditNumberField(
            label = R.string.tip_percentage_label
            , fieldValue = tipPercentage.toString()
            , onValueChanged = { value ->
                tipPercentage = value;
            }
            , modifier = Modifier.fillMaxWidth()
            , imeAction = ImeAction.Done
            , leadingIcon = R.drawable.percent
        )
        Spacer(modifier = Modifier.height(60.dp))
        SwitchWithLabel(
            modifier = Modifier
                .fillMaxWidth()
                .size(48.dp)
            , checked = roundUpTip
            , label = R.string.round_up_tip_label
            , onCheckedChanged = { roundUpTip = it; }
        );
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
            , fontSize = 32.sp
            , fontWeight = FontWeight.ExtraBold
            , text = stringResource(R.string.tip_amount
                , CalculateTip(billAmount.toFloatOrNull() ?: 0f, (tipPercentage.toFloatOrNull()?:0f) / 100f, roundUpTip))
            , style = MaterialTheme.typography.displaySmall
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun  EditNumberField(
    fieldValue: String
    , @StringRes label: Int
    , @DrawableRes leadingIcon: Int
    , onValueChanged: (String)->Unit = {}
    , imeAction: ImeAction = ImeAction.Next
    , modifier: Modifier = Modifier
) {
    println("Recomposition EditNumberField")

    TextField(
        value = fieldValue
        , modifier = modifier
        , onValueChange = onValueChanged
        , label = { Text(text = stringResource(id = label)) }
        , leadingIcon = { Icon(painterResource(id = leadingIcon), "") }
        , keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
            , autoCorrect = false
            , imeAction = imeAction)
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
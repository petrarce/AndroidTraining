package com.example.lemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonapp.ui.theme.LemonAppTheme
import androidx.compose.ui.graphics.Color as AndroidColor

class MainActivity : ComponentActivity() {
    enum class States {
        LemonTree,
        Lemon,
        Lemonade,
        EmptyLemonade
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainView(
                        app = this,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }

    fun switchState(): Unit {
        when(state.value) {
            States.LemonTree -> state.value = States.Lemon;
            States.Lemon -> {
                if(numPressesToSquees == 0) {
                    state.value = States.Lemonade
                    numPressesToSquees = (Math.random() * 4).toInt();
                }
                else
                    numPressesToSquees--;
            };
            States.Lemonade -> state.value = States.EmptyLemonade;
            States.EmptyLemonade -> state.value = States.LemonTree;
        }
        printCurrentState();
    }

    fun printCurrentState() {
        when(state.value) {
            States.LemonTree -> println("LemonTree");
            States.Lemon -> println("Lemon");
            States.Lemonade -> println("Lemonade");
            States.EmptyLemonade -> println("EmptyLemonade");
        }
    }
    public var state = mutableStateOf(States.LemonTree)
        private set(st) {field = st; }

    private var numPressesToSquees = 2;
}

@Composable
fun MainView(modifier: Modifier = Modifier, app: MainActivity? = null) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        val appState = if (app != null)
            remember { app.state; }
        else
            remember { mutableStateOf(MainActivity.States.LemonTree); }

        Image (
            modifier = Modifier.fillMaxWidth(0.5f)
                .aspectRatio(1f)
                .background(
                    color = Color(android.graphics.Color.parseColor("#C3ECD2")),
                    shape = RoundedCornerShape(32.dp))
                .clip(shape = RoundedCornerShape(32.dp))
                .clickable { app?.switchState() },
            painter = painterResource( id = when(appState.value) {
                MainActivity.States.LemonTree -> R.drawable.lemon_tree;
                MainActivity.States.Lemon -> R.drawable.lemon_squeeze
                MainActivity.States.Lemonade -> R.drawable.lemon_drink;
                else -> R.drawable.lemon_restart;
            }),
            contentDescription = "Image describing lemon tree")
        Spacer (modifier = Modifier.height(16.dp))
        Text (text = when(appState.value) {
            MainActivity.States.LemonTree -> "Tap get some lemon";
            MainActivity.States.Lemon -> "Tap to squeeze some lemonade";
            MainActivity.States.Lemonade -> "Tap to drink";
            MainActivity.States.EmptyLemonade -> "Want more? Tap again!";
            else -> ""
        })
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    LemonAppTheme {
        MainView(
            Modifier
                .fillMaxSize()
                .border(width = 4.dp, color = Color.Red)
        )
    }
}
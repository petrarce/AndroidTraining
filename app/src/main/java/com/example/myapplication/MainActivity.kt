package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

/**
 * The main activity of the application.
 *
 * This activity sets up the Compose UI and displays the main content
 * within a MaterialTheme and Surface container.
 * It also handles the initial creation of the activity.
 */
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
                    Greeting("Android")
                }
            }
        }
    }
}

/**
 * Composable function that displays a greeting message.
 *
 * @param name The name to include in the greeting.
 * @param modifier The modifier to apply to the text composable.
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

/**
 * Preview function for the Greeting composable.
 *
 * This function is used to preview the UI of the Greeting composable
 * within the Android Studio design view.
 *
 * The `@Preview` decorator allows to view the UI without running the app in a device or simulator.
 *  `showBackground = true` displays a background. `showSystemUi = true` displays system UI.
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}
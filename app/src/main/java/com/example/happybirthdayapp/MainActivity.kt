package com.example.happybirthdayapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.happybirthdayapp.ui.theme.HappyBirthdayAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayAppTheme {
                // A snonameurface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(to = "Android", from = "Iohannes")
                }
            }
        }
    }
}


@Composable
fun Article(modifier: Modifier = Modifier) {
    Column (modifier = modifier.padding(8.dp)) {
        val bgPicture = painterResource(id = R.drawable.bg_compose_background);
        Image(
            painter = bgPicture,
            contentDescription = null,
            modifier = modifier.fillMaxWidth()
        );
        Text(
            text = stringResource(R.string.ArticleHerder),
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(16.dp)
        );
        Text(
            text = stringResource(R.string.ArticleDescription),
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 16.dp, end = 16.dp)
        );
        Text(
            stringResource(R.string.ArticleBody),
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(16.dp)
        );
    }
}

@Composable
fun TaskManager(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.ic_task_completed),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        );
        Text(
            text = "All Done",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp, bottom = 8.dp)
        );
        Text(
            text = "Nice Work!",
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        );
    }
}

@Composable
fun Quadrant(
        modifier: Modifier = Modifier,
        color : Color = Color.Green,
        composableName : String = "Composable name",
        description : String = "Composable description") {
        Column(
            modifier = modifier
                .background(color)
                .padding(start = 16.dp)
                .padding(end = 16.dp)
                .padding(top = 16.dp)
                .padding(bottom = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center) {

            Text(
                text = composableName,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            );
            Text(
                text = description,
                textAlign = TextAlign.Justify);
        }
}

@Composable
fun Quadrants(modifier : Modifier = Modifier) {
//    Text composable
//            Displays text and follows the recommended Material Design guidelines.
//    Image composable
//            Creates a composable that lays out and draws a given Painter class object.
//    Row composable
//            A layout composable that places its children in a horizontal sequence.
//    Column composable
//            A layout composable that places its children in a vertical sequence.

    Column(verticalArrangement = Arrangement.Top, modifier = modifier) {
        Row(modifier = Modifier.weight(1f)) {
            Quadrant(
                color = Color(0xFFEADDFF),
                modifier= Modifier.weight(1f),
                composableName = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.");
            Quadrant(
                color = Color(0xFFD0BCFF),
                modifier= Modifier.weight(1f),
                composableName = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object.");
        }
        Row(modifier = Modifier.weight(1f)) {
            Quadrant(
                color = Color(0xFFB69DF8),
                modifier= Modifier.weight(1f),
                composableName = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence.");
            Quadrant(
                color = Color(0xFFF6EDFF),
                modifier= Modifier.weight(1f),
                composableName = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.");
        }

    }
}
@Composable
fun GreetingText(to: String = stringResource(R.string.default_receiver), from: String = stringResource(R.string.default_author), modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp),
        ) {
        Text(
            textAlign = TextAlign.Center,
            text = stringResource(R.string.happy_birthday) + to,
            fontSize = 50.sp,
            lineHeight = 50.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        );
        Text(
            textAlign = TextAlign.Right,
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .align(Alignment.End)
                .padding(32.dp)
        );
    }
}

@Composable
fun GreetingImage(
        from: String = "NoName",
        to: String = "Author",
        modifier: Modifier = Modifier): Unit {
    val partyImagePainter = painterResource(id = R.drawable.androidparty);
    Box (modifier = modifier){
        Image(
            painter = partyImagePainter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        );
        GreetingText(
            to = to,
            from = from,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        )
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Quadrants(modifier = Modifier.fillMaxSize())
}
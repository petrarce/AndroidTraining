package com.example.happybirthdayapp
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class BusinessCardActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
		super.onCreate(savedInstanceState, persistentState)
		setContent {
			MainApp(Modifier.fillMaxSize());
		}
	}
};

@Composable
fun MainApp(modifier : Modifier = Modifier) {


	Column(modifier = modifier, verticalArrangement = Arrangement.Bottom){
		Box(modifier = Modifier
			.padding(bottom = 100.dp)
			.fillMaxHeight(0.4f)
			.fillMaxWidth()
			.border(width = 5.dp, color = Color.Blue)
			.padding(8.dp)){
			Column(
				modifier = Modifier.fillMaxSize(),
				verticalArrangement = Arrangement.Center){
				Row(
					modifier = Modifier
						.weight(4f)
						.fillMaxWidth()
						.border(width = 5.dp, Color.Blue)
						.padding(5.dp)
					, horizontalArrangement = Arrangement.Center){
					val img = painterResource(id = R.drawable.androidparty);
					Image(
						modifier = Modifier
							.padding(8.dp)
							.align(Alignment.CenterVertically)
							.aspectRatio(1f)
						, painter = img
						, contentDescription=null
						, contentScale = ContentScale.Crop);
				}
				Text(
					modifier = Modifier
						.weight(2f)
						.fillMaxWidth()
						.border(width = 5.dp, Color.Blue)
						.padding(5.dp)
					, textAlign = TextAlign.Center
					, text = "Full Name"
					, fontSize = 50.sp
					, fontWeight = FontWeight.Bold
				);
				Text(
					modifier = Modifier
						.weight(1f)
						.fillMaxWidth()
						.border(width = 5.dp, Color.Blue)
						.padding(5.dp)
					, textAlign = TextAlign.Center
					, text = "Title"
					, fontSize = 20.sp
					, fontWeight = FontWeight.Normal
				);
			}
//			Surface(Modifier.fillMaxSize().padding(5.dp).border(width = 5.dp, color = Color.Cyan)){}
		}
		Column(
				modifier = Modifier
					.fillMaxHeight(0.5f)
					.fillMaxWidth()
					.border(width = 5.dp, color = Color.Blue)
					.padding(8.dp)) {
			Surface(modifier = Modifier
				.fillMaxWidth()
				.weight(1f)
				.padding(5.dp)
				.border(width = 5.dp, color = Color.Cyan)){}
			Surface(modifier = Modifier
				.fillMaxWidth()
				.weight(1f)
				.padding(5.dp)
				.border(width = 5.dp, color = Color.Cyan)){}
			Surface(modifier = Modifier
				.fillMaxWidth()
				.weight(1f)
				.padding(5.dp)
				.border(width = 5.dp, color = Color.Cyan)){}
		}
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview(){
	MainApp(Modifier.fillMaxSize());
}
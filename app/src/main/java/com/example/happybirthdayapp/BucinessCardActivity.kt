package com.example.happybirthdayapp.BusinessCard

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthdayapp.R
import com.example.happybirthdayapp.ui.theme.HappyBirthdayAppTheme

class BusinessCardActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			HappyBirthdayAppTheme {
				MainApp(Modifier.fillMaxSize());
			}
		}
	}
}

@Composable
fun MainApp(modifier : Modifier = Modifier) {


	Column(modifier = modifier, verticalArrangement = Arrangement.Bottom){
		Box(modifier = Modifier
			.fillMaxHeight(0.4f)
			.fillMaxWidth()
			.padding(8.dp)){
			Column(
				modifier = Modifier.fillMaxSize(),
				verticalArrangement = Arrangement.Center){
				Row(
					modifier = Modifier
						.weight(4f)
						.fillMaxWidth()
						.padding(5.dp)
					, horizontalArrangement = Arrangement.Center){
					val img = painterResource(id = R.drawable.man_with_beard);
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
						.padding(5.dp)
					, textAlign = TextAlign.Center
					, text = "Petrarce"
					, fontSize = 50.sp
					, fontWeight = FontWeight.Bold
				);
				Text(
					modifier = Modifier
						.weight(1f)
						.fillMaxWidth()
						.padding(5.dp)
					, textAlign = TextAlign.Center
					, text = "C++ Software Engineer"
					, fontSize = 20.sp
					, fontWeight = FontWeight.Normal
				);
			}
		}
		Spacer(modifier =
			Modifier.height(100.dp))
		Column(
				modifier = Modifier
					.fillMaxHeight(0.5f)
					.fillMaxWidth()
					.padding(8.dp)) {
			ContactInformation(modifier = Modifier
				.fillMaxWidth()
				.weight(1f)
				.padding(5.dp)
				, icon = Icons.Filled.Call
				, info = "+12 3456789012"
			);
			ContactInformation(modifier = Modifier
				.fillMaxWidth()
				.weight(1f)
				.padding(5.dp)
				, icon = Icons.Filled.Email
				, info = "petrarce@gmail.com"
			);
			ContactInformation(modifier = Modifier
				.fillMaxWidth()
				.weight(1f)
				.padding(5.dp)
				, icon = Icons.Filled.Share
				, info = "@AndroidDev"
			);

		}
	}
}

@Composable
fun ContactInformation(
	modifier : Modifier = Modifier,
	info : String = "Contact information",
	icon : ImageVector = Icons.Filled.Clear
) {

	Row(modifier = modifier
		, horizontalArrangement = Arrangement.SpaceBetween){
		Icon(
			modifier = Modifier
				.aspectRatio(1f)
				.fillMaxHeight()
				.padding(4.dp)
			, imageVector = icon
			, contentDescription = null);
		Box(modifier = Modifier
			.align(Alignment.CenterVertically)
			.fillMaxSize()
			.padding(4.dp)
		) {
			Text(
				modifier = Modifier
					.align(Alignment.Center)
					.padding(4.dp)
				, text = info
				, textAlign = TextAlign.Center
				, fontSize = 20.sp)
		}

	}
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview(){
	HappyBirthdayAppTheme {
		MainApp(Modifier.fillMaxSize());
	}

}

package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    BusinessCardImage(
                        name = "Brendan Coughlan",
                        email = "bcoughlan2404@gmail.com"
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardText(name: String, email: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().padding(0.dp)
    )
    {
        Text(
            text = name,
            fontSize = 60.sp,
            lineHeight = 60.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
        Text(
            text = email,
            fontSize = 24.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
    }
}

@Composable
fun BusinessCardImage(name: String, email: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.profile_image)
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(20.dp),
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
        BusinessCardText(
            name = name,
            email = email,
            modifier = modifier.fillMaxSize().padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        BusinessCardImage(
            name = "Brendan Coughlan",
            email = "bcoughlan2404@gmail.com"
        )
    }
}
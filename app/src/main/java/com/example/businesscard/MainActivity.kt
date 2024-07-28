package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFcffad5)) {
                BusinessCardTheme{
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCardTop(
    title: String,
    desc: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.android_logo)
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
         {
            Box(modifier = Modifier.background(Color(0xFF0a3628))) {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(12.dp)
                )
            }
            Text(
                text = title,
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 35.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 5.dp)
            )
            Text(
                text = desc,
                fontSize = 12.sp,
                fontStyle = FontStyle.Italic,
                color = Color(0xFF06420e)
            )
        }
    }

@Composable
fun BusinessCardBottom(
    number: String,
    email: String,
    social: String,
    modifier: Modifier = Modifier
){
    Column {
        Row(Modifier.padding(bottom = 12.dp)) {
            Icon(
                Icons.Rounded.Call,
                contentDescription = "PhoneIcon",
                modifier = Modifier.padding(end = 12.dp),
                tint = Color(0xFF01690f)
            )
            Text(text = number, textAlign = TextAlign.Center, color = Color(0xFF01690f))
        }
        Row(Modifier.padding(bottom = 12.dp)) {
            Icon(
                Icons.Rounded.Share,
                contentDescription = "SocialMediaIcon",
                modifier = Modifier.padding(end = 12.dp),
                tint = Color(0xFF01690f)
            )
            Text(text = social, textAlign = TextAlign.Center, color = Color(0xFF01690f))
        }
        Row {
            Icon(
                Icons.Rounded.Email,
                contentDescription = "EmailIcon",
                modifier = Modifier.padding(end = 12.dp),
                tint = Color(0xFF01690f)
            )
            Text(text = email, textAlign = TextAlign.Center, color = Color(0xFF01690f))
        }
    }
}

@Composable
fun BusinessCard() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(280.dp),
            contentAlignment = Alignment.Center)
        {
            BusinessCardTop(
                title = stringResource(R.string.title_dev),
                desc = stringResource(R.string.desc_dev),
                backgroundColor = Color.White
            )
        }

        Spacer(modifier = Modifier.height(224.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
            contentAlignment = Alignment.Center)
        {
            BusinessCardBottom(
                number = "+55(61)999999999",
                email = "email@email.com.br",
                social = "github.com/pcconduru",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}
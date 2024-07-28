package com.example.businesscard

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
            Surface(modifier = Modifier.fillMaxSize()) {
                BusinessCardTheme {
                    BusinessCardTop(
                        title = stringResource(R.string.title_dev),
                        desc = stringResource(R.string.desc_dev),
                        backgroundColor = Color.Red)
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
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color(0xFFd8ffd4))
    ){
        Box(modifier = Modifier.background(Color(0xFF0a3628))) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
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
            fontStyle = FontStyle.Italic
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardTop(
            title = stringResource(R.string.title_dev),
            desc = stringResource(R.string.desc_dev),
            backgroundColor = Color(0xFF0a3628)
        )
    }
}
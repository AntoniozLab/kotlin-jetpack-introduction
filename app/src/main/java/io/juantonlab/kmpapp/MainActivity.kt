package io.juantonlab.kmpapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.juantonlab.kmpapp.ui.theme.KMPAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KMPAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val modifier = Modifier
                        .wrapContentSize()
                        .background(Color.LightGray)
                        .height(50.dp)
                        .clickable { Log.d("kmp", "clicked") }

                    Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "Person",
                            modifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                                .border(width = 1.dp, color = Color.Blue)
                        )
                        WelcomeText(modifier, message = "Juan Antonio", fontSize = 15.sp)


                    }
                }
            }
        }
    }
}

@Composable
fun WelcomeText(modifier: Modifier, message: String, fontSize: TextUnit) {
    Box(modifier = modifier, contentAlignment = Alignment.Center){
        Text(
            text = "Bienvenido, $message",
            color = Color.Blue,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )
    }

}

package io.juantonlab.kmpapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
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
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 15.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Card(
                            modifier = Modifier.width(300.dp),
                            border = BorderStroke(1.dp, color = Color.Blue),
                        ) {
                            Column(
                                modifier = Modifier.padding(15.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.Top,
                                    modifier = Modifier.fillMaxWidth()
                                ) {

                                    val headerModifier = Modifier
                                        .wrapContentSize()
                                        .height(50.dp)
                                        .padding(horizontal = 5.dp)
                                        .borderBottom(2.dp, Color.Blue)

                                    Image(
                                        painter = painterResource(id = R.drawable.baseline_person_24),
                                        contentDescription = "Person",
                                        modifier = Modifier
                                            .height(50.dp)
                                            .width(50.dp)
                                    )
                                    CustomBox(
                                        headerModifier,
                                        message = "Bienvenido, Juan Antonio",
                                        fontSize = 15.sp
                                    )
                                }

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center,
                                ) {


                                    val boxButtonModifier = Modifier
                                        .wrapContentSize()
                                        .height(60.dp)
                                        .padding(vertical = 15.dp)
                                        .border(1.dp, color = Color.Black)
                                        .padding(horizontal = 5.dp)

                                    CustomBox(
                                        boxButtonModifier,
                                        message = "Abrir enlace",
                                        fontSize = 15.sp,
                                        color = Color.Black
                                    )

                                }

                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CustomBox(
    modifier: Modifier, message: String, fontSize: TextUnit, color: Color = Color.Blue
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(
            text = message, color = color, fontSize = fontSize, fontWeight = FontWeight.Bold
        )
    }

}


fun Modifier.borderBottom(borderWidth: Dp, color: Color): Modifier = this.then(Modifier.drawBehind {
    val strokeWidth = borderWidth.toPx()
    val y = size.height - strokeWidth / 2
    drawLine(
        color = color, start = Offset(0f, y), end = Offset(size.width, y), strokeWidth = strokeWidth
    )
})
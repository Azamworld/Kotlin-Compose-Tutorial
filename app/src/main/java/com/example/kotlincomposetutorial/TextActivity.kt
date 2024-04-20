package com.example.kotlincomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlincomposetutorial.ui.theme.KotlinComposeTutorialTheme

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        //Display text
                        SimpleText()
                        StringResourceText()

                        //Style Text
                        BlueText()
                        BigText()
                        ItalicText()
                        BoldText()
                        TextShadow()
                        MultipleStylesInText()
                        TextStyleBrush()
                        TextStyleBrushOnSpan()
                        TextStyleSpanWithOpacity()
                      //  Greeting("Android")
                    }

                }
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinComposeTutorialTheme {
        Greeting("Android")
        SimpleText()
    }


}

@Composable
fun SimpleText() {
    Text("Hello World")
}

@Composable
fun StringResourceText() {
    Text(stringResource(R.string.hello_world))
}

@Composable
fun BlueText() {
    Text("Hello World", color = Color.Blue)
}

@Composable
fun BigText() {
    Text("Hello World", fontSize = 30.sp)
}

@Composable
fun ItalicText() {
    Text("Hello World", fontStyle = FontStyle.Italic)
}

@Composable
fun BoldText() {
    Text("Hello World", fontWeight = FontWeight.Bold)
}

@Composable
fun TextShadow() {
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = "Hello world!",
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.Blue, offset = offset, blurRadius = 3f
            )
        )
    )
}

@Composable
fun MultipleStylesInText() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("H")
            }
            append("ello ")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("W")
            }
            append("orld")
        }
    )
}

@Composable
fun TextStyleBrush() {
    val gradientColors = listOf(Cyan, Yellow, Green /*...*/)

    Text(
        text = "Configure your text using a built-in brush within TextStyle. For example, you can configure a linearGradient brush to your text",
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = gradientColors
            )
        )
    )
}

@Composable
private fun TextStyleBrushOnSpan() {
    val gradientColors = listOf(Cyan, LightBlue, Purple /*...*/)

    Text(
        text = buildAnnotatedString {
            append("Do not allow people to dim your shine\n")
            withStyle(
                SpanStyle(
                    brush = Brush.linearGradient(
                        colors = gradientColors
                    )
                )
            ) {
                append("because they are blinded.")
            }
            append("\nTell them to put some sunglasses on.")
        }
    )
}

val LightBlue = Color(0xFF0066FF)
val Purple = Color(0xFF800080)

@Composable
private fun TextStyleSpanWithOpacity() {
    val gradientColors = listOf(Cyan, LightBlue, Purple /*...*/)
    val brush = Brush.linearGradient(colors = gradientColors)

    Text(
        text = buildAnnotatedString {
            withStyle(
                SpanStyle(
                    brush = brush, alpha = .5f
                )
            ) {
                append("Text in ")
            }
            withStyle(
                SpanStyle(
                    brush = brush, alpha = 1f
                )
            ) {
                append("Compose ❤️")
            }
        }
    )
}
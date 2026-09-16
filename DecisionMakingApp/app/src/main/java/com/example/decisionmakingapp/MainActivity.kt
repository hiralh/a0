package com.example.decisionmakingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decisionmakingapp.ui.theme.DecisionMakingAppTheme
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val button = ButtonOperations()
        setContent {
            DecisionMakingAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val introMessage = "Should we go?"
                    Screen(
                        modifier = Modifier.padding(0.dp),
                        introMessage,
                        yesButton = { button.yesButton()},
                        noButton = { button.noButton()},
                        maybeButton = { button.maybeButton()})
                }
            }
        }
    }
}

class ButtonOperations{
    // Code for all the button operations and the button counter
    private val clickCounter = 0

    fun yesButton(){
        // Code for when Yes is pressed
    }

    fun noButton(){
        // Code for when No is pressed
    }

    fun maybeButton(){
        // Code for when Maybe is pressed
    }
}

@Composable
fun Screen(modifier: Modifier,
           message: String,
           yesButton: ()-> Unit,
           noButton: ()-> Unit,
           maybeButton: ()-> Unit) {
    // UI for Background Image
    val image = painterResource(R.drawable.bgimage)
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        //UI for messages and buttons
        Column(modifier = Modifier.size(width = 500.dp, height = 500.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            // For message
            Row(modifier = Modifier.padding(8.dp))
            {
                TextDisplay(modifier, message)
            }
            Spacer(modifier = Modifier.height(10.dp))
            // For buttons
            Row() {
                Button(onClick = {yesButton()},
                    shape  = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .height((50.dp))){
                    Text("YES!")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = {maybeButton()},
                    shape  = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .height((50.dp))){
                    Text("Maybe...")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = {noButton},
                    shape  = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .height((50.dp))){
                    Text("Nope!")
                }
            }
        }
    }
}

@Composable
fun TextDisplay(modifier: Modifier, message: String){
    Text(
        message,
        modifier = modifier,
        color = Color.Black,
        fontSize = 50.sp,
        textAlign = TextAlign.Center,
        //lineHeight = 70.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif
    )
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    val button = ButtonOperations()
    DecisionMakingAppTheme {
        val introMessage = "Should we go?"
        Screen(
            modifier = Modifier.padding(0.dp),
            introMessage,
            yesButton = { button.yesButton()},
            noButton = { button.noButton()},
            maybeButton = { button.maybeButton()})
    }
}
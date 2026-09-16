package com.example.decisionmakingapp

import android.os.Bundle
import android.widget.Space
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
import androidx.compose.runtime.mutableStateOf
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
import androidx.compose.ui.unit.TextUnit
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
                    Screen(
                        modifier = Modifier.padding(0.dp),
                        yesButton = { button.yesButton()},
                        noButton = { button.noButton()},
                        maybeButton = { button.maybeButton()},
                        clickCount = button.clickCounter)
                }
            }
        }
    }
}

// Code for all the button operations and the button counter
class ButtonOperations{
    private var _clickCounter = mutableStateOf(0)

    // Read-only Int for UI display
    val clickCounter: Int
        get() = _clickCounter.value

    fun yesButton(){
        _clickCounter.value++
    }

    fun noButton(){
        _clickCounter.value++
    }

    fun maybeButton(){
        _clickCounter.value++
    }
}

@Composable
fun Screen(modifier: Modifier,
           yesButton: ()-> Unit,
           noButton: ()-> Unit,
           maybeButton: ()-> Unit,
           clickCount: Int) {
    // UI for Background Image
    val image = painterResource(R.drawable.bgimage)
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        // Background image
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop)

        // Student Details
        Column(modifier = Modifier.align(Alignment.TopStart)
            .padding(top = 50.dp, start = 30.dp),
            verticalArrangement = Arrangement.Center){
            Text("Student ID: 1860227",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(10.dp))
            Text("CCID: hhanda2",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold)
        }

        //UI for messages and buttons
        Column(modifier = Modifier.size(width = 500.dp, height = 500.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

            // For intro message
            val introMessage = "Should we go?"
            TextDisplay(Modifier.padding(8.dp), introMessage,45.sp)

            Spacer(modifier = Modifier.height(15.dp))

            // For buttons
            Row() {
                Button(onClick = {yesButton()},
                    shape  = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .height((55.dp))){
                    Text("YES!", fontSize = 24.sp, fontWeight = FontWeight.Normal)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = {maybeButton()},
                    shape  = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .height((55.dp))){
                    Text("Maybe...", fontSize = 24.sp, fontWeight = FontWeight.Normal)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = {noButton()},
                    shape  = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .height((55.dp))){
                    Text("Nope!", fontSize = 24.sp, fontWeight = FontWeight.Normal)
                }
            }
            // For Decision
            // For click counter
            val counterMessage = "Click Count: $clickCount"
            TextDisplay(Modifier.padding(16.dp), counterMessage, 20.sp)
        }
    }
}

@Composable
fun TextDisplay(modifier: Modifier, message: String, textSize: TextUnit){
    Text(
        message,
        modifier = modifier,
        color = Color.Black,
        fontSize = textSize,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif
    )
}

/*@Preview(showBackground = true)
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
            maybeButton = { button.maybeButton()},
            clickCount = button.clickCounter)
    }
}*/
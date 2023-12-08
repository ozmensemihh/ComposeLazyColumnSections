package com.headtopics.composelazycolumnsections

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.headtopics.composelazycolumnsections.ui.theme.ComposeLazyColumnSectionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLazyColumnSectionsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Greeting() {

    val sections = listOf("A","B","C","D")


    LazyColumn(contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)){

        sections.forEach { seciton->
            stickyHeader { Text(modifier =
            Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(12.dp),
                text = "Section $seciton")
            }

            items(5){
                Text(text = "Item sections ${seciton}")
            }
        }


    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeLazyColumnSectionsTheme {
        Greeting()
    }
}
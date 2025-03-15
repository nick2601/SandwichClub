package com.nikhil.sandwichclubproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nikhil.sandwichclubproject.ui.navigation.NavGraph
import com.nikhil.sandwichclubproject.ui.theme.SandwichClubProjectTheme
import com.nikhil.sandwichclubproject.ui.viewmodel.SandwichViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val sandwichViewModel: SandwichViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SandwichClubProjectTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    NavGraph(viewModel = sandwichViewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SandwichClubProjectTheme {
        Text("Sandwich Club App")
    }
}
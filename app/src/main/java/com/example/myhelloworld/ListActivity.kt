package com.example.myhelloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhelloworld.ui.theme.MyHelloWorldTheme
import models.Movie


val movies = listOf<Movie>(
    Movie(
        "The Edge of Tomorrow",
        "Time loop fantasy about hostile aliens and personal growth subtext through cruel repetition.",
        listOf("Tom Cruise", "Emily Blunt", "Bill Paxton", "Charlotte Riley"),
        budget = 123,
    ),
    Movie(
        name = "Once upon a time in Hollywood...",
        description = "All actions happening in Hollywood.",
        listOf("Jonny Depp", "Leonardo Di Caprio"),
        budget = 12444
    ),
)

@Composable
fun MoviesList(movies: List<Movie>) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = movies, itemContent = { movie ->
            MovieItem(movie = movie)
        }) }
}

@Composable
fun MovieItem(movie: Movie) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Name(name = movie.name)
        Budget(budget = movie.budget)
        Description(description = movie.description)
        MyDivider()
        Spacer(Modifier.height(16.dp))
        Actors(actors = movie.actors)
        MyDivider()
    }
}

@Composable
private fun Description(description: String) {
    Text(
        text = description,
        color = Color.Gray,
        fontSize = 20.sp,
        fontFamily = FontFamily.SansSerif,
        textAlign = TextAlign.Left,

    )
}

@Composable
private fun Name(name: String) {
    Text(
        text = name,
        color = Color.Black,
        fontSize = 30.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Left,
        lineHeight = 30.sp
    )
}

@Composable
private fun Budget(budget: Int) {
    Text(
        modifier = Modifier.padding(bottom = 3.dp),
        text = stringResource(id = R.string.detailed_view_budget_label, budget),
        color = Color.Black,
        fontSize = 15.sp,
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
private fun Actors(actors: List<String>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        var i = 0
        for (actor in actors) {
            ActorTextView(actor = actor, ++i == actors.size)
        }
    }
}

@Composable
private fun ActorTextView(actor: String, isTheLastOne: Boolean) {
    Text(
        modifier = Modifier.padding(6.dp, 3.dp),
        text = if (isTheLastOne) actor else "$actor,",
        color = Color.DarkGray,
        fontSize = 19.sp,
        fontFamily = FontFamily.SansSerif,
        fontStyle = FontStyle.Italic
    )
}

@Composable
private fun MyDivider() {
    Divider(color = Color.LightGray)
}

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyHelloWorldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MoviesList(movies = movies)
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
    MyHelloWorldTheme {
        Greeting("Android")
    }
}
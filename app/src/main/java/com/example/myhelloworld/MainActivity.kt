package com.example.myhelloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.myhelloworld.ui.theme.MyHelloWorldTheme
import models.Movie

val movie = Movie("Fight Club", "Guys fighting and demolishing stuff and conservative lifestyle.", listOf("Brad Pitt", "Edward Norton", "Meat Loaf", "Helena Bonham Carter"), 63)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyHelloWorldTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailedView(movie)
                }
            }
        }
    }
}

@Composable
fun DetailedView(movie: Movie) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        MyImage()
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom) {
            Name(name = movie.name)
            Spacer(Modifier.weight(1f))
            Budget(budget = movie.budget)
        }
        Description(description = movie.description)
        MyDivider()
        Spacer(Modifier.height(16.dp))
        Actors(actors = movie.actors)
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom) {
            Image2()
            Image2()
            Image2()
            Image2()
            Image2()
            Image2()
            Image2()
            Image2()
            Image2()
            Image2()
            Text(text = "10 drunk people from 10")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyHelloWorldTheme {
        DetailedView(
            movie = Movie(
                "Fight Club",
                "Guys fighting and demolishing stuff and conservative lifestyle.",
                listOf("Brad Pitt", "Edward Norton", "Meat Loaf", "Helena Bonham Carter"),
                63
            )
        )
    }
}

@Composable
private fun MyDivider() {
    Divider(color = Color.LightGray)
}

@Composable
private fun Name(name: String) {
    Text(
        text = name,
        color = Color.Black,
        fontSize = 30.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center,
    )
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
fun MyImage () {
   AsyncImage(
       model = "https://assets.mubicdn.net/images/artworks/617909/images-original.png?1689617236",
       placeholder = painterResource(
           id = R.drawable.dragon_black
       ),
       error = painterResource(
           id = R.drawable.dragon_black
       ),
       contentDescription = "STUDY",
       contentScale = ContentScale.Crop,
       modifier = Modifier
           .size(350.dp)
           .padding(20.dp)
           .clip(RoundedCornerShape(20.dp))
   )
}

@Composable
fun Image2(){
    Image(
        painter = painterResource(
            id = R.drawable.baseline_local_drink_24),
        contentDescription = stringResource(
        id = R.string.app_name)
    )
}
package com.rabarka.lazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rabarka.lazycolumn.ui.theme.LazyColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AdvanceLazyColumnShower(dogList = dogList(), modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun ListShower(modifier: Modifier) {
    val countryNames = listOf(
        "India",
        "China",
        "Pakistan",
        "Sri Lanka",
        "Nepal",
        "India",
        "China",
        "Pakistan",
        "Sri Lanka",
        "Nepal",
        "India",
        "China",
        "Pakistan",
        "Sri Lanka",
        "Nepal", "India",
        "China",
        "Pakistan",
        "Sri Lanka",
        "Nepal",
        "India",
        "China",
        "Pakistan",
        "Sri Lanka",
        "Nepal",
        "India",
        "China",
        "Pakistan",
        "Sri Lanka",
        "Nepal"
    )
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        countryNames.forEach { country ->
            Text(text = country, fontSize = 32.sp)
        }
    }
}

@Composable
fun LazyColumnShower(modifier: Modifier) {
    LazyColumn {
        //Adding a single item
        item {
            Text(text = "First Item")
        }
        // Adding 7 items
        items(7) {
            Text(text = "Item: $it")
        }
        //adding another single text
        item {
            Text(text = "Last Item")
        }
    }
}

@Composable
fun LazyColumnShower1() {
    val fruitName = listOf("Mango", "Apple", "Banana", "Pineapple", "Peach")
    val textModifier = Modifier
        .padding(8.dp)
        .border(2.dp, Color.Green, RoundedCornerShape(2.dp))
        .padding(4.dp)
    val columnModifier = Modifier
        .fillMaxWidth()
        .background(Color.Transparent)
        .padding(8.dp)

    LazyColumn(modifier = columnModifier) {
        items(fruitName) { fruit ->
            Text(text = fruit, modifier = textModifier)
        }
    }
}

@Composable
fun AdvanceLazyColumnShower(dogList: List<Dog>, modifier: Modifier) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
    ) {
        items(dogList) { dog ->
            DogCard(dog = dog, modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}


@Composable
fun DogCard(dog: Dog, modifier: Modifier) {
    Card(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Image(
                painter = painterResource(id = dog.imageResourceId),
                contentDescription = stringResource(id = dog.nameResourceId),
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(text = stringResource(id = dog.nameResourceId), fontSize = 32.sp)
        }
    }
}


fun dogList(): List<Dog> {
    return listOf(
        Dog(R.string.dog1, R.drawable.dog1),
        Dog(R.string.dog2, R.drawable.dog2),
        Dog(R.string.dog3, R.drawable.dog3),
        Dog(R.string.dog4, R.drawable.dog4),
        Dog(R.string.dog5, R.drawable.dog5),
        Dog(R.string.dog1, R.drawable.dog1),
        Dog(R.string.dog2, R.drawable.dog2),
        Dog(R.string.dog3, R.drawable.dog3),
        Dog(R.string.dog4, R.drawable.dog4),
        Dog(R.string.dog5, R.drawable.dog5)
    )
}


@Preview(showBackground = true)
@Composable
fun DogCardListPreView() {
    AdvanceLazyColumnShower(dogList = dogList(), modifier = Modifier)
}

@Preview(showBackground = true)
@Composable
fun DogCardPreview() {
    DogCard(Dog(R.string.dog2, R.drawable.dog2), Modifier)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LazyColumnTheme {
        ListShower(modifier = Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview1() {
    LazyColumnTheme {
        LazyColumnShower(modifier = Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    LazyColumnTheme {
        LazyColumnShower1()
    }
}

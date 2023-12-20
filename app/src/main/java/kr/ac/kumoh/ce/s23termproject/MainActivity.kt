package kr.ac.kumoh.ce.s23termproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import kr.ac.kumoh.ce.s23termproject.ui.theme.S23TermProjectTheme

class MainActivity : ComponentActivity() {

    private val viewModel:FestivalViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(viewModel)
        }
    }
}

@Composable
fun MainScreen(viewModel: FestivalViewModel) {
    val festivalList by viewModel.festivalList.observeAsState(emptyList())

    S23TermProjectTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            FestivalList(festivalList)
        }
    }
}

@Composable
fun FestivalList(list: List<Festival>) {
    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(list) {
            FestivalItem(it)
        }
    }
}

@Composable
fun FestivalItem(fest: Festival) {

    Card(
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(8.dp)
        ){
            AsyncImage(
                model = fest.image_url,
                contentDescription = "Festival Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(160.dp)
                    .height(220.dp)
                    .clip(RoundedCornerShape(percent = 5))
            )
            Spacer(modifier = Modifier.width(10.dp))

            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                TextName(fest.name)
                TextLoc(fest.location)
                TextDate(fest.start_date, fest.end_date)
            }
        }
    }

}

@Composable
fun TextName(name: String) {
    Text(name, fontSize = 25.sp)
}

@Composable
fun TextLoc(loc: String) {
    Text(loc, fontSize = 15.sp)
}

@Composable
fun TextDate(start: String, end: String) {
    val startD = start.substringBefore("T")
    val endD = end.substringBefore("T")
    Text(startD + " ~ " + endD, fontSize = 15.sp)
}
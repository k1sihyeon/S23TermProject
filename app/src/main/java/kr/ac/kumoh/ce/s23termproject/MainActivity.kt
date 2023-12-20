package kr.ac.kumoh.ce.s23termproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    LazyColumn {
        items(list) {
            FestivalItem(it)
        }
    }
}

@Composable
fun FestivalItem(fest: Festival) {
    Text(text = "이름: ${fest.name}")
    Text(text = "${fest.festival_id}")
    Text(text = "${fest.image_url}")
}
package kr.ac.kumoh.ce.s23termproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import kr.ac.kumoh.ce.s23termproject.ui.theme.S23TermProjectTheme

class MainActivity : ComponentActivity() {

    private val festivalViewModel: FestivalViewModel by viewModels()
    private val performViewModel: PerformanceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(festivalViewModel, performViewModel)
        }
    }
}

@Composable
fun MainScreen(festivalViewModel: FestivalViewModel, performViewModel: PerformanceViewModel) {
    val festivalList by festivalViewModel.festivalList.observeAsState(emptyList())

    S23TermProjectTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            FestivalApp(festivalList, performViewModel)
        }
    }
}

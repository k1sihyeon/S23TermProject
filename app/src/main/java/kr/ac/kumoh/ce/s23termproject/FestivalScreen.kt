package kr.ac.kumoh.ce.s23termproject

import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage

enum class FestivalScreen {
    List,
    Detail
}

@Composable
fun FestivalApp(festivalList: List<Festival>, performViewModel: PerformanceViewModel) {
    val navController = rememberNavController()
    val performList by performViewModel.performList.observeAsState(emptyList())

    NavHost(
        navController = navController,
        startDestination = FestivalScreen.List.name,
    ) {
        composable(route = FestivalScreen.List.name) {
            FestivalList(navController, festivalList)
        }

        composable(
            route = FestivalScreen.Detail.name + "/{index}",
            arguments = listOf(navArgument("index") {
                type = NavType.IntType
            })
            ) {
            val index = it.arguments?.getInt("index") ?: -1
            if (index >= 0) {
                performViewModel.loadPerformances(index + 1)

                FestivalDetail(festivalList[index], performList)
            }

        }
    }
}


@Composable
fun FestivalList(navController: NavController, list: List<Festival>) {
    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(list.size) {
            FestivalItem(navController, list, it)
        }
    }
}

@Composable
fun FestivalItem(navController: NavController, festList: List<Festival>, index: Int) {

    Card(
        modifier = Modifier.clickable {
            navController.navigate(FestivalScreen.Detail.name + "/$index")
        },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(8.dp)
        ){
            AsyncImage(
                model = festList[index].image_url,
                contentDescription = "${festList[index].name} Image",
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
                TextName(festList[index].name)
                TextLoc(festList[index].location)
                TextDate(festList[index].start_date, festList[index].end_date, 15)
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
fun TextDate(start: String, end: String, size: Int) {
    val startD = start.substringBefore("T")
    val endD = end.substringBefore("T")
    Text(startD + " ~ " + endD, fontSize = size.sp)
}


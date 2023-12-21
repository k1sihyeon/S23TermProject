package kr.ac.kumoh.ce.s23termproject

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage

@Composable
fun FestivalDetail(festival: Festival, performList: List<Performance>) {

    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(festival.name, fontSize = 30.sp)
        AsyncImage(
            model = festival.image_url,
            contentDescription = "Festival Image",
            
            )

        TextDate(start = festival.start_date, end = festival.end_date, 20)
        
        Text(text = festival.location, fontSize = 25.sp)

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                val uri =
                    Uri.parse("geo:0,0?q=${festival.address}")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context, intent, null)
            }
        ) {
            Text("지도")
        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) {
            items(performList) {
                PerformItem(it)
            }
        }

    }

}

@Composable
fun PerformItem(perform: Performance) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(

        ){
            AsyncImage(
                model = perform.image_url,
                contentDescription = "${perform.artistName} Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(10))
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(

            ) {
                Text(text = perform.artistName, fontSize = 20.sp)
                Text(perform.performance_date.substringBefore("T"), fontSize = 15.sp)
                Text(perform.stage, fontSize = 15.sp)
                Text(perform.time_start + " ~ " + perform.time_end, fontSize = 15.sp)
            }
        }
    }
}
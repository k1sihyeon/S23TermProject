package kr.ac.kumoh.ce.s23termproject

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import kr.ac.kumoh.ce.s23termproject.ui.theme.pretendardExBold
import kr.ac.kumoh.ce.s23termproject.ui.theme.pretendardM
import kr.ac.kumoh.ce.s23termproject.ui.theme.pretendardR
import kr.ac.kumoh.ce.s23termproject.ui.theme.pretendardSeBold

@Composable
fun FestivalDetail(festival: Festival, performList: List<Performance>) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(8.dp))
        Text(festival.name, fontSize = 30.sp, textAlign = TextAlign.Center, lineHeight = 45.sp, fontFamily = pretendardExBold)

        Spacer(modifier = Modifier.height(16.dp))
        AsyncImage(
            model = festival.image_url,
            contentDescription = "${festival.name} Image",
            modifier = Modifier
                .size(400.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextDate(start = festival.start_date, end = festival.end_date, 20)

        Spacer(modifier = Modifier.height(4.dp))
        
        Text(text = festival.location, fontSize = 20.sp, fontFamily = pretendardM)

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text(text = festival.address, fontSize = 20.sp, fontFamily = pretendardM)
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                modifier = Modifier
                    .width(100.dp),
                onClick = {
                    val uri =
                        Uri.parse("geo:0,0?q=${festival.address}")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(context, intent, null)
                }
            ) {
                Text("지도 🗺️️️", fontFamily = pretendardM)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        performList.forEach {
            PerformItem(it)
        }


    }
}

@Composable
fun PerformItem(perform: Performance) {
    val context = LocalContext.current

    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(10.dp)
            .width(400.dp)
            .clickable {
                val uri =
                    Uri.parse("https://www.youtube.com/results?search_query=${perform.artistName}")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(context, intent, null)
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ){
            AsyncImage(
                model = perform.image_url,
                contentDescription = "${perform.artistName} Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(130.dp)
                    .clip(RoundedCornerShape(10))
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = perform.artistName, fontSize = 23.sp, fontFamily = pretendardSeBold)
                Text(perform.performance_date.substringBefore("T"), fontSize = 15.sp, fontFamily = pretendardR)
                Text(perform.stage, fontSize = 15.sp, fontFamily = pretendardR)
                Text(perform.time_start + " ~ " + perform.time_end, fontSize = 15.sp, fontFamily = pretendardR)
            }
        }
    }
}
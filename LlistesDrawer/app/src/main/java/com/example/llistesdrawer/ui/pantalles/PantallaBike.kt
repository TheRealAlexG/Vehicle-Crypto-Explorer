package com.example.llistesdrawer.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.llistesdrawer.Dades.Bikes
import com.example.llistesdrawer.R

@Preview
@Composable
fun PantallaBike (numero: Int = 1){
    val bikes = Bikes.Bikesid(numero)
    Text(text = "$numero")

    if (bikes != null) {
        Column(modifier=Modifier.background(Color.Blue)) {

            Spacer(modifier =Modifier.height(100.dp) )
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(bikes.foto)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Bikes",
                contentScale = ContentScale.Fit,
                modifier = Modifier.clip(CircleShape)
            )

            Spacer(modifier =Modifier.height(100.dp) )
            Text(text = "Marca: ${bikes.marca}  \n Serie:${bikes.serie}  \n HP: ${bikes.hp} \n ID:${bikes.id}\n ParMotor:${bikes.parmotor} ",

                modifier=Modifier
                    .weight(1F),
                style = MaterialTheme.typography.titleLarge,
                fontWeight= FontWeight.Bold,
                color=Color.White,

            )
            LinearProgressIndicator(progress = bikes.hp.toFloat()/300F,modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(),
                color=Color.Red,



            )
            Spacer(modifier =Modifier.height(100.dp) )

        }


    } else {
        Text(text = "sorry we didint find your bike")
    }
}
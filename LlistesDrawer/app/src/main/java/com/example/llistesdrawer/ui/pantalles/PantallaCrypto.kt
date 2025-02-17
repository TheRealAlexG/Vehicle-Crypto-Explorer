package com.example.llistesdrawer.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.llistesdrawer.Dades.Cryptos
import com.example.llistesdrawer.R


@Preview
@Composable
fun PantallaCrypto (numero: Int = 1){
    val crypto = Cryptos.CryptoId(numero)
    Text(text = "$numero")

    if (crypto != null) {
        Column(modifier= Modifier.background(Color.Blue)) {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(crypto.foto)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Crypto",
                contentScale = ContentScale.Fit,
                modifier = Modifier.clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(100.dp) )
            Text(text = "Marca: ${crypto.marca}  \n COLOR:${crypto.color}  \n ID: ${crypto.id} \n VALOR:${crypto.valor}\n  ",

                modifier= Modifier
                    .weight(1F),
                style = MaterialTheme.typography.titleLarge,
                fontWeight= FontWeight.Bold,
                color= Color.White,


            )

            LinearProgressIndicator(progress = crypto.valor.toFloat()/100000F,modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(),
                color = Color.Magenta

                )
            Spacer(modifier =Modifier.height(100.dp) )
        }


    } else {
        Text(text = "sorry we didint find your bike")
    }
}
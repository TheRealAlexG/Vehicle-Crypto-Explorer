package com.example.llistesdrawer.ui.pantalles

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.llistesdrawer.Dades.Bikes
import com.example.llistesdrawer.R


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Preview
@Composable
fun LlistaBikes (
    onClickElement: (Int) -> Unit = {},
){
    LazyColumn(modifier = Modifier.fillMaxSize() ){
        item { Text(text = "Bikes", fontSize = 45.sp) }
        items(Bikes.dadesBikes){
            ListItem(headlineText = { Text(it.marca)},
                modifier=Modifier.clickable { onClickElement(it.id) },
                leadingContent = {
                    AsyncImage(model =ImageRequest.Builder(LocalContext.current)
                        .data(it.foto)
                        .crossfade(true)
                        .build(),
                        placeholder = painterResource(R.drawable.ic_launcher_background),
                        contentDescription = "Bikes",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.clip(CircleShape).width(80.dp).aspectRatio(1F)

                    )
                },

                )


        }


    }
}
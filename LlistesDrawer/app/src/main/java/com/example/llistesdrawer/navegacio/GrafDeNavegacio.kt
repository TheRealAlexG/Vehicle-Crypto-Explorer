package com.example.llistesdrawer.navegacio

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.llistesdrawer.ui.pantalles.LlistaBikes
import com.example.llistesdrawer.ui.pantalles.LlistaCars
import com.example.llistesdrawer.ui.pantalles.LlistaCrypto
import com.example.llistesdrawer.ui.pantalles.PantallaBike
import com.example.llistesdrawer.ui.pantalles.PantallaCar
import com.example.llistesdrawer.ui.pantalles.PantallaCrypto
import com.example.llistesdrawer.ui.pantalles.PantallaTercera
import com.example.llistesdrawer.ui.pantalles.SegonaPantalla

@Composable
fun GrafDeNavegacio(controladorDeNavegacio: NavHostController = rememberNavController(),paddingValues: PaddingValues){
    NavHost(navController = controladorDeNavegacio , startDestination = CategoriaDeNavegacio.LlistaBikes.rutaPrevia )
    {
        navigation(startDestination = Destinacio.LlistaBikes.rutaBase,route= CategoriaDeNavegacio.LlistaBikes.rutaPrevia)
        {
            composable(route= Destinacio.LlistaBikes.rutaGenerica){
                LlistaBikes(
                    onClickElement = {numero:Int -> controladorDeNavegacio.navigate(Destinacio.PantallaBike.CreaRutaAmbArguments(numero))})
            }

            composable(route= Destinacio.PantallaBike.rutaGenerica, arguments = Destinacio.PantallaBike.navArgs){
                val numero=it.arguments?.getInt(ArgumentDeNavegacio.IdBikes.clau)
                requireNotNull(numero)
                PantallaBike(numero= numero)
            }


        }


        navigation(startDestination = Destinacio.LlistaCars.rutaBase,route= CategoriaDeNavegacio.LlistaCars.rutaPrevia)
        {
            composable(route= Destinacio.LlistaCars.rutaGenerica){
                LlistaCars(
                    onClickElement = {numero:Int -> controladorDeNavegacio.navigate(Destinacio.PantallaCar.CreaRutaAmbArguments(numero))})
            }

            composable(route= Destinacio.PantallaCar.rutaGenerica, arguments = Destinacio.PantallaCar.navArgs){
                val numero=it.arguments?.getInt(ArgumentDeNavegacio.IdCars.clau)
                requireNotNull(numero)
                PantallaCar(numero= numero)
            }


        }


        navigation(startDestination = Destinacio.LlistaCrypto.rutaBase,route= CategoriaDeNavegacio.LlistaCrypto.rutaPrevia)
        {
            composable(route= Destinacio.LlistaCrypto.rutaGenerica){
                LlistaCrypto(
                    onClickElement = {numero:Int -> controladorDeNavegacio.navigate(Destinacio.PantallaCrypto.CreaRutaArguments(numero))})
            }

            composable(route= Destinacio.PantallaCrypto.rutaGenerica, arguments = Destinacio.PantallaCrypto.navArgs){
                val numero=it.arguments?.getInt(ArgumentDeNavegacio.IdCrypto.clau)
                requireNotNull(numero)
                PantallaCrypto(numero= numero)
            }


        }

        navigation(startDestination = Destinacio.Pantalla2.rutaBase,route= CategoriaDeNavegacio.Pantalla2.rutaPrevia)
        {
            composable(route= Destinacio.Pantalla2.rutaGenerica){
                SegonaPantalla()
            }
        }

        navigation(startDestination = Destinacio.Pantalla3.rutaBase,route= CategoriaDeNavegacio.Pantalla3.rutaPrevia)
        {
            composable(route= Destinacio.Pantalla3.rutaGenerica){
                PantallaTercera()
            }
        }









    }
}
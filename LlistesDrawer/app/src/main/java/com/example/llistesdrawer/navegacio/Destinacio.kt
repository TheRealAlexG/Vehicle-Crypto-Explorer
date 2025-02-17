package com.example.llistesdrawer.navegacio

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.llistesdrawer.R


enum class CategoriaDeNavegacio(
    val rutaPrevia: String,
    val icona: ImageVector,
    @StringRes val titol: Int
)
{
    LlistaBikes("LlistaBikes", Icons.Default.Star, R.string.llistabikes),
    LlistaCars("LlistaCars", Icons.Default.ThumbUp,R.string.llistacars),
    LlistaCrypto("LlistaCrypto",Icons.Default.Warning,R.string.llistacrypto),
    Pantalla2("Pantalla2",Icons.Default.Warning, R.string.pantalla2),
    Pantalla3("Pantalla3",Icons.Default.Call, R.string.pantalla3),

}

sealed class Destinacio(
    val rutaBase: String,
    val argumentsDeNavegacio: List <ArgumentDeNavegacio> = emptyList()
)
{

    val navArgs = argumentsDeNavegacio.map { it.toNavArgument()}
    /**
     * Propietat que crea l'string amb la ruta base i tots els arguments separats per barres
     */
    val rutaGenerica = run {
        //cal construir un string tipus: rutabase/{arg1}/{arg2} ...
        val clausArguments = argumentsDeNavegacio.map{"{${it.clau}}"}
        listOf(rutaBase)
            .plus(clausArguments)
            .joinToString("/")
    }

    object LlistaBikes: Destinacio(CategoriaDeNavegacio.LlistaBikes.rutaPrevia+"/LlistaBikes")
    object LlistaCars: Destinacio(CategoriaDeNavegacio.LlistaCars.rutaPrevia+"/LlistaCars")
    object LlistaCrypto: Destinacio(CategoriaDeNavegacio.LlistaCrypto.rutaPrevia+"/LlistaCryptos")
    object Pantalla2: Destinacio(CategoriaDeNavegacio.Pantalla2.rutaPrevia+"/Pantalla2")
    object Pantalla3: Destinacio(CategoriaDeNavegacio.Pantalla3.rutaPrevia+"/Pantalla3")

    object PantallaBike: Destinacio(
        CategoriaDeNavegacio.LlistaBikes.rutaPrevia+"/PantallaBike", listOf(ArgumentDeNavegacio.IdBikes)){
        fun CreaRutaAmbArguments (idBikes: Int) = "$rutaBase/$idBikes"
    }

    object PantallaCar: Destinacio(
        CategoriaDeNavegacio.LlistaCars.rutaPrevia+"/PantallaCar", listOf(ArgumentDeNavegacio.IdCars)){
        fun CreaRutaAmbArguments (idCars:Int) = "$rutaBase/$idCars"
    }

    object PantallaCrypto: Destinacio(
        CategoriaDeNavegacio.LlistaCrypto.rutaPrevia+"/PantallaCrypto",
        listOf(ArgumentDeNavegacio.IdCrypto)){
        fun CreaRutaArguments(idCrypto:Int)="$rutaBase/$idCrypto"
    }

}



//NavType<*> ens permet identificar qualsevol tipus de NavType
enum class ArgumentDeNavegacio (val clau: String, val tipus: NavType<*>){
    IdBikes("IdBike", NavType.IntType),
    IdCars("IdCars", NavType.IntType),
    IdCrypto("IdCrypto", NavType.IntType);

    fun toNavArgument (): NamedNavArgument {
        return navArgument(clau) {type = tipus}
    }
}


fun main(){
    var mapaBarcosJugador1 = Array(10){Array(10){"_"} }
    var mapaBarcosJugador2 = Array(10){Array(10){"_"} }
    var mapaEnemigoJugador1 = Array(10){Array(10){"_"} }
    var mapaEnemigoJugador2 = Array(10){Array(10){"_"} }
    var ataqueExito = true
    var victoria = false
    var turno= 0
    println("       Hundir La FLota")
    println("   Despliegue de la Flota JUGADOR 1")
    imprimirTablero1(mapaBarcosJugador1)
         getFlotaPosition(mapaEnemigoJugador1)
    limpiarpantalla()
    println("Despliegue de la Flota JUGADOR 2")
    imprimirTablero1(mapaBarcosJugador2)
         getFlotaPosition(mapaBarcosJugador2)
    do {
        do {
            imprimirTablero1(mapaEnemigoJugador1)
            var posicionAtaque = getCasilla(mapaEnemigoJugador1)
            ataqueExito = imprimirAtaque(posicionAtaque, mapaEnemigoJugador1, mapaBarcosJugador2)
            victoria = isVictoria(mapaBarcosJugador2, mapaEnemigoJugador1)
        } while (!ataqueExito)
        turno +=1
        do {
            imprimirTablero1(mapaEnemigoJugador2)
            var posicionAtaque = getCasilla(mapaEnemigoJugador2)
            ataqueExito = imprimirAtaque(posicionAtaque, mapaEnemigoJugador2, mapaBarcosJugador1)
            victoria = isVictoria(mapaBarcosJugador1, mapaEnemigoJugador2)
        } while (!ataqueExito)
        turno +=1
    }while(!victoria)
    when(turno % 2){
        0 -> println("Felicidades Jugador 1 eres el Campeon!!!!")
        1 -> println("Felicidades Jugador 2 eres el Campeon!!!!")
    }
}

private fun imprimirTablero1(tablero:Array<Array<String>>) {
    val linea = "-│—————————————————————————————│——"
    val abc = arrayOf("J","I","H","G","F","E","D","C","B","A")
    println(linea)
    for (fila in tablero.size-1 downTo   0) {
        println("${abc[fila]}|${tablero[fila].joinToString()} |")
    }
    println(linea)
    println("-│0  1  2  3  4  5  6  7  8  9 │-")
}

fun getFlotaPosition(mapaBarcosJugador1:Array<Array<String>>) {
    println(" TIENES QUE DESPLEGAR TU FLOTA. PARA ELLO INDICA LA CASILLA DE INICIO Y FIN DE CADA BARCO")
    getPortaAviones(mapaBarcosJugador1)
    imprimirTablero1(mapaBarcosJugador1)
    getFragata(mapaBarcosJugador1)
    imprimirTablero1(mapaBarcosJugador1)
    getFragata(mapaBarcosJugador1)
    imprimirTablero1(mapaBarcosJugador1)
    getCorbeta(mapaBarcosJugador1)
    imprimirTablero1(mapaBarcosJugador1)
    getCorbeta(mapaBarcosJugador1)
    imprimirTablero1(mapaBarcosJugador1)
    getCorbeta(mapaBarcosJugador1)
    imprimirTablero1(mapaBarcosJugador1)
    getSubmarino(mapaBarcosJugador1)
    imprimirTablero1(mapaBarcosJugador1)
    getSubmarino(mapaBarcosJugador1)
    imprimirTablero1(mapaBarcosJugador1)
    getSubmarino(mapaBarcosJugador1)
    imprimirTablero1(mapaBarcosJugador1)
    getSubmarino(mapaBarcosJugador1)
    imprimirTablero1(mapaBarcosJugador1)
}

fun getPortaAviones(mapaBarcosJugador1: Array<Array<String>>){
    var respuestaCorrecta = false
    val tamanoBarco = 4
    var posiciones:Pair<Pair<Int,Int>,Pair<Int,Int>>
    do {
        println(" Donde quieres colocar el portaviones (Distancia de 4)")
        var posicionInicio = getCasillaInicio()
        var posicionFinal = getCasillaFinal()
        posiciones =Pair(first = Pair(first = posicionInicio.first, second =posicionInicio.second ), second =
        Pair(first = posicionFinal.first, second = posicionFinal.second))
        respuestaCorrecta = puedoPonerBarco(posiciones,mapaBarcosJugador1,tamanoBarco)
    }while(!respuestaCorrecta)
    ponerBarco(posiciones,tamanoBarco,mapaBarcosJugador1)
}

fun getFragata(mapaBarcosJugador1: Array<Array<String>>){
    var respuestaCorrecta = false
    val tamanoBarco = 3
    var posiciones:Pair<Pair<Int,Int>,Pair<Int,Int>>
    do {
        println(" Donde quieres colocar el Fragata (Distancia de 3)")
        var posicionInicio = getCasillaInicio()
        var posicionFinal = getCasillaFinal()
        posiciones =Pair(first = Pair(first = posicionInicio.first, second =posicionInicio.second ), second =
        Pair(first = posicionFinal.first, second = posicionFinal.second))
        respuestaCorrecta = puedoPonerBarco(posiciones,mapaBarcosJugador1,tamanoBarco)
    }while(!respuestaCorrecta)
    ponerBarco(posiciones,tamanoBarco,mapaBarcosJugador1)
}

fun getCorbeta(mapaBarcosJugador1: Array<Array<String>>){
    var respuestaCorrecta = false
    val tamanoBarco = 2
    var posiciones:Pair<Pair<Int,Int>,Pair<Int,Int>>
    do {
        println(" Donde quieres colocar el Fragata (Distancia de 2)")
        var posicionInicio = getCasillaInicio()
        var posicionFinal = getCasillaFinal()
        posiciones =Pair(first = Pair(first = posicionInicio.first, second =posicionInicio.second ), second =
        Pair(first = posicionFinal.first, second = posicionFinal.second))
        respuestaCorrecta = puedoPonerBarco(posiciones,mapaBarcosJugador1,tamanoBarco)
    }while(!respuestaCorrecta)
    ponerBarco(posiciones,tamanoBarco,mapaBarcosJugador1)
}

fun getSubmarino(mapaBarcosJugador1: Array<Array<String>>){
    var respuestaCorrecta = false
    val tamanoBarco =1
    var posiciones:Pair<Pair<Int,Int>,Pair<Int,Int>>
    do {
        println(" Donde quieres colocar el Fragata (Distancia de 1)")
        var posicionInicio = getCasillaInicio()
        var posicionFinal = posicionInicio
        posiciones =Pair(first = Pair(first = posicionInicio.first, second =posicionInicio.second ), second =
        Pair(first = posicionFinal.first, second = posicionFinal.second))
        respuestaCorrecta = puedoPonerBarco(posiciones,mapaBarcosJugador1,tamanoBarco)
    }while(!respuestaCorrecta)
    ponerBarco(posiciones,tamanoBarco,mapaBarcosJugador1)
}

fun getCasillaInicio():Pair<Int,Int> {
    var respuesta = ""
    val abc = arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
    var respuestaCorrecta = false

    var ejeXInicio = -1
    var ejeYInicio = -1
    do {
        print("CASILLA DE INICIO : ")
        respuesta = readln().trim().uppercase()
        for (i in abc.indices) {
            if (respuesta[0].toString() == abc[i]) {
                ejeYInicio = 9 - i
                break
            }
        }
        ejeXInicio = respuesta[1].digitToInt()
        if (ejeYInicio >= 0) {
            respuestaCorrecta = true
        }
    } while (!respuestaCorrecta)
    var posicion = Pair(first = ejeYInicio, second = ejeXInicio)
    return posicion
}

fun getCasilla(mapaEnemigoJugador1: Array<Array<String>>):Pair<Int,Int> {
    var respuesta = ""
    val abc = arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
    var respuestaCorrecta = false

    var ejeXInicio = -1
    var ejeYInicio = -1
    do {
        print("CASILLA DONDE ATACAR : ")
        respuesta = readln().trim().uppercase()
        for (i in abc.indices) {
            if (respuesta[0].toString() == abc[i]) {
                ejeYInicio = 9 - i
                break
            }
        }
        ejeXInicio = respuesta[1].digitToInt()
        if (ejeYInicio >= 0 && mapaEnemigoJugador1[ejeYInicio][ejeXInicio]!="0") {
            respuestaCorrecta = true
        }
    } while (!respuestaCorrecta)
    var posicion = Pair(first = ejeYInicio, second = ejeXInicio)
    return posicion
}

fun getCasillaFinal():Pair<Int,Int> {
    var respuesta = ""
    val abc = arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
    var respuestaCorrecta = false

    var ejeXInicio = -1
    var ejeYInicio = -1
    do {
        print("CASILLA FINAL : ")
        respuesta = readln().trim().uppercase()
        for (i in abc.indices) {
            if (respuesta[0].toString() == abc[i]) {
                ejeYInicio = 9 - i
            }
        }
        ejeXInicio = respuesta[1].digitToInt()
        if (ejeYInicio >= 0) {
            respuestaCorrecta = true
        }
    } while (!respuestaCorrecta)
    var posicion = Pair(first = ejeYInicio, second = ejeXInicio)
    return posicion
}

fun puedoPonerBarco(posiciones:Pair<Pair<Int,Int>,Pair<Int,Int>>, mapaBarcosJugador1: Array<Array<String>>
                    ,tamanoBarco:Int):Boolean{
    if(posiciones.first.second-posiciones.second.second== tamanoBarco-1 &&
        posiciones.first.first-posiciones.second.first == 0 ) {
        for (k in 0..-tamanoBarco) {
            for (i in -1..1) {
                for (j in -1..1) {
                    if (posiciones.first.first + i >= 0
                        && posiciones.first.first + i < mapaBarcosJugador1.size
                        && posiciones.first.second + j +k >= 0
                        && posiciones.first.second + j +k < mapaBarcosJugador1.size
                    ) {
                        if (mapaBarcosJugador1[posiciones.first.first + i][posiciones.first.second + j +k] == "X") {
                            return false
                        }
                    }
                }
            }
        }
        return true
    }else if(posiciones.first.first-posiciones.second.first== tamanoBarco-1 &&
        posiciones.first.second-posiciones.second.second == 0) {
        for (k in 0..-tamanoBarco) {
            for (i in -1..1) {
                for (j in -1..1) {
                    if (posiciones.first.first + i +k>= 0
                        && posiciones.first.first + i +k< mapaBarcosJugador1.size
                        && posiciones.first.second + j  >= 0
                        && posiciones.first.second + j  < mapaBarcosJugador1.size
                    ) {
                        if (mapaBarcosJugador1[posiciones.first.first + i+k][posiciones.first.second + j] == "X") {
                            return false
                        }
                    }
                }
            }
        }
        return true
    }else if(posiciones.second.second-posiciones.first.second== tamanoBarco-1 &&
        posiciones.second.first-posiciones.first.first == 0){
        for (k in 0..tamanoBarco) {
            for (i in -1..1) {
                for (j in -1..1) {
                    if (posiciones.first.first + i >= 0
                        && posiciones.first.first + i < mapaBarcosJugador1.size
                        && posiciones.first.second + j +k >= 0
                        && posiciones.first.second + j +k < mapaBarcosJugador1.size
                    ) {
                        if (mapaBarcosJugador1[posiciones.first.first + i][posiciones.first.second + j +k] == "X") {
                            return false
                        }
                    }
                }
            }
        }
        return true
    }else if(posiciones.second.first-posiciones.first.first== tamanoBarco-1
        && posiciones.first.second-posiciones.second.second == 0){
        for (k in 0..-tamanoBarco) {
            for (i in -1..1) {
                for (j in -1..1) {
                    if (posiciones.first.first + i +k>= 0
                        && posiciones.first.first + i +k< mapaBarcosJugador1.size
                        && posiciones.first.second + j  >= 0
                        && posiciones.first.second + j  < mapaBarcosJugador1.size
                    ) {
                        if (mapaBarcosJugador1[posiciones.first.first + i+k][posiciones.first.second + j] == "X") {
                            return false
                        }
                    }
                }
            }
        }
        return true
    }
    return false
}

fun ponerBarco(posiciones: Pair<Pair<Int, Int>, Pair<Int, Int>>,
               tamanoBarco: Int, mapaBarcosJugador1: Array<Array<String>>){
    if(posiciones.first.second-posiciones.second.second== tamanoBarco-1) {
        for (i in (0 downTo  -(tamanoBarco-1))) {
            mapaBarcosJugador1[posiciones.first.first][posiciones.first.second + i] = "X"
        }
    }else if(posiciones.first.first-posiciones.second.first== tamanoBarco-1){
        for (i in (0 downTo -(tamanoBarco-1))) {
            mapaBarcosJugador1[posiciones.first.first+ i][posiciones.first.second ] = "X"
        }
    }else if(posiciones.second.second-posiciones.first.second== tamanoBarco-1){
        for (i in (0 until tamanoBarco)) {
            mapaBarcosJugador1[posiciones.first.first][posiciones.first.second + i] = "X"
        }
    }else if(posiciones.second.first-posiciones.first.first== tamanoBarco-1){
        for (i in (0 until  tamanoBarco)) {
            mapaBarcosJugador1[posiciones.first.first+i ][posiciones.first.second] = "X"
        }
    }
}

fun limpiarpantalla(){
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
    println("")
}

fun imprimirAtaque(posicionAtaque:Pair<Int,Int>,mapaEnemigoJugador1:Array<Array<String>>,
                   mapaBarcosJugador2: Array<Array<String>>):Boolean{
    if(mapaBarcosJugador2[posicionAtaque.second][posicionAtaque.first]=="X"){
        mapaEnemigoJugador1[posicionAtaque.second][posicionAtaque.first]= "X"
        return true
    }else{
        mapaEnemigoJugador1[posicionAtaque.second][posicionAtaque.first]= "0"
        return false
    }
}

fun isVictoria(mapaBarcosJugador2:Array<Array<String>>, mapaEnemigoJugador1:Array<Array<String>>):Boolean{
    for(i in mapaBarcosJugador2.indices){
        for(j in mapaBarcosJugador2[i].indices){
            if(mapaBarcosJugador2[i][j]=="X"&& mapaEnemigoJugador1[i][j]=="0"){
                return false
            }
        }
    }
    return true
}
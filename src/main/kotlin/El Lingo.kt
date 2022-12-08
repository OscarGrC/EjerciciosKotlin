fun main() {
    val bibliotecaPalabras= arrayOf("ROCAS","ARDOR","BLANCO","CORCHO","DALIA","EPICO","FEROZ","GRIAL","HILOS",
    "ILUSO", "JALEO", "KARMA","LINDE","MARCA","NUEVO","ORDEN","PRIMO")
    //mensajeInicio()
    var numeroRondas=pedirNumeroRondas()
    var puntosTotalesJugador1= Array<Int>(numeroRondas){0}
    var intentosPorRonda:Int = 5
    var acertastes:Boolean = false
    var charCorrecto = BooleanArray(5){false}
    var rondaContador = 1

    do{
        println("  -.Ronda $rondaContador.-")
        var palabrasecreta =generarpalabrasecreta(bibliotecaPalabras)
        do{
            println("Tienes $intentosPorRonda intentos")
            visualUsuario(palabrasecreta,charCorrecto)
            var palabraJugador1 =pedirPalabra()
            analizador(palabraJugador1,palabrasecreta,charCorrecto)
            acertastes= isAcierto(charCorrecto)
            intentosPorRonda--
        }while(intentosPorRonda>0 && !acertastes)
        intentosPorRonda= 5
        numeroRondas--
       for(i in charCorrecto.indices){
           charCorrecto[i]= false
       }
        rondaContador+=1
    }while (numeroRondas>0)
    println("Se terminaron las rondas. Gracias por Jugar")

}

fun pedirNumeroRondas():Int{
    var rondas:String= ""
    var numero= 0
    do {
        println("¿Cuantas rondas quereis jugar?")
        print(" ")
        rondas = readln().trim()
        try {
            require(Regex("[1-5]").matches(rondas)) { "NAIN NAIN NAIN NAIN" }
            numero = rondas.toInt()
            return numero
        } catch (e: Exception) {
            println("El $rondas no es válido")
            println("Tiene que ser un maximo entre 1 y 5")
        }
    }
        while(rondas.toInt()>0)
            return numero
}

fun generarpalabrasecreta(bibliotecaPalabras:Array<String>):CharArray{
    return  bibliotecaPalabras.random().toCharArray()
}

fun visualUsuario(palabrasecreta:CharArray,charCorrecto: BooleanArray){
    charCorrecto[0]= true
    var visualUsuario = CharArray(5){'_'}
    for (i in charCorrecto.indices){
        if(charCorrecto[i]){
            visualUsuario[i]=palabrasecreta[i]
        }
    }
    val visualSalida = visualUsuario.concatToString()
    println(visualSalida)

}

fun pedirPalabra():String{
    var palabra = ""
    var valida = false
    do{
        println("¿Cual es la palabra secreta?")
        print(" ")
        try {
            palabra = readln().uppercase()
            require(Regex("^[a-zA-Z]{5}").matches(palabra)) {"NAIN NAIN NAIN NAIN"}
            return palabra
        } catch (e: Exception) {
            println("La $palabra no es válida")
            println("Tiene que tener un maximo de 5 letras")
        }
    }
    while(!valida)
    return palabra
}

fun analizador(palabra:String,palabrasecreta:CharArray,charCorrecto:BooleanArray){
    val palabraJugador = palabra.toCharArray()
    for(i in 1 until palabraJugador.size){
        if(palabrasecreta[i]==palabraJugador[i]){
           charCorrecto[i]= true
        }
        for(j in 1 until  palabrasecreta.size){
            if(palabraJugador[i]==palabrasecreta[j]){
            if(palabrasecreta[i]!=palabraJugador[i]){
                println("Tiene  ${palabraJugador[i]} pero el orden no es correcto")
            }}
        }
    }
    println(" ---------------------------")
}

 private    fun isAcierto(charCorrecto: BooleanArray):Boolean{
    for(i in charCorrecto.indices){
        if(!charCorrecto[i]){
            return false
        }
    }
        println("Felicidades. Acertaste la palabra")
        return true
}
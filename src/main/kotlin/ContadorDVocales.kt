//Valores globales.

const val texto= "SOY UN TEXTO DE PRaooop.... -¨^*Ççç%&€@/º|?¿UEBA Y TENGO UNA LONGITUD DE VETE TU A SABER " +
        "y ahora voy a poner casos de prueba 123124áéíóú"//Aqui se inserta el texto a analizar

fun main(){
    //mensajeInicio()
    var textoCorregido:String = getSinEspacios(texto)
    println("$textoCorregido")
    textoCorregido = getMinusculas(textoCorregido)
    println("$textoCorregido")
    textoCorregido = getSinAcentos(textoCorregido)
    println("$textoCorregido")
    var numeroVocales = getNumeroVocales(textoCorregido)
    getMasUsada(numeroVocales)
}

/**
 * funcion que quita espacios en blanco
 */
fun getSinEspacios(texto:String):String{
    var textoLocal = texto.replace(" ", "" )
   return textoLocal
}

/**
 * funcion que pasa a Minusculas el texto
 */
fun getMinusculas(textoCorregido: String):String{
    var textoLocal = textoCorregido.lowercase()
    return textoLocal
}

/**
 * funcion que quita acentos a vocales
 */
fun getSinAcentos(textoCorregido:String):String{
    var textoLocal = textoCorregido.replace("á","a").replace("é", "e")
        .replace("í", "i").replace("ó","o").replace("ú","u")
            .replace("ü","u")
    return textoLocal
}

/**
 * funcion que cuenta el numero de vocales y lo retorna como IntArray
 */
fun getNumeroVocales(textoCorregido: String):IntArray{
    var textoLocal = textoCorregido.toCharArray()
    var respuesta = IntArray(5)
        for(i in textoCorregido.indices){
      when(textoCorregido[i]){
          'a' -> respuesta[0]+=1
          'e' -> respuesta[1]+=1
          'i' -> respuesta[2]+=1
          'o' -> respuesta[3]+=1
          'u' -> respuesta[4]+=1
      }
    }

    println("El numero de A es ${respuesta[0]}, de E es ${respuesta[1]}, de I es ${respuesta[2]}," +
            " de O es ${respuesta[3]},de U es ${respuesta[4]}")
    return respuesta

}

/**
 * funcion que nos dice cual es la vocal mas usada
 */
fun getMasUsada(numeroVocales:IntArray){
    var array = numeroVocales.clone()
    var arrayVocal = arrayOf("A","E","I","O","U")

    //oredenaccion por seleccion
    for (i in 0 until array.size - 1) {
        var min = i
        for (j in i + 1 until array.size) {
            if (array[j] > array[min]) {
                min = j
            }
        }
        val aux = array[i]
        array[i] = array[min]
        array[min] = aux
    }

       // Esta nos dice si tenemos empate quien es segundo
        for(i in numeroVocales.indices){
            if(array[0]==numeroVocales[i]){
                println("La vocal mas usada es la ${arrayVocal[i]} con ${numeroVocales[i]}")
            }
        }

}

/**

   // var arreglo = IntArray(10) { indice -> indice+1 }
    var arreglo = IntArray(10) {(it * 2)+2}
    println(arreglo.joinToString())
    var matriz = Array(3){IntArray(3){((Math.random()*100)+1).toInt() } }
    for (i in 0 until matriz.size) {
        for (j in 0 until matriz.size){

        }
        println(matriz[i].joinToString())
    }

}
   **/
/**
//Si queremos guardar los valores 0,2,4,6 etc. podemos utilizar la sintaxis:

//Si queremos almacenar valores aleatorios comprendidos entre 1 y 6 podemos
// crear el objeto de la clase IntArray con la siguiente sintaxis:
var arreglo = IntArray(10) {((Math.random() * 6) + 1).toInt()}
 ***/

/**
 * funcion que imprime el tablero
 *
 */
/**
fun imprimirTablero(tablero:Array<Array<String>>) {
    val linea = "│—————————————————————————————│——"

    println(linea)
    for (fila in tablero.size-1 downTo   0) {
        println("|${tablero[fila].joinToString()} |$fila")
    }
    println(linea)
    println("│0  1  2  3  4  5  6  7  8  9 │")
}

/**
 *
var respuesta:String = ""
var respuestaCheck:Boolean = false
do {
    val regex = Regex(pattern = "^-?\\d+\$|" +
            "^(-?\\d+,-?\\d+)\$|" +
            "^(-?\\d+,-?\\d+,-?\\d+)\$|" +
            "^(-?\\d+,-?\\d+,-?\\d+,-?\\d+)\$|" +
            "(^-?\\d+,-?\\d+,-?\\d+,-?\\d+,-?\\d+)\$")
    print("      :")
    respuesta = readln().trim().lowercase()
    if (!regex.matches(respuesta)){ println("Fallo en la secuencia") }
    else{
        respuestaCheck = true
    }
}while (respuestaCheck!=true)
        **/
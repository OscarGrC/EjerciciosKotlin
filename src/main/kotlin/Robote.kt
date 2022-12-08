
/*
 * Reto #46
 * ¿DÓNDE ESTÁ EL ROBOT?
 * Fecha publicación enunciado: 14/11/22
 * Fecha publicación resolución: 21/11/22
 * Dificultad: MEDIA
 *
 * Enunciado: Calcula dónde estará un robot (sus coordenadas finales) que se encuentra en una cudrícula
 * representada por los ejes "x" e "y".
 * - El robot comienza en la coordenada (0, 0).
 * - Para idicarle que se mueva, le enviamos un array formado por enteros (positivos o negativos)
 *   que indican la secuencia de pasos a dar.
 *  - Por ejemplo: [10, 5, -2] indica que primero se mueve 10 pasos, se detiene, luego 5, se detiene,
 *    y finalmente 2. El resultado en este caso sería (x: -5, y: 12)
 * - Si el número de pasos es negativo, se desplazaría en sentido contrario al que está mirando.
 * - Los primeros pasos los hace en el eje "y". Interpretamos que está mirando hacia la parte
 *   positiva del eje "y".
 * - El robot tiene un fallo en su programación: cada vez que finaliza una secuencia de pasos gira
 *   90 grados en el sentido contrario a las agujas del reloj.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
   var tablero = Array(10) { Array(10) { "0" } }
    var posicionRobot= Pair(0,0)
    tablero[0][0]="R"
    var pasos:IntArray = getPasos()
    println(pasos.joinToString())
    imprimirTablero(tablero)
    //comenzamos

}

/**
 * funcion que pide a usuario los pasos y filtra. //falta arreglar un unico digito
 */
fun getPasos():IntArray{
    println("INTRODUCE LOS PASOS QUE QUIERES DAR PRIMERO VERTICAL LUEGO HORIZONTAL")
    println("Nota:Maximo 5 pasos separados por como y sin punto ni coma al final -1,1,1,2,2")
    var respuesta:String = ""
    var respuestaCheck:Boolean = false
    do {
        val regex = Regex(pattern = "-?\\d*|" +
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
    var salida = IntArray(5){0}
     var contador = 0
     var charRespuesta= respuesta.toCharArray()
    var numero = ""
    for(i in charRespuesta.indices){

        if(charRespuesta[i]==','){
            salida[0+contador] = numero.toInt()
            numero =""
          contador+=1
        }else {
            numero += charRespuesta[i]
        }
    }
    salida[0+contador] = numero.toInt()
    return salida

}

/**
 * funcion que imprime el tablero
 *
 */
private  fun imprimirTablero(tablero:Array<Array<String>>) {
    val linea = "│—————————————————————————————│——"

    println(linea)
    for (fila in tablero.size-1 downTo   0) {
            println("|${tablero[fila].joinToString()} |$fila")
    }
    println(linea)
    println("│0  1  2  3  4  5  6  7  8  9 │")
}
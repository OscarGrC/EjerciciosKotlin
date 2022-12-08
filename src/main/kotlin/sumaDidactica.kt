private fun main() {
    val tamanoMaximo:Int = 5
    mensajeInicio()
    mensajeAvisoTamanoMaximo(tamanoMaximo)
    var numero1: Int = pedirnumero(tamanoMaximo)
    var numero2:Int = pedirnumero(tamanoMaximo)
    var resultadoSuma:Int = suma(numero1,numero2)
    var sumatorio:String = crearSumatorio(numero1, numero2,tamanoMaximo)
    vueltacalcetin(sumatorio)
    imprimirNumeros(numero1,numero2,tamanoMaximo)
    imprimirSuma(resultadoSuma,tamanoMaximo)
}

/**
 * Mensaje inicial del programa
 */
private fun mensajeInicio(){
    println("""///   PROGRAMA PARA REALIZAR CONTEO DE VOCALES EN UN TEXTO   \\\""")
}

/**
 * aviso usuario tamaño maximo permitido en numero
 */
fun mensajeAvisoTamanoMaximo(tamanoMaximo: Int){
    println("El numero de digitos maximos permitos en la suma es $tamanoMaximo")
}

/**
 * Pide introducir un numero por pantalla
 */
private fun pedirnumero(tamanoMaximo:Int):Int{
    var numero1:String= ""
    var numero= 0
   do{
        println("¿Que numero quieres sumar?")
        print(" ")
    try {
        numero1 = readln().toString()
        require(Regex("^[0-9]{1,$tamanoMaximo}$").matches(numero1)) {"NAIN NAIN NAIN NAIN"}
        numero= numero1.toInt()
        return numero
    } catch (e: Exception) {
        println("El $numero1 no es válido tiene")
        println("Tiene que tener un maximo de $tamanoMaximo digitos y solo contener numeros")
    }
   }
    while(numero1.toInt()>0)
    return numero
}

/**
 * suma 2 numeros y devuelve resultado
 */
fun suma(numero1: Int,numero2: Int):Int{
    val resultado = numero1+numero2
    return  resultado
}

/**
 * funcion que nos devuelve el sumatorio de la suma
 */
fun crearSumatorio(numero1: Int, numero2: Int, tamanoMaximo: Int):String{
    var localNumero1 = numero1
    var localNumero2 = numero2
    var resultado:Int = 0
    var salida:String = ""

    for (i in  1 until tamanoMaximo){
        localNumero1 = numero1
        localNumero2 = numero2
        while ( localNumero1>=Math.pow(10.0,i.toDouble()).toInt()-1) {
            localNumero1 -=Math.pow(10.0,i.toDouble()).toInt()
        }
        while ( localNumero2>=Math.pow(10.0,i.toDouble()).toInt()) {
            localNumero2 -=Math.pow(10.0,i.toDouble()).toInt()
        }

        resultado = localNumero1 + localNumero2

        if(resultado>=Math.pow(10.0,i.toDouble()).toInt()){
            salida+= "1"
        }
          else{
           salida+="0"
          }

    }

    return salida

}

/**
 * funcion que da la vuelta al string y lo imprime
 */
fun vueltacalcetin(salida:String){
    var secuencia = ""
    for(i in salida.length-1 downTo 0){
        secuencia += salida[i]
    }
   println(" ${secuencia}0")
}

/**
 * imprime por pantalla los numeros y añade " "
 */
fun imprimirNumeros(numero1: Int, numero2: Int, tamanoMaximo: Int){
    var primerValor = numero1.toString()
    var segundoValor = numero2.toString()
    while (primerValor.length < tamanoMaximo) {
        primerValor = " " + primerValor
    }
    while (segundoValor.length < tamanoMaximo){
       segundoValor= " " + segundoValor
    }
        println(" $primerValor")
        println(" $segundoValor")
        println("-----------------")
}

/**
 * imprime el resultado de la suma
 */
fun imprimirSuma(resultadoSuma:Int,tamanoMaximo: Int) {
    var resultado = resultadoSuma.toString()
    if(resultado.length> tamanoMaximo){
        println("$resultado")
    }
    else {
        while (resultado.length < tamanoMaximo) {
            resultado = " " + resultado
        }
        println(" $resultado")
    }
}
fun main(){
    var texto:String= ("     Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto." +
            " Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un" +
            " impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los" +
            " mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, " +
            "sino que tambien ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual" +
            " al original. Fue popularizado en los 60s con la creación de las hojas Letraset, las cuales " +
            "contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo" +
            " Aldus PageMaker, el cual incluye versiones de Lorem Ipsum.   ")
    var texto2= ("Dabale arroz a la zorra el abad")
     // funciona  reversed(texto2)
    var textoTrim= funcionTrim(texto)
    var palabrasTotal=contadorPalabras(textoTrim)
    var textoConSplit:Array<String> = funcionSplit(textoTrim,palabrasTotal)
    var texto2SinEspacios:String =textoSinEspacios(texto2)
    var isPalindromo:Boolean = palindromo(texto2SinEspacios)



}

fun funcionTrim(texto:String):String {
    var textoLocal: String = texto
    do {
        if (textoLocal[0] == ' ') {
            textoLocal = textoLocal.substring(1, textoLocal.length)
        }
    } while (textoLocal[0] == ' ')

    do {
        if (textoLocal[textoLocal.length-1] == ' ') {
            textoLocal = textoLocal.substring(0, textoLocal.length - 2)
        }
    } while (textoLocal[textoLocal.length-1] == ' ')
            return textoLocal



}

fun reversed(texto: String){
            var textoLocal:String = ""
            for(i in texto.length-1 downTo 0){
                textoLocal+= texto[i].lowercase()
            }
            println(textoLocal)
        }

fun contadorPalabras(texto: String):Int {
    var contador: Int = 1
    var textoLocal = texto
    for (i in 1 until textoLocal.length) {
        if (textoLocal[i] == ' ') {
            contador += 1
        }
    }
    return contador
}

fun funcionSplit (texto:String,palabrasTotal:Int):Array<String>{
    var textoLocal= texto
    var palabra:String = ""
    var textoEnArrayString= Array<String>(palabrasTotal){" "}
    var contador = 0
    for(i in 0 until texto.length){
        palabra+= textoLocal[i]

        if(textoLocal[i]== ' '){
            palabra = palabra.substring(0,palabra.length-1)
          textoEnArrayString[contador]= palabra
            palabra = ""
            contador += 1
        }
    }
    textoEnArrayString[contador]=palabra
    contador = 0
    palabra = " "
    return textoEnArrayString
}

fun textoSinEspacios(texto:String):String{
    var textoInterno= ""
    var contador = 0
    for(i in 0 until texto.length){
        textoInterno += texto[i]
        contador+=1
        if(texto[i]==' '){
            textoInterno = textoInterno.substring(0,contador-1)
            contador-=1
        }
    }
    return textoInterno
}

fun palindromo(texto:String):Boolean {
    var texto1 = texto.toCharArray()
    println(texto1)
    var texto2 = reversed(texto)
    println(texto2)

    return true
}
const val starkiller= -1
const val integridadEscudosInicial= 100
const val dañoNavesEnemigas= 10
const val navesEnemigasMaximas=50
const val provabilidadDaño= 0.1
const val tiempoMaximoBatalla= 30000
var escrituraMatriz= Array(7) { IntArray(7) { 0 } }
var lecturaMatriz= escrituraMatriz.clone()

fun main() {
    var starkillerVivo:Boolean= true
    var navesEnemigasInicial= pedirNumeroNaves()
    var navesEnemigasVivas = navesEnemigasInicial
    sorteoNavesEnemigas(escrituraMatriz,navesEnemigasInicial)
    var posicionStarkiller:IntArray= sorteoStarkiller(escrituraMatriz)
    var temporizador= 0
    var matanzaTotal= 0
    var integridadEscudos= integridadEscudosInicial
    imprimirTablero()

    //comienza batalla
    do {
        var navesAtacan:Int= enemigosRodean(lecturaMatriz,posicionStarkiller)
        println("atacan $navesAtacan")
        var navesMuertasRonda:Int= atacaStarkiller(lecturaMatriz, posicionStarkiller)
        integridadEscudos= venganza(navesAtacan,integridadEscudos)
        starkillerVivo= vive(integridadEscudos)
        navesEnemigasVivas-= navesMuertasRonda
        borradoStarkiller(escrituraMatriz,posicionStarkiller)
        posicionStarkiller= sorteoStarkiller(escrituraMatriz)
        imprimirTablero()
        temporizador+= 1000
        lecturaMatriz= escrituraMatriz
    }while(temporizador<tiempoMaximoBatalla&&navesEnemigasVivas>0&&starkillerVivo==true)

    resumenTiempo(temporizador)
    resumenVida(integridadEscudos)
    resumenTropelias(navesEnemigasVivas,navesEnemigasInicial)
    imprimirTablero()

}
fun imprimirTablero() {
    val linea = "—│———————│"
    println("\n │1234567│")
    println(linea)
    for (fila in lecturaMatriz.indices) {
        print("${fila + 1}│")
        for (columna in lecturaMatriz[fila].indices) {
            print(
                when {
                    lecturaMatriz[fila][columna] == 0 -> "0"
                    lecturaMatriz[fila][columna] == -1-> "S"
                    lecturaMatriz[fila][columna] == 1 -> "1"
                    lecturaMatriz[fila][columna] == 2 -> "2"
                    lecturaMatriz[fila][columna] == 3 -> "3"
                    lecturaMatriz[fila][columna] == 4 -> "4"
                    lecturaMatriz[fila][columna] == 5 -> "5"

                    else -> "K"
                }
            )
        }
        println("│")
    }
    println(linea)
}

fun pedirNumeroNaves():Int {
    var numero1:String= ""
    var numero= 0
    do{
        println("¿Contra cuantas naves te vas a enfretar?")
        print(" ")
        try {
            numero1 = readln().toString()
            require(Regex("^[0-9]{1,$navesEnemigasMaximas}$").matches(numero1)) {"NAIN NAIN NAIN NAIN"}
            numero= numero1.toInt()
            return numero
        } catch (e: Exception) {
            println("El $numero1 no es válido")
            println("Tiene que tener un maximo de $navesEnemigasMaximas y minimo 1")
        }
    }
    while(numero1.toInt()>0)
    return numero
}

fun getPosicion(escrituraMatriz:Array<IntArray>): Int {
    var fila: Int
    do {
        fila = (escrituraMatriz.indices).random()
    } while (fila < 0 || fila >= escrituraMatriz.size)
    return fila
}

fun sorteoNavesEnemigas(escrituraMatriz: Array<IntArray>, navesEnemigasInicial:Int){
    var navesXasignar = navesEnemigasInicial
    do {
        var naveEnemigaX = getPosicion(escrituraMatriz)
        var naveEnemigaY = getPosicion(escrituraMatriz)
        if(escrituraMatriz[naveEnemigaX][naveEnemigaY]<5) {
                escrituraMatriz[naveEnemigaX][naveEnemigaY] += 1
                navesXasignar -= 1
            }
        }while(navesXasignar!=0)
}

fun sorteoStarkiller(escrituraMatriz: Array<IntArray>):IntArray {
    var posicion = intArrayOf(0,0)
    do {
        var fila = getPosicion(escrituraMatriz)
        var columna = getPosicion(escrituraMatriz)
        posicion[0]= fila
        posicion[1]= columna
        if (escrituraMatriz[fila][columna] == 0) {
            escrituraMatriz[fila][columna] = starkiller
            return posicion
        }
    } while (escrituraMatriz[fila][columna] != 0)
    return posicion
}

fun atacaStarkiller(lecturaMatriz: Array<IntArray>, posionStarkiller:IntArray):Int{
    var contador = 0
    for (x in -1..1) {
        for (y in -1..1) {
            if (posionStarkiller[0] + x >= 0
                && posionStarkiller[0] + x < escrituraMatriz.size
                && posionStarkiller[1] + y >= 0
                && posionStarkiller[1] + y < escrituraMatriz.size
            ) {
                if (lecturaMatriz[posionStarkiller[0] + x][posionStarkiller[1] + y] > 0) {
                    contador+=1
                    lecturaMatriz[posionStarkiller[0] + x][posionStarkiller[1] + y] -= 1
                }
            }
        }
    }
    return contador
}

fun venganza(enemigosRodean:Int,integridadEscudos:Int):Int {
    var valorAleatorio = IntArray(enemigosRodean) { ((Math.random() * 100) +1).toInt() }
    //println("${valorAleatorio.joinToString()}")
    var escudo = integridadEscudos
    for(i in 0 until valorAleatorio.size-1){
        if(valorAleatorio[i]<=10){
            escudo-=dañoNavesEnemigas
        }
    }
    return  escudo
}

fun vive(integridadEscudos: Int):Boolean{
    if(integridadEscudos<=0){
        return false
    }else
        return true

}

fun borradoStarkiller(escrituraMatriz: Array<IntArray>, posionStarkiller: IntArray):IntArray {
    escrituraMatriz[posionStarkiller[0]][posionStarkiller[1]]= 0
    return posionStarkiller
}

fun enemigosRodean(lecturaMatriz: Array<IntArray>, posionStarkiller:IntArray):Int{
    var contador = 0
    for (x in -1..1) {
        for (y in -1..1) {
            if (posionStarkiller[0] + x >= 0
                && posionStarkiller[0] + x < escrituraMatriz.size
                && posionStarkiller[1] + y >= 0
                && posionStarkiller[1] + y < escrituraMatriz.size
            ) {
                if (lecturaMatriz[posionStarkiller[0] + x][posionStarkiller[1] + y] > 0) {
                    contador+=lecturaMatriz[posionStarkiller[0] + x][posionStarkiller[1] + y]

                }
            }
        }
    }
    return contador
}

fun resumenTiempo(temporizador:Int){
    var porcentaje = (temporizador * 100)/tiempoMaximoBatalla
    if(tiempoMaximoBatalla==temporizador){
        println("El tiempo se agoto, la batalla a terminado")
    }else{ "Solo aguantastes el $porcentaje% de la batalla" }
}

fun resumenVida(integridadEscudos: Int){
    if(integridadEscudos>0){
        var porcentaje= (integridadEscudos*100)/integridadEscudosInicial
        println("Los escudos de la Slave1 estan al $porcentaje%")
    }else{
        println("Mala suerte Starkiller murio")
    }
}

fun resumenTropelias(navesEnemigasVivas:Int,navesEnemigasInicial: Int){
    if(navesEnemigasVivas== 0){
        println("Felicidades eliminastes todos los cazas enemigos")
    }else{
        var porcentaje= (navesEnemigasVivas*100)/navesEnemigasInicial
        println("Quedaron por destruir $navesEnemigasVivas naves. El $porcentaje% de la flota")
    }
}
package models

class Direcciones {
    /// Estados
    val norte = Pair(0,1)
    val sur = Pair(0,-1)
    val oeste = Pair(-1,0)
    val este = Pair (1,0)
    val noroeste = Pair(-1,1)
    val noreste = Pair(1,1)
    val sureste = Pair (1,-1)
    val suroeste = Pair(-1,-1)
    //comportamiento
    fun puedoMoverme(matriz:Array<IntArray>,posicion:IntArray,direccion:Pair<Int,Int>):Boolean{
             if(posicion[0]+direccion.first >=0 && posicion[0]+direccion.first <= matriz.size-1 &&
                posicion[1]+direccion.second >=0 && posicion[1]+direccion.second <= matriz.size-1){
                 return true
             }
        return false
    }


}
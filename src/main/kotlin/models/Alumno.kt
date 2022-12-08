package models

data class Alumno(
    var nombre:String  ="",
    var id:Int = -1,
    var calificacion:Double = 0.0
) {
    //Estados
    val isAprobado:Boolean get()= calificacion>= 5
}
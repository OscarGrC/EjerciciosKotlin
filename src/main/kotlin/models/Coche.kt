package models

class Coche {
    // Estados
    var matricula = ""
    var marca = "Seat"
    var modelo = "Leon"
    var fabricacion = "11.02.2012"

    //tipo motor gas diesel elec hibrid
    //fun es contaminante? true si es con
    var revision = false

    //Comportamiento
    fun info() {
        println("Soy un $marca modelo $modelo con matricula $matricula fabricado en $fabricacion")
    }

    fun IsRevision(): Boolean {
        TODO()
    }

    fun SetMatricula(matricula: String) {
        val regex = Regex("^[0-9]{4}[\\d]{3}$")
        var matricula = matricula.trim().uppercase()
        if (!regex.matches(matricula)) {
            println("Fallo en la matricula")
        } else {
            this.matricula = matricula
        }
    }


}
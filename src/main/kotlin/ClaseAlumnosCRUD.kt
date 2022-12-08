import models.Alumno


fun main(){
    val nombresLista:Array<String> = arrayOf("Pepe","Maria","Ana","Jose","Sergio","Sofia","Marcos","Iñaki","Gorka")
    var listaAlumnos= Array<Alumno?>(30) { null }
    val alumno1 = Alumno(nombresLista.random(), calificacion = ((0..1000).random().toDouble()/100), id = 1)
     listaAlumnos[0] = alumno1
    val alumno2 = Alumno(nombresLista.random(), calificacion =((0..1000).random().toDouble()/100), id = 2)
    listaAlumnos[1] = alumno2
    val alumno3 = Alumno(nombresLista.random(), calificacion = ((0..1000).random().toDouble()/100), id = 3)
    listaAlumnos[2] = alumno3

    var option:String
    var optionValida:Boolean
    var salida = false
    var hueco:Int
    mensajeInicio()
    do {
        do {
            option = menu()
            optionValida = isOptionValida(option)
        } while (!optionValida)
        when(option){
            "1" -> {
                hueco = getHuecoLista(listaAlumnos)
                var datosAlumno:Triple<String,Int,Double> = Triple(getNombre(),getIdInsert(listaAlumnos),getNotaIngreso())
                crearAlumno(datosAlumno,hueco,listaAlumnos)
            }
            "2" ->  actualizarInfo(listaAlumnos)
            "3" ->  imprimirLista(listaAlumnos)
            "4" ->  borrarAlumno(listaAlumnos)
            "5" ->  informeClase(listaAlumnos)
            "6"->   informeAlumno(listaAlumnos)
            "S" -> salida = true
        }
    }while (!salida)
   mensajeSalida()
}

/**
 * Mensaje inicial del programa
 */
private fun mensajeInicio(){
    println("""///   PROGRAMA PARA ADMINISTRACIÓN DE CALIFICACIONES DE ALUMNOS EN CLASE   \\\""")
}
/**
 * Mensaje final del programa
 */
private fun mensajeSalida(){
    println("""///   GRACIAS POR UTILIZAR NUESTRO PROGRAMA  \\\""")
    println("Jefe de Programación: Oscar Gracia Cobo")
    println("Tester y chico del cafe: Oscar Gracia Cobo")
    println("Especial agradecimiento a: .......")
}
/**
 * Función que muestra el menu al usuario para escoger opción
 */
private fun menu(): String {

    println("   LAS OPCIONES DISPONIBLES SON:")
    println("-|---------------------------------|-")
    println(" 1.- Crear nuevo alumno")
    println(" 2.- Actualizar información alumno")
    println(" 3.- Ver lista alumnos")
    println(" 4.- Borrar alumno")
    println(" 5.- Informe Global Clase")
    println(" 6.- Informe Alumno ")
    println(" S.- Salir")
    println("-|---------------------------------|-")
    println(" ")
    println("      ¿Que deseas hacer?  ")
    return readln().trim().uppercase()

}
/**
 * Funcion de control para asegurar que opcion seleccionada en menu es valida
 */
private fun isOptionValida(opcion:String):Boolean{
    return if(opcion=="1"||opcion=="2"||opcion=="3"||opcion=="4"||opcion=="5"||opcion=="6"||opcion=="S"){
        true
    }else{
        println("   Lo siento $opcion no es valida. Tienes que usar un valor entre 1-6 o una S ")
        false
    }
}
/**
 * Funciones para crear un nuevo alumno.
 */
fun getHuecoLista(listaAlumnos:Array<Alumno?>):Int{
    var index:Int = -1
    for(i in listaAlumnos.indices){
        if(listaAlumnos[i]==null){
            index = i
            break
        }
    }
    return index
}
fun getNombre(): String {
    println("     ¿Cual es el nombre del alumno?")
    print("       :")
    return readln().trim()
}
fun getIdInsert(listaAlumnos: Array<Alumno?>):Int{
    var listaId = ""
    var identificador:Int = -1
    var idValida = false
    var usado = false

    for (i in listaAlumnos.indices){
        if(listaAlumnos[i]!= null){
            listaId+= " "+ listaAlumnos[i]?.id.toString()
        }
    }

    println (" Las IDs usadas actualmente son: $listaId")

    do {
        println("    ¿Cual es su id?")
        print("    :")
        identificador = try {
            readln().toInt()
        }catch (e: IllegalArgumentException){
            println("$identificador no es un numero")
            0
        }
        for (i in listaAlumnos.indices){
            if(listaAlumnos[i]?.id == identificador){
                println(" El ID $identificador ya esta siendo usado")
                usado = true
            }
        }
        if(!usado){
            idValida = true
        }
    }while(!idValida)
    return  identificador
}
fun getNotaIngreso():Double {
    var qualification = 0.0
    var calValida = false
    do {
        println("   ¿Cual es su calificación?")
        print("   :")
        qualification = try {
            readln().toDouble()
        } catch (e: IllegalArgumentException) {
            println("$qualification  no es un numero")
            -1.0
        }
        if (qualification in 0.0..10.0) {
            calValida = true
        }else {
            println("Tiene que ser un valor entre 0.0 y 10.0")
        }
    } while (!calValida)
    return qualification
}
fun crearAlumno(datosAlumno:Triple<String,Int,Double>,hueco:Int,listaAlumnos: Array<Alumno?> ){
    if(hueco!=-1) {
        listaAlumnos[hueco] =
            Alumno(nombre = datosAlumno.first, id = datosAlumno.second, calificacion = datosAlumno.third)
    }else println("Lo Siento no quedan Huecos disponibles. Borre un alumno antes")
}
/**
 * Función para confirmar accion
 */
fun getConfirmation():Boolean{
    var respuesta:String
    var valido = false
    println("  ¿Estas seguro?")
    do{
        print("Pulse S/N  :")
        respuesta= readln().uppercase().trim()
        if(respuesta=="S" ||respuesta=="N"){
            valido = true
        }else{
            println("Tienes que pulsar S o N ")
        }
    }while(!valido)
    if(respuesta=="S"){
        return  true
   }
    return false
}
/**
 * Función que imprime la lista de alumnos
 */
fun imprimirLista (listaAlumnos: Array<Alumno?>){
    for(i in listaAlumnos.indices){
        if(listaAlumnos[i]!=null){
            println("ID ${listaAlumnos[i]?.id}  Nombre: ${listaAlumnos[i]?.nombre}")
        }
    }
    println(" ")
    println(" ")
}
/**
 * Función que pide una ID a usuario (no filtra)
 */
fun getId():Int{
    var identificador:Int = -1
    var idValida = false

    do {
        println("    ¿Cual es su id?")
        print("    :")
        identificador = try {
            readln().toInt()
        }catch (e: IllegalArgumentException){
            println("$identificador no es un numero")
            0
        }
        if(identificador in 0..30){
            idValida = true
        }
    }while(!idValida)
    return  identificador
}
/**
 * Función que actualiza la Info de un alumno
 */
fun actualizarInfo(listaAlumnos: Array<Alumno?>){
    var idValida = false
    var identificador:Int
    println(" ¿Que alumno quieres modificar?")
    imprimirLista(listaAlumnos)
    println("------------------")
    do {
        identificador = getId()
        if (listaAlumnos[identificador] != null) {
            idValida = true
        }else {
            println("Id no encontrada")
        }
    }while (!idValida)
    var nota:Double = getNotaIngreso()
    listaAlumnos[identificador]?.calificacion = nota
}
/**
 * Función para borrar un alumno
 */
fun borrarAlumno(listaAlumnos: Array<Alumno?>){

    var idValida = false
    var identificador: Int
    println(" ¿Que alumno quieres modificar?")
    imprimirLista(listaAlumnos)
    println("------------------")
    do {
        identificador = getId()
        if (listaAlumnos[identificador] != null) {
            idValida = true
        }else {
            println("Id no encontrada")
        }
    }while (!idValida)
    var confirmation: Boolean = getConfirmation()
    if(confirmation){
        listaAlumnos[identificador]= null
    }

}
/**
 * Función que imprime el informe de un alumno
 */
fun informeAlumno(listaAlumnos: Array<Alumno?>){
    var idValida = false
    var identificador: Int
    var position = 0
    println(" ¿Que alumno quieres ver?")
    imprimirLista(listaAlumnos)
    println("------------------")
    do {
        identificador = getId()
        for(i in listaAlumnos.indices){
            if (listaAlumnos[i]?.id == identificador) {
                position = i
                idValida = true
            }
        }

    }while (!idValida)
            println("El alumno ${listaAlumnos[position]?.nombre} Tiene una calificación de " +
                    " ${listaAlumnos[position]?.calificacion}")
            if(listaAlumnos[position]?.isAprobado==true){
                println(" Y esta Aprobado")
            }else{
                println(" Y esta Suspendido")
        }
    }
/**
 * Funcion que imprime en Orden los alumnos con sus notas y la media
 */
fun informeClase(listaAlumnos: Array<Alumno?>){
    var alumnosTotales = 0
    var contadorNota = 0.0
    var listaAlumnosInterna = listaAlumnos.clone()

    for (i in 0 until listaAlumnosInterna.size - 1) {
        for (j in 0 until listaAlumnosInterna.size - 1 - i) {
            if ((listaAlumnosInterna[j]?.calificacion ?: -1.0) < (listaAlumnosInterna[j + 1]?.calificacion ?: -1.0)){
                val aux = listaAlumnosInterna[j]
                listaAlumnosInterna[j] = listaAlumnosInterna[j + 1]
                listaAlumnosInterna[j + 1] = aux
            }
        }
    }
    for(i in listaAlumnosInterna.indices){
        if(listaAlumnosInterna[i]!=null){
            println("El ${alumnosTotales+1} de clase es:${listaAlumnosInterna[i]?.nombre} con" +
                    " ${listaAlumnosInterna[i]?.calificacion} de nota.")
            alumnosTotales++
            contadorNota+= listaAlumnosInterna[i]?.calificacion ?:0.0
        }
}
    println("La nota media es de ${contadorNota/alumnosTotales}")

}


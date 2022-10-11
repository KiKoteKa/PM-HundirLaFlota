var tableroJugador = Tablero()
var tableroEnemigo = Tablero()

fun main(args: Array<String>) {
/*
    while(!tableroEnemigo.gameOver() && !tableroJugador.gameOver()) {
        mostrarTableros()
        disparoJugador()
        if (!tableroJugador.gameOver()) {
            disparoEnemigo()
        }
    }
*/
    mostrarMensajeFinJuego()
}

fun mostrarTableros()
{
    println("TABLERO JUGADOR")
    println("--------------------------------")
    tableroJugador.mostrarTablero()
    println("--------------------------------")
    println("TABLERO ENEMIGO")
    println("--------------------------------")
    tableroEnemigo.mostrarTablero(false)
}

fun disparoJugador()
{
    var disparoErroneo = true
    while(disparoErroneo) {

    }

    /*
    var disparoErroneo = true
    while(disparoErroneo) {
        println("*-----------*")
        println("Introduce la posicion donde quieras disparar (ejemplo \"1A\")")
        println("*-----------*")
        val lectura = readLine().toString()
        lectura.uppercase()
        if ("[1-8][A-H]".toRegex().matches(lectura))
        {
            println(lectura)
            disparoErroneo = false
        }else{
            println(lectura)
            println("*-----------*")
            println("Posición incorrecta, utiliza un número y una letra (ejemplo \"1A\")")
        }
    }
    */
}

fun disparoEnemigo()
{
    //TODO
}
fun mostrarMensajeFinJuego()
{
   //TODO
}
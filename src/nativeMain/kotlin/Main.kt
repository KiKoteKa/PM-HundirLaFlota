fun main(args: Array<String>) {
    mostrarTableros()
}


fun mostrarTableros()
{
    println("TABLERO JUGADOR")
    println("--------------------------------")
    val tableroJugador:Tablero = Tablero()
    tableroJugador.mostrarTablero()
    println("--------------------------------")
    println("TABLERO ENEMIGO")
    println("--------------------------------")
    val tableroEnemigo:Tablero = Tablero()
    tableroEnemigo.mostrarTablero(false)
}
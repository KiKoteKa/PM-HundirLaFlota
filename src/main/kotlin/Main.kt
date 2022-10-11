import java.util.*

var tableroJugador = Tablero()
var tableroEnemigo = Tablero()

fun main(args: Array<String>) {

    while(!tableroEnemigo.gameOver() && !tableroJugador.gameOver()) {
        mostrarTableros()
        disparoJugador()
        if (!tableroJugador.gameOver()) {
            disparoEnemigo()
        }
    }
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
    //tableroEnemigo.mostrarTablero(false)
    tableroEnemigo.mostrarTablero()
}

fun disparoJugador()
{
    var disparoErroneo = true
    while(disparoErroneo) {
        println("*-----------*")
        println("Introduce la posicion donde quieras disparar (ejemplo \"1A\")")
        println("*-----------*")
        val lectura = readLine().toString()
        if ("[1-8][A-H]".toRegex().matches(lectura.uppercase()))
        {
            when (tableroEnemigo.disparar(Position(lectura.uppercase()))) {
                //posición ya disparada
                -1 -> {
                    println("*-----------*")
                    println("Posición ya disparada, selecciona otra posición")
                }
                //posición ya disparada
                0 -> {
                    println("*-----AGUA------*")
                    disparoErroneo = false
                }
                1 -> {
                    println("*----TOCADO-----*")
                    disparoErroneo = false
                }
                2 -> {
                    println("*----HUNDIDO----*")
                    disparoErroneo = false
                }
            }

        }else{
            println(lectura)
            println("*-----------*")
            println("Posición incorrecta, utiliza un número y una letra (ejemplo \"1A\")")
        }
    }
}

fun disparoEnemigo()
{
    for(i in 1..5) {
        Thread.sleep(300)
        print(".")
    }
    println()
    var disparoErroneo = true
    while(disparoErroneo) {
        val posX = (1..8).random()
        val posY = (1..8).random()
        when (tableroJugador.disparar(Position(posX,posY))){
            0 -> {
                println("OH NO HE FALLADO!")
                disparoErroneo = false
            }
            1 -> {
                println("SII, TOCADO!!")
                disparoErroneo = false
            }
            2 ->{
                println("WEEEEEEEE HUNDIDO!!!")
                disparoErroneo = false
            }
        }
    }
}
fun mostrarMensajeFinJuego()
{
   //TODO
}
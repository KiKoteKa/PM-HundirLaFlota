const val sizeTablero = 8
const val numBarcosPequeño = 2
const val numBarcosMediano = 2
const val numBarcosGrande = 1

class Tablero {
    private var numBarcos=0
    private val disparadas:List<Casilla>
    private val conBarco:List<Casilla>
    private val barcos:List<Barco>

    constructor(){
        disparadas = listOf()
        conBarco = listOf()
        barcos = listOf()
        rellenaBarcos()
    }

    fun gameOver():Boolean{
        for(barco in barcos){
            if (!barco.isHundido()) return false
        }
        return true
    }

    fun disparar(pos:Position){
        //si ya está disparada devolver error
        //si hay varco, tocado
            //usar el id para marcar el barco como tocado
                //si el barco sigue vivo, decir tocado, decir hundido si no
        //si no hay varco devolvemos fallado
    }


    fun rellenaBarcos(){
        for(i in 1..numBarcosGrande){
            barcos.toMutableList().add(ponerBarco(4));
        }
        for(i in 1..numBarcosMediano){
            barcos.toMutableList().add(ponerBarco(3));
        }
        for(i in 1..numBarcosPequeño){
            barcos.toMutableList().add(ponerBarco(2));
        }
    }

    fun ponerBarco(size:Int):Barco{
        //buscar posición inicio random que no esté ocupada
        //dirección random (Arriba,abajo,derecha,izquierda) que no se salga del tablero
        //que ninguna de las posiciones esté ocupada
        //Marcar posiciones como barco
        numBarcos++
        return Barco(numBarcos,size,listOf(Position(1,'A'),Position(2,'A')))
    }





}
class Casilla {
    private var idBarco:Int
    private var posicion:Position

    constructor(idBarco:Int,posicion:Position){
        this.idBarco = idBarco
        this.posicion = posicion
    }

    fun getIdBarco(): Int {
        return idBarco
    }

    fun getPosicion(): Position {
        return posicion
    }



}
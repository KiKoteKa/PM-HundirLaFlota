class Casilla {
    private var idBarco:String
    private var posicion:Position

    constructor(idBarco:String,posicion:Position){
        this.idBarco = idBarco
        this.posicion = posicion
    }

    fun getIdBarco(): String {
        return idBarco
    }

    fun getPosicion(): Position {
        return posicion
    }



}
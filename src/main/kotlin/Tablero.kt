const val sizeTablero = 8
const val numBarcosPequeño = 2
const val numBarcosMediano = 2
const val numBarcosGrande = 1

class Tablero {
    private var numBarcos=0
    private val disparadas:MutableList<Position>
    private val conBarco:MutableList<Casilla>
    private val barcos:MutableList<Barco>

    constructor(){
        disparadas = mutableListOf<Position>()
        conBarco = mutableListOf<Casilla>()
        barcos = mutableListOf<Barco>()
        rellenaBarcos()
    }

    fun gameOver():Boolean{
        for(barco in barcos){
            if (!barco.isHundido()) return false
        }
        return true
    }

    /*
        return -1 : Ya disparada
        return  0 : Fallado
        return  1 : Tocado
        return  2 : Hundido
     */
    fun disparar(pos:Position):Int{
        //Primer Caso: si ya está disparada devolver error
        if (disparoEnPos(pos)>0) {
            return -1
        }
        disparadas.add(pos)
        //Segundo Caso: si hay varco, tocarlo
        //usar el id para marcar el barco como tocado
        //si el barco sigue vivo, decir tocado, decir hundido si no
        val listCasilla = conBarco.filter { it.getPosicion().getPosY() == pos.getPosY() && it.getPosicion().getPosY() == pos.getPosY() } //filtramos por la posición que disparamos
        if (!listCasilla.isEmpty()){
            val casilla:Casilla = listCasilla.first()
            return tocarBarco(casilla.getIdBarco())
        }
        //Tercer Caso: si no hay varco devolvemos fallado
        return 0;
    }

    //Devuelve si hay un barco en la posición dada
    fun barcoEnPos(pos:Position):Int{
        val listCasilla = conBarco.filter { it.getPosicion().getPosY() == pos.getPosY() && it.getPosicion().getPosX() == pos.getPosX() }
        return listCasilla.size
    }

    fun disparoEnPos(pos:Position):Int{
        val listDisparo = disparadas.filter { it.getPosY() == pos.getPosY() && it.getPosX() == pos.getPosX() }
        return listDisparo.size
    }

    //Devuelve 2 si se ha hundido y 1 si solo lo han tocado
    fun tocarBarco(idBarco:Int):Int{
        val barco:Barco = barcos.filter{it.getId().equals(idBarco)}.first()
        barco.tocar()
        if (barco.isHundido())
            return 2

        return 1
    }

    fun rellenaBarcos(){
        for(i in 1..numBarcosGrande){
            ponerBarco(4);
        }
        for(i in 1..numBarcosMediano){
            ponerBarco(3);
        }
        for(i in 1..numBarcosPequeño){
            ponerBarco(2);
        }
    }

    fun ponerBarco(size:Int){
        //buscar posición inicio random que no esté ocupada
        //dirección random (Arriba,abajo,derecha,izquierda) que no se salga del tablero
        //que ninguna de las posiciones esté ocupada
        //Marcar posiciones como barco
        var noSituado = true
        while(noSituado){
            var pos:Position = Position((1..sizeTablero).random(),(1..sizeTablero).random())
            val direccion = (1..4).random()
            var barcoCorrecto = true
            when (direccion) {
                //derecha
                1 -> if (pos.getPosX()<= sizeTablero-size){
                    barcoCorrecto = true
                    for (i in (pos.getPosX() until pos.getPosX()+size)){
                         if (barcoEnPos(Position(i,pos.getPosY()))>0){
                             barcoCorrecto = false
                         }
                    }
                    if(barcoCorrecto) {
                        barcos.add(Barco(numBarcos, size))
                        for (i in (pos.getPosX() until pos.getPosX() + size)) {
                            conBarco.add(Casilla(numBarcos, Position(i, pos.getPosY())))

                        }
                        noSituado = false
                    }
                }
                //abajo
                2 -> if (pos.getPosY()<= sizeTablero-size){
                    barcoCorrecto = true
                    for (i in (pos.getPosY() until pos.getPosY()+size)){
                        if (barcoEnPos(Position(pos.getPosX(),i))>0){
                            barcoCorrecto = false
                        }
                    }
                    if (barcoCorrecto) {
                        barcos.add(Barco(numBarcos, size));
                        for (i in (pos.getPosY() until pos.getPosY() + size)) {
                            conBarco.add(Casilla(numBarcos, Position(pos.getPosX(), i)))
                        }
                        noSituado = false
                    }
                }
                //izquierda
                3 -> if (pos.getPosX()>= size){
                    barcoCorrecto = true
                    for (i in (pos.getPosX() - size+1..pos.getPosX())){
                        if (barcoEnPos(Position(i,pos.getPosY()))>0){
                            barcoCorrecto = false
                        }
                    }
                    if(barcoCorrecto) {
                        barcos.add(Barco(numBarcos, size));
                        for (i in (pos.getPosX() - size+1..pos.getPosX())) {
                            conBarco.add(Casilla(numBarcos, Position(i, pos.getPosY())))
                        }
                        noSituado = false
                    }
                }
                //arriba
                4 -> if (pos.getPosY()<= size){
                    barcoCorrecto = true
                    for (i in (pos.getPosY()-size+1..pos.getPosY())){
                        if (barcoEnPos(Position(pos.getPosX(),i))>0){
                            barcoCorrecto = false
                        }
                    }
                    if (barcoCorrecto) {
                        barcos.add(Barco(numBarcos, size))
                        for (i in (pos.getPosY()-size+1..pos.getPosY())) {
                            conBarco.add(Casilla(numBarcos, Position(pos.getPosX(), i)))
                        }
                        noSituado = false
                    }
                }

            }
        }
        numBarcos++
    }

    fun mostrarTablero(mostrarBarco:Boolean=true){
        for(i in (0..sizeTablero)){
            if (i== 0){
                println("   A  B  C  D  E  F  G  H")
            }else {
                var str= "$i "
                for (j in (1 .. sizeTablero)) {
                    str += " ${caracterPosicion(Position(i,j),mostrarBarco)} "
                }
                println(str)
            }
        }
    }

    fun caracterPosicion(pos:Position,mostrarBarco: Boolean):Char{
        if (disparoEnPos(pos)>0) {
            return '*'
        }
        if (mostrarBarco && barcoEnPos(pos) > 0 ){
            return '+'
        }
        return '-'
    }

}
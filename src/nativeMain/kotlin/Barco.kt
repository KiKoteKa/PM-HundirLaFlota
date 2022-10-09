class Barco {
    private var id:Int
    private var size:Int
    private var tocados:Int
    private val pos:List<Position>

    constructor(id:Int,size:Int,pos:List<Position>){
        this.id = id
        this.size = size
        this.pos = pos
        this.tocados = 0
    }

    fun getId(): Int {
        return id
    }

    fun getSize(): Int {
        return size
    }

    fun getTocados(): Int {
        return tocados
    }

    fun getPositions(): List<Position> {
        return pos
    }

    fun isHundido():Boolean{
        return tocados==size;
    }

    fun tocar(){
        tocados++
    }
}
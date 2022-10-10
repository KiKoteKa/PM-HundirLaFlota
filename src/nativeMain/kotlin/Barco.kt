class Barco {
    private var id:Int
    private var size:Int
    private var tocados:Int

    constructor(id:Int,size:Int){
        this.id = id
        this.size = size
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


    fun isHundido():Boolean{
        return tocados==size;
    }

    fun tocar(){
        tocados++
    }
}
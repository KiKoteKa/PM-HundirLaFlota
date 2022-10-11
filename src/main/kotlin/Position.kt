class Position {
    private var posX = 0
    private var posY = 0

    constructor(posX:Int,posY:Int){
        this.posX = posX
        this.posY = posY
    }

    fun getPosX(): Int {
        return posX
    }

    fun getPosY(): Int {
        return posY
    }

    fun setPosX(posX:Int){
        this.posX = posX;
    }

    fun setPosY(posY:Int){
        this.posY = posY;
    }

    fun getPosXLetter():Char{
        val letras = listOf('A','B','C','D','E','F','G','H','I','J','K','L','M')
        return letras.get(posY)
    }
}
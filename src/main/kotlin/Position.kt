class Position {
    private var posX = 0
    private var posY = 0

    constructor(posX:Int,posY:Int){
        this.posX = posX
        this.posY = posY
    }
    constructor(pos:String){
        this.posX = pos.get(0).digitToInt()
        this.posY = getPosXLetter(pos.get(1))
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

    fun getLetterPosX():Char{
        val letras = listOf('A','B','C','D','E','F','G','H','I','J','K','L','M')
        return letras.get(posY)
    }

    fun getPosXLetter(c:Char):Int{
        val letras = listOf('A','B','C','D','E','F','G','H','I','J','K','L','M')
        return letras.indexOf(c)+1
    }
}
class Position {
    private var posX = 0
    private var posY = 'A'

    constructor(posX:Int,posY:Char){
        this.posX = posX
        this.posY = posY
    }


    fun getPosX(): Int {
        return posX
    }

    fun getPosY(): Char {
        return posY
    }

    fun setPosX(posX:Int){
        this.posX = posX;
    }

    fun setPosY(posY:Char){
        this.posY = posY;
    }

}
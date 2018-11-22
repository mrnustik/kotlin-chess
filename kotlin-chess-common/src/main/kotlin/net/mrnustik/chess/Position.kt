package net.mrnustik.chess

import net.mrnustik.chess.pieces.Piece

fun Int.isOdd() : Boolean = this % 2 == 0
fun Int.isEven() : Boolean = this % 2 != 0

class Position (val x: Int,val y: Int){

    var piece: Piece? = null

    val color: Color
        get() = if ((x.isOdd() && y.isOdd()) || (x.isEven() && y.isEven())) {
            Color.BLACK
        } else {
            Color.WHITE
        }

    fun isEmpty(): Boolean = piece == null

    override fun toString(): String {
        return "[$x,$y]"
    }
}

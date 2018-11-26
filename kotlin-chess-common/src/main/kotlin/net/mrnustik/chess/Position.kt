package net.mrnustik.chess

import net.mrnustik.chess.pieces.NullPiece
import net.mrnustik.chess.pieces.Piece



class Position (val x: Int,val y: Int){

    private fun Int.isOdd() : Boolean = this % 2 == 0
    private fun Int.isEven() : Boolean = this % 2 != 0

    var piece: Piece = NullPiece()

    val color: Color
        get() = if ((x.isOdd() && y.isOdd()) || (x.isEven() && y.isEven())) {
            Color.BLACK
        } else {
            Color.WHITE
        }

    fun isEmpty(): Boolean = piece is NullPiece

    override fun toString(): String {
        return "${getXCoordinateAsCharacter()}${y+1}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Position) return false

        if (x != other.x) return false
        if (y != other.y) return false
        if (piece::class != other.piece::class) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        result = 31 * result + piece::class.hashCode()
        return result
    }

    private fun getXCoordinateAsCharacter() : Char {
        var c = 'a'
        return c + x
    }
}

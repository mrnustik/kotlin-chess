package net.mrnustik.chess.rules

import net.mrnustik.chess.Color
import net.mrnustik.chess.Position
import net.mrnustik.chess.pieces.Piece

abstract class BaseRule : Rule {

    protected fun isWithinBounds(x: Int, y: Int) : Boolean{
        return x in (0..7) && y in (0..7)
    }

    protected fun isAttackable(currentPosition: Position, attackingPosition: Position) : Boolean{
        return !attackingPosition.isEmpty() && attackingPosition.piece.color != currentPosition.piece.color
    }

    protected fun addToForwardDirectionOfPiece(position: Position, valueToBeAdded: Int) : Int {
        return when (position.piece.color) {
            Color.WHITE -> position.y + valueToBeAdded
            Color.BLACK -> position.y - valueToBeAdded
            else -> position.y
        }
    }
}
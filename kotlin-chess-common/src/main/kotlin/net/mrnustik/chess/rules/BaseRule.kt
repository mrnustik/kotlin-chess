package net.mrnustik.chess.rules

import net.mrnustik.chess.Color
import net.mrnustik.chess.Position
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move

abstract class BaseRule : Rule {

    protected fun isWithinBounds(x: Int, y: Int) : Boolean{
        return x in (0..7) && y in (0..7)
    }

    protected fun addToForwardDirectionOfPiece(position: Position, valueToBeAdded: Int) : Int {
        return when (position.piece.color) {
            Color.WHITE -> position.y + valueToBeAdded
            Color.BLACK -> position.y - valueToBeAdded
            else -> position.y
        }
    }

    protected fun MutableSet<Move>.addMoveIfPossible(board: Board, position: Position, x: Int, y: Int){
        if(isWithinBounds(x, y)) {
            this.add(Move(position, board.positions[y][x]))
        }
    }
}
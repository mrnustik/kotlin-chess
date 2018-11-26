package net.mrnustik.chess.rules

import net.mrnustik.chess.Color
import net.mrnustik.chess.Position
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.BasicMove

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

    protected fun MutableSet<BasicMove>.addMoveIfPossible(board: Board, position: Position, x: Int, y: Int){
        if(isWithinBounds(x, y)) {
            this.add(BasicMove(position, board.positions[y][x]))
        }
    }

    protected fun MutableSet<BasicMove>.addMovesUntilBlocked(board: Board, position: Position, changeX : (Int) -> Int, changeY : (Int) -> Int) {
        var x = changeX(position.x)
        var y = changeY(position.y)
        while(isWithinBounds(x, y))
        {
            val movePosition= board.positions[y][x]
            if (movePosition.isEmpty()) {
                this.add(BasicMove(position, movePosition))
            } else {
                this.add(BasicMove(position, movePosition))
                break
            }
            x = changeX(x)
            y = changeY(y)
        }
    }
}
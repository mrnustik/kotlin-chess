package net.mrnustik.chess.rules

import net.mrnustik.chess.Position
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move

class BishopMovementRule : BaseRule() {
    override fun getValidMoves(board: Board, currentPosition: Position): Set<Move> {
        val moves = mutableSetOf<Move>()
        moves.addTopLeftQuadrantMoves(board, currentPosition)
        moves.addTopRightQuadrantMoves(board, currentPosition)
        moves.addBottomLeftQuadrantMoves(board, currentPosition)
        moves.addBottomRightQuadrantMoves(board, currentPosition)
        return moves
    }

    private fun MutableSet<Move>.addTopLeftQuadrantMoves(board: Board, position: Position) {
        val changeX = { x: Int -> x - 1 }
        val changeY = { y: Int -> y + 1 }
        this.addAvailableMovesMoves(board, position, changeX, changeY)
    }


    private fun MutableSet<Move>.addTopRightQuadrantMoves(board: Board, position: Position) {
        val changeX = { x: Int -> x + 1 }
        val changeY = { y: Int -> y + 1 }
        this.addAvailableMovesMoves(board, position, changeX, changeY)
    }

    private fun MutableSet<Move>.addBottomLeftQuadrantMoves(board: Board, position: Position) {
        val changeX = { x: Int -> x - 1 }
        val changeY = { y: Int -> y - 1 }
        this.addAvailableMovesMoves(board, position, changeX, changeY)
    }

    private fun MutableSet<Move>.addBottomRightQuadrantMoves(board: Board, position: Position) {
        val changeX = { x: Int -> x + 1 }
        val changeY = { y: Int -> y - 1 }
        this.addAvailableMovesMoves(board, position, changeX, changeY)
    }

    private fun MutableSet<Move>.addAvailableMovesMoves(board: Board, position: Position, changeX : (Int) -> Int, changeY : (Int) -> Int) {
        var x = changeX(position.x)
        var y = changeY(position.y)
        while(isWithinBounds(x, y))
        {
            val movePosition= board.positions[y][x]
            if (movePosition.isEmpty()) {
                this.add(Move(position, movePosition))
            } else {
                this.add(Move(position, movePosition))
                break
            }
            x = changeX(x)
            y = changeY(y)
        }
    }

}







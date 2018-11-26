package net.mrnustik.chess.rules

import net.mrnustik.chess.Position
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.BasicMove

class BishopMovementRule : BaseRule() {
    override fun getValidMoves(board: Board, currentPosition: Position): Set<BasicMove> {
        val moves = mutableSetOf<BasicMove>()
        moves.addTopLeftQuadrantMoves(board, currentPosition)
        moves.addTopRightQuadrantMoves(board, currentPosition)
        moves.addBottomLeftQuadrantMoves(board, currentPosition)
        moves.addBottomRightQuadrantMoves(board, currentPosition)
        return moves
    }

    private fun MutableSet<BasicMove>.addTopLeftQuadrantMoves(board: Board, position: Position) {
        val changeX = { x: Int -> x - 1 }
        val changeY = { y: Int -> y + 1 }
        this.addMovesUntilBlocked(board, position, changeX, changeY)
    }


    private fun MutableSet<BasicMove>.addTopRightQuadrantMoves(board: Board, position: Position) {
        val changeX = { x: Int -> x + 1 }
        val changeY = { y: Int -> y + 1 }
        this.addMovesUntilBlocked(board, position, changeX, changeY)
    }

    private fun MutableSet<BasicMove>.addBottomLeftQuadrantMoves(board: Board, position: Position) {
        val changeX = { x: Int -> x - 1 }
        val changeY = { y: Int -> y - 1 }
        this.addMovesUntilBlocked(board, position, changeX, changeY)
    }

    private fun MutableSet<BasicMove>.addBottomRightQuadrantMoves(board: Board, position: Position) {
        val changeX = { x: Int -> x + 1 }
        val changeY = { y: Int -> y - 1 }
        this.addMovesUntilBlocked(board, position, changeX, changeY)
    }

}







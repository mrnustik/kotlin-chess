package net.mrnustik.chess.rules

import net.mrnustik.chess.Position
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.BasicMove

class KnightMovementRule : BaseRule() {
    override fun getValidMoves(board: Board, currentPosition: Position): Set<BasicMove> {
        val moves = mutableSetOf<BasicMove>()
        moves.addTopMoves(board, currentPosition)
        moves.addLeftMoves(board, currentPosition)
        moves.addBottomMoves(board, currentPosition)
        moves.addRightMoves(board, currentPosition)
        return moves
    }

    private fun MutableSet<BasicMove>.addTopMoves(board: Board, position: Position) {
        this.addMoveIfPossible(board, position, position.x + 1, position.y + 2)
        this.addMoveIfPossible(board, position, position.x - 1, position.y + 2)
    }


    private fun MutableSet<BasicMove>.addLeftMoves(board: Board, position: Position) {
        this.addMoveIfPossible(board, position, position.x + 2, position.y - 1)
        this.addMoveIfPossible(board, position, position.x + 2, position.y + 1)
    }

    private fun MutableSet<BasicMove>.addBottomMoves(board: Board, position: Position) {
        this.addMoveIfPossible(board, position, position.x + 1, position.y - 2)
        this.addMoveIfPossible(board, position, position.x - 1, position.y - 2)
    }

    private fun MutableSet<BasicMove>.addRightMoves(board: Board, position: Position) {
        this.addMoveIfPossible(board, position, position.x - 2, position.y - 1)
        this.addMoveIfPossible(board, position, position.x - 2, position.y + 1)
    }
}
package net.mrnustik.chess.rules

import net.mrnustik.chess.Position
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move

class KingMovementRule : BaseRule() {
    override fun getValidMoves(board: Board, currentPosition: Position): Set<Move> {
        val moves = mutableSetOf<Move>()
        moves.addTopMoves(board, currentPosition)
        moves.addLeftMoves(board, currentPosition)
        moves.addBottomMoves(board, currentPosition)
        moves.addRightMoves(board, currentPosition)
        return moves
    }

    private fun MutableSet<Move>.addTopMoves(board: Board, position: Position) {
        this.addMoveIfPossible(board, position, position.x + 1, position.y + 2)
        this.addMoveIfPossible(board, position, position.x - 1, position.y + 2)
    }


    private fun MutableSet<Move>.addLeftMoves(board: Board, position: Position) {
        this.addMoveIfPossible(board, position, position.x + 2, position.y - 1)
        this.addMoveIfPossible(board, position, position.x + 2, position.y + 1)
    }

    private fun MutableSet<Move>.addBottomMoves(board: Board, position: Position) {
        this.addMoveIfPossible(board, position, position.x + 1, position.y - 2)
        this.addMoveIfPossible(board, position, position.x - 1, position.y - 2)
    }

    private fun MutableSet<Move>.addRightMoves(board: Board, position: Position) {
        this.addMoveIfPossible(board, position, position.x - 2, position.y - 1)
        this.addMoveIfPossible(board, position, position.x - 2, position.y + 1)
    }
}
package net.mrnustik.chess.rules

import net.mrnustik.chess.Position
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move

class KingMovementRule : BaseRule() {

    override fun getValidMoves(board: Board, currentPosition: Position): Set<Move> {
        val moves = mutableSetOf<Move>()
        moves.addPossibleMoves(board, currentPosition)
        return moves
    }

    private fun MutableSet<Move>.addPossibleMoves(board: Board, currentPosition: Position) {
        this.addMoveIfPossible(board, currentPosition, currentPosition.x + 1, currentPosition.y + 1)
        this.addMoveIfPossible(board, currentPosition, currentPosition.x + 1, currentPosition.y - 1)
        this.addMoveIfPossible(board, currentPosition, currentPosition.x - 1, currentPosition.y + 1)
        this.addMoveIfPossible(board, currentPosition, currentPosition.x - 1, currentPosition.y - 1)
        this.addMoveIfPossible(board, currentPosition, currentPosition.x + 1, currentPosition.y)
        this.addMoveIfPossible(board, currentPosition, currentPosition.x - 1, currentPosition.y)
        this.addMoveIfPossible(board, currentPosition, currentPosition.x, currentPosition.y + 1)
        this.addMoveIfPossible(board, currentPosition, currentPosition.x, currentPosition.y - 1)
    }
}



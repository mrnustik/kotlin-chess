package net.mrnustik.chess.moves.validator

import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move

class StandardChessMoveValidator : MoveValidator {
    override fun isMoveValid(board: Board, move: Move): Boolean {
        if(isAttackingMove(move) && isAttackingItsOwnColor(move)) {
            return false
        }

        return true
    }

    private fun isAttackingMove(move: Move): Boolean {
        return !move.to.isEmpty()
    }

    private fun isAttackingItsOwnColor(move: Move) =
            move.usedPiece.color == move.takenPiece.color
}
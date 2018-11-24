package net.mrnustik.chess.moves.validator

import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move

class StandardChessMoveValidator : MoveValidator {
    override fun isMoveValid(board: Board, move: Move): Boolean {
        if(!isNotAttackingItsOwnColor(move)) {
            return false
        }

        return true
    }

    private fun isNotAttackingItsOwnColor(move: Move) =
            move.usedPiece.color.getOpositeColor() == move.takenPiece.color
}
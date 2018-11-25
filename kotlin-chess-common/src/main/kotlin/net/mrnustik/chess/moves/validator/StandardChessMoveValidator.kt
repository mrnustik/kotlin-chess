package net.mrnustik.chess.moves.validator

import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move
import net.mrnustik.chess.pieces.NullPiece

class StandardChessMoveValidator : MoveValidator {
    override fun isMoveValid(board: Board, move: Move): Boolean {
        if(!isAttackingItsOwnColor(move)) {
            return false
        }

        return true
    }

    private fun isAttackingItsOwnColor(move: Move) =
            move.takenPiece !is NullPiece && move.usedPiece.color == move.takenPiece.color
}
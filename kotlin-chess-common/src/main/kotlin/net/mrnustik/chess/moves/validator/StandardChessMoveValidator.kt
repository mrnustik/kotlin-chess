package net.mrnustik.chess.moves.validator

import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move
import net.mrnustik.chess.pieces.*

class StandardChessMoveValidator : MoveValidator {
    override fun isMoveValid(board: Board, move: Move): Boolean {
        if(isAttackingMove(move) && isAttackingItsOwnColor(move)) {
            return false
        }

        if(isMovingKing(move) && isToPositionUnderAttack(board, move)) {
            return false
        }

        return true
    }

    private fun isMovingKing(move: Move): Boolean {
        return move.usedPiece is King
    }

    private fun isToPositionUnderAttack(board: Board, move: Move): Boolean {
        return board.isPositionUnderAttack(move.to.x, move.to.y, move.usedPiece.color.getOpositeColor())
    }

    private fun isAttackingMove(move: Move): Boolean {
        return !move.to.isEmpty()
    }

    private fun isAttackingItsOwnColor(move: Move) =
            move.usedPiece.color == move.takenPiece.color
}
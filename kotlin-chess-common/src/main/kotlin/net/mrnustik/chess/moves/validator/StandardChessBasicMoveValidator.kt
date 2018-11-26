package net.mrnustik.chess.moves.validator

import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.BasicMove
import net.mrnustik.chess.pieces.*

class StandardChessBasicMoveValidator : BasicMoveValidator {
    override fun isMoveValid(board: Board, move: BasicMove): Boolean {
        if(isAttackingMove(move) && isAttackingItsOwnColor(move)) {
            return false
        }

        if(isMovingKing(move) && isToPositionUnderAttack(board, move)) {
            return false
        }

        return true
    }

    private fun isMovingKing(move: BasicMove): Boolean {
        return move.usedPiece is King
    }

    private fun isToPositionUnderAttack(board: Board, move: BasicMove): Boolean {
        return board.isPositionUnderAttack(move.to.x, move.to.y, move.usedPiece.color.getOpositeColor())
    }

    private fun isAttackingMove(move: BasicMove): Boolean {
        return !move.to.isEmpty()
    }

    private fun isAttackingItsOwnColor(move: BasicMove) =
            move.usedPiece.color == move.takenPiece.color
}
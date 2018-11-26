package net.mrnustik.chess.moves.validator

import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.BasicMove

interface BasicMoveValidator {
    fun isMoveValid(board: Board, move: BasicMove) : Boolean
}
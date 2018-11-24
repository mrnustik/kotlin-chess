package net.mrnustik.chess.moves.validator

import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move

interface MoveValidator {
    fun isMoveValid(board: Board, move: Move) : Boolean
}
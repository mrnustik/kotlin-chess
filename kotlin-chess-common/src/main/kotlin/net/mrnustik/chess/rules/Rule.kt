package net.mrnustik.chess.rules

import net.mrnustik.chess.Position
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move

interface Rule {
    fun getValidMoves(board: Board, currentPosition: Position) : Set<Move>
}
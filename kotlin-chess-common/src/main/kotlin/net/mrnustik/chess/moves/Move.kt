package net.mrnustik.chess.moves

import net.mrnustik.chess.board.*

interface Move {
    fun apply(board: Board)
}
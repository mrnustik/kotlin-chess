package net.mrnustik.chess.board.factory

import net.mrnustik.chess.board.Board

interface BoardFactory {
    fun createBoard() : Board
}

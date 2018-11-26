package net.mrnustik.chess.moves

import net.mrnustik.chess.Position
import net.mrnustik.chess.board.*
import net.mrnustik.chess.pieces.*

data class BasicMove(val from: Position, val to: Position) : Move {
    val usedPiece: Piece = from.piece
    val takenPiece: Piece = to.piece

    override fun apply(board: Board) {
        board.positions[from.y][from.x].piece = NullPiece()
        board.positions[to.y][to.x].piece = usedPiece
    }
}
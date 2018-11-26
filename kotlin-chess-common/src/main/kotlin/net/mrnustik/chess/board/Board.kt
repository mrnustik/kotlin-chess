package net.mrnustik.chess.board

import net.mrnustik.chess.Color
import net.mrnustik.chess.Position
import net.mrnustik.chess.moves.*
import net.mrnustik.chess.pieces.Piece

interface Board {
    val positions: Array<Array<Position>>
    fun addPiece(x: Int, y: Int, piece: Piece)
    fun getAllPiecePositions(): Set<Position>
    fun getAllPlayerPiecePositions(playerColor: Color): Set<Position>
    fun getAllValidMoves(playerColor: Color): Set<BasicMove>
    fun isPositionUnderAttack(x: Int, y: Int, playerColor: Color): Boolean
    fun clone(): Board
    fun performMove(move: Move): Board
}
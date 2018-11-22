package net.mrnustik.chess.pieces.factory

import net.mrnustik.chess.Color
import net.mrnustik.chess.pieces.*

interface PieceFactory {
    fun createKnight(color: Color): Piece
    fun createPawn(color: Color): Piece
    fun createKing(color: Color): Piece
    fun createQueen(color: Color): Piece
    fun createBishop(color: Color): Piece
    fun createRook(color: Color): Piece
}
package net.mrnustik.chess.pieces

import net.mrnustik.chess.Color

class Pawn(color: Color) : Piece(color) {
    override val character: Char = 'P'
}
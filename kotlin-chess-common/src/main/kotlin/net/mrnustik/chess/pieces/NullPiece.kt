package net.mrnustik.chess.pieces

import net.mrnustik.chess.Color

class NullPiece : Piece(Color.NONE) {
    override val character: Char
        get() = ' '
}
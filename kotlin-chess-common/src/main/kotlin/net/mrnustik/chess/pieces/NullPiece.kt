package net.mrnustik.chess.pieces

import net.mrnustik.chess.Color
import net.mrnustik.chess.moves.RelativeMove

class NullPiece : Piece(Color.NONE) {
    override val character: Char
        get() = ' '
}
package net.mrnustik.chess.pieces

import net.mrnustik.chess.moves.RelativeMove

abstract class Piece {
    abstract val character: Char

    abstract val attackMoves: Set<RelativeMove>
    abstract val moves : Set<RelativeMove>
}


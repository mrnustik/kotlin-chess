package net.mrnustik.chess.pieces

import net.mrnustik.chess.Color
import net.mrnustik.chess.rules.Rule

class NullPiece : Piece(Color.NONE) {

    override fun getAppliedRules(): Set<Rule> {
        return emptySet()
    }

    override val character: Char
        get() = ' '
}
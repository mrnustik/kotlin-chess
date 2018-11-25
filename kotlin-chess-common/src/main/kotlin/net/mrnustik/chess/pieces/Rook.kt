package net.mrnustik.chess.pieces

import net.mrnustik.chess.Color
import net.mrnustik.chess.rules.RookMovementRule
import net.mrnustik.chess.rules.Rule

class Rook(color: Color) : Piece(color) {

    override fun getAppliedRules(): Set<Rule> {
        return setOf(RookMovementRule())
    }

    override val character: Char = 'R'
}
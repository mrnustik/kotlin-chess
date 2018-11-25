package net.mrnustik.chess.pieces

import net.mrnustik.chess.Color
import net.mrnustik.chess.rules.BishopMovementRule
import net.mrnustik.chess.rules.Rule

class Bishop(color: Color) : Piece(color) {

    override fun getAppliedRules(): Set<Rule> {
        return setOf(BishopMovementRule())
    }

    override val character: Char = 'B'
}
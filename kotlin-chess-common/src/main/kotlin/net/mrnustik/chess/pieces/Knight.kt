package net.mrnustik.chess.pieces

import net.mrnustik.chess.Color
import net.mrnustik.chess.rules.KnightMovementRule
import net.mrnustik.chess.rules.Rule

class Knight(color: Color) : Piece(color) {

    override fun getAppliedRules(): Set<Rule> {
        return setOf(KnightMovementRule())
    }

    override val character: Char = 'N'
}
package net.mrnustik.chess.pieces

import net.mrnustik.chess.Color
import net.mrnustik.chess.rules.KingMovementRule
import net.mrnustik.chess.rules.Rule

class King(color: Color) : Piece(color) {

    override fun getAppliedRules(): Set<Rule> {
        return setOf(KingMovementRule())
    }

    override val character: Char = 'K'
}
package net.mrnustik.chess.pieces

import net.mrnustik.chess.Color
import net.mrnustik.chess.rules.QueenMovementRule
import net.mrnustik.chess.rules.Rule

class Queen(color: Color) : Piece(color) {

    override fun getAppliedRules(): Set<Rule> {
        return setOf(QueenMovementRule())
    }

    override val character: Char = 'Q'
}
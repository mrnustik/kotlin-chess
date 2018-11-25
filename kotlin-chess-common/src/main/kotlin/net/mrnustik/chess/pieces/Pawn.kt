package net.mrnustik.chess.pieces

import net.mrnustik.chess.Color
import net.mrnustik.chess.rules.PawnAttackingRule
import net.mrnustik.chess.rules.PawnMovementRule
import net.mrnustik.chess.rules.Rule

class Pawn(color: Color) : Piece(color) {

    override fun getAppliedRules(): Set<Rule> {
        return setOf(PawnAttackingRule(), PawnMovementRule())
    }

    override val character: Char = 'P'
}
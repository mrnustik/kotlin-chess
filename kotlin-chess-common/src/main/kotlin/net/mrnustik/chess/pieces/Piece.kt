package net.mrnustik.chess.pieces

import net.mrnustik.chess.Color
import net.mrnustik.chess.rules.Rule

abstract class Piece (val color: Color){

    abstract val character: Char

    abstract fun getAppliedRules() : Set<Rule>
}


package net.mrnustik.chess.game

data class CastlePossibility(var isQueenCastlePossible: Boolean = true, var isKingCastlePossible: Boolean = true){
    fun isAnyCastlePossible() : Boolean {
        return isQueenCastlePossible || isKingCastlePossible
    }
}
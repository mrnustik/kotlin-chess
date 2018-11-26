package net.mrnustik.chess.game

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.BasicMove
import net.mrnustik.chess.pieces.*
import net.mrnustik.chess.player.Player

class Game(var board: Board, val whitePlayer: Player, val blackPlayer: Player) {
    val movesHistory : MutableList<BasicMove> = mutableListOf()
    val castlePossibilitiesMap = mapOf(Color.BLACK to CastlePossibility(), Color.WHITE to CastlePossibility())
    var activePlayerColor: Color = Color.WHITE

    val activePlayer : Player?
        get() = when (activePlayerColor) {
            Color.WHITE -> whitePlayer
            Color.BLACK -> blackPlayer
            else -> null
        }

    fun getAllValidMovesForActivePlayer() : Set<BasicMove> {
        val simpleMoves = board.getAllValidMoves(activePlayerColor).toMutableSet()
        val castlePossibilities = castlePossibilitiesMap[activePlayerColor]
        if(castlePossibilities?.isAnyCastlePossible() == true) {
            TODO("add castle moves")
        }
        return simpleMoves
    }

    fun performMove(move: BasicMove) {
        board = board.performMove(move)
        detectCastlePossibilityChange(move)
        movesHistory.add(move)
        activePlayerColor = activePlayerColor.getOpositeColor()
    }

    private fun detectCastlePossibilityChange(move: BasicMove) {
        if(move.usedPiece is King) {
            castlePossibilitiesMap[activePlayerColor]?.isQueenCastlePossible = false
            castlePossibilitiesMap[activePlayerColor]?.isKingCastlePossible = false
        } else if(move.usedPiece is Rook) {
            val wasRookInStartingPlace = (move.from.y == 0 || move.from.y == 7) && (move.from.x == 0 || move.from.x == 7)
            val isQueenSideRook = move.from.x == 0
            if(wasRookInStartingPlace && isQueenSideRook) {
                castlePossibilitiesMap[activePlayerColor]?.isQueenCastlePossible = false
            } else if(wasRookInStartingPlace) {
                castlePossibilitiesMap[activePlayerColor]?.isKingCastlePossible = false
            }
        }
    }
}
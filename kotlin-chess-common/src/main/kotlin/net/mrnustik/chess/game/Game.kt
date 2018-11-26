package net.mrnustik.chess.game

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move
import net.mrnustik.chess.player.Player

class Game(var board: Board, val whitePlayer: Player, val blackPlayer: Player) {
    val movesHistory : MutableList<Move> = mutableListOf()
    var activePlayerColor: Color = Color.WHITE

    val activePlayer : Player?
        get() = when (activePlayerColor) {
            Color.WHITE -> whitePlayer
            Color.BLACK -> blackPlayer
            else -> null
        }

    fun getAllValidMovesForActivePlayer() : Set<Move> {
        return board.getAllValidMoves(activePlayerColor)
    }

    fun performMove(move: Move) {
        board = board.performMove(move)
        movesHistory.add(move)
        activePlayerColor = activePlayerColor.getOpositeColor()
    }
}
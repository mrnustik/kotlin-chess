package net.mrnustik.chess.player

import net.mrnustik.chess.Color
import net.mrnustik.chess.game.Game

abstract class Player(val color: Color) {
    abstract fun performMove(game: Game)
}
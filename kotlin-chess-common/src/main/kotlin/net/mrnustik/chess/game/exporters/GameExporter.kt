package net.mrnustik.chess.game.exporters

import net.mrnustik.chess.game.*

interface GameExporter<TOutputType> {
    fun exportGame(game: Game): TOutputType
}
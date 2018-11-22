package net.mrnustik.chess.rules

import net.mrnustik.chess.board.factory.StandardBoardFactory
import net.mrnustik.chess.pieces.factory.StandardPieceFactory

open class BaseRuleTests {
    val pieceFactory = StandardPieceFactory()
    val boardFactory = StandardBoardFactory(pieceFactory)
}
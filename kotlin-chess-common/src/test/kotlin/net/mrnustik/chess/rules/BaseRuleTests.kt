package net.mrnustik.chess.rules

import net.mrnustik.chess.board.Board
import net.mrnustik.chess.board.StandardChessBoard
import net.mrnustik.chess.board.factory.StandardBoardFactory
import net.mrnustik.chess.pieces.factory.StandardPieceFactory

open class BaseRuleTests {
    protected val pieceFactory = StandardPieceFactory()
    protected val boardFactory = StandardBoardFactory(pieceFactory)

    protected fun createEmptyBoard(): Board {
        return StandardChessBoard()
    }
}
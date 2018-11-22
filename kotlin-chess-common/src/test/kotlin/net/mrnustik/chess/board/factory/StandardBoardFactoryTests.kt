package net.mrnustik.chess.board.factory

import net.mrnustik.chess.pieces.factory.StandardPieceFactory
import org.junit.Assert.assertFalse
import org.junit.Test

class StandardBoardFactoryTests {

    @Test
    fun createBoard_withStandardPieces_allFrontPiecesAreFilled() {
        //Arrange
        var boardFactory = StandardBoardFactory(StandardPieceFactory())

        //Act
        var board = boardFactory.createBoard()

        //Assert
        for(i in (0..7)){
            assertFalse(board.positions[0][i].isEmpty())
            assertFalse(board.positions[1][i].isEmpty())
            assertFalse(board.positions[6][i].isEmpty())
            assertFalse(board.positions[7][i].isEmpty())
        }
    }
}
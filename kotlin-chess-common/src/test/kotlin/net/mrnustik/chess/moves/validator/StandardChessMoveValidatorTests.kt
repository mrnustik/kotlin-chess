package net.mrnustik.chess.moves.validator

import assertk.assert
import assertk.assertions.*
import net.mrnustik.chess.Color
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.board.StandardChessBoard
import net.mrnustik.chess.board.factory.StandardBoardFactory
import net.mrnustik.chess.moves.BasicMove
import net.mrnustik.chess.pieces.factory.PieceFactory
import net.mrnustik.chess.pieces.factory.StandardPieceFactory
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class StandardChessMoveValidatorTests  {
    val pieceFactory : PieceFactory = StandardPieceFactory()

    @Test
    fun isMoveValid_whenTakingOwnPiece_returnsFalse()
    {
        //Arrange
        val board = StandardChessBoard()
        board.addPiece(0,0, pieceFactory.createRook(Color.BLACK))
        board.addPiece(0,1, pieceFactory.createRook(Color.BLACK))
        val move = BasicMove(board.positions[0][0], board.positions[1][0])
        val validator = StandardChessBasicMoveValidator()

        //Act
        val isValid = validator.isMoveValid(board, move)

        //Assert
        assertFalse(isValid)
    }

    @Test
    fun isMoveValid_completelyValidOpening_returnsTrue()
    {
        //Arrange
        val board = StandardBoardFactory(StandardPieceFactory()).createBoard()
        val e4Opening = BasicMove(board.positions[1][4], board.positions[3][4])
        val validator = StandardChessBasicMoveValidator()

        //Act
        val isValid = validator.isMoveValid(board, e4Opening)

        //Assert
        assertTrue(isValid)
    }


    @Test
    fun isMoveValid_whenKingMovesIntoCheck_returnsFalse()
    {
        //Arrange
        val board = createEmptyBoard()
        board.addPiece(0,0, pieceFactory.createKing(Color.BLACK))
        board.addPiece(3,0, pieceFactory.createKing(Color.WHITE))
        board.addPiece(4,7,pieceFactory.createRook(Color.BLACK))
        val e4Opening = BasicMove(board.positions[0][3], board.positions[0][4])
        val validator = StandardChessBasicMoveValidator()

        //Act
        val isValid = validator.isMoveValid(board, e4Opening)

        //Assert
        assert(isValid).isFalse()
    }

    private fun createEmptyBoard(): Board {
        return StandardChessBoard()
    }

}
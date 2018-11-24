package net.mrnustik.chess.moves.validator

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move
import net.mrnustik.chess.pieces.factory.PieceFactory
import net.mrnustik.chess.pieces.factory.StandardPieceFactory
import org.junit.Assert.assertFalse
import org.junit.Test

class StandardChessMoveValidatorTests  {
    val pieceFactory : PieceFactory = StandardPieceFactory()

    @Test
    fun isMoveValid_whenTakingOwnPiece_returnsFalse()
    {
        //Arrange
        val board = Board()
        board.addPiece(0,0, pieceFactory.createRook(Color.BLACK))
        board.addPiece(1,0, pieceFactory.createRook(Color.BLACK))
        val move = Move(board.positions[0][0], board.positions[1][0])
        val validator = StandardChessMoveValidator()

        //Act
        val isValid = validator.isMoveValid(board, move)

        //Assert
        assertFalse(isValid)
    }

}
package net.mrnustik.chess.board

import net.mrnustik.chess.Color
import net.mrnustik.chess.pieces.factory.PieceFactory
import net.mrnustik.chess.pieces.factory.StandardPieceFactory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class BoardTests {
    val pieceFactory : PieceFactory = StandardPieceFactory()

    @Test(expected = IllegalArgumentException::class)
    fun addPiece_outOfBoardBounds_throwsArgumentException(){
        //Arrange
        val board = Board()
        val piece = pieceFactory.createBishop(Color.WHITE)

        //Act
        board.addPiece(8,10, piece)

        //Assert
    }

    @Test
    fun addPiece_withinBounds_addsPiece(){
        //Arrange
        val board = Board()
        val piece = pieceFactory.createBishop(Color.WHITE)

        //Act
        board.addPiece(0,2, piece)

        //Assert
        assertEquals(piece, board.positions[2][0].piece)
    }

    @Test
    fun getAllPiecePositions_withOnePiece_returnsItsPosition(){
        //Arrange
        val board = Board()
        val piece = pieceFactory.createBishop(Color.WHITE)
        board.addPiece(0,2, piece)

        //Act
        val piecePositions = board.getAllPiecePositions()

        //Assert
        assertEquals(1, piecePositions.size)
        val position = piecePositions.first()
        assertEquals(0, position.x)
        assertEquals(2, position.y)
        assertEquals(piece, position.piece)
        assertFalse(position.isEmpty())

    }
}
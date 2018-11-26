package net.mrnustik.chess.board

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.factory.StandardBoardFactory
import net.mrnustik.chess.exceptions.InvalidMoveException
import net.mrnustik.chess.moves.Move
import net.mrnustik.chess.pieces.factory.PieceFactory
import net.mrnustik.chess.pieces.factory.StandardPieceFactory
import org.junit.Assert.*
import org.junit.Test

class BoardTests {
    val pieceFactory : PieceFactory = StandardPieceFactory()

    @Test(expected = IllegalArgumentException::class)
    fun addPiece_outOfBoardBounds_throwsArgumentException(){
        //Arrange
        val board = StandardChessBoard()
        val piece = pieceFactory.createBishop(Color.WHITE)

        //Act
        board.addPiece(8,10, piece)

        //Assert
    }

    @Test
    fun addPiece_withinBounds_addsPiece(){
        //Arrange
        val board = StandardChessBoard()
        val piece = pieceFactory.createBishop(Color.WHITE)

        //Act
        board.addPiece(0,2, piece)

        //Assert
        assertEquals(piece, board.positions[2][0].piece)
    }

    @Test
    fun getAllPiecePositions_withOnePiece_returnsItsPosition(){
        //Arrange
        val board = StandardChessBoard()
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

    @Test
    fun getAllPlayerPiecePositions_withOnePieceOfEachColor_returnsOnlyOnePosition(){
        //Arrange
        val board = StandardChessBoard()
        val whitePiece = pieceFactory.createBishop(Color.WHITE)
        board.addPiece(0,2, whitePiece)
        val blackPiece = pieceFactory.createBishop(Color.BLACK)
        board.addPiece(2,0, blackPiece)

        //Act
        val piecePositions = board.getAllPlayerPiecePositions(Color.WHITE)

        //Assert
        assertEquals(1, piecePositions.size)
        val position = piecePositions.first()
        assertEquals(0, position.x)
        assertEquals(2, position.y)
        assertEquals(whitePiece, position.piece)
        assertFalse(position.isEmpty())
    }

    @Test
    fun getAllValidMoves_withStandardBoard_returnsAllOpeningMoves() {
        //Arrange
        val boardFactory = StandardBoardFactory(StandardPieceFactory())
        val board = boardFactory.createBoard()

        //Act
        val allValidMoves = board.getAllValidMoves(Color.WHITE)

        //Assert
        assertEquals(20, allValidMoves.size)
    }

    @Test
    fun performMove_withValidOpeningMove_createsNewBoardWithPerformedMove() {
        //Arrange
        val boardFactory = StandardBoardFactory(StandardPieceFactory())
        val board = boardFactory.createBoard()
        val e4Opening = Move(board.positions[1][4], board.positions[3][4])

        //Act
        val newBoard = board.performMove(e4Opening)

        //Assert
        assertNotEquals(board, newBoard)
        assertTrue(newBoard.positions[1][4].isEmpty())
        assertFalse(newBoard.positions[3][4].isEmpty())
    }

    @Test(expected = InvalidMoveException::class)
    fun performMove_withInvalidMove_throwsIllegalMoveException() {
        //Arrange
        val boardFactory = StandardBoardFactory(StandardPieceFactory())
        val board = boardFactory.createBoard()
        val e1toe2Opening = Move(board.positions[0][4], board.positions[1][4])

        //Act
        board.performMove(e1toe2Opening)
    }
}
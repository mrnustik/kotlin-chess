package net.mrnustik.chess.rules

import net.mrnustik.chess.Color
import net.mrnustik.chess.moves.BasicMove
import net.mrnustik.chess.pieces.NullPiece
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class BishopMovementRuleTests : BaseRuleTests() {

    @Test
    fun getMoves_whenBlocked_noMovesReturned(){
        //Arrange
        val board = createEmptyBoard()
        board.addPiece(3,3,pieceFactory.createBishop(Color.WHITE))
        board.addPiece(2,2,pieceFactory.createPawn(Color.WHITE))
        board.addPiece(4,4,pieceFactory.createPawn(Color.WHITE))
        board.addPiece(4,2,pieceFactory.createPawn(Color.WHITE))
        board.addPiece(2,4,pieceFactory.createPawn(Color.WHITE))
        val rule = BishopMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[3][3])

        //Assert
        assertEquals(4, moves.size)
    }

    @Test
    fun getMoves_whenMovesAvailableInTopRightQuadrant_availableMovesReturned(){
        //Arrange
        val board = boardFactory.createBoard()
        board.positions[1][3].piece = NullPiece()
        val rule = BishopMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[0][2])

        //Assert
        assertEquals(6, moves.size)
    }

    @Test
    fun getMoves_whenMovesAvailableInAllQuadrants_availableMovesReturned(){
        //Arrange
        val board = createEmptyBoard()
        board.addPiece(4,4, pieceFactory.createBishop(Color.BLACK))
        val rule = BishopMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[4][4])

        //Assert
        assertEquals(13, moves.size)
    }

    @Test
    fun getMoves_whenEnemyCanBeTaken_attackMoveReturned(){
        //Arrange
        val board = createEmptyBoard()
        board.addPiece(3,3,pieceFactory.createBishop(Color.WHITE))
        board.addPiece(2,2,pieceFactory.createPawn(Color.WHITE))
        board.addPiece(4,4,pieceFactory.createPawn(Color.BLACK))
        board.addPiece(4,2,pieceFactory.createPawn(Color.WHITE))
        board.addPiece(2,4,pieceFactory.createPawn(Color.WHITE))
        val rule = BishopMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[3][3])

        //Assert
        assertEquals(4, moves.size)
        assertTrue(moves.contains(BasicMove(board.positions[3][3], board.positions[4][4])))
    }
}
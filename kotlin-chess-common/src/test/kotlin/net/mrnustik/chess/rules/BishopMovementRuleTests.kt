package net.mrnustik.chess.rules

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move
import net.mrnustik.chess.pieces.NullPiece
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class BishopMovementRuleTests : BaseRuleTests() {

    @Test
    fun getMoves_whenBlocked_noMovesReturned(){
        //Arrange
        val board = Board()
        board.positions[3][3].piece = pieceFactory.createBishop(Color.WHITE)
        board.positions[2][2].piece = pieceFactory.createPawn(Color.WHITE)
        board.positions[4][4].piece = pieceFactory.createPawn(Color.WHITE)
        board.positions[4][2].piece = pieceFactory.createPawn(Color.WHITE)
        board.positions[2][4].piece = pieceFactory.createPawn(Color.WHITE)
        val rule = BishopMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[3][3])

        //Assert
        assertEquals(0, moves.size)
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
        assertEquals(5, moves.size)
    }

    @Test
    fun getMoves_whenMovesAvailableInAllQuadrants_availableMovesReturned(){
        //Arrange
        val board = Board()
        board.positions[4][4].piece = pieceFactory.createBishop(Color.BLACK)
        val rule = BishopMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[4][4])

        //Assert
        assertEquals(13, moves.size)
    }

    @Test
    fun getMoves_whenEnemyCanBeTaken_attackMoveReturned(){
        //Arrange
        val board = Board()
        board.positions[3][3].piece = pieceFactory.createBishop(Color.WHITE)
        board.positions[2][2].piece = pieceFactory.createPawn(Color.WHITE)
        board.positions[4][4].piece = pieceFactory.createPawn(Color.BLACK)
        board.positions[4][2].piece = pieceFactory.createPawn(Color.WHITE)
        board.positions[2][4].piece = pieceFactory.createPawn(Color.WHITE)
        val rule = BishopMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[3][3])

        //Assert
        assertEquals(1, moves.size)
        assertTrue(moves.contains(Move(board.positions[3][3], board.positions[4][4])))
    }
}
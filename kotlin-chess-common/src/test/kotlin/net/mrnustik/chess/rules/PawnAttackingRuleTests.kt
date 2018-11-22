package net.mrnustik.chess.rules

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move
import net.mrnustik.chess.pieces.factory.StandardPieceFactory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PawnAttackingRuleTests {
    private val pieceFactory = StandardPieceFactory()

    @Test
    fun getMoves_whenCanAttackOnLeft_returnsValidLeftMove() {
        //Arrange
        val board = Board()
        board.positions[1][1].piece = pieceFactory.createPawn(Color.WHITE)
        board.positions[2][0].piece = pieceFactory.createBishop(Color.BLACK)
        val rule = PawnAttackingRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[1][1])

        //Assert
        assertEquals(1, moves.size)
        assertTrue(moves.contains(Move(board.positions[1][1], board.positions[2][0])))
    }

    @Test
    fun getMoves_whenCanAttackOnRight_returnsValidRightMove() {
        //Arrange
        val board = Board()
        board.positions[1][1].piece = pieceFactory.createPawn(Color.WHITE)
        board.positions[2][2].piece = pieceFactory.createBishop(Color.BLACK)
        val rule = PawnAttackingRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[1][1])

        //Assert
        assertEquals(1, moves.size)
        assertTrue(moves.contains(Move(board.positions[1][1], board.positions[2][2])))
    }

    @Test
    fun getMoves_whenNoPiecesCanBeAttacked_noMovesReturned() {
        //Arrange
        val board = Board()
        board.positions[1][1].piece = pieceFactory.createPawn(Color.WHITE)
        val rule = PawnAttackingRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[1][1])

        //Assert
        assertEquals(0, moves.size)
    }

    @Test
    fun getMoves_whenAttackingOwnPiece_noMovesReturned() {
        //Arrange
        val board = Board()
        board.positions[1][1].piece = pieceFactory.createPawn(Color.WHITE)
        board.positions[2][2].piece = pieceFactory.createBishop(Color.WHITE)
        val rule = PawnAttackingRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[1][1])

        //Assert
        assertEquals(0, moves.size)
    }
}
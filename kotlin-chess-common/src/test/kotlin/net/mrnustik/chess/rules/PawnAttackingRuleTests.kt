package net.mrnustik.chess.rules

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PawnAttackingRuleTests : BaseRuleTests() {

    @Test
    fun getMoves_whenCanAttackOnLeft_returnsValidLeftMove() {
        //Arrange
        val board = Board()
        board.addPiece(1,1,pieceFactory.createPawn(Color.WHITE))
        board.addPiece(2,0,pieceFactory.createBishop(Color.BLACK))
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
        board.addPiece(1,1, pieceFactory.createPawn(Color.WHITE))
        board.addPiece(2,2, pieceFactory.createBishop(Color.BLACK))
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
        board.addPiece(1,1, pieceFactory.createPawn(Color.WHITE))
        val rule = PawnAttackingRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[1][1])

        //Assert
        assertEquals(0, moves.size)
    }
}
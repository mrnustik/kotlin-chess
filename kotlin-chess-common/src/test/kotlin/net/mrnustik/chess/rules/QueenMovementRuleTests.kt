package net.mrnustik.chess.rules

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.Board
import org.junit.Assert.assertEquals
import org.junit.Test

class QueenMovementRuleTests : BaseRuleTests() {

    @Test
    fun getMoves_whenNotBlocked_returnsAllMoves() {
        //Arrange
        val board = Board()
        board.positions[4][4].piece = pieceFactory.createQueen(Color.BLACK)
        val rule = QueenMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[4][4])

        //Assert
        assertEquals(27, moves.size)
    }

    @Test
    fun getMoves_whenBlockedAtAllSides_returnsAllMoves() {
        //Arrange
        val board = Board()
        board.positions[4][4].piece = pieceFactory.createQueen(Color.BLACK)
        board.positions[5][4].piece = pieceFactory.createKing(Color.WHITE)
        board.positions[3][4].piece = pieceFactory.createKing(Color.WHITE)
        board.positions[5][5].piece = pieceFactory.createKing(Color.WHITE)
        board.positions[4][5].piece = pieceFactory.createKing(Color.WHITE)
        board.positions[3][5].piece = pieceFactory.createKing(Color.WHITE)
        board.positions[3][3].piece = pieceFactory.createKing(Color.WHITE)
        board.positions[5][3].piece = pieceFactory.createKing(Color.WHITE)
        board.positions[4][3].piece = pieceFactory.createKing(Color.WHITE)
        val rule = QueenMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[4][4])

        //Assert
        assertEquals(8, moves.size)
    }
}
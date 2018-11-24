package net.mrnustik.chess.rules

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.Board
import org.junit.Assert.assertEquals
import org.junit.Test

class RookMovementRuleTests : BaseRuleTests() {

    @Test
    fun getMoves_whenInTheMiddleOfBoard_returnsAllMoves() {
        //Arrange
        val board = Board()
        board.positions[4][4].piece = pieceFactory.createRook(Color.WHITE)
        val rule = RookMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[4][4])

        //Assert
        assertEquals(14, moves.size)
    }

    @Test
    fun getMoves_whenBlockedInCorner_returnsAllMoves() {
        //Arrange
        val board = Board()
        board.positions[0][0].piece = pieceFactory.createRook(Color.WHITE)
        board.positions[0][1].piece = pieceFactory.createRook(Color.WHITE)
        board.positions[1][0].piece = pieceFactory.createRook(Color.WHITE)
        val rule = RookMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[0][0])

        //Assert
        assertEquals(2, moves.size)
    }
}
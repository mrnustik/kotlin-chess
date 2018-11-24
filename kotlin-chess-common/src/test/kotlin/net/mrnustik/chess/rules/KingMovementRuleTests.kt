package net.mrnustik.chess.rules

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.Board
import org.junit.Assert.assertEquals
import org.junit.Test

class KingMovementRuleTests : BaseRuleTests() {

    @Test
    fun getMoves_whenNoMovesBlocked_returnsAll() {
        //Arrange
        val board = Board()
        board.addPiece(4,4,pieceFactory.createKing(Color.BLACK))
        val rule = KingMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[4][4])

        //Assert
        assertEquals(8, moves.size)
    }

    @Test
    fun getMoves_whenSomeMovesBlockedByCorner_returnsAll() {
        //Arrange
        val board = Board()
        board.addPiece(0,0, pieceFactory.createKing(Color.BLACK))
        val rule = KingMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[0][0])

        //Assert
        assertEquals(3, moves.size)
    }
}
package net.mrnustik.chess.rules

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.Board
import org.junit.Assert.assertEquals
import org.junit.Test

class KnightMovementRuleTests : BaseRuleTests() {

    @Test
    fun getMoves_whenAllMovesPossible_allReturned(){
        //Arrange
        val board = Board()
        board.positions[4][4].piece = pieceFactory.createKing(Color.WHITE)
        val rule = KnightMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[4][4])

        //Assert
        assertEquals(8, moves.size)
    }

    @Test
    fun getMoves_whenSomeMovesOutsideBounds_allReturned(){
        //Arrange
        val board = Board()
        board.positions[1][1].piece = pieceFactory.createKing(Color.WHITE)
        board.positions[2][3].piece = pieceFactory.createBishop(Color.WHITE)
        board.positions[3][2].piece = pieceFactory.createBishop(Color.BLACK)
        val rule = KnightMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[1][1])

        //Assert
        assertEquals(4, moves.size)
    }

}
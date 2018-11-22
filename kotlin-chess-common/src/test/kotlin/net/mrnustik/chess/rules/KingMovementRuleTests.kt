package net.mrnustik.chess.rules

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.Board
import org.junit.Assert.assertEquals
import org.junit.Test

class KingMovementRuleTests : BaseRuleTests() {

    @Test
    fun getMoves_whenAllMovesPossible_allReturned(){
        //Arrange
        val board = Board()
        board.positions[4][4].piece = pieceFactory.createKing(Color.WHITE)
        val rule = KingMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[4][4])

        //Assert
        assertEquals(8, moves.size)
    }

    @Test
    fun getMoves_whenSomeMovesBlocked_allReturned(){
        //Arrange
        val board = Board()
        board.positions[4][4].piece = pieceFactory.createKing(Color.WHITE)
        board.positions[6][5].piece = pieceFactory.createBishop(Color.WHITE)
        board.positions[3][6].piece = pieceFactory.createBishop(Color.BLACK)
        val rule = KingMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[4][4])

        //Assert
        assertEquals(7, moves.size)
    }

}
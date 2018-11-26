package net.mrnustik.chess.rules

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.board.StandardChessBoard
import org.junit.Assert.assertEquals
import org.junit.Test

class KnightMovementRuleTests : BaseRuleTests() {

    @Test
    fun getMoves_whenAllMovesPossible_allReturned(){
        //Arrange
        val board = createEmptyBoard()
        board.addPiece(4,4, pieceFactory.createKing(Color.WHITE))
        val rule = KnightMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[4][4])

        //Assert
        assertEquals(8, moves.size)
    }

    @Test
    fun getMoves_whenSomeMovesOutsideBounds_allReturned(){
        //Arrange
        val board = createEmptyBoard()
        board.addPiece(1,1, pieceFactory.createKing(Color.WHITE))
        board.addPiece(2,3, pieceFactory.createBishop(Color.WHITE))
        board.addPiece(3,2, pieceFactory.createBishop(Color.BLACK))
        val rule = KnightMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[1][1])

        //Assert
        assertEquals(4, moves.size)
    }

}
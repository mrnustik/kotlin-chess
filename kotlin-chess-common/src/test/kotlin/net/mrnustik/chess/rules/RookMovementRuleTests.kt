package net.mrnustik.chess.rules

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.Board
import org.junit.Assert.assertEquals
import org.junit.Test

class RookMovementRuleTests : BaseRuleTests() {

    @Test
    fun getMoves_whenInTheMiddleOfBoard_returnsAllMoves() {
        //Arrange
        val board = createEmptyBoard()
        board.addPiece(4,4, pieceFactory.createRook(Color.WHITE))
        val rule = RookMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[4][4])

        //Assert
        assertEquals(14, moves.size)
    }

    @Test
    fun getMoves_whenBlockedInCorner_returnsAllMoves() {
        //Arrange
        val board = createEmptyBoard()
        board.addPiece(0,0, pieceFactory.createRook(Color.WHITE))
        board.addPiece(0,1, pieceFactory.createRook(Color.WHITE))
        board.addPiece(1,0, pieceFactory.createRook(Color.WHITE))
        val rule = RookMovementRule()

        //Act
        val moves = rule.getValidMoves(board, board.positions[0][0])

        //Assert
        assertEquals(2, moves.size)
    }
}
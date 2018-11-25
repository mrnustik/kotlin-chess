package net.mrnustik.chess.rules

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PawnMovementRuleTests : BaseRuleTests() {
    @Test
    fun getValidMoves_onDefaultBoard_returnsAllValidMoves(){
        //Arrange
        val board = boardFactory.createBoard()
        val rule = PawnMovementRule()

        //Act
        val validMoves = rule.getValidMoves(board, board.positions[1][0])

        //Assert
        assertEquals(2, validMoves.size)
        assertTrue(validMoves.contains(Move(board.positions[1][0], board.positions[2][0])))
        assertTrue(validMoves.contains(Move(board.positions[1][0], board.positions[3][0])))
    }

    @Test
    fun getValidMoves_whenPawnBlocked_returnsNoMoves(){
        //Arrange
        val board = Board()
        board.addPiece(0,1, pieceFactory.createPawn(Color.WHITE))
        board.addPiece(0,2, pieceFactory.createPawn(Color.WHITE))
        val rule = PawnMovementRule()

        //Act
        val validMoves = rule.getValidMoves(board, board.positions[1][0])

        //Assert
        assertTrue(validMoves.isEmpty())
    }

    @Test
    fun getValidMoves_whenDoubleStepIsBlocked_returnsValidMoves(){
        //Arrange
        val board = Board()
        board.addPiece(0,1,pieceFactory.createPawn(Color.WHITE))
        board.addPiece(0,3,pieceFactory.createPawn(Color.WHITE))
        val rule = PawnMovementRule()

        //Act
        val validMoves = rule.getValidMoves(board, board.positions[1][0])

        //Assert
        assertEquals(1, validMoves.size)
        assertTrue(validMoves.contains(Move(board.positions[1][0], board.positions[2][0])))
    }
}
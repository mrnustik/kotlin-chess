package net.mrnustik.chess


import net.mrnustik.chess.pieces.Knight
import org.junit.Assert.*
import org.junit.Test

class PositionTests {

    @Test
    fun color_Of00_isBlack(){
        //Arrange
        val position = Position(0, 0)

        //Act
        val color = position.color

        //Assert
        assertEquals(Color.BLACK, color)
    }

    @Test
    fun color_Of01_isWhite(){
        //Arrange
        val position = Position(0, 1)

        //Act
        val color = position.color

        //Assert
        assertEquals(Color.WHITE, color)
    }

    @Test
    fun isEmpty_WhenNoPiecePresent_returnsTrue(){
        //Arrange
        val position = Position(0,0)

        //Act
        val result = position.isEmpty()

        //Assert
        assertTrue(result)
    }

    @Test
    fun isEmpty_WhenPiecePresent_returnsFalse(){
        //Arrange
        val position = Position(0,0)
        position.piece = Knight(Color.BLACK)

        //Act
        val result = position.isEmpty()

        //Assert
        assertFalse(result)
    }
}
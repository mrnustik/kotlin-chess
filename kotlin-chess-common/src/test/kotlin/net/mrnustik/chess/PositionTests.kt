package net.mrnustik.chess


import javafx.geometry.Pos
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

    @Test
    fun toString_of00_isa1() {
        //Arrange
        val position = Position(0, 0)

        //Act
        val stringRepresentation = position.toString()

        //Assert
        assertEquals("a1", stringRepresentation)
    }

    @Test
    fun toString_of74_ish5() {
        //Arrange
        val position = Position(7, 4)

        //Act
        val stringRepresentation = position.toString()

        //Assert
        assertEquals("h5", stringRepresentation)
    }
}
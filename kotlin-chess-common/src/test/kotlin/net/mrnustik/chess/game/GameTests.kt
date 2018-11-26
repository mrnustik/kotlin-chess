package net.mrnustik.chess.game

import assertk.assert
import assertk.assertions.*

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.factory.BoardFactory
import net.mrnustik.chess.board.factory.StandardBoardFactory
import net.mrnustik.chess.moves.BasicMove
import net.mrnustik.chess.pieces.*
import net.mrnustik.chess.pieces.factory.PieceFactory
import net.mrnustik.chess.pieces.factory.StandardPieceFactory
import net.mrnustik.chess.player.Player
import org.junit.Test

class GameTests {
    class TestingPlayer(color: Color) : Player(color) {
        override fun performMove(game: Game) {
            throw NotImplementedError()
        }
    }

    private val pieceFactory: PieceFactory = StandardPieceFactory()
    private val boardFactory: BoardFactory = StandardBoardFactory(pieceFactory)

    @Test
    fun performMove_validOpeningMove_boardChanged() {
        //Given
        val startingBoard = boardFactory.createBoard()
        val game = Game(startingBoard, TestingPlayer(Color.WHITE), TestingPlayer(Color.BLACK))
        val move = BasicMove(game.board.positions[1][4], game.board.positions[3][4])

        //When
        game.performMove(move)

        //Then
        assert(game.board).isNotEqualTo(startingBoard)
    }

    @Test
    fun performMove_validOpeningMove_moveAddedToHistory() {
        //Given
        val board = boardFactory.createBoard()
        val game = Game(board, TestingPlayer(Color.WHITE), TestingPlayer(Color.BLACK))
        val move = BasicMove(game.board.positions[1][4], game.board.positions[3][4])

        //When
        game.performMove(move)

        //Then
        assert(game.movesHistory).contains(move)
    }

    @Test
    fun performMove_validOpeningMove_activePlayerSwitches() {
        //Given
        val board = boardFactory.createBoard()
        val game = Game(board, TestingPlayer(Color.WHITE), TestingPlayer(Color.BLACK))
        val move = BasicMove(game.board.positions[1][4], game.board.positions[3][4])

        //When
        game.performMove(move)

        //Then
        assert(game.activePlayerColor).isEqualTo(Color.BLACK)
    }

    @Test
    fun activePlayer_whenBlackPlayerActive_returnsBlackPlayer() {
        //Given
        val board = boardFactory.createBoard()
        val whitePlayer = TestingPlayer(Color.WHITE)
        val blackPlayer = TestingPlayer(Color.BLACK)
        val game = Game(board, whitePlayer, blackPlayer)
        game.activePlayerColor = Color.BLACK

        //When
        val activePlayer = game.activePlayer

        //Then
        assert(activePlayer).isEqualTo(blackPlayer)
    }

    @Test
    fun activePlayer_whenWhitePlayerActive_returnsWhitePlayer() {
        //Given
        val board = boardFactory.createBoard()
        val whitePlayer = TestingPlayer(Color.WHITE)
        val blackPlayer = TestingPlayer(Color.BLACK)
        val game = Game(board, whitePlayer, blackPlayer)

        //When
        val activePlayer = game.activePlayer

        //Then
        assert(activePlayer).isEqualTo(whitePlayer)
    }

    @Test
    fun performMove_whenKingMoved_castlePossibilityChangeDetected() {
        //Given
        val board = boardFactory.createBoard()
        board.positions[1][4].piece = NullPiece();
        val whitePlayer = TestingPlayer(Color.WHITE)
        val blackPlayer = TestingPlayer(Color.BLACK)
        val game = Game(board, whitePlayer, blackPlayer)
        val move = BasicMove(game.board.positions[0][4], game.board.positions[1][4])

        //When
        game.performMove(move)

        //Then
        assert(game.castlePossibilitiesMap[Color.WHITE]!!.isAnyCastlePossible()).isFalse()
    }

    @Test
    fun performMove_whenQueenSideRookMoved_castlePossibilityChangeDetected() {
        //Given
        val board = boardFactory.createBoard()
        board.positions[1][0].piece = NullPiece();
        val whitePlayer = TestingPlayer(Color.WHITE)
        val blackPlayer = TestingPlayer(Color.BLACK)
        val game = Game(board, whitePlayer, blackPlayer)
        val move = BasicMove(game.board.positions[0][0], game.board.positions[1][0])

        //When
        game.performMove(move)

        //Then
        assert(game.castlePossibilitiesMap[Color.WHITE]!!.isAnyCastlePossible()).isTrue()
        assert(game.castlePossibilitiesMap[Color.WHITE]!!.isQueenCastlePossible).isFalse()
    }
}
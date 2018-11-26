package net.mrnustik.chess.rules

import net.mrnustik.chess.Position
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.BasicMove

class RookMovementRule : BaseRule() {

    override fun getValidMoves(board: Board, currentPosition: Position): Set<BasicMove> {
        val moves = mutableSetOf<BasicMove>()
        moves.addTopMoves(board, currentPosition)
        moves.addLeftMoves(board, currentPosition)
        moves.addBottomMoves(board, currentPosition)
        moves.addRightMoves(board, currentPosition)
        return moves
    }

    private fun MutableSet<BasicMove>.addRightMoves(board: Board, currentPosition: Position) {
        val changeX : (Int) -> Int = {x : Int -> x + 1}
        val changeY : (Int) -> Int = {y : Int -> y}
        this.addMovesUntilBlocked(board, currentPosition, changeX, changeY)
    }

    private fun MutableSet<BasicMove>.addBottomMoves(board: Board, currentPosition: Position) {
        val changeX : (Int) -> Int = {x : Int -> x}
        val changeY : (Int) -> Int = {y : Int -> y - 1}
        this.addMovesUntilBlocked(board, currentPosition, changeX, changeY)
    }

    private fun MutableSet<BasicMove>.addLeftMoves(board: Board, currentPosition: Position) {
        val changeX : (Int) -> Int = {x : Int -> x - 1}
        val changeY : (Int) -> Int = {y : Int -> y}
        this.addMovesUntilBlocked(board, currentPosition, changeX, changeY)
    }

    private fun MutableSet<BasicMove>.addTopMoves(board: Board, currentPosition: Position) {
        val changeX : (Int) -> Int = {x : Int -> x}
        val changeY : (Int) -> Int = {y : Int -> y + 1}
        this.addMovesUntilBlocked(board, currentPosition, changeX, changeY)
    }
}
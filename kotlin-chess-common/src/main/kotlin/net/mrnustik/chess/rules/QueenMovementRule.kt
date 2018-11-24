package net.mrnustik.chess.rules

import net.mrnustik.chess.Position
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move

class QueenMovementRule : BaseRule() {
    override fun getValidMoves(board: Board, currentPosition: Position): Set<Move> {
        val moves = mutableSetOf<Move>()
        moves.addTopLeftQuadrantMoves(board, currentPosition)
        moves.addTopRightQuadrantMoves(board, currentPosition)
        moves.addBottomLeftQuadrantMoves(board, currentPosition)
        moves.addBottomRightQuadrantMoves(board, currentPosition)
        moves.addTopMoves(board, currentPosition)
        moves.addLeftMoves(board, currentPosition)
        moves.addBottomMoves(board, currentPosition)
        moves.addRightMoves(board, currentPosition)
        return moves
    }

    private fun MutableSet<Move>.addRightMoves(board: Board, currentPosition: Position) {
        val changeX : (Int) -> Int = {x : Int -> x + 1}
        val changeY : (Int) -> Int = {y : Int -> y}
        this.addMovesUntilBlocked(board, currentPosition, changeX, changeY)
    }

    private fun MutableSet<Move>.addBottomMoves(board: Board, currentPosition: Position) {
        val changeX : (Int) -> Int = {x : Int -> x}
        val changeY : (Int) -> Int = {y : Int -> y - 1}
        this.addMovesUntilBlocked(board, currentPosition, changeX, changeY)
    }

    private fun MutableSet<Move>.addLeftMoves(board: Board, currentPosition: Position) {
        val changeX : (Int) -> Int = {x : Int -> x - 1}
        val changeY : (Int) -> Int = {y : Int -> y}
        this.addMovesUntilBlocked(board, currentPosition, changeX, changeY)
    }

    private fun MutableSet<Move>.addTopMoves(board: Board, currentPosition: Position) {
        val changeX : (Int) -> Int = {x : Int -> x}
        val changeY : (Int) -> Int = {y : Int -> y + 1}
        this.addMovesUntilBlocked(board, currentPosition, changeX, changeY)
    }

    private fun MutableSet<Move>.addBottomRightQuadrantMoves(board: Board, currentPosition: Position) {
        val changeX : (Int) -> Int = {x : Int -> x + 1}
        val changeY : (Int) -> Int = {y : Int -> y - 1}
        this.addMovesUntilBlocked(board, currentPosition, changeX, changeY)
    }

    private fun MutableSet<Move>.addBottomLeftQuadrantMoves(board: Board, currentPosition: Position) {
        val changeX : (Int) -> Int = {x : Int -> x - 1}
        val changeY : (Int) -> Int = {y : Int -> y - 1}
        this.addMovesUntilBlocked(board, currentPosition, changeX, changeY)
    }

    private fun MutableSet<Move>.addTopRightQuadrantMoves(board: Board, currentPosition: Position) {
        val changeX : (Int) -> Int = {x : Int -> x + 1}
        val changeY : (Int) -> Int = {y : Int -> y + 1}
        this.addMovesUntilBlocked(board, currentPosition, changeX, changeY)
    }

    private fun MutableSet<Move>.addTopLeftQuadrantMoves(board: Board, currentPosition: Position) {
        val changeX : (Int) -> Int = {x : Int -> x - 1}
        val changeY : (Int) -> Int = {y : Int -> y + 1}
        this.addMovesUntilBlocked(board, currentPosition, changeX, changeY)
    }
}



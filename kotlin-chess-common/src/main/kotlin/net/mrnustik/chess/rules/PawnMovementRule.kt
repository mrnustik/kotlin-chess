package net.mrnustik.chess.rules

import net.mrnustik.chess.Color
import net.mrnustik.chess.Position
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move

class PawnMovementRule : BaseRule() {
    override fun getValidMoves(board: Board, currentPosition: Position): Set<Move> {
        val moves = mutableListOf<Move>()
        moves.addForwardMoveIfPossible(board, currentPosition)
        moves.addDoubleForwardMoveIfPossible(board, currentPosition);
        return moves.toSet()
    }

    private fun MutableList<Move>.addForwardMoveIfPossible(board: Board, currentPosition: Position) {
        val x = currentPosition.x
        val y = addToForwardDirectionOfPiece(currentPosition, 1)
        if (isPositionAvailable(board, x, y)) {
            this.add(Move(currentPosition, board.positions[y][x]))
        }
    }

    private fun MutableList<Move>.addDoubleForwardMoveIfPossible(board: Board, currentPosition: Position) {
        val x = currentPosition.x
        var y = addToForwardDirectionOfPiece(currentPosition, 1)
        if (isPositionAvailable(board, x, y)) {
            if (currentPosition.y == 1 && currentPosition.piece.color == Color.WHITE) {
                y++
                if (isPositionAvailable(board, x, y)) {
                    this.add(Move(currentPosition, board.positions[y][x]))
                }
            } else if (currentPosition.y == 6 && currentPosition.piece.color == Color.BLACK) {
                y--
                if (isPositionAvailable(board, x, y)) {
                    this.add(Move(currentPosition, board.positions[y][x]))
                }
            }
        }
    }

    private fun isPositionAvailable(board: Board, x: Int, y: Int): Boolean {

        return isWithinBounds(x, y) && board.positions[y][x].isEmpty()
    }
}


package net.mrnustik.chess.board

import net.mrnustik.chess.Color
import net.mrnustik.chess.Position
import net.mrnustik.chess.exceptions.InvalidMoveException
import net.mrnustik.chess.moves.Move
import net.mrnustik.chess.moves.validator.MoveValidator
import net.mrnustik.chess.moves.validator.StandardChessMoveValidator
import net.mrnustik.chess.pieces.NullPiece
import net.mrnustik.chess.pieces.Piece
import java.util.*

class StandardChessBoard(override val positions: Array<Array<Position>> = initializeEmptyPositions()) : Board {
    override fun isPositionUnderAttack(x: Int, y: Int, playerColor: Color): Boolean {
        return getAllPlayerMoves(playerColor)
                .any { it.to.x == x && it.to.y == y }
    }

    private val moveValidator: MoveValidator = StandardChessMoveValidator()

    override fun addPiece(x: Int, y: Int, piece: Piece) {
        if (!isWithinBounds(x, y)) {
            throw IllegalArgumentException("Position($x,$y) is outside of board bounds.")
        }
        positions[y][x].piece = piece
    }

    override fun getAllPiecePositions(): Set<Position> {
        val piecePositions = mutableSetOf<Position>()
        for (line in positions) {
            for (position in line) {
                if (!position.isEmpty()) {
                    piecePositions.add(position)
                }
            }
        }
        return piecePositions
    }

    override fun getAllPlayerPiecePositions(playerColor: Color): Set<Position> {
        val piecePositions = mutableSetOf<Position>()
        for (line in positions) {
            for (position in line) {
                if (!position.isEmpty() && position.piece.color == playerColor) {
                    piecePositions.add(position)
                }
            }
        }
        return piecePositions
    }

    override fun getAllValidMoves(playerColor: Color): Set<Move> {
        val moves = getAllPlayerMoves(playerColor)
        return moves.filter { m -> moveValidator.isMoveValid(this, m) }.toSet()
    }

    private fun getAllPlayerMoves(playerColor: Color): MutableSet<Move> {
        val piecePositions = getAllPlayerPiecePositions(playerColor)
        val moves = mutableSetOf<Move>()
        for (position in piecePositions) {
            val piece = position.piece
            for (rule in piece.getAppliedRules()) {
                moves.addAll(rule.getValidMoves(this, position))
            }
        }
        return moves
    }

    override fun performMove(move: Move): Board {
        if (!moveValidator.isMoveValid(this, move))
            throw InvalidMoveException("Move $move is not valid on this board.")
        val board: Board = this.clone()
        board.positions[move.from.y][move.from.x].piece = NullPiece()
        board.positions[move.to.y][move.to.x].piece = move.usedPiece
        return board
    }

    override fun clone(): Board {
        return StandardChessBoard(positions.clone())
    }

    private fun isWithinBounds(x: Int, y: Int): Boolean {
        return x in (0..7) && y in (0..7)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StandardChessBoard) return false

        if (!positions.contentDeepEquals(other.positions)) return false

        return true
    }

    override fun hashCode(): Int {
        return Arrays.hashCode(positions)
    }

    companion object {
        private fun initializeEmptyPositions(): Array<Array<Position>> {
            return arrayOf(
                    arrayOf(
                            Position(0, 0),
                            Position(1, 0),
                            Position(2, 0),
                            Position(3, 0),
                            Position(4, 0),
                            Position(5, 0),
                            Position(6, 0),
                            Position(7, 0)
                    ),
                    arrayOf(
                            Position(0, 1),
                            Position(1, 1),
                            Position(2, 1),
                            Position(3, 1),
                            Position(4, 1),
                            Position(5, 1),
                            Position(6, 1),
                            Position(7, 1)
                    ),
                    arrayOf(
                            Position(0, 2),
                            Position(1, 2),
                            Position(2, 2),
                            Position(3, 2),
                            Position(4, 2),
                            Position(5, 2),
                            Position(6, 2),
                            Position(7, 2)
                    ),
                    arrayOf(
                            Position(0, 3),
                            Position(1, 3),
                            Position(2, 3),
                            Position(3, 3),
                            Position(4, 3),
                            Position(5, 3),
                            Position(6, 3),
                            Position(7, 3)
                    ),
                    arrayOf(
                            Position(0, 4),
                            Position(1, 4),
                            Position(2, 4),
                            Position(3, 4),
                            Position(4, 4),
                            Position(5, 4),
                            Position(6, 4),
                            Position(7, 4)
                    ),
                    arrayOf(
                            Position(0, 5),
                            Position(1, 5),
                            Position(2, 5),
                            Position(3, 5),
                            Position(4, 5),
                            Position(5, 5),
                            Position(6, 5),
                            Position(7, 5)
                    ),
                    arrayOf(
                            Position(0, 6),
                            Position(1, 6),
                            Position(2, 6),
                            Position(3, 6),
                            Position(4, 6),
                            Position(5, 6),
                            Position(6, 6),
                            Position(7, 6)
                    ),
                    arrayOf(
                            Position(0, 7),
                            Position(1, 7),
                            Position(2, 7),
                            Position(3, 7),
                            Position(4, 7),
                            Position(5, 7),
                            Position(6, 7),
                            Position(7, 7)
                    )
            )
        }
    }
}

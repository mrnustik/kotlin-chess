package net.mrnustik.chess.board

import net.mrnustik.chess.Color
import net.mrnustik.chess.Position
import net.mrnustik.chess.moves.Move
import net.mrnustik.chess.moves.validator.MoveValidator
import net.mrnustik.chess.moves.validator.StandardChessMoveValidator
import net.mrnustik.chess.pieces.Piece

class Board {
    val positions: Array<Array<Position>> = initializeEmptyPositions()

    val moveValidator: MoveValidator = StandardChessMoveValidator()

    fun addPiece(x: Int, y: Int, piece: Piece) {
        if(!isWithinBounds(x, y)) {
            throw IllegalArgumentException("Position($x,$y) is outside of board bounds.")
        }
        positions[y][x].piece = piece
    }

    fun getAllPiecePositions() : Set<Position> {
        val piecePositions = mutableSetOf<Position>()
        for (line in positions) {
            for (position in line) {
                if(!position.isEmpty()){
                    piecePositions.add(position)
                }
            }
        }
        return piecePositions
    }

    fun getAllPlayerPiecePositions(playerColor: Color) : Set<Position> {
        val piecePositions = mutableSetOf<Position>()
        for (line in positions) {
            for (position in line) {
                if(!position.isEmpty() && position.piece.color == playerColor){
                    piecePositions.add(position)
                }
            }
        }
        return piecePositions
    }

    fun getAllValidMoves(playerColor: Color) : Set<Move> {
        val piecePositions = getAllPlayerPiecePositions(playerColor)
        val moves = mutableSetOf<Move>()
        for (position in piecePositions) {
            val piece = position.piece
            for (rule in piece.getAppliedRules()) {
                moves.addAll(rule.getValidMoves(this, position))
            }
        }
        return moves.filter { m -> moveValidator.isMoveValid(this, m) }.toSet()
    }

    private fun isWithinBounds(x: Int, y: Int): Boolean {
        return x in (0..7) && y in (0..7)
    }

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

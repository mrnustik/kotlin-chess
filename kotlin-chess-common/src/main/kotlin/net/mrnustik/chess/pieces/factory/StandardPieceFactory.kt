package net.mrnustik.chess.pieces.factory

import net.mrnustik.chess.Color
import net.mrnustik.chess.pieces.*

class StandardPieceFactory : PieceFactory {
    override fun createKnight(color: Color): Piece {
        return Knight(color)
    }

    override fun createPawn(color: Color): Piece {
        return Pawn(color)
    }

    override fun createKing(color: Color): Piece {
        return King(color)
    }

    override fun createQueen(color: Color): Piece {
        return Queen(color)
    }

    override fun createBishop(color: Color): Piece {
        return Bishop(color)
    }

    override fun createRook(color: Color): Piece {
        return Rook(color)
    }
}
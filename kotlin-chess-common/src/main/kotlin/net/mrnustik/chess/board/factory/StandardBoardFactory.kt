package net.mrnustik.chess.board.factory

import net.mrnustik.chess.Color
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.pieces.factory.PieceFactory

class StandardBoardFactory(val pieceFactory: PieceFactory) : BoardFactory {
    override fun createBoard(): Board {
        val board = Board()
        createWhitePieces(board)
        createBlackPieces(board)
        return board
    }

    private fun createBlackPieces(board: Board) {
        board.positions[7][0].piece = pieceFactory.createRook(Color.WHITE)
        board.positions[7][1].piece = pieceFactory.createKnight(Color.WHITE)
        board.positions[7][2].piece = pieceFactory.createBishop(Color.WHITE)
        board.positions[7][3].piece = pieceFactory.createQueen(Color.WHITE)
        board.positions[7][4].piece = pieceFactory.createKing(Color.WHITE)
        board.positions[7][5].piece = pieceFactory.createBishop(Color.WHITE)
        board.positions[7][6].piece = pieceFactory.createKnight(Color.WHITE)
        board.positions[7][7].piece = pieceFactory.createRook(Color.WHITE)
        for(i in (0..7)){
            board.positions[6][i].piece = pieceFactory.createPawn(Color.WHITE)
        }
    }

    private fun createWhitePieces(board: Board) {
        board.positions[0][0].piece = pieceFactory.createRook(Color.WHITE)
        board.positions[0][1].piece = pieceFactory.createKnight(Color.WHITE)
        board.positions[0][2].piece = pieceFactory.createBishop(Color.WHITE)
        board.positions[0][3].piece = pieceFactory.createQueen(Color.WHITE)
        board.positions[0][4].piece = pieceFactory.createKing(Color.WHITE)
        board.positions[0][5].piece = pieceFactory.createBishop(Color.WHITE)
        board.positions[0][6].piece = pieceFactory.createKnight(Color.WHITE)
        board.positions[0][7].piece = pieceFactory.createRook(Color.WHITE)
        for(i in (0..7)){
            board.positions[1][i].piece = pieceFactory.createPawn(Color.WHITE)
        }
    }
}
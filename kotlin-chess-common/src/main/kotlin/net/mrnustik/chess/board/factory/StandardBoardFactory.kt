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
        board.addPiece(0,7,pieceFactory.createRook(Color.WHITE));
        board.addPiece(1,7,pieceFactory.createKnight(Color.WHITE))
        board.addPiece(2,7,pieceFactory.createBishop(Color.WHITE))
        board.addPiece(3,7,pieceFactory.createQueen(Color.WHITE))
        board.addPiece(4,7,pieceFactory.createKing(Color.WHITE))
        board.addPiece(5,7,pieceFactory.createBishop(Color.WHITE))
        board.addPiece(6,7,pieceFactory.createKnight(Color.WHITE))
        board.addPiece(7,7,pieceFactory.createRook(Color.WHITE))
        for(i in (0..7)){
            board.addPiece(i,6,pieceFactory.createPawn(Color.WHITE))
        }
    }

    private fun createWhitePieces(board: Board) {
        board.addPiece(0,0,pieceFactory.createRook(Color.WHITE))
        board.addPiece(1,0,pieceFactory.createKnight(Color.WHITE))
        board.addPiece(2,0,pieceFactory.createBishop(Color.WHITE))
        board.addPiece(3,0,pieceFactory.createQueen(Color.WHITE))
        board.addPiece(4,0,pieceFactory.createKing(Color.WHITE))
        board.addPiece(5,0,pieceFactory.createBishop(Color.WHITE))
        board.addPiece(6,0,pieceFactory.createKnight(Color.WHITE))
        board.addPiece(7,0,pieceFactory.createRook(Color.WHITE))
        for(i in (0..7)){
            board.addPiece(i,1,pieceFactory.createPawn(Color.WHITE))
        }
    }
}
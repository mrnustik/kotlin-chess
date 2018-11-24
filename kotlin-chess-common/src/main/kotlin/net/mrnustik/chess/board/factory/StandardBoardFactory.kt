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
        board.addPiece(7,0,pieceFactory.createRook(Color.WHITE));
        board.addPiece(7,1,pieceFactory.createKnight(Color.WHITE))
        board.addPiece(7,2,pieceFactory.createBishop(Color.WHITE))
        board.addPiece(7,3,pieceFactory.createQueen(Color.WHITE))
        board.addPiece(7,4,pieceFactory.createKing(Color.WHITE))
        board.addPiece(7,5,pieceFactory.createBishop(Color.WHITE))
        board.addPiece(7,6,pieceFactory.createKnight(Color.WHITE))
        board.addPiece(7,7,pieceFactory.createRook(Color.WHITE))
        for(i in (0..7)){
            board.addPiece(6,i,pieceFactory.createPawn(Color.WHITE))
        }
    }

    private fun createWhitePieces(board: Board) {
        board.addPiece(0,0,pieceFactory.createRook(Color.WHITE))
        board.addPiece(0,1,pieceFactory.createKnight(Color.WHITE))
        board.addPiece(0,2,pieceFactory.createBishop(Color.WHITE))
        board.addPiece(0,3,pieceFactory.createQueen(Color.WHITE))
        board.addPiece(0,4,pieceFactory.createKing(Color.WHITE))
        board.addPiece(0,5,pieceFactory.createBishop(Color.WHITE))
        board.addPiece(0,6,pieceFactory.createKnight(Color.WHITE))
        board.addPiece(0,7,pieceFactory.createRook(Color.WHITE))
        for(i in (0..7)){
            board.addPiece(1,i,pieceFactory.createPawn(Color.WHITE))
        }
    }
}
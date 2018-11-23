package net.mrnustik.chess.rules

import net.mrnustik.chess.Position
import net.mrnustik.chess.board.Board
import net.mrnustik.chess.moves.Move

class PawnAttackingRule : BaseRule(){
    override fun getValidMoves(board: Board, currentPosition: Position): Set<Move> {
        val moves = mutableSetOf<Move>()
        moves.addAttackableMovesIfPossible(board, currentPosition)
        return moves
    }

    private fun MutableSet<Move>.addAttackableMovesIfPossible(board: Board, currentPosition: Position) {
        val rightAttackX = currentPosition.x + 1
        val rightAttackY = addToForwardDirectionOfPiece(currentPosition, 1)
        if(isWithinBounds(rightAttackX, rightAttackY) && !board.positions[rightAttackY][rightAttackX].isEmpty()){
            this.add(Move(currentPosition, board.positions[rightAttackY][rightAttackX]))
        }
        val leftAttackX = currentPosition.x - 1
        val leftAttackY = addToForwardDirectionOfPiece(currentPosition, 1)
        if(isWithinBounds(rightAttackX, rightAttackY) && !board.positions[leftAttackY][leftAttackX].isEmpty()){
            this.add(Move(currentPosition, board.positions[leftAttackY][leftAttackX]))
        }
    }
}


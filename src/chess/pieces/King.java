package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color); 
	}

	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		return ((getBoard().positionExists(position)) &&
			   ((!getBoard().thereIsAPiece(position)) || (isThereOpponentPiece(position)))); 
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		// Above
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		for (int i = 0; i < 3; i++) {
			if (canMove(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}			
			
			p.setColumn(p.getColumn() + 1);
		}
		
		// Inside
		p.setValues(position.getRow(), position.getColumn() - 1);
		for (int i = 0; i < 3; i++) {
			if (canMove(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setColumn(p.getColumn() + 1);			
		}
		
		// Below
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		for (int i = 0; i < 3; i++) {
			if (canMove(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}			
			
			p.setColumn(p.getColumn() + 1);			
		}
		
		return mat;
	}
}

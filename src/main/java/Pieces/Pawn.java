package Pieces;

import chessgui.chessBoard;

public class Pawn extends Pieces {
    private boolean has_moved;
    public Pawn(int x, int y, boolean isWhite, String file_path, chessBoard board){
        super(x,y,isWhite,file_path, board);
        has_moved = false;
    }
    public void setHasMoved(boolean has_moved){
        this.has_moved = has_moved;
    }
    public boolean getHasMoved(){
        return has_moved;
    }
    public boolean canMove(int destination_x, int destination_y){  
        return true;
    }
}

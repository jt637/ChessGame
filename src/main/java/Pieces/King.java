package Pieces;

import Pieces.Pieces;
import chessgui.chessBoard;

public class King extends Pieces {
    public King(int x, int y, boolean isWhite, String file_path, chessBoard board){
        super(x,y,isWhite,file_path, board);
    }
    public boolean canMove(int destination_x, int destination_y){   
        return true;
    }
}

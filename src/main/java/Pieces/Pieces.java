package Pieces;
import chessgui.chessBoard;
public class Pieces {
    private int x;
    private int y;
    final private boolean is_white;
    private String file_path;
    public chessBoard board;
    
    public Pieces(int x, int y, boolean isWhite, String file_path, chessBoard board){
        this.is_white = isWhite;
        this.x = x;
        this.y = y;
        this.file_path = file_path;
        this.board = board;
    }
    public String getFilePath(){
        return file_path;
    }
    public void setFilePath(String path){
        this.file_path = path;
    }
    public boolean isWhite(){
        return is_white;
    }
    public boolean isBlack(){
        return !is_white;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public boolean canMove(int destination_x, int destination_y){
        return false;
    }
}

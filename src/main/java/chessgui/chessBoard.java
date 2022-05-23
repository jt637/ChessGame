package chessgui;
import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Pieces;
import Pieces.Queen;
import Pieces.Rook;
import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class chessBoard extends JComponent {
    private final int Square_Width = 65;    
    public int turn = 0;
    private static Image NULL_IMAGE = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
    public ArrayList<DrawingShape> Static_Shapes;
    public ArrayList<DrawingShape> Graphics;
    public ArrayList<Pieces> whitePieces;
    public ArrayList<Pieces> blackPieces;
    public Pieces currentPiece;
    private final int rows = 8;
    private final int cols = 8;
    private Integer[][] BoardLayout;
    private String boardPath = "images" + File.separator + "board.png";
    
    public chessBoard() {
        BoardLayout = new Integer[rows][cols];
        Static_Shapes = new ArrayList();
        Graphics = new ArrayList();
        whitePieces = new ArrayList();
        blackPieces = new ArrayList();
        Grid();
        this.setBackground(new Color(37,13,84));
        this.setPreferredSize(new Dimension(520, 520));
        this.setMinimumSize(new Dimension(100, 100));
        this.setMaximumSize(new Dimension(1000, 1000));
        this.addMouseListener(mouseAdapter);
        this.setVisible(true);
        this.requestFocus();
        drawBoard();
    }
    private void drawBoard(){
        Graphics.clear();
        Static_Shapes.clear();
        Image board = loadImage(boardPath);
        Static_Shapes.add(new DrawingImage(board, new Rectangle2D.Double(0, 0, board.getWidth(null), board.getHeight(null))));
        
        for (int i = 0; i < whitePieces.size(); i++){
            int column = whitePieces.get(i).getX();
            int row = whitePieces.get(i).getY();
            Image piece = loadImage("images" + File.separator + "whitePieces" + File.separator + whitePieces.get(i).getFilePath());  
            Graphics.add(new DrawingImage(piece, new Rectangle2D.Double(Square_Width*column,Square_Width*row, piece.getWidth(null), piece.getHeight(null))));
        }
        for (int i = 0; i < blackPieces.size(); i++){
            int COL = blackPieces.get(i).getX();
            int ROW = blackPieces.get(i).getY();
            Image piece = loadImage("images" + File.separator + "blackPieces" + File.separator + blackPieces.get(i).getFilePath());  
            Graphics.add(new DrawingImage(piece, new Rectangle2D.Double(Square_Width*COL,Square_Width*ROW, piece.getWidth(null), piece.getHeight(null))));
        }
        this.repaint();
    }
    public void Grid(){
        for (int x = 0; x < rows; x++){
            for (int y = 0; y < cols; y++){
                BoardLayout[x][y] = 0;
            }
        }
        whitePieces.add(new King(3,0,true,"King.png",this));
        whitePieces.add(new Queen(4,0,true,"Queen.png",this));
        whitePieces.add(new Bishop(2,0,true,"Bishop.png",this));
        whitePieces.add(new Bishop(5,0,true,"Bishop.png",this));
        whitePieces.add(new Knight(1,0,true,"Knight.png",this));
        whitePieces.add(new Knight(6,0,true,"Knight.png",this));
        whitePieces.add(new Rook(0,0,true,"Rook.png",this));
        whitePieces.add(new Rook(7,0,true,"Rook.png",this));
        whitePieces.add(new Pawn(0,1,true,"Pawn.png",this));
        whitePieces.add(new Pawn(1,1,true,"Pawn.png",this));
        whitePieces.add(new Pawn(2,1,true,"Pawn.png",this));
        whitePieces.add(new Pawn(3,1,true,"Pawn.png",this));
        whitePieces.add(new Pawn(4,1,true,"Pawn.png",this));
        whitePieces.add(new Pawn(5,1,true,"Pawn.png",this));
        whitePieces.add(new Pawn(6,1,true,"Pawn.png",this));
        whitePieces.add(new Pawn(7,1,true,"Pawn.png",this));

        blackPieces.add(new King(3,7,false,"King.png",this));
        blackPieces.add(new Queen(4,7,false,"Queen.png",this));
        blackPieces.add(new Bishop(2,7,false,"Bishop.png",this));
        blackPieces.add(new Bishop(5,7,false,"Bishop.png",this));
        blackPieces.add(new Knight(1,7,false,"Knight.png",this));
        blackPieces.add(new Knight(6,7,false,"Knight.png",this));
        blackPieces.add(new Rook(0,7,false,"Rook.png",this));
        blackPieces.add(new Rook(7,7,false,"Rook.png",this));
        blackPieces.add(new Pawn(0,6,false,"Pawn.png",this));
        blackPieces.add(new Pawn(1,6,false,"Pawn.png",this));
        blackPieces.add(new Pawn(2,6,false,"Pawn.png",this));
        blackPieces.add(new Pawn(3,6,false,"Pawn.png",this));
        blackPieces.add(new Pawn(4,6,false,"Pawn.png",this));
        blackPieces.add(new Pawn(5,6,false,"Pawn.png",this));
        blackPieces.add(new Pawn(6,6,false,"Pawn.png",this));
        blackPieces.add(new Pawn(7,6,false,"Pawn.png",this));

    }
    public Pieces getPiece(int x, int y) {
        for (Pieces p : whitePieces){
            if (p.getX() == x && p.getY() == y){
                return p;
            }
        }
        for (Pieces p : blackPieces){
            if (p.getX() == x && p.getY() == y){
                return p;
            }
        }
        return null;
    }
    private MouseAdapter mouseAdapter = new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {    
        }

        @Override
        public void mousePressed(MouseEvent e) {
            int d_X = e.getX();
            int d_Y = e.getY();  
            int clickedRow = d_Y / Square_Width;
            int clickedColumn = d_X / Square_Width;
            boolean is_whites_turn = true;
            if (turn%2 == 1){
                is_whites_turn = false;
            }
            
            Pieces selectedPiece = getPiece(clickedColumn, clickedRow);
            
            if (currentPiece == null && selectedPiece != null && 
                    ((is_whites_turn && selectedPiece.isWhite()) || (!is_whites_turn && selectedPiece.isBlack()))){
                currentPiece = selectedPiece;
            }
            else if (currentPiece != null && currentPiece.getX() == clickedColumn && currentPiece.getY() == clickedRow){
                currentPiece = null;
            }
            else if (currentPiece != null && currentPiece.canMove(clickedColumn, clickedRow) && ((is_whites_turn && currentPiece.isWhite()) || (!is_whites_turn && currentPiece.isBlack()))){
                if (selectedPiece != null){
                    if (selectedPiece.isWhite()){
                        whitePieces.remove(selectedPiece);
                    }
                    else{
                        blackPieces.remove(selectedPiece);
                    }
                }
                currentPiece.setX(clickedColumn);
                currentPiece.setY(clickedRow);
                if (currentPiece.getClass().equals(Pawn.class)){
                    Pawn castedPawn = (Pawn)(currentPiece);
                    castedPawn.setHasMoved(true);
                }
                currentPiece = null;
                turn++;
            }
            
            drawBoard();
        }
        @Override
        public void mouseDragged(MouseEvent e) {		
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
        }	
    };
    private void adjustShapePositions(double dx, double dy) {

        Static_Shapes.get(0).adjustPosition(dx, dy);
        this.repaint();
    }  
    private Image loadImage(String imageFile) {
        try {
                return ImageIO.read(new File(imageFile));
        }
        catch (IOException e) {
                return NULL_IMAGE;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        drawBackground(g2);
        drawShapes(g2);
    }

    private void drawBackground(Graphics2D g2) {
        g2.setColor(getBackground());
        g2.fillRect(0,  0, getWidth(), getHeight());
    }
       

    private void drawShapes(Graphics2D g2) {
        for (DrawingShape shape : Static_Shapes) {
            shape.draw(g2);
        }	
        for (DrawingShape shape : Graphics) {
            shape.draw(g2);
        }

}



interface DrawingShape {
    boolean contains(Graphics2D g2, double x, double y);
    void adjustPosition(double dx, double dy);
    void draw(Graphics2D g2);
}


class DrawingImage implements DrawingShape {

    public Image image;
    public Rectangle2D rect;

    public DrawingImage(Image image, Rectangle2D rect) {
            this.image = image;
            this.rect = rect;
    }

    @Override
    public boolean contains(Graphics2D g2, double x, double y) {
            return rect.contains(x, y);
    }

    @Override
    public void adjustPosition(double dx, double dy) {
            rect.setRect(rect.getX() + dx, rect.getY() + dy, rect.getWidth(), rect.getHeight());	
    }

    @Override
    public void draw(Graphics2D g2) {
            Rectangle2D bounds = rect.getBounds2D();
            g2.drawImage(image, (int)bounds.getMinX(), (int)bounds.getMinY(), (int)bounds.getMaxX(), (int)bounds.getMaxY(),
                                            0, 0, image.getWidth(null), image.getHeight(null), null);
    }	
}
}
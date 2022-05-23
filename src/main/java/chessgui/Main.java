package chessgui;
public class Main {
    public GUIFrame boardframe;
    
    public static void main(String[] args) {
        Main gui = new Main();
        gui.boardframe = new GUIFrame();
        gui.boardframe.setVisible(true); 
    }
}

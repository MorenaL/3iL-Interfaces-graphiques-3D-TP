package projet;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

public class Maiin {

    //Constants
    public static final int FRAME_WIDTH = 1168;
    public static final int FRAME_HEIGHT = 800;
    public static final int MENU_HEIGHT = 500;
    public static final int MENU_WIDTH = 200;

    //Attributes
    private JFrame frame; // La fenêtre
    private JMenuBar menuBar; // Menu en haut horizontal
    private JMenuItem close, help;

    //Constructor
    public Maiin() {
       createView();
    }

    // COMMANDS
    public void display() {
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createView() {
        frame = new JFrame("Application_Morena");
        frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        close = new JMenuItem("Fermer", new ImageIcon("images/fermer.jpg"));
        help = new JMenuItem("Aide", new ImageIcon("images/aide.jpg"));
       
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Maiin().display();
            }
        });
    }
}

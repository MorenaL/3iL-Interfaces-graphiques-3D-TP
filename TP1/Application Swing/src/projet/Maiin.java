package projet;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import projet.Main.Carrefour;
import projet.Main.Route;

import java.awt.BorderLayout;
import java.awt.Image;

public class Maiin {

    //Constants
    public static final int FRAME_WIDTH = 1168;
    public static final int FRAME_HEIGHT = 800;
    public static final int MENU_HEIGHT = 500;
    public static final int MENU_WIDTH = 200;

    //Attributes
    private JFrame frame; 
    private JMenuBar menuBar; 
    private JMenuItem close, help;
    private JButton reconstruire;
    private Image imgFond;
    private Graph<Carrefour, Route> g; 
    private Layout<Carrefour, Route> layout;
    private VisualizationViewer<Carrefour, Route> vv;
    private EditingModalGraphMouse gm; 

    //Constructor
    public Maiin() {
       createView();
       placeComponents();
    }

    // COMMANDS
    public void display() {
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    private void createView() {
        frame = new JFrame("Application_Morena");
        frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        close = new JMenuItem("Close", new ImageIcon("images/fermer.jpg"));
        help = new JMenuItem("help", new ImageIcon("images/aide.jpg"));
        reconstruire = new JButton("Reconstruire");
       
    }

    private void placeComponents() {
        JPanel menu1 = new JPanel();
        {
            menu1.setPreferredSize(new Dimension(MENU_WIDTH, MENU_HEIGHT));
            menu1.setBorder(BorderFactory.createEtchedBorder());

            JLabel l1 = new JLabel("                ");
            menu1.add(l1);

            //menu1.add(sliderNoeudRang);
            //menu1.add(sliderArreteRang);

           // JPanel menu1_1 = new JPanel(new GridLayout(3, 1));
            {
                JMenuBar menuBar = new JMenuBar();
                {
                    gm.getModeMenu().getItem(0).setText("Se déplacer/Zoomer");
                    gm.getModeMenu().getItem(1).setText("Sélectionner/Modifier");
                   gm.getModeMenu().getItem(2).setText("Créer/Supprimer");
                   JMenu modeMenu = gm.getModeMenu();
                    modeMenu.setText("Selectionner un outil");
                    modeMenu.setPreferredSize(new Dimension(156, 30));
                    menuBar.add(modeMenu);
                }
                //menu1_1.add(menuBar);

                JLabel l2 = new JLabel(" ");
               // menu1_1.add(l2);
                JLabel l3 = new JLabel(" ");
               // menu1_1.add(l3);
            }
            //menu1.add(menu1_1);

           // JPanel menu1_3 = new JPanel(new GridLayout(2, 1));
            {
                JLabel l5 = new JLabel("                ");
                //menu1_3.add(l5);
                JLabel l6 = new JLabel("                ");
                //menu1_3.add(l6);
            }
            //menu1.add(menu1_3);

            //menu1.add(sliderCoefNoeudProche);
            //menu1.add(sliderCoefLongNouvelleRoute);

            JPanel menu1_2 = new JPanel(new GridLayout(1, 1));
            {
                menu1_2.add(reconstruire);
                menu1_2.setPreferredSize(new Dimension(156, 30));
            }
            menu1.add(menu1_2);

            JPanel menu1_4 = new JPanel(new GridLayout(1, 1));
            {
                ImageIcon imgIndications = new ImageIcon("images/indications.jpg");
                JLabel l4 = new JLabel(imgIndications);
                menu1_4.add(l4, BorderLayout.CENTER);
            }
            menu1.add(menu1_4);
        }
        frame.add(menu1, BorderLayout.EAST);
        //frame.add(vv, BorderLayout.CENTER); // Ajout du graph
            
        menuBar = new JMenuBar();
        {
            JMenu menuFichier = new JMenu("Files");
            {
                menuFichier.add(close);
            }
            menuBar.add(menuFichier);
            JMenu menuEdition = new JMenu("Contact us");
            {
                menuEdition.add(help);
            }
            menuBar.add(menuEdition);
        }
        frame.setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Maiin().display();
            }
        });
    }
}

package tec.poo.battleship;

import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;

public class BattleshipUI extends JFrame {  // implement ActionListener

    private void makeFrameFullSize(JFrame aFrame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        aFrame.setSize(screenSize.width, screenSize.height);
    }
    public static void main(String[] args) {
        /* Página principal */
        BattleshipUI home = new BattleshipUI();

        home.setVisible(true);
        home.setTitle("Battleship");
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = home.getContentPane();

        JLabel mainTitle = new JLabel("Sink-a-ship", SwingConstants.CENTER);
        mainTitle.setFont(new Font("Serif", Font.PLAIN, 80));

        /* Menú */
        JMenuBar menuBar = new JMenuBar();
        JMenu game = new JMenu("Juego");
        JMenu about = new JMenu("Acerca de");
        JMenu settings = new JMenu("Configuración");
        
        JMenuItem nuevo = new JMenuItem("Nuevo");
        JMenuItem cargar = new JMenuItem("Cargar");
        JMenuItem salir = new JMenuItem("Salir");
        
        game.add(nuevo);
        game.add(cargar);
        game.add(salir);

        menuBar.add(game);
        menuBar.add(settings);
        menuBar.add(about);
        
        /* Acerca de */
        JInternalFrame aboutWindow = new JInternalFrame();
        aboutWindow.setTitle("Acerca de");
        
        JLabel aboutText = new JLabel("Sink-a-ship \n Hecho por: Valery Carvajal 2022314299", SwingConstants.CENTER);

        aboutWindow.add(aboutText);
        home.add(aboutWindow);

        /* Agregar a página principal */
        home.setJMenuBar(menuBar);
        c.add(mainTitle);
        home.makeFrameFullSize(home);
    }
}

package game;

import javax.swing.JFrame;
import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import game.screens.*;
import java.awt.Color;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;

public class ApplicationMain extends JFrame implements KeyListener {
    
    private AsciiPanel terminal;
    private Screen screen;
 
    public ApplicationMain() {
        super();
        terminal = new AsciiPanel(80,24);
        add(terminal);
        pack();
        screen = new StartScreen();
        addKeyListener(this);
        repaint();
    }
 
    public void repaint() {
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }
 
    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }
 
    public void keyReleased(KeyEvent e) { }
 
    public void keyTyped(KeyEvent e) { }
 
    public static void main(String[] args) {
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setBackground(Color.black);
        app.setTitle("CrawleR 0.0.0");
        /*ImageIcon img = new ImageIcon("icon.png");
        app.setIconImage(img.getImage());*/
        
        /*BufferedImage image = null;
        try {
            image = ImageIO.read(
                app.getClass().getResource("/icon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        app.setIconImage(image);*/

        //app.setResizable(false);
    }
}
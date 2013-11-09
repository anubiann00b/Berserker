package game;

import javax.swing.JFrame;
import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import game.screens.*;
import java.awt.Color;

public class ApplicationMain extends JFrame implements KeyListener {
    
    private final int WIDTH = 80;
    private final int HEIGHT = 24;
    
    private AsciiPanel terminal;
    private Screen screen;
 
    public ApplicationMain() {
        super();
        terminal = new AsciiPanel(WIDTH+2,HEIGHT+2);
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
        app.setTitle("CrawlR 0.0.0");
    }
}
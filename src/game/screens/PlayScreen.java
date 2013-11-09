package game.screens;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {
    private final int WIDTH = 80;
    private final int HEIGHT = 24;
    private AsciiPanel terminal;
    
    public void displayOutput(AsciiPanel terminal) {
        this.terminal = terminal;
        displayMap();
        displayMessages();
        displayInfo();
    }
    
    private void displayMap() {
        for (int i = 0; i < 16; i++)
        {
            write("#########################",0,i);
            write("#########################",25,i);
        }
        
    }

    private void displayMessages() {
        //createMessagebox(30, 24);
    }

    private void displayInfo() {
       for (int i = 0; i < 8; i++)
        {
            write("@@@@@@@@@@@@@@@@@@@@@@@@@",0,i+15);
            write("@@@@@@@@@@@@@@@@@@@@@@@@@",25,i+15);
        }
    }

    private void write(String s, int x, int y) {
        if (x>WIDTH-1) {
            throw new IllegalArgumentException("X is too big.");
        }
        terminal.write(s,x+1,y+1);
    }
    
    public Screen respondToUserInput(KeyEvent key) {
        return (key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this);
    }

   

    
}

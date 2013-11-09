package game.screens;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {
    
    private AsciiPanel terminal;
    
    public void displayOutput(AsciiPanel terminal) {
        this.terminal = terminal;
        displayMap();
        displayMessages();
        displayInfo();
    }
    
    private void displayMap() {

    }

    private void displayMessages() {
        
    }

    private void displayInfo() {
        
    }
    
    private void write(String s, int x, int y) {
        terminal.write(s,x+1,y+1);
    }
    
    public Screen respondToUserInput(KeyEvent key) {
        return (key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this);
    }
}

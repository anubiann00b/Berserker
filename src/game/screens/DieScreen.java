package game.screens;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
 
public class DieScreen implements Screen {
 
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("This screen will display death messages.",0,0);
        terminal.write("(Enter to restart)",0,1);
    }
 
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}
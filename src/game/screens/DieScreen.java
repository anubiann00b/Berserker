package game.screens;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
 
public class DieScreen implements Screen {
 
    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("Being a Berserker is hard...",1);
        terminal.writeCenter("Better luck next time!",2);
        terminal.writeCenter("(Enter to restart)",3);
    }
 
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new StartScreen() : this;
    }
}
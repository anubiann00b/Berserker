package game.screens;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

public class WinScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("Congratulations!",1);
        terminal.writeCenter("You have defeated many Kobolds!",2);
        terminal.writeCenter("The caves have been cleansed",4);
        terminal.writeCenter("...",5);        
        terminal.writeCenter("For now",6);
        terminal.writeCenter("...",7);
        terminal.writeCenter("TO BE CONTINUED",8);
        terminal.writeCenter("Produced by Masilan and Shreyas",10);
        terminal.write("Special Thanks:",5,12);
        terminal.write("Trog, for endowing upon us the art of Berserking",5,14);
        terminal.write("Edward, for creating the original BAZAKA",5,16);
        terminal.write("Liam, for inspiring with us the fiery passion for programming",5,18);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return (key.getKeyCode() == KeyEvent.VK_ENTER ? new StartScreen() : this);
    }

}

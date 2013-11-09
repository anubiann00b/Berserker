package game.screens;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

public class StartScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.write("Welcome to CrawlR version 0.0.0!",1,1);
        terminal.write("This game open source, based off of Trystan's Ascii Panel.",1,2);
        terminal.write("WARNING: ALPHA VERSION: There's probably no content (besides this).",1,3);
        terminal.write("Made by Shreyas (anubiann00b) and Masilan (robomas).",1,4);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return (key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this);
    }

}

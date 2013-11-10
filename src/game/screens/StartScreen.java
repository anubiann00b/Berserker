package game.screens;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

public class StartScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.write("Welcome to CrawleR version 0.0.0!",0,0);
        terminal.write("WARNING: ALPHA VERSION: There's probably no content (besides this message).",0,1);
        terminal.write("Made by Shreyas (anubiann00b) and Masilan (robomas).",0,2);
        terminal.write("Special thanks to Liam (buckbanzai).",0,3);

    }

    public Screen respondToUserInput(KeyEvent key) {
        return (key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this);
    }

}

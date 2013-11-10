package game.screens;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

public class StartScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.write("Welcome to CrawleR version 0.0.0!",0,0);
        terminal.write("This game open source, based off of Trystan's Ascii Panel.",0,1);
        terminal.write("WARNING: ALPHA VERSION: There's probably no content (besides this).",0,2);
        terminal.write("Made by Overlord Shreyas (anubiann00b).",0,3);

    }

    public Screen respondToUserInput(KeyEvent key) {
        return (key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this);
    }

}

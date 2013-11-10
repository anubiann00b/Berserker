package game.screens;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

public class StartScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("Welcome to BERSERKER version 1.0.0!",1);
        terminal.writeCenter("ALPHA VERSION: Work in progress. However, it's playable.",2);
        terminal.writeCenter("Made by Shreyas (anubiann00b) and Masilan (robomas).",3);
        terminal.writeCenter("You play BAZAKA, a Berserker. Your objective is to kill 25 of the Kobolds",5);
        terminal.writeCenter("infesting these caves. However, they pose a significant threat, although they",6);
        terminal.writeCenter("are pretty stupid. Move with Vi keys, Arrow keys, or numpad. Your rage bar",7);
        terminal.writeCenter("fills up as you hit or kill enemies. Rage increases your strength, but",8);
        terminal.writeCenter("it wears off quickly when out of combat. Good luck and have fun!",9);

    }

    public Screen respondToUserInput(KeyEvent key) {
        return (key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this);
    }

}

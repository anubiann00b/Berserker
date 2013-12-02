package game.screens;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

public class LoadingScreen implements Screen {

    int counter=0;
    char[] cycle = new char[] { '-','/','|','\\' };

    public void displayOutput(AsciiPanel terminal) {
        if (counter<440) {
            terminal.writeCenter("Loading",4);
            terminal.writeCenter("+----------+",5);
            String loadingBar = "";
            for (int i=0;i<10;i++) {
                if (i<counter/40) {
                    loadingBar+=cycle[(i+counter/4)%4];
                } else {
                    loadingBar+=" ";
                }
                terminal.writeCenter("" + counter,9);
            }
            if (counter>400) {
                
            }
            terminal.writeCenter("|" + loadingBar + "|",6);
            terminal.writeCenter("+----------+",7);
            counter++;
        } else {
            terminal.writeCenter("Done!",4);
            terminal.writeCenter("+----------+",5);
            terminal.writeCenter("|----------|",6);
            terminal.writeCenter("+----------+",7);
        }
    }

    public Screen respondToUserInput(KeyEvent key) {
        return this;
    }
}

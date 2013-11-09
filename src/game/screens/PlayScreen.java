package game.screens;

import asciiPanel.AsciiPanel;
import game.*;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {
    private final int WIDTH = 80;
    private final int HEIGHT = 24;
    private final int MAP_WINDOW_WIDTH = 40;
    private final int MAP_WINDOW_HEIGHT = 15;
    int mapWidth;
    int mapHeight;
    private AsciiPanel terminal;
    private World world;
    
    public PlayScreen() {
        mapWidth = 200;
        mapHeight = 92;
        Creature player = new Creature();
        createWorld();
    }
    
    private void createWorld() {
        world = new WorldBuilder(mapWidth, mapHeight).generateWorld().create();
    }
    
    public void displayOutput(AsciiPanel terminal) {
        this.terminal = terminal;
        displayMap();
        displayMessages();
        displayInfo();
    }
    
    public int getScrollX() { return Math.max(0, Math.min(player.getX() - MAP_WINDOW_WIDTH / 2, world.getWidth() - MAP_WINDOW_WIDTH)); }
	
    public int getScrollY() { return Math.max(0, Math.min(player.getY() - MAP_WINDOW_HEIGHT / 2, world.getHeight() - MAP_WINDOW_HEIGHT)); }

    private void displayTiles(int left, int top) {
        for (int x = 0; x < MAP_WINDOW_WIDTH; x++) {
            for (int y = 0; y < MAP_WINDOW_HEIGHT; y++) {
                int wx = x + left;
                int wy = y + top;

                write(world.getTile(wx, wy).getChar(), x, y, world.getTile(wx, wy).getColor());
            }
        }
    }

    private void scrollBy(int mx, int my) {
        player.moveBy(mx, my);
    }
    
    private void displayMap() { //40 wide
        for(int i=0;i<15;i++) {
            write("The map goes here---------------------40",0,i);
        }
    }

    private void displayMessages() {

    }

    private void displayInfo() { //39 wide

    }

    private void write(String s, int x, int y) {
        if (x+1>=WIDTH-1 && x+1<WIDTH) {
            throw new IllegalArgumentException("X bleeds into the overflow area.");
        }
        
        if (y+1>=HEIGHT-1 && y+1<HEIGHT) {
            throw new IllegalArgumentException("Y bleeds into the overflow area.");
        }
        
        terminal.write(s,x+1,y+1);
    }
    
    private void write(char c, int x, int y) {
        if (x+1>=WIDTH-1 && x+1<WIDTH) {
            throw new IllegalArgumentException("X bleeds into the overflow area.");
        }
        
        if (y+1>=HEIGHT-1 && y+1<HEIGHT) {
            throw new IllegalArgumentException("Y bleeds into the overflow area.");
        }
        
        terminal.write(c,x+1,y+1);
    }
    
    private void write(char c, int x, int y, Color color) {
        if (x+1>=WIDTH-1 && x+1<WIDTH) {
            throw new IllegalArgumentException("X bleeds into the overflow area.");
        }
        
        if (y+1>=HEIGHT-1 && y+1<HEIGHT) {
            throw new IllegalArgumentException("Y bleeds into the overflow area.");
        }
        
        terminal.write(c,x+1,y+1);
    }
    
    public Screen respondToUserInput(KeyEvent key) {
        return (key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this);
    }
}

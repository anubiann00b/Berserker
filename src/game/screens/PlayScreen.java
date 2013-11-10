package game.screens;

import asciiPanel.AsciiPanel;
import game.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.lang.Math;

public class PlayScreen implements Screen {
    private final int WIDTH = 80;
    private final int HEIGHT = 24;
    private final int MAP_WINDOW_WIDTH = 40;
    private final int MAP_WINDOW_HEIGHT = 15;
    int mapWidth;
    int mapHeight;
    private World world;
    private Creature player;
    
    public PlayScreen() {
        mapWidth = 200;
        mapHeight = 92;
        player = new Creature(5,5,'@',AsciiPanel.brightWhite);
        createWorld();
    }
    
    private void createWorld() {
        world = new WorldBuilder(mapWidth, mapHeight).generateWorld().create();
    }
    
    public void displayOutput(AsciiPanel terminal) {
        displayMap(terminal);
        displayMessages(terminal);
        displayInfo(terminal);
    }
    
    public int getScrollX() { return Math.max(0,Math.min(player.getX()-MAP_WINDOW_WIDTH/2,world.getWidth()-MAP_WINDOW_WIDTH)); }
    public int getScrollY() { return Math.max(0,Math.min(player.getY()-MAP_WINDOW_HEIGHT/2,world.getHeight()-MAP_WINDOW_HEIGHT)); }

    private void displayTiles(AsciiPanel terminal, int left, int top) {
        for (int x = 0; x < MAP_WINDOW_WIDTH; x++) {
            for (int y = 0; y < MAP_WINDOW_HEIGHT; y++) {
                int wx = x + left;
                int wy = y + top;

                write(terminal, world.getTile(wx, wy).getChar(), x, y, world.getTile(wx, wy).getColor());
            }
        }
        write(terminal, player.getChar(), player.getX()-left, player.getY()-top, player.getColor());
    }
    
    private void displayMap(AsciiPanel terminal) { //40 wide
        for(int i=0;i<15;i++) {
            write(terminal, "The map goes here---------------------40",0,i);
        }
        
        int left = getScrollX();
        int top = getScrollY();
        
        displayTiles(terminal,left,top);
    }

    private void displayMessages(AsciiPanel terminal) {

    }

    private void displayInfo(AsciiPanel terminal) { //39 wide

    }

    private void write(AsciiPanel terminal, String s, int x, int y) {
        if (x+1>=WIDTH-1 && x+1<WIDTH) {
            throw new IllegalArgumentException("X bleeds into the overflow area.");
        }
        
        if (y+1>=HEIGHT-1 && y+1<HEIGHT) {
            throw new IllegalArgumentException("Y bleeds into the overflow area.");
        }
        
        terminal.write(s,x+1,y+1);
    }
    
    private void write(AsciiPanel terminal, char c, int x, int y) {
        if (x+1>=WIDTH-1 && x+1<WIDTH) {
            throw new IllegalArgumentException("X bleeds into the overflow area.");
        }
        
        if (y+1>=HEIGHT-1 && y+1<HEIGHT) {
            throw new IllegalArgumentException("Y bleeds into the overflow area.");
        }
        
        terminal.write(c,x+1,y+1);
    }
    
    private void write(AsciiPanel terminal, char c, int x, int y, Color color) {
        if (x+1>=WIDTH-1 && x+1<WIDTH) {
            throw new IllegalArgumentException("X bleeds into the overflow area.");
        }
        
        if (y+1>=HEIGHT-1 && y+1<HEIGHT) {
            throw new IllegalArgumentException("Y bleeds into the overflow area.");
        }
        
        terminal.write(c,x+1,y+1);
    }
    
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_LEFT: case KeyEvent.VK_NUMPAD4: case KeyEvent.VK_H: player.moveBy(-1, 0); break;
            case KeyEvent.VK_RIGHT: case KeyEvent.VK_NUMPAD6: case KeyEvent.VK_L: player.moveBy(1, 0); break;
            case KeyEvent.VK_UP: case KeyEvent.VK_NUMPAD8: case KeyEvent.VK_K: player.moveBy(0,-1); break;
            case KeyEvent.VK_DOWN: case KeyEvent.VK_NUMPAD2:case KeyEvent.VK_J: player.moveBy(0, 1); break;
            case KeyEvent.VK_Y: case KeyEvent.VK_NUMPAD7: player.moveBy(-1,-1); break;
            case KeyEvent.VK_U: case KeyEvent.VK_NUMPAD9: player.moveBy( 1,-1); break;
            case KeyEvent.VK_B: case KeyEvent.VK_NUMPAD1: player.moveBy(-1, 1); break;
            case KeyEvent.VK_N: case KeyEvent.VK_NUMPAD3: player.moveBy( 1, 1); break;
            case KeyEvent.VK_P: player.setHp(-1); break;
            case KeyEvent.VK_O: player.setHp(1); break;
            case KeyEvent.VK_1: player.setMp(1); break;
            case KeyEvent.VK_2: player.setMp(-1); break;
        }
        return this;
    }
}

package game;

import java.awt.Color;
import asciiPanel.AsciiPanel;
 
public enum Tile {
    FLOOR('.', AsciiPanel.yellow, true, true),
    WALL('#', AsciiPanel.yellow, false, false),
    BOUNDS('x', AsciiPanel.brightBlack, false, false),
    UNKNOWN(' ', AsciiPanel.white, true, false);
 
    private char glyph;
    public char glyph() { return glyph; }
 
    private Color color;
    public Color color() { return color; }
    
    private boolean isPassable;
    public boolean isPassable() { return isPassable; }
    
    private boolean isTransparent;
    public boolean isTransparent() { return isTransparent; }
    
    public boolean isGround() { return this == FLOOR; }
 
    Tile(char glyph, Color color, boolean isPassable, boolean isTransparent) {
        this.glyph = glyph;
        this.color = color;
        this.isPassable = isPassable;
        this.isTransparent = isTransparent;
    }
}
package game;

import asciiPanel.AsciiPanel;
import java.awt.Color;

public enum Tile {
    FLOOR('.',AsciiPanel.yellow,true,true),
    WALL('#',AsciiPanel.yellow,false,false),
    BOUNDARIES('x',AsciiPanel.white,false,false);
    
    private char Character;
    private boolean isWalkable;
    private boolean isTransparent;
    private Color color;
    
    public char getChar() {
        return Character;
    }
    
    public boolean isWalkable() {
        return isWalkable;
    }
    
    public boolean isTransparent() {
        return isTransparent;
    }
    
    public Color getColor() {
        return color;
    }
    
    Tile(char Character, Color color, boolean isWalkable, boolean isTransparent) {
        this.Character = Character;
        this.color = color;
        this.isWalkable = isWalkable;
        this.isTransparent = isTransparent;
    }
}

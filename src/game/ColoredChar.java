package game;

import java.awt.Color;

public class ColoredChar {

    private Color color;
    private char character;

    public ColoredChar(char character, Color color) {
        this.character = character;
        this.color = color;
    }
    
    public static ColoredChar getConvertedChar(char character, Color color) {
        return new ColoredChar(character, color);
    }
    
    public char getChar () { return character; }
    public Color getColor () { return color; }

    public void setChar (char character) { this.character = character; }
    public void setColor () { this.color = color; }
}

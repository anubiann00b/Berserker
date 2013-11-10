package game;

import java.awt.Color;

public class ColoredChar {
    
    public ColoredChar(Color color, char character)
    {
        this.color = color;
        this.character = character;
    }
    private Color color;
    private char character;
       
    public char getChar () { return character; }
    public void setChar (char character) { this.character = character; }
    
    public Color getColor () { return color; }
    public void setColor () { this.color = color; }
    
}

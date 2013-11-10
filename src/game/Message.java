package game;

import java.awt.Color;

public class Message {
    private ColoredChar[] characters = new ColoredChar[80];
    
    public Message(ColoredChar[] characters)
    {
        this.characters = characters;
    }
    
    public ColoredChar[] getMessage() { return characters; }
    public void setMessage(ColoredChar[] characters) { this.characters = characters; }
    
}

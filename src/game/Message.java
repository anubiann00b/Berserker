package game;

import java.awt.Color;

public class Message {
    private ColoredChar[] characters = new ColoredChar[80];
    
    public Message(ColoredChar[] characters) {
        this.characters = characters;
    }
    
    public Message convert(String input, Color color) {
        Message newMessage = new Message (characters);
        for (int i = 0; i < 80; i++) {
            characters[i].convert(input.charAt(i), color);
        }
        
        return newMessage;
        
        //returns a message object of string in the color color
    }
    public ColoredChar[] getMessage() { return characters; }
    public void setMessage(ColoredChar[] characters) { this.characters = characters; }
}

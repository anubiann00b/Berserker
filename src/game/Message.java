package game;

import java.awt.Color;
import asciiPanel.AsciiPanel;
import java.util.ArrayList;

public class Message {
    private String message;
    private Color color;
       
    public Message(String message, Color color) {
        this.message = message;
        this.color = color;
    }
    
    public Message(String message) {
        this(message, AsciiPanel.white);
    }

    public String getMessage() { return this.message; }
    public Color getColor() { return this.color; }
    public int getLength() { return message.length(); }
    public void append(String input) { this.message.concat(input); }
    public void setMessage(String message) { this.message = message; }
}

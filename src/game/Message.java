package game;

import java.awt.Color;
import asciiPanel.AsciiPanel;
import game.ColoredChar;

public class Message {
    private ColoredChar[] characters = new ColoredChar[80];
    
    public Message(ColoredChar[] characters) {
        this.characters = characters;
    }
    
    public static Message getConvertedMessage(String input, Color color) {
        ColoredChar[] newMessage = new ColoredChar[80];
        for (int i=0;i<input.length();i++) {
            if (input.charAt(i)==0)
                break;
            newMessage[i] = ColoredChar.getConvertedChar(input.charAt(i), color);
        }
        return new Message(newMessage);
    }
    
    public static Message getConvertedMessage(String input) {
        return getConvertedMessage(input,AsciiPanel.white);
    }

    public ColoredChar[] getMessage() { return characters; }
    public String getString() { char[] newChars=new char[80]; for(int i=0;i<characters.length;i++) { if(newChars[i]==0) break; newChars[i]=characters[i].getChar(); } return new String(newChars); }
    public ColoredChar getCharacter(int index) { if(characters[index]!=null) return characters[index]; return null;}
    public int getLength() { return characters.length; }
    
    public void setCharacter(ColoredChar character, int index) { characters[index] = character; }
    public void setMessage(ColoredChar[] characters) { this.characters = characters; }
}

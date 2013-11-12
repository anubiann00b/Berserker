package game;

import asciiPanel.AsciiPanel;
import game.screens.*;
import java.util.ArrayList;

public class PlayerAi extends CreatureAi {
    private FieldOfView fov;

    public PlayerAi(Creature creature, FieldOfView fov) {
        super(creature);
        this.fov = fov;
        creature.getMessageList(initializeMessageList());
    }
    
    public boolean canSee(int wx, int wy) {
        return fov.isVisible(wx, wy);
    }
    
    public void onEnter(int x, int y, Tile tile){
        if (tile.isPassable()) {
            creature.setX(x);
            creature.setY(y);
        } else {
            double r = Math.random();
            if (r<0.2) {
                creature.addMessage("Good luck trying to walk through walls.");
            } else if (r<0.4) {
                creature.addMessage("You can't move there.");
            } else if (r<0.6) {
                creature.addMessage("You crash into a stone wall.");
            } else if (r<0.8) {
                creature.addMessage("Ow.");
            } else if (r<1) {
                creature.addMessage("The wall mutters some questionable adjectives.");
            }
        }
    }
    
    public ArrayList<Message> getMessages() {
        ArrayList<Message> theMessages = new ArrayList();
        theMessages.addAll(creature.messages);
        creature.messages.clear();
        return theMessages;
    }
    
    public ArrayList<Message> initializeMessageList() {
        ArrayList<Message> m = new ArrayList<Message>();
            // Critical hit messages
            m.add(Message.getConvertedMessage("Your weapon bestows your rage upon your victims!",AsciiPanel.brightRed));
            m.add(Message.getConvertedMessage("You skewer the pathetic creature!",AsciiPanel.brightRed));
            m.add(Message.getConvertedMessage("You pull of a devasting attack!",AsciiPanel.brightRed));
            m.add(Message.getConvertedMessage("Your grandpa's secret technique passsed on through the generations hits!",AsciiPanel.brightRed));
            m.add(Message.getConvertedMessage("YOU IMPALE THE LITTLE INSECT",AsciiPanel.brightRed));
            
            // Hit messages
            m.add(Message.getConvertedMessage("You hit",AsciiPanel.red));
            m.add(Message.getConvertedMessage("You strike",AsciiPanel.red));
            m.add(Message.getConvertedMessage("You swing at",AsciiPanel.red));
            m.add(Message.getConvertedMessage("You smack",AsciiPanel.red));
            m.add(Message.getConvertedMessage("You clobber",AsciiPanel.red));
            /*
            m.add(Message.getConvertedMessage("",AsciiPanel.));
            m.add(Message.getConvertedMessage("",AsciiPanel.));
            m.add(Message.getConvertedMessage("",AsciiPanel.));
            m.add(Message.getConvertedMessage("",AsciiPanel.));
            m.add(Message.getConvertedMessage("",AsciiPanel.));

            m.add(Message.getConvertedMessage("",AsciiPanel.));
            m.add(Message.getConvertedMessage("",AsciiPanel.));
            m.add(Message.getConvertedMessage("",AsciiPanel.));
            m.add(Message.getConvertedMessage("",AsciiPanel.));
            m.add(Message.getConvertedMessage("",AsciiPanel.));*/
        return m;
    }
}
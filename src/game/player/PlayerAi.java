package game.player;

import asciiPanel.AsciiPanel;
import game.enemy.Creature;
import game.message.Message;
import game.world.Tile;
import java.awt.Color;
import java.util.ArrayList;

public class PlayerAi {
    private FieldOfView fov;
    private Player player;
    
    public PlayerAi(Player player, FieldOfView fov) {
        this.player = player;
        this.player.setCreatureAi(this);
        this.fov = fov;
    }
    
    public boolean canSee(int x, int y) {
        return fov.isVisible(x, y);
    }
    
    public void onEnter(int x, int y, Tile tile){
        if (tile.isPassable()) {
            player.setX(x);
            player.setY(y);
        } else {
            double r = Math.random();
            if (r<0.2) {
                player.addMessage("Good luck trying to walk through walls.");
            } else if (r<0.4) {
                player.addMessage("You can't move there.");
            } else if (r<0.6) {
                player.addMessage("You crash into a stone wall.");
            } else if (r<0.8) {
                player.addMessage("Ow.");
            } else if (r<1) {
                player.addMessage("The wall mutters some questionable adjectives.");
            }
        }
    }
    
    public ArrayList<Message> getMessages() {
        ArrayList<Message> theMessages = new ArrayList();
        theMessages.addAll(player.messages);
        player.messages.clear();
        return theMessages;
    }
    
    protected void addCritMessage(Creature other) {
        double r = Math.random();
        if (r<0.2)
            player.addMessage("Your weapon bestows your rage upon your victims!", AsciiPanel.brightRed);
        else if (r<0.4)
            player.addMessage("You skewer the pathetic creature!",AsciiPanel.brightRed);
        else if (r<0.6)
            player.addMessage("You pull off a devasting attack!",AsciiPanel.brightRed);
        else if (r<0.8)
            player.addMessage("Your grandpa's secret technique passsed on through the generations hits!",AsciiPanel.brightRed);
        else if (r<1)
            player.addMessage("YOU IMPALE THE LITTLE INSECT",AsciiPanel.brightRed);
    }
    
    protected void addCritMissMessage(Creature other) {
        double r = Math.random();
        if (r<0.2)
            player.addMessage("You are very MISS-leading in your combat ability.");
        else if (r<0.4)
            player.addMessage("Even a baby could of hit that.");
        else if (r<0.6)
            player.addMessage("You get an A for effort.");
        else if (r<0.8)
            player.addMessage("Who taught you to fight, your grandpa?");
        else if (r<1)
            player.addMessage("YOU SHAME YOUR FAMILY");
    }
    
    protected void addMissMessage(Creature other) {
        double r = Math.random();
        if (r<0.2)
            player.addMessage("Your weapon barely grazes it. Try harder.", Color.WHITE);
        else if (r<0.4)
            player.addMessage("You miss.", Color.WHITE);
        else if (r<0.6)
            player.addMessage("You missed. Better luck next time!", Color.WHITE);
        else if (r<0.8)
            player.addMessage("Maybe you should train harder.", Color.WHITE);
        else if (r<1)
            player.addMessage("You must study more.", Color.WHITE);
    }
    
    protected void addHitMessage(Creature other) {
        double r = Math.random();
        if (r<0.2)
            player.addMessage("You hit the " + other.getName() + ".", AsciiPanel.red);
        else if (r<0.4)
            player.addMessage("You strike the " + other.getName() + ".", AsciiPanel.red);
        else if (r<0.6)
            player.addMessage("You swing at the " + other.getName() + ".", AsciiPanel.red);
        else if (r<0.8)
            player.addMessage("You smack the " + other.getName() + ".", AsciiPanel.red);
        else if (r<1)
            player.addMessage("You clobber the " + other.getName() + ".", AsciiPanel.red);
    }
}
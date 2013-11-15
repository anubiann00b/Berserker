package game.screens;
//                                                                              Screw the 80 character limit.
import asciiPanel.AsciiPanel;
import game.Creature;
import game.CreatureFactory;
import game.FieldOfView;
import game.GroundedItem;
import game.ItemFactory;
import game.Message;
import game.World;
import game.WorldBuilder;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;

public class PlayScreen implements Screen {
    private World world;
    private int screenWidth;
    private int screenHeight;
    private int mapWidth;
    private int mapHeight;
    private Creature player;
    private FieldOfView fov;
    private ArrayList<Message> messages;
    private CreatureFactory creatureFactory;

    public PlayScreen() {
        messages = new ArrayList();
        messages.add(new Message("Game Started!"));
        screenWidth = 40;
        screenHeight = 14;
        mapWidth = 200;
        mapHeight = 92;
        createWorld();
        fov = new FieldOfView(world);
        creatureFactory = new CreatureFactory(world);
        spawnCreatures();
        ItemFactory itemFactory = new ItemFactory(world);
        spawnItems(itemFactory);
    }

    private void spawnCreatures() {
        player = creatureFactory.newPlayer(fov);

        for (int i=0;i<50;i++) {
            creatureFactory.newPlant();
        }
        
        for (int i=0;i<50;i++) {
            creatureFactory.newKobold(new FieldOfView(world), player);
        }
    }
    
    private void spawnItems(ItemFactory itemFactory){
        for (int i=0;i<80;i++){
            itemFactory.spawnItem();
        }
    }

    private void createWorld() {
        world = new WorldBuilder(mapWidth, mapHeight)
                .makeCaves()
                .build();
    }

    public int getScrollX() { return Math.max(0,Math.min(player.getX()-screenWidth/2,world.width()-screenWidth)); }

    public int getScrollY() { return Math.max(0,Math.min(player.getY()-screenHeight/2,world.height()-screenHeight)); }

    public void displayMap(AsciiPanel terminal) {
        int left = getScrollX();
        int top = getScrollY();

        displayTiles(terminal, left, top);

        terminal.write(player.getGlyph(), player.getX() - left + 1, player.getY() - top + 1, player.getColor());
    }

    private void displayTiles(AsciiPanel terminal, int left, int top) {
        fov.update(player.getX(), player.getY(),player.getVisionRadius());
        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                int wx = x + left;
                int wy = y + top;

                Creature creature = world.getCreature(wx, wy);
                GroundedItem item = world.getItem(wx, wy);
                if (player.canSee(wx, wy)) {
                    terminal.write(world.getGlyph(wx, wy), x + 1, y + 1, world.getColor(wx, wy));
                    if (creature != null) {
                        terminal.write(creature.getGlyph(), creature.getX() - left + 1, creature.getY() - top + 1, creature.getColor());
                    } else if (item != null) {
                        terminal.write(item.getItem().getEquipable().getGlyph(), item.getX() - left + 1, item.getY() - top + 1, item.getItem().getEquipable().getColor());
                    }
                } else {
                    terminal.write(fov.tile(wx, wy).glyph(), x + 1, y + 1, Color.DARK_GRAY);
                }
            }
        }
    }

    private void scrollBy(int mx, int my) {
        player.moveBy(mx, my);
    }
    
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_LEFT: case KeyEvent.VK_NUMPAD4: case KeyEvent.VK_H: scrollBy(-1, 0); break;
            case KeyEvent.VK_RIGHT: case KeyEvent.VK_NUMPAD6: case KeyEvent.VK_L: scrollBy(1, 0); break;
            case KeyEvent.VK_UP: case KeyEvent.VK_NUMPAD8: case KeyEvent.VK_K: scrollBy(0,-1); break;
            case KeyEvent.VK_DOWN: case KeyEvent.VK_NUMPAD2:case KeyEvent.VK_J: scrollBy(0, 1); break;
            case KeyEvent.VK_Y: case KeyEvent.VK_NUMPAD7: scrollBy(-1,-1); break;
            case KeyEvent.VK_U: case KeyEvent.VK_NUMPAD9: scrollBy( 1,-1); break;
            case KeyEvent.VK_B: case KeyEvent.VK_NUMPAD1: scrollBy(-1, 1); break;
            case KeyEvent.VK_N: case KeyEvent.VK_NUMPAD3: scrollBy( 1, 1); break;
            case KeyEvent.VK_P: player.setHp(-1); break;
            case KeyEvent.VK_O: player.setHp(1); break;
            case KeyEvent.VK_1: player.setRp(1); break;
            case KeyEvent.VK_2: player.setRp(-1); break;
            case KeyEvent.VK_COMMA: case KeyEvent.VK_G: player.pickUp();
        }
        if (player.getCurrentHp()<1) {
            return new DieScreen();
        }
        //if (world.getKillCount()>=25) {
        //    return new WinScreen();
        //}
        world.update();
        //creatureFactory.newKobold(new FieldOfView(world), player);
        return this;
    }
    
    public void displayOutput(AsciiPanel terminal) {
        displayInfo(terminal);
        displayMessages(terminal);
        displayMap(terminal);
    }
    
    public void displayInfo(AsciiPanel terminal) {
        terminal.write("BERSERKER V.1.0.0",42,1);
        terminal.write("HP: " + player.getCurrentHp() + "/" + player.getMaxHp(),42,3);
        int hpRatio = 25*player.getCurrentHp()/player.getMaxHp();
        for (int i=0;i<hpRatio;i++) {
            terminal.write("=",54+i,3,Color.GREEN);
        }
        for (int i=0;i<25-hpRatio;i++) {
            terminal.write("-",54+hpRatio+i,3,Color.GRAY);
        }
        terminal.write("RP: " + player.getCurrentRp() + "/" + player.getMaxRp(),42,4);
        if (player.getMaxRp()>0)
        {
            int mpRatio = 25*player.getCurrentRp()/player.getMaxRp();
            for (int i=0;i<mpRatio;i++) {
                terminal.write("=",54+i,4,AsciiPanel.brightRed);
            }
            for (int i=0;i<25-mpRatio;i++) {
                terminal.write("-",54+mpRatio+i,4,Color.GRAY);
            }
        }
        terminal.write("Atk|" + player.getAtk(),42,5);
        terminal.write("Dmg|" + player.getDmg(),51,5);
        terminal.write("Eva|" + player.getEva(),60,5);
        terminal.write("Def|" + player.getDef(),69,5);
        terminal.write("Weapon : " + player.getWeapon().getName(),42,7);
        terminal.write("  " + " (" + player.getWeapon().getAtk() + "  " + player.getWeapon().getDmg() + "  " + player.getWeapon().getEva() + "  " + player.getWeapon().getDef() + ")",42,8);       
        terminal.write("Armor  : " + player.getArmor().getName(),42,9);
        terminal.write("  " + " (" + player.getArmor().getAtk() + "  " + player.getArmor().getDmg() + "  " + player.getArmor().getEva() + "  " + player.getArmor().getDef() + ")",42,10);
        terminal.write("Shield : " + player.getShield().getName(),42,11);
        terminal.write("  " + " (" + player.getShield().getAtk() + "  " + player.getShield().getDmg() + "  " + player.getShield().getEva() + "  " + player.getShield().getDef() + ")",42,12);
        terminal.write("Kills: " + world.getKillCount(),42,13);
    }
    
    public void displayMessages(AsciiPanel terminal) {
        ArrayList<Message> newMessages = player.getMessages();
        Collections.reverse(newMessages);
        newMessages.addAll(messages);
        messages = newMessages;
        if (messages.size()>8) {
            for (int i=0;i<messages.size()-8;i++) {
                messages.remove(8+i);
            }
        }
        for (int i=0;i<messages.size();i++) {
            Message message = messages.get(i);
            terminal.write(message.getMessage(),1,23-i,message.getColor());
        }
    }
}

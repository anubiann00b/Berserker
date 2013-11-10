package game.screens;
//                                                                              Screw the 80 character limit.
import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import game.*;
import java.awt.Color;
import java.util.ArrayList;

public class PlayScreen implements Screen {
	private World world;
	private int screenWidth;
	private int screenHeight;
        private int mapWidth;
        private int mapHeight;
        private Creature player;
        private FieldOfView fov;
        private ArrayList<String> messages;
	
	public PlayScreen() {
            messages = new ArrayList();
            messages.add("Game Started!");
            screenWidth = 47;
            screenHeight = 13;
            mapWidth = 200;
            mapHeight = 92;
            createWorld();
            fov = new FieldOfView(world);
            CreatureFactory creatureFactory = new CreatureFactory(world);
            player = creatureFactory.newPlayer(fov);
	}
        
	private void createWorld() {
            world = new WorldBuilder(mapWidth, mapHeight)
                    .makeCaves()
                    .build();
	}

	public int getScrollX() { return Math.max(0, Math.min(player.getX() - screenWidth / 2, world.width() - screenWidth)); }
	
	public int getScrollY() { return Math.max(0, Math.min(player.getY() - screenHeight / 2, world.height() - screenHeight)); }
	
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
                    
                    if (player.canSee(wx, wy)) {
                        terminal.write(world.glyph(wx, wy), x + 1, y + 1, world.color(wx, wy));
                    } else {
                        terminal.write(fov.tile(wx, wy).glyph(), x + 1, y + 1, Color.DARK_GRAY);
                    }
                }
            }
                    System.out.println(player.getX()+ " " + player.getY());

	}
	
	private void scrollBy(int mx, int my) {
            player.moveBy(mx, my);
	}
    
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE: return new DieScreen();
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
            case KeyEvent.VK_1: player.setMp(1); break;
            case KeyEvent.VK_2: player.setMp(-1); break;
        }
        return this;
    }
    
    public void displayOutput(AsciiPanel terminal) {
        displayInfo(terminal);
        displayMessages(terminal);
        displayMap(terminal);
    }
    
    public void displayInfo(AsciiPanel terminal) {
        //29 wide
        terminal.write("Name Level #",51,1);
        terminal.write("Race Class",51,2);
        terminal.write("HP: " + player.getCurrentHp() + "/" + player.getMaxHp(),51,3);
        int hpRatio = 16*player.getCurrentHp()/player.getMaxHp();
        for (int i=0;i<hpRatio;i++) {
            terminal.write("=",63+i,3,Color.GREEN);
        }
        for (int i=0;i<16-hpRatio;i++) {
            terminal.write("-",63+hpRatio+i,3,Color.GRAY);
        }
        terminal.write("MP: " + player.getCurrentMp() + "/" + player.getMaxMp(),51,4);
        if (player.getMaxMp()>0)
        {
            int mpRatio = 16*player.getCurrentMp()/player.getMaxMp();
            for (int i=0;i<mpRatio;i++) {
                terminal.write("=",63+i,4,Color.BLUE);
            }
            for (int i=0;i<16-mpRatio;i++) {
                terminal.write("-",63+mpRatio+i,4,Color.GRAY);
            }
        }
        terminal.write("Str|" + player.getStr(),51,5);
        terminal.write("Con|" + player.getCon(),58,5);
        terminal.write("Dex|" + player.getDex(),65,5);
        terminal.write("Int|" + player.getInt(),72,5);

    }
    
    public void displayMessages(AsciiPanel terminal) {
        ArrayList<String> newMessages = player.getMessages();
        messages.addAll(newMessages); //Adds to end.
        if (messages.size()>8) {
            for (int i=0;i<messages.size()-8;i++) {
                messages.remove(i);
            }
        }
        //add(0,element);
        for (int i=0;i<messages.size();i++) {
            String message = messages.get(i);
            terminal.write(message,1,23-i);
        }
    }
}

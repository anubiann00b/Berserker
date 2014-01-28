package game.pathfinder;

import game.util.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
 
public class Node {
    private int x;
    private int y;
    private int g;
    private int h;
    private int f;
    private Node parent;

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getG() { return this.g; }
    public int getH() { return this.h; }
    public int getF() { return this.f; }
    public Node getParent() { return this.parent; }
    
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setG(int g) { this.g = g; }
    public void setH(int h) { this.h = h; }
    public void setF(int f) { this.f = f; }
    public void setParent(Node parent) { this.parent = parent; }
    
    public Node(Point point) {
        this.x = point.getX();
        this.y = point.getY();
        parent = null;
    }
        
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        parent = null;
    }
    
    public Node(int x, int y, Node parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }
        
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Node))
            return false;
        Node other = (Node) obj;
        if (x != other.getX())
            return false;
        if (y != other.getY())
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.x;
        hash = 29 * hash + this.y;
        hash = 29 * hash + this.g;
        hash = 29 * hash + this.h;
        hash = 29 * hash + this.f;
        hash = 29 * hash + Objects.hashCode(this.parent);
        return hash;
    }
    
    public List<Node> getNeighbors() {
        List<Node> nodes = new ArrayList<Node>();
        for (int ox = -1; ox < 2; ox++) {
            for (int oy = -1; oy < 2; oy++) {
                if (ox == 0 && oy == 0)
                    continue;
                nodes.add(new Node(x+ox, y+oy));
            }
        }
        Collections.shuffle(nodes);
        return nodes;
    }
}
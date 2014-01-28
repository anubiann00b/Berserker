package game.pathfinder;

import game.util.Point;
import game.world.Tile;
import java.util.ArrayList;

public class Pathfinder {
    public static void findPath(Point start, Point end, Tile[][] world) {
        ArrayList<Node> open = new ArrayList<Node>();
        ArrayList<Node> closed = new ArrayList<Node>();
        boolean completed = false;
        Node focusNode = new Node(start);
        while(!completed) {
            closed.add(focusNode);
            if (focusNode.getX() == end.getX() && focusNode.getY() == end.getY()) {
                completed = true;
                formPath(closed);
            }
            for (Node n : focusNode.getNeighbors()) {
                if (!world[n.getX()][n.getY()].isPassable() || closed.contains(n))
                    continue;
                if (open.contains(n)) {
                    if(n.getG()>focusNode.getG()+1) {
                        n.setParent(focusNode);
                    }
                    continue;
                }
                n.setParent(focusNode);
                n.setG(n.getParent().getG()+1);
                n.setH(Math.max(Math.abs(n.getX()-end.getX()),Math.abs(n.getX()-end.getX())));
                n.setF(n.getG()+n.getH());
                open.add(n);
            }
            int lowestF = 50;
            Node lowestNode = null;
            for (Node n : open) {
                if (n.getF()<lowestF) {
                    lowestF = n.getF();
                    lowestNode = n;
                }
            }
            if (lowestNode == null) {
                //throw new Exception("No path found, qq.");
            }
            focusNode = lowestNode;
        }
    }

    private static void formPath(ArrayList<Node> closed) {

    }
}

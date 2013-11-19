package game;

import java.util.ArrayList;

public class Pathfinder {
    public static void findPath(Point start, Point end, Tile[][] world) throws Exception {
        ArrayList<Node> open = new ArrayList<Node>();
        ArrayList<Node> closed = new ArrayList<Node>();
        boolean completed = true;
        Node focusNode = new Node(start);
        while(completed != false) {
            closed.add(focusNode);
            for (Node n : focusNode.getNeighbors()) {
                if (!world[n.getX()][n.getY()].isPassable())
                    continue;
                open.add(n);
                n.setG(n.getParent().getG()+1);
                n.setH(Math.max(Math.abs(n.getX()-end.getX()),Math.abs(n.getX()-end.getX())));
                n.setF(n.getG()+n.getH());
            }
            int lowestF = 500;
            Node lowestNode = null;
            for (Node n : focusNode.getNeighbors()) {
                if (n.getF()<lowestF) {
                    lowestF = n.getF();
                    lowestNode = n;
                }
            }
            if (lowestNode == null) {
                throw new Exception("No path found, qq.");
            }
            focusNode = lowestNode;
        }
    }
}

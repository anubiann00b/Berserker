package game;

import java.util.ArrayList;

public class Pathfinder {
    public static void findPath(Point start, Point end) {
        ArrayList<Node> open = new ArrayList<Node>();
        ArrayList<Node> closed = new ArrayList<Node>();
        Node focusNode = new Node(start);
        closed.add(focusNode);
        for (Node n : focusNode.getNeighbors()) {
            open.add(n);
            n.setG(n.getParent().getG()+1);
            n.setH(Math.max(Math.abs(n.getX()-end.getX()),Math.abs(n.getX()-end.getX())));
            n.setF(n.getG()+n.getH());
        }
    }
}

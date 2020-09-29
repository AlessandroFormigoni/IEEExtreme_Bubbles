import jdk.jshell.execution.Util;

import java.util.*;

public class Graph {

    private HashMap<Node, List<Node>> graph = new HashMap<>();

    public void addNode(Node n) {
        graph.put(n, new ArrayList<Node>());
    }

    public void addEntry(Node n, Node ns) {
        graph.get(n).add(ns);
    }

    public boolean pointsTo(Node n, Node s) {
        return this.graph.get(n).contains(s);
    }

    public boolean bidirectional(Node n, Node s) {
        return pointsTo(n,s) && pointsTo(s,n);
    }

    public ArrayList<Node> intersection (Node n, Node s) {
        ArrayList<Node> intersection = new ArrayList<>();
        for (Node w : graph.get(n)) {
            for (Node u : graph.get(s)) {
                if(w.equals(u))
                    intersection.add(w);
            }
        }
        return intersection;
    }

    public ArrayList<Node> union (Node n, Node s) {
        ArrayList<Node> union = new ArrayList<>();
        for (Node w : graph.get(n)) {
            if (!union.contains(w)) union.add(w);
            for (Node u : graph.get(w)) {
                if (!union.contains(u)) {union.add(u);}
            }
        }
        for (Node a : graph.get(s)) {
            if(!union.contains(a)) {union.add(a);}
            for (Node b : graph.get(a)) {
                if (!union.contains(b)) {union.add(b);}
            }
        }
        return union;
    }

    public boolean pointsAll(ArrayList<Node> nodes, Node key) {
        for(Node s : nodes) {
            if(pointsTo(key,s)) return true;
        }
        return false;
    }

    public HashMap<Node, List<Node>> getGraph() {
        return this.graph;
    }

}

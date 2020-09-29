public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        g.addNode(zero);
        g.addNode(one);
        g.addNode(two);
        g.addNode(three);
        g.addEntry(zero,one);
        g.addEntry(zero,two);
        g.addEntry(zero,three);
        g.addEntry(one,two);
        g.addEntry(two,three);
        Tubes t = new Tubes(g);
        System.out.println(t.loops());


    }
}

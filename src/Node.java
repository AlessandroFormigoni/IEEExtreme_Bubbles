import java.util.Objects;

public class Node {

    private int node;

    public Node(int node) {
        this.node = node;
    }

    public int getNode() {
        return this.node;
    }
    public void setNode(int i) {
        this.node = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node1 = (Node) o;
        return node == node1.node;
    }

    @Override
    public int hashCode() {
        return Objects.hash(node);
    }
}

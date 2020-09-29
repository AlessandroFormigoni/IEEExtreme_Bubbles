import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Tubes {
    Graph tubature;
    public Tubes(Graph tubature) {
        this.tubature = tubature;
    }

    int loops () {
        for (Node key : tubature.getGraph().keySet()) {
            for (Node node : tubature.getGraph().get(key)) {
                if( tubature.pointsAll(tubature.intersection(node,key) , key))
                    return 1;
            }
        }
        return 0;
    }

    private ArrayList<Node> completedUnion(Node key, Node node) {
        ArrayList<Node> comp = new ArrayList<>(tubature.union(node,key));
        comp.add(key);
        return comp;
    }

    private boolean intersectionVal (Node n, Node s) {
        return tubature.intersection(n, s).size() != Math.max(tubature.getGraph().get(n).size(), tubature.getGraph().get(s).size()) - tubature.union(n,s).size();
    }


}

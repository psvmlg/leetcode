import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    public static void main(String[] args) {
        CloneGraph c = new CloneGraph();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.addAll(Arrays.asList(n2, n4));
        n2.neighbors.addAll(Arrays.asList(n1, n3));
        n3.neighbors.addAll(Arrays.asList(n2, n4));
        n4.neighbors.addAll(Arrays.asList(n1, n3));

        Node fin = c.cloneGraph(n1);
        System.out.println(fin.val);
    }

    HashMap<Integer, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node != null && visited.containsKey(node.val)) {
            return visited.get(node.val);
        } else if (node == null) {
            return null;
        }
        Node newNode = new Node();
        newNode.val = node.val;
        visited.put(newNode.val, newNode);
        ArrayList<Node> neighbours = new ArrayList<>();
        for (Node adjNode: node.neighbors) {
            newNode.neighbors.add(cloneGraph(adjNode));
        }

        return newNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    public static void main(String[] args) {
        CloneGraph c = new CloneGraph();
        NodeList n1 = new NodeList(1);
        NodeList n2 = new NodeList(2);
        NodeList n3 = new NodeList(3);
        NodeList n4 = new NodeList(4);

        n1.neighbors.addAll(Arrays.asList(n2, n4));
        n2.neighbors.addAll(Arrays.asList(n1, n3));
        n3.neighbors.addAll(Arrays.asList(n2, n4));
        n4.neighbors.addAll(Arrays.asList(n1, n3));

        NodeList fin = c.cloneGraph(n1);
        System.out.println(fin.val);
    }

    HashMap<Integer, NodeList> visited = new HashMap<>();
    public NodeList cloneGraph(NodeList node) {
        if (node != null && visited.containsKey(node.val)) {
            return visited.get(node.val);
        } else if (node == null) {
            return null;
        }
        NodeList newNode = new NodeList();
        newNode.val = node.val;
        visited.put(newNode.val, newNode);
        ArrayList<NodeList> neighbours = new ArrayList<>();
        for (NodeList adjNode: node.neighbors) {
            newNode.neighbors.add(cloneGraph(adjNode));
        }

        return newNode;
    }
}

class NodeList {
    public int val;
    public List<NodeList> neighbors;
    public NodeList() {
        val = 0;
        neighbors = new ArrayList<NodeList>();
    }
    public NodeList(int _val) {
        val = _val;
        neighbors = new ArrayList<NodeList>();
    }
    public NodeList(int _val, ArrayList<NodeList> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

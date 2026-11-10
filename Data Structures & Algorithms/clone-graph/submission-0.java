/*
Definition for a Node.
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
*/

class Solution {
    Map<Node,Node> clonedNodeMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }
        if(clonedNodeMap.containsKey(node)) {
            return clonedNodeMap.get(node);
        }
        Node cloneNode = new Node(node.val);
        clonedNodeMap.put(node, cloneNode);
        if(node.neighbors == null) {
            return cloneNode;
        }
        List<Node> neighbors = new ArrayList<>();
        cloneNode.neighbors= neighbors;
        for(Node neighbor : node.neighbors) {
            neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}
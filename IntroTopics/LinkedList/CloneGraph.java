public class CloneGraph {
    // https://leetcode.com/problems/clone-graph/description/

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                dfs(neighbor, map);
            }
            newNode.neighbors.add(map.get(neighbor));
        }
        return newNode;
    }
}

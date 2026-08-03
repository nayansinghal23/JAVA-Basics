// https://www.lintcode.com/problem/859    

class Node {
    public int val;
    public Node next;
    public Node prev;

    public Node(int val) {
        this.val = val;
        next = prev = null;
    }
}

class DLL {
    private final Node head;
    private final Node tail;

    public DLL() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public Node push(int x) {
        Node node = new Node(x);
        Node after = head.next;

        head.next = node;
        after.prev = node;

        node.prev = head;
        node.next = after;

        return node;
    }

    public Node pop() {
        Node node = head.next;

        head.next = node.next;
        node.next.prev = head;

        node.next = node.prev = null;

        return node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = node.prev = null;
    }

    public int top() {
        return head.next.val;
    }
}

class MaxStack {
    private DLL st;
    private TreeMap<Integer, List<Node>> tm;

    public MaxStack() {
        st = new DLL();
        tm = new TreeMap<>();
    }
  
    public void push(int x) {
        Node node = st.push(x);
        tm.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
    }

    public int pop() {
        Node node = st.pop();

        List<Node> nodes = tm.get(node.val);
        nodes.remove(nodes.size() - 1);

        if (nodes.isEmpty()) {
            tm.remove(node.val);
        }

        return node.val;
    }

    public int top() {
        return st.top();
    }
  
    public int peekMax() {
        return tm.lastKey();
    }
  
    public int popMax() {
        Map.Entry<Integer, List<Node>> entry = tm.lastEntry();

        int max = entry.getKey();
        List<Node> nodes = entry.getValue();

        Node node = nodes.remove(nodes.size() - 1);

        if (nodes.isEmpty()) {
            tm.remove(max);
        }

        st.remove(node);
        return max;
    }
}
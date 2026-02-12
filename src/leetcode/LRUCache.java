package leetcode;

class LRUCache {
    private static class Node {
        private Node prev;
        private Node next;
        private int key;
        private int val;

        public Node (int k, int val) {
            this.key = k;
            this.val = val;
        }

        private void del() {
            if (next != null)
                next.prev = prev;
            if (prev != null)
                prev.next = next;
            next = null;
            prev = null;
        }

        private void add(Node t) {
            if (t == this)
                return;
            prev = t;
            t.next = this;
            this.next = null;
        }
    }

    private final int cap;
    private final Node[] nodes;
    private Node head;
    private Node tail;
    private int used;

    public LRUCache(int capacity) {
        cap = capacity;
        used = 0;
        nodes = new Node[10001];
    }

    public int get(int key) {
        if (nodes[key] != null) {
            reorder(key);
            return nodes[key].val;
        }
        return -1;
    }

    private void evict() {
        int key = head.key;
        deleteNode(head);
        nodes[key] = null;
    }

    private void linkNode(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        if (tail != null) {
            node.add(tail);
        }
        tail = node;
    }

    private void deleteNode(Node n) {
        if (head == n)
            head = n.next;
        if (tail == n)
            tail = n.prev;
        n.del();
    }

    private Node deleteNode(int key) {
        Node n = nodes[key];
        deleteNode(n);
        return n;
    }

    private void reorder(int key) {
        Node n = deleteNode(key);
        linkNode(n);
    }

    public void put(int key, int value) {
        if (head == null) {
            Node n = new Node(key, value);
            linkNode(n);
            nodes[key] = n;
            used++;
            return;
        }
        if (nodes[key] != null) {
            reorder(key);
            nodes[key].val = value;
            return;
        }
        if (used >= cap)
            evict();
        else
            used++;
        Node n = new Node(key, value);
        linkNode(n);
        nodes[key] = n;
    }
}

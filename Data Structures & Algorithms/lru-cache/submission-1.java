class LRUCache {

    Map<Integer, Node> cache;
    Node head;
    Node tail;
    int size;

    public LRUCache(int capacity) {
        cache = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
        size = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);

        if (node != null) {
            moveToFront(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {

        if (cache.get(key) != null) {
            Node old = cache.get(key);
            old.val = value;
            moveToFront(old);

        } else {
            Node n = new Node(key, value);

            cache.put(key, n);
            addToFront(n);

            if (cache.size() > size) {
                removeLRUEntry();
            }
        }
    }

    private void removeLRUEntry() {
        Node nodeToBeRemoved = tail.prev;

        removeFromList(nodeToBeRemoved);
        cache.remove(nodeToBeRemoved.key);
    }

    private void moveToFront(Node node) {
        removeFromList(node);
        addToFront(node);
    }

    private void removeFromList(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void addToFront(Node node) {
        Node nextToHead = head.next;

        head.next = node;
        node.prev = head;

        node.next = nextToHead;
        nextToHead.prev = node;
    }

    class Node {
        Node prev;
        Node next;
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
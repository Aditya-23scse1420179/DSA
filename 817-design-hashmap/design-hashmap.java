class MyHashMap {
    private static final int SIZE = 10000;
    private List<Node>[] buckets;

    private static class Node {
        int key, value;
        Node(int k, int v) { key = k; value = v; }
    }

    public MyHashMap() {
        buckets = new ArrayList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int h = hash(key);
        for (Node node:buckets[h]) {
            if (node.key ==key) {
                node.value =value; 
                return;
            }
        }
        buckets[h].add(new Node(key, value));
    }

    public int get(int key) {
        int h = hash(key);
        for (Node node: buckets[h]) {
            if (node.key== key)
                return node.value;
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Node> it = buckets[h].iterator();
        while (it.hasNext()) {
            Node node =it.next();
            if (node.key==key) {
                it.remove();
                return;
            }
        }
    }
}

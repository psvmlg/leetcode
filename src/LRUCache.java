import java.util.HashMap;

class LRUCache {

    public static void main(String[] args) {
        LRUCache d = new LRUCache(2);
        d.put(2,1);
        d.put(2,2);
//        System.out.println(d.get(1));
//        d.put(3,3);
        System.out.println(d.get(2));
        d.put(3,2);
        System.out.println(d.get(2));
        System.out.println(d.get(3));
//        System.out.println(d.get(4));

    }

    int cap;
    Node head = null;
    Node tail = null;
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            if (n.key != head.key) {
                if (n.next == null) {
                    tail = n.prev;
                }
                if (n.prev != null) {
                    n.prev.next = n.next;
                }
                if (n.next != null) {
                    n.next.prev = n.prev;
                }
                n.next = head;
                head.prev = n;
                head = n;
            }
            return n.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (head == null) {
            head = new Node(key, value, null, null);
            tail = head;
            map.put(key, head);
        } else if(map.containsKey(key)) {
            Node n = map.get(key);
            if (n.key != head.key) {
                if (n.next == null) {
                    tail = n.prev;
                }
                if (n.prev != null) {
                    n.prev.next = n.next;
                }
                if (n.next != null) {
                    n.next.prev = n.prev;
                }
            }
        } else {
            Node n = new Node(key, value, null, null);
            if (map.size() == cap) {
                map.remove(tail.key);
                n.next = head;
                head.prev = n;
                head = n;
                tail = tail.prev;
                tail.next = null;
                map.put(key, n);
            } else {
                n.next = head;
                head.prev = n;
                head = n;
                map.put(key, n);
            }
        }
    }

    class Node {
        int key;
        int val;
        public Node next;
        public Node prev;

        public Node(int key, int val, Node next, Node prev) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
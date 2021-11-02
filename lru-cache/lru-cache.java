class LRUCache {
    
    class DLNode {
        int key;
        int value;
        DLNode prev;
        DLNode next;
    }
    
    DLNode head;
    DLNode tail;
    Map<Integer, DLNode> map;
    int capacity;
    int cnt;
    

    public LRUCache(int capacity) {
        head = new DLNode();
        tail = new DLNode();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        cnt = 0;
        map = new HashMap<Integer, DLNode>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key).value;
            update(key);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        DLNode curr = new DLNode();
        curr.value = value;
        curr.key = key;
        if (map.containsKey(key)) {
            remove(map.get(key));
            add(curr);
        } else {
            // System.out.println(capacity);
            // System.out.println(cnt);
            if (cnt < capacity) {
                add(curr);
                cnt ++;
            } else {
                map.remove(tail.prev.key);
                remove(tail.prev);
                add(curr);
            }
        }
    }
    
    public void add(DLNode curr) {
        map.put(curr.key, curr);
        DLNode first = head.next;
        head.next = curr;
        curr.next = first;
        curr.prev = head;
        first.prev = curr;
    }
    
    public void update(int key) {
        DLNode curr = map.get(key);
        remove(curr);
        add(curr);
    }

    public void remove(DLNode curr) {
        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
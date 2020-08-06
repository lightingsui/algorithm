package lru;

import java.util.HashMap;

/**
 * 自实现LRU
 *
 * @author ：隋亮亮
 * @since ：2020/8/6 23:00
 */
public class LruMyself<K> {

    private int capacity;

    private HashMap<K, Node> cache;

    private Node<K> head;

    private Node<K> tail;

    public LruMyself(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity * 2);

        head = new Node(null);
        tail = head;
    }

    public boolean put(K key) {
        // 参数判断
        if(key == null) {
            return false;
        }

        // 判断是否在缓存中
        if(cache.containsKey(key)) {
            // - 存在缓存中
            removeNodeToTail(cache.get(key));

        } else {
            // - 不存在缓存中
            Node<K> node = new Node<>(key);

            // 加入到缓存中
            cache.put(key, node);

            // 加入到链表的尾部
            addNode(node);

            // 判断是否超出容量
            if(cache.size() > capacity) {
                // 从链表中移除
                Node<K> delNode = removeHead();

                // 从缓冲中移除
                cache.remove(delNode.val);
            }
        }

        return true;
    }


    public void addNode(Node<K> node) {
        tail.next = node;
        tail = tail.next;
    }

    public Node<K> removeHead() {
        return head = head.next;
    }

    public void removeNodeToTail(Node node) {
        Node<K> tmp = head;
        Node<K> cur = head;

        while((tmp = tmp.next) != null) {
            if (node == tmp) {
                tail.next = tmp;
                cur.next = tmp.next;
                tmp.next = null;
                tail = tmp;
                break;
            }
            cur = tmp;
        }
    }

    public static class Node<K> {
        public K val;
        public Node next;

        public Node(K val) {
            this.val = val;
        }
    }

    @Override
    public String toString() {
        Node<K> node = head;

        while((node = node.next) != null) {
            System.out.println(node.val);
        }
        return null;
    }
}

class LruMyselfTest {
    public static void main(String[] args) {
        LruMyself<String> lru = new LruMyself<>(3);

        lru.put("a");
        lru.put("b");
        lru.put("c");
//        lru.put("d");
//        lru.put("c");
//        lru.put("b");
        lru.put("d");
        lru.put("e");

        System.out.println(lru);
    }
}

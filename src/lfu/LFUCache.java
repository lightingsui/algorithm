package lfu;

import java.util.HashMap;
import java.util.Map;

/**
 * 双端链表（带头尾节点）和哈希表实现
 *
 * @author ：隋亮亮
 * @since ：2020/8/8 15:49
 */
public class LFUCache {
    private int capacity;

    private Node head;
    private Node tail;

    private Map<Integer, Node> cache;

    public LFUCache(int capacity) {
        this.capacity = capacity;

        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;

        cache = new HashMap<>(capacity * 2);
    }

    public Integer put(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            if (cache.size() >= capacity) {
                deleteNode();
            }
            // 创建出来节点加入到cache
            Node addNode = new Node(key, value, 1);
            cache.put(key, addNode);

            // 加入到链表尾部
            Node tmpPre = tail.pre;
            tail.pre = addNode;

            addNode.pre = tmpPre;
            addNode.next = tail;

            tmpPre.next = addNode;
        } else {
            frePlus(node);
            int retValue = node.value;
            node.value = value;

            return retValue;
        }

        return null;
    }

    /**
     * 刷新访问次数，移动链表节点位置
     */
    public void frePlus(Node node) {
        // 增加访问次数
        int count = node.count;
        node.count = ++count;
        count = node.count;

        Node moveNode = node.pre;

        // 移动链表位置
        while (moveNode != null) {
            Node iterator = moveNode;
            if (moveNode.count < count && moveNode != head) {
                // 记录前节点和后节点
                Node moveNodePre = moveNode.pre;
                Node nodeNext = node.next;

                // 修改两个交换节点间的指向
                node.next = moveNode;
                node.pre = moveNodePre;
                moveNode.next = nodeNext;
                moveNode.pre = node;

                // 修改交换节点之前两个左右节点的指向
                nodeNext.pre = moveNode;
                moveNodePre.next = node;
                break;
            }

            moveNode = iterator.pre;
        }
    }

    /**
     * 删除访问次数最少的那个节点
     */
    public void deleteNode() {

        Node tmpPre = tail.pre.pre;
        // 从HashMap中移除
        cache.remove(tmpPre.next.key);

        // 清除待删除节点的指向
        tail.pre.pre = null;
        tail.pre.next = null;

        // 修改尾节点的指向
        tmpPre.next = tail;
        tail.pre = tmpPre;
    }

    @Override
    public String toString() {
        Node tmp = head;

        while ((tmp = tmp.next) != null && tmp != tail) {
            System.out.println("key 为 " + tmp.key + "  value 为 " + tmp.value + "  访问次数为：" + tmp.count);
        }

        return "";
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(3);

        lfu.put(1, 1);
        lfu.put(2, 2);
        lfu.put(3, 3);
        lfu.put(1, 1);
        lfu.put(1, 1);
        lfu.put(4, 4);
        lfu.put(4, 4);
        lfu.put(5, 5);
        lfu.put(5, 5);
        lfu.put(6, 6);

        System.out.println(lfu);
    }
}

class Node {
    public int key;
    public int value;

    public int count;

    public Node pre;
    public Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node(int key, int value, int count) {
        this(key, value);
        this.count = count;
    }
}

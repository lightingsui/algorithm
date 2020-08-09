package lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 双Hash表实现O(1)时间复杂度的LFU
 *
 * @author ：隋亮亮
 * @since ：2020/8/8 20:26
 */
public class LFUDoubleHash {
    private int capacity;

    private int minCapacity;

    private Map<Integer, NodeCache> cache;
    private Map<Integer, LinkedHashSet<NodeCache>> countCache;

    public LFUDoubleHash(int capacity) {
        this.capacity = capacity;

        cache = new HashMap<>(capacity * 2);
        countCache = new HashMap<>(capacity * 2);
    }

    public Integer put(int key, int value) {
        NodeCache nodeCache = cache.get(key);

        if (nodeCache == null) {
            eliminate();

            // 添加到cache、添加到对应countCache中
            NodeCache addNode = new NodeCache(key, value, 1);

            cache.put(key, addNode);

            LinkedHashSet<NodeCache> nodeCaches = countCache.get(1);

            // 此处为待添加的集合为 null，则创建一个
            if (nodeCaches == null) {
                nodeCaches = new LinkedHashSet<>(capacity * 2 / 4);
                countCache.put(1, nodeCaches);
            }

            nodeCaches.add(addNode);
            minCapacity = 1;

        } else {

            int oldVal = nodeCache.value;
            nodeCache.value = value;

            frePlus(key);

            return oldVal;
        }

        return null;
    }

    private void frePlus(int key) {
        NodeCache deleteNode = cache.get(key);
        LinkedHashSet<NodeCache> selectSet = countCache.get(key);
        selectSet.remove(deleteNode);
        int showCount = deleteNode.count;

        if (minCapacity == showCount && selectSet.size() == 0) {
            minCapacity++;
        }

        LinkedHashSet<NodeCache> addCaches = countCache.get(++showCount);

        if (addCaches == null) {
            addCaches = new LinkedHashSet<>();
            countCache.put(showCount, addCaches);
        }

        deleteNode.count = showCount;
        addCaches.add(deleteNode);
    }

    private void eliminate() {
        if (cache.size() < capacity) {
            return;
        }

        LinkedHashSet<NodeCache> tmp = countCache.get(minCapacity);
        NodeCache remove = tmp.iterator().next();

        cache.remove(remove.key);
    }

    @Override
    public String toString() {

        for (Map.Entry<Integer, NodeCache> iterator : cache.entrySet()) {
            NodeCache node = iterator.getValue();

            System.out.println("key: " + node.key  + " value: " + node.value + " count: " + node.count);
        }

        return null;
    }

    public static void main(String[] args) {
        LFUDoubleHash lfu = new LFUDoubleHash(3);

        lfu.put(1, 1);
        lfu.put(2, 2);
        lfu.put(3, 3);
        lfu.put(1, 1);
        lfu.put(4, 4);


        System.out.println(lfu);
    }
}

class NodeCache {
    public int key;
    public int value;
    public int count;

    public NodeCache(int key, int value, int count) {
        this.key = key;
        this.value = value;
        this.count = count;
    }
}

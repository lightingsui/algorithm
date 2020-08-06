package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU使用LinkedHashMap实现
 *
 * @author ：隋亮亮
 * @since ：2020/8/6 22:36
 */
public class LruLinkedHashMap<K, V> {
    private int capacity;
    public LinkedHashMap<K, V> map;

    public LruLinkedHashMap(int initialCapacity) {
        map = new LinkedHashMap<K, V>(initialCapacity * 2, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > initialCapacity;
            }
        };
    }


    public V put(K key, V value) {
        return map.put(key, value);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class LRUTest {
    public static void main(String[] args) {
        LruLinkedHashMap<String, String> lru = new LruLinkedHashMap<>(3);

        lru.put("a", "1");
        lru.put("b", "2");
        lru.put("c", "3");
        lru.put("d", "3");
        lru.put("b", "3");
//        lru.put("e", "4");

        System.out.println(lru.map);
    }
}

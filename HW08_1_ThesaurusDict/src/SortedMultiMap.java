import java.util.*;

public class SortedMultiMap<K,V> {
    private Map<K, Collection<V>> sortedMap = new TreeMap<>();
    /* add value with key in hashmap */
    public void put(K key, V value)
    {
        if (sortedMap.get(key) == null) {
            sortedMap.put(key, new ArrayList<>());
        }
// if entry exists, but not value, then add value
        if (sortedMap.get(key).contains(value) == false) {
            sortedMap.get(key).add(value);
        }
    }
    /* returns a collection of values for key */
    public Collection<V> get(Object key) {
        return sortedMap.get(key);
    }
    /* returns set of keys */
    public Set<K> keySet() {
        return sortedMap.keySet();
    }
    /* returns set of entries */
    public Set<Map.Entry<K, Collection<V>>> entrySet() {
        return sortedMap.entrySet();
    }
    /* returns the collection of values */
    public Collection<Collection<V>> values() {
        return sortedMap.values();
    }
}

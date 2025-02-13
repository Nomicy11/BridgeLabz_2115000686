import java.util.LinkedList;

class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] map;
    private int size;

    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public CustomHashMap() {
        map = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            map[i] = new LinkedList<>();
        }
        size = 0;
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode() % map.length);
    }

    public void put(K key, V value) {
        int index = getHash(key);
        LinkedList<Entry<K, V>> bucket = map[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getHash(key);
        LinkedList<Entry<K, V>> bucket = map[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null; // Key not found
    }

    public void remove(K key) {
        int index = getHash(key);
        LinkedList<Entry<K, V>> bucket = map[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    public void printMap() {
        for (int i = 0; i < map.length; i++) {
            if (!map[i].isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : map[i]) {
                    System.out.print("[" + entry.key + "=" + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();

        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        hashMap.put("four", 4);

        System.out.println("Value for key 'three': " + hashMap.get("three"));
        System.out.println("Contains key 'two'? " + hashMap.containsKey("two"));

        hashMap.remove("two");
        System.out.println("Contains key 'two' after removal? " + hashMap.containsKey("two"));

        System.out.println("HashMap Size: " + hashMap.size());
        hashMap.printMap();
    }
}

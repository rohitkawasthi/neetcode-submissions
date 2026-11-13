class LRUCache {

    private LinkedHashMap<Integer,Integer> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>();;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int value = this.cache.getOrDefault(key, -1);
        if(value != -1) {
            this.cache.remove(key);
            this.cache.put(key, value);
        }
        return value;
    }
    
    public void put(int key, int value) {
        int existingVal = this.get(key);
        if(this.cache.size()==capacity && existingVal==-1) {
            this.cache.remove(this.cache.keySet().iterator().next());
        }
        if(existingVal != -1) {
            this.cache.remove(key);
        }
        this.cache.put(key, value);
    }
}

package org.example.maps;

import java.util.ArrayList;
import java.util.List;

public class OurMap<K, V> {
    private List<MapNode<K, V>> bucket;
    private int capacity;
    private int size;
    private final int INITIAL_CAPACITY = 5;

    public OurMap() {
        bucket = new ArrayList<>();
        capacity = INITIAL_CAPACITY;
        for (int i = 0; i < capacity; i++) {
            bucket.add(null);
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % capacity;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        while(head != null) {
            if(head.key.equals((key)))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public void put(K key, V val) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        while(head != null) {
            if(head.key.equals((key))) {
                head.value = val;
            }
            head = head.next;
        }
        size++;
        MapNode<K, V> newEntry = new MapNode<K, V>(key, val);
        newEntry.next = head;
        bucket.set(bucketIndex, newEntry);
    }

    public void remove(K key) {

    }

    private class MapNode<K, V> {
        K key;
        V value;
        MapNode<K, V> next;

        public MapNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}

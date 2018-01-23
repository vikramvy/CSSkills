package com.test.skills;

import java.util.HashMap;
import java.util.Map;


public class LRUCache<K, V> {
    class Node<T, U> {
        Node<T, U> previous;
        Node<T, U> next;
        T key;
        U value;

        public Node(Node<T, U> previous, Node<T, U> next, T key, U value) {
            this.previous = previous;
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }

    Node<K, V> mostRecentlyUsed;
    Node<K, V> leastRecentlyUsed;
    int maxSize;
    int currentSize;
    Map<K, Node<K, V>> cache;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.cache = new HashMap<>();
        this.mostRecentlyUsed = null;
        this.leastRecentlyUsed = null;
    }

    public V get(K key) {
        //if it isn't cached, leave it
        if(cache.get(key) == null || currentSize == 0) {
            return null;
        }

        //if get the most recently used, don't modify the list
        if(key.equals(mostRecentlyUsed.key)) {
            return mostRecentlyUsed.value;
        }

        //it is in the cache, but not in the beginning
        Node<K, V> hitNode = cache.get(key);

        hitNode.previous.next = hitNode.next;
        if(hitNode.next != null) {
            hitNode.next.previous = hitNode.previous;
        } else {
            leastRecentlyUsed = hitNode.previous;
        }
        hitNode.next = mostRecentlyUsed;
        mostRecentlyUsed.previous = hitNode;
        hitNode.previous = null;
        mostRecentlyUsed = hitNode;

        return hitNode.value;
    }

    public void put(K key, V value) {
        if(cache.containsKey(key)) {
            return;
        }

        Node<K, V> newNode = new Node<>(null, mostRecentlyUsed, key, value);
        cache.put(key, newNode);
        mostRecentlyUsed = newNode;
        if(mostRecentlyUsed.next != null) {
            mostRecentlyUsed.next.previous = mostRecentlyUsed;
        } else {
            leastRecentlyUsed = newNode;
        }

        if(currentSize == maxSize) {
            cache.remove(leastRecentlyUsed.key);
            leastRecentlyUsed.previous.next = null;
            leastRecentlyUsed = leastRecentlyUsed.previous;
        } else {
            currentSize++;
        }
    }

    public void printState() {
        System.out.print("HEAD-> ");
        Node<K, V> head = mostRecentlyUsed;
        while(head != null) {
            System.out.print(String.format(" [%s : %s |  %s  %s], ", head.key, head.value, head.previous, head.next));
            head = head.next;
        }
        System.out.print(" <- TAIL");
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> lru = new LRUCache<>(3);
        lru.put("1", 1);
        lru.put("2", 2);
        lru.put("3", 3);
        lru.printState();

        System.out.println("START GETTING");

        System.out.println(lru.get("3"));
       /* System.out.println(lru.get("2"));
        System.out.println(lru.get("1"));
        System.out.println(lru.get("3"));
        System.out.println(lru.get("3"));
        System.out.println(lru.get("1"));*/
        lru.printState();
        lru.put("4", 4);
        lru.printState();
        System.out.println(lru.get("2"));
       /* System.out.println(lru.get("4"));
        System.out.println(lru.get("3"));

        System.out.println(lru.get("1"));*/
        lru.printState();
    }
}
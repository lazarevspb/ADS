package ru.lazarev.lesson8.hashTable.impl;

import ru.lazarev.lesson8.hashTable.HashTable;

public class ChainHashTableImpl<K, V> implements HashTable<K, V> {

    static class Item<K, V> implements Entry<K, V> {

        private final K key;
        private V value;
        private Item<K, V> next;

        Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        public Item<K, V> getNext() {
            return next;
        }

        public void setNext(Item<K, V> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private final Item<K, V>[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public ChainHashTableImpl(int initialCapacity) {
        this.data = new Item[initialCapacity];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);
        Item<K, V> current = data[index];

        while (current != null) {
            if (current.getKey().equals(key)) {
                current.setValue(value);
                return true;
            }
            current = current.getNext();
        }
        Item<K, V> newItem = new Item<>(key, value);
        newItem.setNext(data[index]);
        data[index] = newItem;
        size++;
        return true;
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        Item<K, V> current = data[index];

        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        Item<K, V> current = data[index];
        Item<K, V> prev = null;

        while (current != null) {
            if (current.getKey().equals(key)) {
                break;
            }
            prev = current;
            current = current.getNext();
        }

        if (current == null) {
            return null;
        }

        V value = current.getValue();

        if (prev == null) {
            data[index] = current.getNext();
        } else {
            prev.setNext(current.getNext());
        }

        current.setNext(null);

        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < data.length; i++) {
            StringBuilder sb = new StringBuilder();
            Item<K, V> current = data[i];
            while (current != null) {
                sb.append(current);
                current = current.getNext();
                if (current != null) {
                    sb.append(" -> ");
                }
            }
            System.out.printf("%d: [%s]%n", i, sb);
        }
    }
}
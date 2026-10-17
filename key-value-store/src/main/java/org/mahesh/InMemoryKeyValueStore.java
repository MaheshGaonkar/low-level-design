package org.mahesh;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class InMemoryKeyValueStore <K, V> {
    /*
    private final Map<K, V> store = new ConcurrentHashMap<>();

    private final  ThreadLocal<Deque<Transaction<K, V>>> txStack = ThreadLocal.withInitial(ArrayDeque::new);

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(K key, V value) {
        //Base62
        Deque<Transaction<K, V>> currentTx = txStack.get();
        if (currentTx.isEmpty()) {
            store.put(key, value);
        } else {

        }
    }

    public V get(K key) {
        return store.get(key);
    }

    public void delete(K key) {
        lock.writeLock().lock();
        try {
            if (!store.containsKey(key)) {
                return;
            }
            recordOriginalValue(key);
            store.remove(key);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void begin() {
        lock.writeLock().lock();
        try {
           // txStack.offer(new Transaction<>());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void commit() {
        lock.writeLock().lock();
        try {
           // if (txStack.isEmpty()) {
           //     throw new RuntimeException("No Active transaction to commit");
           // }

            Transaction<K, V> currentTx = txStack.pop();

            if (!txStack.isEmpty()) {
                Transaction<K, V> parentTx = txStack.peek();
                mergeToParent(parentTx, currentTx);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void rollback() {

    }

    private void mergeToParent(Transaction<K, V> parent, Transaction<K, V> child) {
        for (Map.Entry<K, Change<V>> entry : child.changes.entrySet()) {
            K key = entry.getKey();
            Change<V> change = entry.getValue();
            parent.changes.putIfAbsent(key, change);
        }
    }

    private void recordOriginalValue(K key) {
        if (txStack.isEmpty()) {
            return;
        }

        Transaction<K, V> currentTx = txStack.peek();

        if (currentTx.changes.containsKey(key)) {
            return;
        }

        boolean existedBefore = store.containsKey(key);
        V oldValue = store.get(key);

        Change<V> change = new Change<>(oldValue, existedBefore);
        currentTx.changes.put(key, change);
    }

    public static class Transaction<K, V> {
        private final Map<K, Change<V>> changes = new HashMap<>();
    }

    private static class Change<V> {
        private final V oldValue;
        private final boolean existedBefore;

        public Change(V oldValue, boolean existedBefore) {
            this.oldValue = oldValue;
            this.existedBefore = existedBefore;
        }
    }

     */
}

package com.example.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 * <p>
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache(2);    // 缓存容量为 2
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得关键字 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得关键字 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */
class LRUCache {
    DoublyLinkedNode head;
    DoublyLinkedNode tail;
    Map<Integer, DoublyLinkedNode> map;
    int size;

    public LRUCache(int capacity) {
        head = new DoublyLinkedNode(0);
        tail = new DoublyLinkedNode(0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        size = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoublyLinkedNode node = map.get(key);
            delete(node);
            add(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoublyLinkedNode cur = map.get(key);
            delete(cur);
            cur.val = value;
            add(cur);
        } else {
            DoublyLinkedNode newNode = new DoublyLinkedNode(key, value);
            add(newNode);
            map.put(key, newNode);
        }
    }

    /**
     * 构建双向链表
     */
    private static class DoublyLinkedNode {
        DoublyLinkedNode prev;
        DoublyLinkedNode next;
        int key;
        int val;

        public DoublyLinkedNode(int val) {
            this.val = val;
        }

        public DoublyLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * 删除 LinkedList 和 Map 中的节点
     *
     * @param node 待删除的节点
     */
    private void delete(DoublyLinkedNode node) {
        DoublyLinkedNode prev = node.prev;
        DoublyLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
        map.remove(node.key);
    }

    /**
     * 向 LinkedList 的最前面和 Map 中添加一个节点，并且删除原来的节点
     *
     * @param newNode 待添加的节点
     */
    private void add(DoublyLinkedNode newNode) {
        // 将新创建的节点添加进队列
        insertNodeToQueue(newNode);
        map.put(newNode.key, newNode);
        if (map.size() > size) {    // 缓存满了
            DoublyLinkedNode toBeDelete = tail.prev;
            delete(toBeDelete);
            map.remove(toBeDelete.key);
        }
    }

    /**
     * 向队列的最前面插入一个新的节点
     *
     * @param node 待插入的节点
     */
    private void insertNodeToQueue(DoublyLinkedNode node) {
        // 取出队列中的第一个节点
        DoublyLinkedNode oldFirst = head.next;
        node.next = oldFirst;
        oldFirst.prev = node;
        head.next = node;
        node.prev = head;
    }

    public static void main(String[] args) {
//        LRUCache cache = new LRUCache(2);  // 缓存容量为 2
//        cache.put(1,1);
//        cache.put(2,2);
//        System.out.println(cache.get(1));
//        cache.put(3,3);     // 该操作会使得密钥 2 作废
//        System.out.println(cache.get(2));
//        cache.put(4,4);     // 该操作会使得密钥 1 作废
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));

//        LRUCache cache = new LRUCache(1);  // 缓存容量为 1
//        cache.put(2,1);
//        System.out.println(cache.get(1));

        LRUCache cache = new LRUCache(2);  // 缓存容量为 2
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
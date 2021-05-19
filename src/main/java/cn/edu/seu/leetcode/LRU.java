package cn.edu.seu.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

class Node {
    int key;
    int value;

    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

}

class DoubleNode{
    private Node head, tail;
    private int size;

    public DoubleNode() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addList(Node node){
        // 先连接后部
        node.prev = tail.prev;
        node.next = tail;

        // 在连接前部
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    public void removeFirst(){
        Node remove = head.next;

        remove.next.prev = head;
        head.next = remove.next;
    }
}

public class LRU {
    private int capacity;
    private LinkedList<Node> list;
    private HashMap<Integer, Node> map;

    public LRU(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public Node get(int key){
        Node node = map.get(key);
        if (null == node){
            return null;
        }





        return node;
    }

    public void add(Node node){

    }


}

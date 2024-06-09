package LinkedList;

public class LinkedListNode {
    public int data;
    public LinkedListNode next;
    public LinkedListNode prev;
    public LinkedListNode arbitraryPointer;
    public LinkedListNode(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
        this.arbitraryPointer = null;
    }
}

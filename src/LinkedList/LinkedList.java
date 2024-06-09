package LinkedList;

import java.util.List;

public class LinkedList {

    public LinkedListNode head;

    public LinkedList() {
        this.head = null;
    }

    public void insertHead(int data){
        if(this.head == null){
            this.head = new LinkedListNode(data);
        }
        LinkedListNode newNode = new LinkedListNode(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void insertTail(int data)
    {
        if(this.head == null){
            this.head = new LinkedListNode(data);
        }
        LinkedListNode newNode = new LinkedListNode(data);
        LinkedListNode temp = this.head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }


    public void createLinkedList(List<Integer> lst) {
        for (int i = lst.size() - 1; i >= 0; i--) {
           this.insertHead(lst.get(i));
        }
    }

    public void  displayLinkedList(){
        LinkedListNode temp = this.head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static LinkedListNode reverse(LinkedListNode head){

        if(head == null || head.next == null) {
            return head;
        }

        LinkedListNode listToDo = head.next;
        LinkedListNode reverseList = head;
        reverseList.next = null;

        while(listToDo != null){
            LinkedListNode temp = listToDo;
            listToDo  = listToDo.next;
            temp.next = reverseList;
            reverseList = temp;
        }
        return reverseList;

    }


}

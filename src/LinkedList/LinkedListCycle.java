package LinkedList;

public class LinkedListCycle {

    public static boolean isCycleExisist(LinkedListNode head){

        if(head == null){
            return false;
        }
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow.data == fast.data){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
// Create nodes
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);

        // Link nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Create a cycle for testing: node5 -> node3
        node5.next = node3;

        // Test for cycle
        boolean result = isCycleExisist(node1);
        System.out.println("Cycle exists: " + result); // Output should be true

        // Remove the cycle for testing
        node5.next = null;

        // Test for cycle again
        result = isCycleExisist(node1);
        System.out.println("Cycle exists: " + result); // Output should be false
    }
}

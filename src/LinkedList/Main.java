package LinkedList;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Integer[][] inputs={{29, 23, 82, 11, 4, 3, 21}, {59, 7, -3, 21, 14, 30, 120}};

        for (int i=0; i < inputs.length; i++) {
            LinkedList obj=new LinkedList();
            obj.createLinkedList(Arrays.asList(inputs[i]));

            System.out.print((i + 1) + ". Original list:\t");
            obj.displayLinkedList();

            // Reversing the created linked list
            LinkedList objTmp=new LinkedList();
            objTmp.head= new LinkedList().reverse(obj.head);
            System.out.print("   Reversed list:\t");

            // Display Reversed List
            objTmp.displayLinkedList();
            if (i != inputs.length - 1)
                System.out.println(
                        "-------------------------------------------------------------------------------------------------------\n");
        }
    }
}

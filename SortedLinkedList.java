import java.util.Collections;
import java.util.LinkedList;

public class SortedLinkedList {
    public static void main(String[] args) {
        // Create a linked list
        LinkedList<Integer> list = new LinkedList<>();

        // Add elements to the linked list
        list.add(42);
        list.add(15);
        list.add(8);
        list.add(23);
        list.add(16);

        System.out.println("Original List: " + list);

        // Sort the linked list
        Collections.sort(list);

        // Print the sorted list
        System.out.println("Sorted List: " + list);
    }
}

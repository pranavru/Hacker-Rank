import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the compareLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode curr1 = head1;
        SinglyLinkedListNode curr2 = head2;
        boolean value = true;
        if(curr1 != null && curr2 != null ) {
            if(curr1.data == curr2.data) {
                System.out.println("Line 72 curr1 data " + curr1.data + " curr2 data " + curr2.data + true);
                curr1 = curr1.next;
                curr2 = curr2.next;
                if(curr1 == null || curr2 == null) {
                    return false;
                } else {
                    compareLists(curr1, curr2);
                }
            } else {
                System.out.println("Line 74 curr1 data " + curr1.data + " curr2 data " + curr2.data + false);
                value = false;
            }
        } else if(curr1 == null && curr2 == null) {
            System.out.println("line 83 curr1 " + curr1 + " curr2 " + curr2 + true);
            value = true;
        } else {
            value = true;
        }
        return value;
    }

    private static final Scanner scanner = new Scanner(System.in);

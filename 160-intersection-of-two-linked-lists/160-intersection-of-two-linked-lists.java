/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        
        ListNode a = headA;
        while (a != null) {
            a = a.next;
            lenA++;
        }
        
        ListNode b = headB;
        while (b != null) {
            b = b.next;
            lenB++;
        }
        
        int diff = Math.abs(lenA - lenB);
        if (lenA >= lenB) {
            a = headA;
            b = headB;
        } else {
            a = headB;
            b = headA;
        }
        
        while (diff != 0) {
            a = a.next;
            diff--;
        }
        
        while (b != null) {
            if (a == b) {
                return a;
            } else {
                a = a.next;
                b = b.next;
            }
        }
        return null;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        
        ListNode midNode = getMid(head);
        ListNode reversedSecond = reverse(midNode.next);
    
        
        while (reversedSecond != null) {
            if (head.val != reversedSecond.val)
                return false;
            
            head = head.next;
            reversedSecond = reversedSecond.next;
        }
        
        return true;
    }
    
    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        
        while (head != null) {
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }
        
        return prev;
    }
}
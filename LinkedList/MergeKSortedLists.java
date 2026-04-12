Leetcode - 23 Using PriorityQueue
  Brute : O(n logn)
    class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(ListNode ele : lists) {
            while(ele != null) {
                pq.add(ele.val);
                ele = ele.next;
            }
        }

        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(!pq.isEmpty()) {
            ListNode remove = new ListNode(pq.remove());
            temp.next = remove;
            temp = temp.next;
        }

        return head.next;
    }
}

Optimal : O(nlogk)
  class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode ele : lists) {
            if(ele != null) pq.add(ele);
        }

        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(!pq.isEmpty()) {
            ListNode remove = pq.remove();
            if(remove != null) {
                if(remove.next != null) pq.add(remove.next);
                remove.next = null;
                temp.next = remove;
                temp = temp.next;
            }
        }

        return head.next;
    }
}
  

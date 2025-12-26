Leetcode - 2058

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1,-1};
        if(head.next.next == null) return ans;
        int size = 1;
        ListNode temp = head.next;
        ListNode t = head;
        int fidx = -1;
        int lidx = -1;
        int min = Integer.MAX_VALUE;
        int dist = Integer.MAX_VALUE;
        while(temp.next != null){
            if((temp.val>t.val && temp.val>temp.next.val) || (temp.val<t.val && temp.val<temp.next.val)){
                if(fidx == -1){
                    fidx = size;
                }
                if(lidx != -1) dist = size - lidx;
                min = Math.min(dist,min);
                lidx = size;
        }
            t = t.next;
            temp = temp.next;
            size++;
        }
        if(fidx == -1 || fidx == lidx) {
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        if(min == Integer.MAX_VALUE) min = -1;
        ans[0] = min;
        ans[1] = lidx - fidx;
        return ans;
    }
}

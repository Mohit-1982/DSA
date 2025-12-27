Leetcode - 2487
Approach 1 :
class Solution {
    public ListNode removeNodes(ListNode head) {
if(head == null || head.next == null) return head;
        head = rev(head);
        ListNode temp = head.next;
        ListNode t = head;
        while(temp != null){
            if(temp.val < t.val){
                temp = temp.next;
            }else{
                t.next = temp;
                t = t.next;
                temp = temp.next;
            }
        }
        t.next = null;
        head = rev(head);
        return head;
    }
    ListNode rev(ListNode head){
        ListNode f = null;
        ListNode c = head;
        ListNode p = null;
        while(c != null){
            f = c.next;
            c.next = p;
            p = c;
            c = f;
        }
        return p;
    }
}


-------------------------------------------------------------------------------------------------------------------------------
Approach 2 :

class Solution {
    public ListNode removeNodes(ListNode head) {
        //solve using reverse as well as stack method
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            while(st.size() > 0 && st.peek().val < temp.val){ 
                        st.pop();
                    }
                    st.push(temp);
                    temp = temp.next;
                }
        temp = null;
        while(st.size() > 0){
            ListNode t = st.pop();
            t.next = temp;
            temp = t;
        }
        return temp;
    }
}

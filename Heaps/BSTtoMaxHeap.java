GFG

  Approach 1 : Tc -- > n(logn) Sc -- > O(n) NOT very OPTIMAL

  class Solution {
    public static void convertToMaxHeapUtil(Node root) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        helper(root,pq);
        Convert(root,pq);
    }
    public static void helper(Node root,PriorityQueue<Integer> pq) {
        if(root == null) return;
        pq.add(root.data);
        helper(root.left,pq);
        helper(root.right,pq);
    }
    public static void Convert(Node root,PriorityQueue<Integer> pq) {
        if(root == null) return;
        if(root!=null) {
            root.data = pq.remove();
        }
        Convert(root.right,pq);
        Convert(root.left,pq);
    }
}

Approach 2 : 
Tc -- > O(n)    Sc -- > O(n)

  class Solution {
    static int i;
    public static void convertToMaxHeapUtil(Node root) {
        i = 0;
        ArrayList<Integer> list = new ArrayList<>();
        InOrder(root,list);
        PostOrder(root,list);
    }
    public static void InOrder(Node root,ArrayList<Integer> list) {
        if(root == null) return;
        InOrder(root.left,list);
        list.add(root.data);
        InOrder(root.right,list);
    }
    public static void PostOrder(Node root,ArrayList<Integer> list) {
        if(root ==null) return;
        PostOrder(root.left,list);
        PostOrder(root.right,list);
        root.data = list.get(i++);
    }
}

GFG

  class Solution {
    public ArrayList<Integer> kLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<nums.length;i++) {
            pq.offer(nums[i]);
            if(pq.size() > k) pq.remove();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<k;i++) {
            ans.add(pq.remove());
        }
        Collections.reverse(ans);
        return ans;
    }
}

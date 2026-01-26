//Brute >>>> using queue
class Solution {
    public static ArrayList<ArrayList<Integer>> binTreeSortedLevels(int arr[], int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        q.add(arr[0]);
        int j = 1;
        while(!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int level = q.size();
            for(int i = 0;i < level;i++) {
                list.add(q.peek());
                if(j < n) q.add(arr[j++]);
                if(j < n) q.add(arr[j++]);
                q.remove(q.peek());
            }
            Collections.sort(list);
            ans.add(list);
        }
        return ans;
    }
}


//Optimal 
Without queue

  

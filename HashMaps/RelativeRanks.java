Leetcode - 506
  Brute : 
    class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] arr = new int[score.length];
        for(int i = 0; i < score.length; i++) {
            arr[i] = score[i];
        }
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], arr.length - i);
        }
        String[] res = new String[score.length];
        int k = 0;
        for(int i = 0; i < score.length; i++) {
            int ele = map.get(score[i]);
            if(ele == 1) res[k++] = "Gold Medal";
            else if(ele == 2) res[k++] = "Silver Medal";
            else if(ele == 3) res[k++] = "Bronze Medal";
            else res[k++] = "" + ele;
        }
        return res;
    }
}

Optimal ; 
  class Solution {
    public String[] findRelativeRanks(int[] score) {
        //Better to use PriorityQueue Approach
        int maxScore = -1;
        for(int ele : score) {
            maxScore = Math.max(maxScore, ele); 
        }
        int[] arr = new int[maxScore + 1];
        Arrays.fill(arr, -1);
        for(int i = 0; i < score.length; i++) {
            arr[score[i]] = i;
        }
        int j = arr.length - 1;
        int k = 0;
        String[] res = new String[score.length];
        while(j >= 0) {
            if(arr[j] == -1) {
                j--;
                continue;
            }else if(k == 0) res[arr[j]] = "Gold Medal";
            else if(k == 1) res[arr[j]] = "Silver Medal";
            else if(k == 2) res[arr[j]] = "Bronze Medal";
            else res[arr[j]] = "" + (k + 1);
            k++; 
            j--;
        }
        return res;
    }
}

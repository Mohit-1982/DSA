GFG
  Brute : 
    class Solution {
    static ArrayList<Integer> list;
    public ArrayList<Integer> largestSubset(int[] arr) {
        Arrays.sort(arr);
        list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        genComb(arr, 0, -1, res);
        return list;
    }
    public void genComb(int[] arr, int i, int prev, ArrayList<Integer> res) {
        if(i == arr.length) {
            if(list.size() <= res.size()) list = new ArrayList<>(res);
            return;
        }
        if(prev == -1 || arr[i] % arr[prev] == 0) {
            res.add(arr[i]);
            genComb(arr, i + 1, i, res);
            res.remove(res.size() - 1);
        }
        genComb(arr, i + 1, prev, res);
    }
}
Better : 
  

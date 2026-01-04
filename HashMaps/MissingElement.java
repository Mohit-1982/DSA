class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < arr.length; i++) {
            set.add(arr[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = low;i<=high; i++) {
            if(!set.contains(i)) list.add(i);
        }
        return list;
    }
}

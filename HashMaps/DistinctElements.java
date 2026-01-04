// User function Template for Java
class Solution {
    static int distinct(int arr[]) {
        // HashSet<Integer> set = new HashSet<>();
        // for(int i = 0;i<arr.length;i++) {
        //     set.add(arr[i]);
        // }
        // return set.size();
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        for(i = 0;i<arr.length-1;i++) {
            if(arr[i] != arr[i+1]) list.add(arr[i]);
        }
        list.add(arr[i]);
        return list.size();
    }
}

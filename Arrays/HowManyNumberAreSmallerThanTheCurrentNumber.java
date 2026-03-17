Leetcode - 1365
  Brute : 
    class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            for(int j = 0;j < nums.length; j++) {
                if(j != i && nums[i] > nums[j]) count++;
            }
            arr[i] = count;
        }
        return arr;
    }
}
  Better : 
    class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //solve using merge sort and also with counting sort
        //merge sort
        int[] arr = new int[nums.length];
        for(int i = 0; i < arr.length; i++) arr[i] = nums[i];
        mergeSort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        for(int i = 0; i < arr.length; i++) {
            if(i != 0 && arr[i] != arr[i - 1]) {
                map.put(arr[i], i);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
    public void mergeSort(int[] arr) {
        int n = arr.length;
        if(n <= 1) return;
        int[] a = new int[n / 2];
        int[] b = new int[n - n / 2];
        int k = 0;
        for(int i = 0; i < a.length; i++) {
            a[i] = arr[k++];
        }
        for(int j = 0; j < b.length; j++) {
            b[j] = arr[k++];
        }
        mergeSort(a);
        mergeSort(b);
        merge(a, b, arr);
    }
    public void merge(int[] a, int[] b, int[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]) arr[k++] = a[i++];
            else arr[k++] = b[j++]; 
        }
        while(i < a.length) arr[k++] = a[i++];
        while(j < b.length) arr[k++] = b[j++];
    }
}
Optimal :   
  class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[101];
        for(int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            for(int j = 0; j < nums[i]; j++) {
                if(arr[j] > 0) count += arr[j];
            }
            nums[i] = count;
        }
        return nums;
    }
}
More Optimal : 
    class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[101];
        for(int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        //prefix sum compute
        for(int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) nums[i] = arr[nums[i] - 1];
        }
        return nums;
    }
}

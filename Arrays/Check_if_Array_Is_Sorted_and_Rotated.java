Leetcode - 1752
  Brute : 
    class Solution {
    static boolean check(int[] nums) {
        int k = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                k = i + 1;
                break;
            }
        }

        if (k == 0) return true;

        int i = 0;
        int[] arr = new int[n];
        for (int ele : nums) {
            arr[i++] = ele;
        }

        Arrays.sort(arr);

        k = n - k - 1;
        //reverse
        i = 0;
        int j = k;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        i = k + 1;
        j = n - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        i = 0;
        j = n - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        for (i = 0; i < n; i++) {
            if (arr[i] != nums[i]) return false;
        }

        return true;
    }
}

Optimal : 
  class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) count++;
        }

        if (nums[0] < nums[n - 1]) count++;

        return (count <= 1);
    }
}

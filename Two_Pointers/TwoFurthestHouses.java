Leetcode - 2078
  class Solution {
    public int maxDistance(int[] colors) {
        int i = 0;
        int j = colors.length - 1;
        int max1 = 0;
        int max2 = 0;

        while (i < j) {
            if (colors[i] == colors[j]) {
                i++;
            }else {
                max1 = j - i;
                break;
            }
        }

        i = 0;
        j = colors.length - 1;
        while (i < j) {
            if (colors[i] == colors[j]) {
                j--;
            }else {
                max2 = j - i;
                break;
            }
        }

        return Math.max(max1, max2);
    }
}

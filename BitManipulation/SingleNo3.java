Leetcode - 260

  //Method 1 Using Hashmap or hashset
//Method 2 :
class Solution {
    public int[] singleNumber(int[] nums) {
        int b1 = 0;
        int b2 = 0;
        int xor = 0;
        for(int i = 0;i<nums.length;i++) {
            xor ^= nums[i];
        }
        int mask = (xor & (xor-1)) ^ xor;
        for(int i = 0;i<nums.length;i++) {
            if((nums[i] & mask) == 0) {
                b1 ^= nums[i];
            }else b2 ^= nums[i];
        }
        return new int[]{b1,b2};
    }
}

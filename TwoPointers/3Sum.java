Leetcode - 15
  Brute : 
using Hashset and 3 nested loops 
    class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                for(int k = j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        set.add(list);//here we are using set so what it will do it will remove all the duplicates if exist
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}

Optimal :
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i < nums.length-2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
            int sum = 0 - nums[i];
            int s = i + 1;
            int e = nums.length - 1;
            while(s < e) {
                List<Integer> list = new ArrayList<>();
                if(nums[s] + nums[e] == sum) {
                    list.add(nums[s]);
                    list.add(nums[e]);
                    list.add(sum * (-1));
                    ans.add(list);

                    while(s < e && nums[s] == nums[s + 1]) s++;
                    while(s < e && nums[e] == nums[e - 1]) e--;
                    s++; e--;

                }else if(nums[s] + nums[e] < sum) s++;
                else e--;
            }
        }
        }
        return ans;
    }
}

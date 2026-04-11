class Solution {
    public int minimumDistance(int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        for(int num : map.keySet()) {
            if(map.get(num).size() >= 3) {
                List<Integer> list = map.get(num);
                int k = 3;
                for(int i = 0; i < list.size(); i++) {
                    if(i + k > list.size()) break;
                    int a = list.get(i);
                    int b = list.get(i + 1);
                    int c = list.get(i + 2);
                    int dist = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);
                    res = Math.min(res, dist);
                }
            }
        }

        return (res != Integer.MAX_VALUE) ? res : -1;
    }
}

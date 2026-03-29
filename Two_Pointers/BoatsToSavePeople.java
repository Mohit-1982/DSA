Leetcode - 881
  class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int minBoat = 0;
        while(i < j) {
            if(people[i] + people[j] > limit) {
                minBoat++;
                j--;
            }else {
                minBoat++;
                i++;
                j--;
            }
        }
        if(i == j) minBoat++;
        return minBoat;
    }
}

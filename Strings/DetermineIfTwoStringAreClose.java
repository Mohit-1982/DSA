Leetcode - 1657
  class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int[] arr = new int[26];
        for(int i = 0; i < word1.length(); i++) {
            arr[word1.charAt(i) - 'a']++;
        }
        int[] arr1 = new int[26];
        for(int i = 0; i < word2.length(); i++) {
            arr1[word2.charAt(i) - 'a']++;
        }
        //same character check
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0 && arr1[i] == 0) return false;
            if(arr[i] == 0 && arr1[i] > 0) return false;
        }
        Arrays.sort(arr);
        Arrays.sort(arr1);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != arr1[i]) return false;
        }
        return true;
    }
}

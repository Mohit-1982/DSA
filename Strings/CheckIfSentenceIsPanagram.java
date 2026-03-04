Leetcode - 1832
  Brute :
    class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            set.add(ch - 'a');
        }
        return (set.size() == 26);
    }
}
Optimal : 
  class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        for(int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            arr[ch - 'a']++;
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) return false;
        }
        return true;
    }
}

More Optimal : 
    class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        int count = 0;
        for(int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            arr[ch - 'a']++;
            if(arr[ch - 'a'] == 1) count++;
        }
        return count == 26;
    }
}

Bitmask : 
  class Solution {
    public boolean checkIfPangram(String sentence) {
        int BitMask = 0;
        for(int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            //this will make the bit 1 
            BitMask = BitMask | (1 << (ch - 'a'));
        }
        // if bitmask will contains 26 one bits then it is a panagram
        return BitMask == (1 << 26) - 1;
    }
}

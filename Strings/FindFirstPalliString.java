Leetcode - 2108
  Brute : 
class Solution {
    public String firstPalindrome(String[] words) {
        int idx = 0;
        String ans = "";
        return isPalli(words,idx,ans);
    }
    public String isPalli(String[] words,int idx,String ans) {
        //Base Case
        if(idx == words.length) {
            return ans;
        }
        //if Already we have a ans just return it back
        if(!ans.isEmpty()) {
            return ans;
        }
        //check
        String str = words[idx];
        int i = 0;
        int j = str.length() - 1;
        boolean flag = true;
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                flag = false;
                break;
            }
            i++;
            j--;
        }
        if(flag == true) {
            ans = str;
            return ans;
        }else {
            return isPalli(words,idx + 1,ans);
        }
    }
}

Optimal : 
  class Solution {
    public String firstPalindrome(String[] words) {
        //Time complexity --> O(n.m)
        //Here n is array length and m is length of string we are checking
        //Space Complexity --> O(1)
        for(String str : words) {
            if(isPalli(str)) {
                return str;
            }
        }
        return "";
    }
    public boolean isPalli(String str) {
        int i = 0;
        int j = str.length() - 1;
        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

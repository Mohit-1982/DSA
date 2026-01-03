Leetcode - 17

class Solution {
    public List<String> letterCombinations(String digits) {
        String[] arr = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
       List<String> ans =  Combi(arr,digits);
       return ans;
    }
    public List<String> Combi(String[] arr,String Digstr) {
            if(Digstr.length() == 0) {
                List<String> res = new ArrayList<>();
                res.add("");
                return res;
            }
            char ch = Digstr.charAt(0);
            List<String> list = Combi(arr,Digstr.substring(1));
            String len = arr[ch - '0'];
            List<String> ans = new ArrayList<>();
            for(int i = 0;i<len.length();i++) {
                char add = len.charAt(i); 
                for(String rstr : list) {
                    ans.add(add + rstr);
                }
            }
            return ans;
    }
}

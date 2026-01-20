GFG
  Complex Answer :
  class Solution {
    public ArrayList<String> possibleWords(int[] arr) {
        ArrayList<String> list = new ArrayList<>();
        String[] nums = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> ans = generate(arr,nums,list,0);
        return ans;
    }
    public ArrayList<String> generate(int[] arr, String[] nums, ArrayList<String> list, int idx) {
        if(idx == arr.length) {
            return new ArrayList<>();//return empty arrayList
        }
        ArrayList<String> ans = generate(arr,nums,list,idx+1);//this will give the answer for eg arr is [2,3] it will give for 3 then we will combine it with values at 2
        ArrayList<String> str = new ArrayList<>();
        for(int i = 0;i < nums[arr[idx]].length();i++) {
            char ch = nums[arr[idx]].charAt(i);
            if(ans.size() < nums[arr[idx]].length()-1) {
                str.add(ch + "");
            }
            else {
                for (int j = 0; j < ans.size(); j++) {
                    str.add(ch + ans.get(j));
                }
            }
        }
        if(str.isEmpty()) return ans;
        else return str;
    }
}

Better :

  //String ke ek ek character uthao list me daalo
class Solution {
    public ArrayList<String> possibleWords(int[] arr) {
        String[] nums = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        return generate(arr,nums,0);
    }
    
    public ArrayList<String> generate(int[] arr, String[] nums, int idx) {
        if(idx == arr.length) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;//return list with a empty string as it is one way if we dont have any word we can form one word which is empty word
        }
        ArrayList<String> ans = generate(arr,nums,idx+1);//this will give the answer for eg arr is [2,3] it will give for 3 then we will combine it with values at 2
        ArrayList<String> str = new ArrayList<>();
        for(int i = 0;i < nums[arr[idx]].length();i++) {
            char ch = nums[arr[idx]].charAt(i);
            for (String ele : ans) {
                str.add(ch + ele);
            }
        }
        if(str.isEmpty()) return ans;
        else return str;
    }
}

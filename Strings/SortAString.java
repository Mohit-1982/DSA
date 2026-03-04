GFG
  Brute : 
    class Solution {
    String sort(String s) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return new String(arr);
    }
}
Optimal :
//counting sort
class Solution {
    String sort(String s) {
        //Counting Sort
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        String res = "";
        for(int i = 0; i < 26; i++) {
            if(arr[i] != 0) {
                for(int j = 0; j < arr[i]; j++) {
                    res += (char) (i + 'a');
                }
            }
        }
        return res;
    }
}

Leetcode - 1324
  Brute : 
    class Solution {
    public List<String> printVertically(String s) {
        //1.Matrix
        //2.Store every word in a list then add one by one 1, 2 , 3 char from it using nested loops.
        int words = 0;
        int maxLen = 0;
        int i = 0;
        int j = 0;
        int n = s.length();
        while(i < n) {
            j = i;
            boolean wordF = false;
            while(j < n && s.charAt(j) != ' ') {
                if(!wordF) wordF = true;
                j++;
            }
            if(wordF) words++;
            maxLen = Math.max(maxLen, j - i);
            i = j + 1;
        }
        if(i < n) {
            words++;
            maxLen = Math.max(maxLen, j - i);
        }
        char[][] arr = new char[words][maxLen];
        for(char[] row : arr) Arrays.fill(row, ' ');
        int k = 0;
        for(i = 0; i < arr.length; i++) {
            for(j = 0; j < arr[0].length; j++) {
                if(k >= n || s.charAt(k) == ' ') break;
                arr[i][j] = s.charAt(k);
                k++;
            }
            k++;
        }
        List<String> res = new ArrayList<>();
        for(int col = 0; col < arr[0].length; col++) {
            StringBuilder sb = new StringBuilder();
            for(int row = 0; row < arr.length; row++) {
                if(arr[row][col] == ' ') sb.append(" ");
                else sb.append(arr[row][col]);
            }
            while(sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1); 
            res.add(sb.toString());
        }
        return res;
    }
}

Optimal : 
  class Solution {
    public List<String> printVertically(String s) {
        List<String> list = new ArrayList<>();
        int maxLen = 0;
        int n = s.length();
        int i = 0;
        while(i < n) {
            int j = i;
            StringBuilder sb = new StringBuilder();
            while(j < n && s.charAt(j) != ' ') {
                sb.append(s.charAt(j));
                j++;
            }
            maxLen = Math.max(maxLen, j - i);
            i = j + 1;
            list.add(sb.toString());
        }
        List<String> res = new ArrayList<>();
        for(i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < list.size(); j++) {
                if(list.get(j).length() > i) sb.append(list.get(j).charAt(i));
                else sb.append(" ");
            }
            while(sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
        }
        return res;
    }
}

GFG
  class Solution {
    public String reverseWords(String s) {
        int j = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(j >= 0 && s.charAt(j) == '.') j--;
        int i = j + 1;
        while(j >= 0) {
            while(j >= 0 && s.charAt(j) != '.') j--;
            sb.append(s.substring(j + 1, i));
            sb.append(".");
            while(j >= 0 && s.charAt(j) == '.') j--;
            i = j + 1;
        }
        while(!sb.isEmpty() && sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

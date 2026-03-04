Leetcode - 1544
  Optimal :
    class Solution {
    public String makeGood(String s) {
        if(s.length() == 1) return s;
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i != n) {
            char ch = s.charAt(i);
            if(!st.isEmpty() && (st.peek() == (ch + 32) || st.peek() == (ch - 32))) {
                st.pop();
            }else {
                st.push(ch);
            }
            i++;
        } 
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}

More Readable : 
    class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        //We are going to think stringbuilder as a stack
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);
            if(sb.length() > 0 && Math.abs(sb.charAt(sb.length() - 1) - ch) == 32) {
                sb.deleteCharAt(sb.length() - 1);
            }else {
                sb.append(ch);
            }
            i++;
        }
        return sb.toString();
    }
}

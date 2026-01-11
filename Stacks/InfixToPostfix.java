package Stack;

import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
        String s = "a^b^c";
        Stack<Character> st = new Stack<>();
        int i = 0;
        String ans = "";
        while (i < s.length()) {
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
                ans += ch;
            }else if(ch == '(') {
                st.push(ch);
            }else if(ch == ')') {
                while(st.peek() != '(') {
                    ans += st.pop();
                }
                st.pop();
            }else {
                while(!st.isEmpty() && (priority(ch) < priority(st.peek()) || (priority(ch) == priority(st.peek()) && ch != '^'))) {
                    ans += st.pop();
                }
                st.push(ch);
            }
            i++;
        }
        while(!st.isEmpty()) {
            ans += st.pop();
        }
        System.out.println(ans);
    }
    static int priority(char ch) {
        if(ch == '^') return 3;
        else if(ch == '*' || ch == '/') return 2;
        else if(ch == '+' || ch == '-') return 1;
        else return 0;
    }
}

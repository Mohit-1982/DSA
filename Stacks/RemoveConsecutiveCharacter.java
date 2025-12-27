

// In Java, Stack prints values from bottom to top when iterated because Stack extends Vector.
// Vector stores elements like a list (indexed order).
// Stack operations such as push, pop, and peek work on the top element,
// but when we iterate over the stack (for-each loop),
// it reads elements from bottom to top (index 0 to last).

class Solution {
    public String removeConsecutiveCharacter(String s) {
        Stack<Character> st = new Stack<>();
        // Stack<Character> st2 = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(st.size() == 0) st.push(ch);
            else{
                char top = st.peek();
                if(ch != top){
                    st.push(ch);
                }
            }
        }
        // while(st.size()>0) st2.push(st.pop());
        StringBuilder sb = new StringBuilder();
        for(char c : st){
            sb.append(c);
        }
        return sb.toString();
    }
}

Leetcode - 20

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        if(s.length() %2 != 0) return false;

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{') st.push(ch);
            else{
                if(st.size() == 0) return false;
                char open = st.peek();
                if(sameStyle(open,ch)){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return (st.size() == 0);
    }
    public boolean sameStyle(char open,char close){
        if(open=='(' && close==')') return true;
        if(open=='[' && close==']') return true;
        if(open=='{' && close=='}') return true;
        return false;
    }
}






Same Approach just GFG solution

    class Solution {
    public boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        if(s.length() % 2 != 0) return false;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{') st.push(ch);
            else{
                if(st.size() == 0) return false;
                char open = st.peek();
                if(pair(ch,open)) st.pop();
                else return false;
            }
        }
        return (st.size()==0); //if size is zero it will return true else false;
    }
    public boolean pair(char close,char open){
        if(open=='(' && close==')') return true;
        if(open=='[' && close==']') return true;
        if(open=='{' && close=='}') return true;
        return false;
    }
}


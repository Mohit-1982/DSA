import java.util.*;
class Main {
    public static void main(String[] args) {
        String str = "Mohit";
        helper(str, "", 0, 0);
    }
    static void helper(String str, String p, int i, int count) {
        if(i == str.length()) {
            if(count > 0) System.out.println(p + count);
            else System.out.println(p);
            return;
        }
        if(count == 0) {
            helper(str, p + str.charAt(i), i + 1, count);
        }else {
            helper(str, p + count + str.charAt(i), i + 1, 0);
        }
        helper(str, p, i + 1, count + 1);
    }
}

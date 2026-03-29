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

*2nd Method : 
    import java.util.*;
class Main {
    public static void main(String[] args) {
        String s = "Mohit";
        int len = s.length();
        int n = 1 << s.length();
        for(int i = 0; i < n; i++) {
            int count = 0;
            String p = "";
            int j = 0;
            while(j < len) {
                if(((i >> j) & 1) == 0) {
                    if(count != 0){
                         p = p + count + s.charAt(j);
                         count = 0;
                    }
                    else p = p + s.charAt(j);
                }
                else count++;
                j++;
            }
            if(count != 0) {
                p = p + count;
            }
            System.out.println(p);
        }
    }
}

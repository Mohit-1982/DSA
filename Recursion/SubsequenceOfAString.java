import java.util.ArrayList;

public class Subseuences {
    public static void main(String[] args) {
//       subse("abc","");
        ArrayList<String> ans = subseRet("abc","");
        System.out.println(ans);
    }

    static void subse(String p,String up) {
        if(p.isEmpty()) {
            System.out.print(up + " ");
            return;
        }
        char ch = p.charAt(0);
        subse(p.substring(1),up + ch);
        subse(p.substring(1),up);
    }

    static ArrayList<String> subseRet(String p,String up) {
        if(p.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(up);
            return list;
        }
        char ch = p.charAt(0);
        ArrayList<String> left = subseRet(p.substring(1),up + ch);
        ArrayList<String> right = subseRet(p.substring(1),up);

        left.addAll(right);
        return left;
    }
}

public class PrintPermutation {
    public static void main(String[] args) {
        permutation("","abc");
    }
    static void permutation(String p,String up) {
        if(up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }
        for (int i = 0; i < up.length(); i++) {
            char ch = up.charAt(i);
            String leftPart = up.substring(0,i);
            String rightPart = up.substring(i+1);
            String stringSoFar = leftPart + rightPart;
            permutation(p+ch,stringSoFar);
        }
    }
}

public class PrintEncodings {
    public static void main(String[] args) {
        String[] str = {"","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        printEncode("103","",str);
    }
    static void printEncode(String up,String p,String[] arr) {
        if(up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }
        if(up.charAt(0) == '0') {
            return;
        }
        int idx = Integer.parseInt("" + up.charAt(0));
            printEncode(up.substring(1),p + arr[idx],arr);
        if(up.length() >= 2) {
            String sh = "" + up.charAt(0) + up.charAt(1);
            int idx1 = Integer.parseInt(sh);
            if(idx1 <= 26) printEncode(up.substring(2),p + arr[idx1],arr);
        }
    }
}

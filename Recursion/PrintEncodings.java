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

//Count Encodings

public class CountEncodings {
    public static void main(String[] args) {
        String[] arr = {"","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        System.out.println(encodings("123",arr,0));
    }
        public int encodingsLittleOptimal(String str) {
            if(str.isEmpty()) {
                return 1;
            }
            if(str.charAt(0) == '0') {
                return 0;
            }
            int one = encodingsLittleOptimal(str.substring(1));
            int two = 0;
            if(str.length() >= 2) {
                String sh = "" + str.charAt(0) + str.charAt(1);
                int idx1 = (str.charAt(0) - '0') * 10 + (str.charAt(1) - '0');
                if(idx1 <= 26) {
                    two = encodingsLittleOptimal(str.substring(2));
                }
            }
            return one + two;
        }
        
    static int encodings(String str,String[] arr,int count) {
        if(str.isEmpty()) {
            return 1;
        }
        if(str.charAt(0) == '0') {
            return 0;
        }
        int idx = Integer.parseInt("" + str.charAt(0));
        int one = count + encodings(str.substring(1),arr,count);
        int two = 0;
        if(str.length() >= 2) {
            String sh = "" + str.charAt(0) + str.charAt(1);
            int idx1 = Integer.parseInt(sh);
            if(idx1 <= 26) {
                two = count + encodings(str.substring(2), arr, count);
            }
        }
        return one + two;
    }
}



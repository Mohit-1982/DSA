public class SkipWord {
    public static void main(String[] args) {
        System.out.println(skipWor("badappleinmouth"));
    }
    static String skipWor(String p) {
        if(p.isEmpty()) {
            return "";
        }

        if(p.startsWith("apple")) {
            return skipWor(p.substring(5));
        }
        else {
            return p.charAt(0) + skipWor(p.substring(1));
        }
    }
}

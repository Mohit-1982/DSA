public class ClearKthBit {
    public static void main(String[] args) {
        int n = 11011;
        int k = 2;
//        System.out.println(n & ( ~ ( 1<<k ) ) );
        System.out.println(n ^ (1<<k)); // we cant apply this because if bit is already zero this will fail this is good for toggle
    }
}

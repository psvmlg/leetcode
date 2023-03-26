import java.util.HashSet;

public class FindGCD {

    public static void main(String[] args) {
        System.out.println(gcd(1, 10));
    }

    public static int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }

    public static long solution(long n) {
        if (n == 0) {
            return 0;
        }
        long[] count = new long[(int) (n + 1)];
        count[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[(int) n];
    }
}

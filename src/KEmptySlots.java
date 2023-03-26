import org.checkerframework.checker.units.qual.K;

public class KEmptySlots {

    public static void main(String[] args) {
        KEmptySlots k = new KEmptySlots();

        //k.kEmptySlots(new int[]{1, 4, 7, 5, 6, 8, 2, 3}, 1);
        k.kEmptySlots(new int[]{1, 4, 2, 3}, 2);
    }

    public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length;
        int[] position = new int[n + 1];
        for (int i = 0; i < n; i++) {
            position[flowers[i]] = i;
        }

        int res = Integer.MAX_VALUE;
        int lo = 1, hi = 2 + k;
        for (int i = 1; hi <= n; i++) {
            if (position[i] > position[lo] && position[i] > position[hi]) {
                continue;
            }

            if (i == hi) {
                res = Math.min(res, Math.max(position[lo], position[hi]) + 1);
            }

            lo = i;
            hi = i + k + 1;
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
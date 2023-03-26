public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas s = new KokoEatingBananas();
        s.minEatingSpeed(new int[]{3,6,7,11}, 8);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        int low = 1;
        int high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canEatbananas(piles, mid, h)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }

    public boolean canEatbananas(int[] piles, int count, int h) {
        int ans = 0;
        for (int i = 0; i < piles.length; i++) {
            int rem = piles[i] % count;
            if (rem == 0) {
                ans += piles[i]/count;
            } else {
                ans += piles[i]/count;
                ans += 1;
            }
        }
        return ans <= h;
    }
}

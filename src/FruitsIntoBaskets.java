import java.util.HashMap;

public class FruitsIntoBaskets {

    public static void main(String[] args) {
        FruitsIntoBaskets f = new FruitsIntoBaskets();

        f.totalFruit(new int[]{0, 1, 2, 2});
    }

    public int totalFruit(int[] fruits) {

        char f = '1';
        Integer.parseInt(String.valueOf(f));
        int left = 0;
        int maxValue = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) <= 0) {
                    map.remove(fruits[left]);
                }
                left += 1;
            }
            maxValue = Math.max(maxValue, i - left + 1);
        }
        return maxValue;
    }
}

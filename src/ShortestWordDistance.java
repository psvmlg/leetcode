class ShortestWordDistance {
    public int shortestDistance(String[] arr, String word1, String word2) {

        int word1Match = -1;
        int word2Match = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(word1)) {
                word1Match = i;
                if (word2Match != -1) {
                    minDistance = Math.min(minDistance, Math.abs(word1Match - word2Match));
                }
            } else if (arr[i].equals(word2)) {
                word2Match = i;
                if (word1Match != -1) {
                    minDistance = Math.min(minDistance, Math.abs(word1Match - word2Match));
                }
            }
        }
        return minDistance;
    }
}


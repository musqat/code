import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        used.add(words[0]);

        char lastChar = words[0].charAt(words[0].length() - 1);

        for (int i = 1; i < words.length; i++) {
            String word = words[i];

            if (word.charAt(0) != lastChar || used.contains(word)) {
                int person = (i % n) + 1;
                int turn = (i / n) + 1;
                return new int[]{person, turn};
            }
            used.add(word);
            lastChar = word.charAt(word.length() - 1);
        }

        return new int[]{0, 0};
    }
}
class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int f = food[i] / 2;

            for (int j = 0; j < f; j++) {
                sb.append(i);
            }
        }
        String left = sb.toString();
        String right = sb.reverse().toString();

        return left + 0 + right;

    }
}
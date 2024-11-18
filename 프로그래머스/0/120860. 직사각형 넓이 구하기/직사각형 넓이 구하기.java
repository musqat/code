class Solution {
    public int solution(int[][] dots) {
        int xMax = Integer.MIN_VALUE;
        int xMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;

        for (int[] dot : dots) {
            xMax = Math.max(xMax, dot[0]);
            xMin = Math.min(xMin, dot[0]);
            yMax = Math.max(yMax, dot[1]);
            yMin = Math.min(yMin, dot[1]);
        }

        int width = xMax - xMin;
        int height = yMax - yMin;

        return width * height;
    }
}

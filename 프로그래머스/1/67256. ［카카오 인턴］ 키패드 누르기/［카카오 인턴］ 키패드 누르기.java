class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int curLeft = 10;
        int curRight = 12;

        for (int num : numbers) {
            char selectedHand;


            if (num == 1 || num == 4 || num == 7) {
                selectedHand = 'L';
            } else if (num == 3 || num == 6 || num == 9) {
                selectedHand = 'R';
            } else {
                int leftDist = getDist(curLeft, num);
                int rightDist = getDist(curRight, num);

                if (leftDist < rightDist) {
                    selectedHand = 'L';
                } else if (leftDist > rightDist) {
                    selectedHand = 'R';
                } else {
                    selectedHand = hand.equals("left") ? 'L' : 'R';

                }
            }
            answer.append(selectedHand);
            if (selectedHand == 'L') curLeft = num;
            else curRight = num;

        }

        return answer.toString();
    }

    private int[] getPos(int n) {
        if (n == 0) return new int[]{3, 1};
        if (n == 10) return new int[]{3, 0};
        if (n == 12) return new int[]{3, 2};
        return new int[]{(n - 1) / 3, (n - 1) % 3};
    }


    private int getDist(int a, int b) {
        int[] posA = getPos(a);
        int[] posB = getPos(b);
        return Math.abs(posA[0] - posB[0]) + Math.abs(posA[1] - posB[1]);
    }
}
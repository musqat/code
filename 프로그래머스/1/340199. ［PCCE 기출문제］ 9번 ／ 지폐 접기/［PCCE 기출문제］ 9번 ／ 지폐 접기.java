class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int Bx = bill[0];
        int By = bill[1];

        while (!putWallet(wallet, Bx, By)) {
            if (Bx > By) {
                Bx /= 2;
            } else {
                By /= 2;
            }

            answer++;
        }

        return answer;
    }

    static boolean putWallet(int[] wallet, int bx, int by) {
        int w1 = wallet[0], w2 = wallet[1];
        
        return (bx <= w1 && by <= w2) || (bx <= w2 && by <= w1);
    }
}
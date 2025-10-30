import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];

            answer[i] = cal(array, a,b,c);
        }
        return answer;
    }

    static int cal(int[] arr, int a, int b, int c){
        int[] tmp = Arrays.copyOfRange(arr, a - 1, b);
        Arrays.sort(tmp);
        return tmp[c - 1];
    }


}
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;
        int remove = 0;

        while (!s.equals("1")) {
            int zero = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zero++;
                }
            }
            remove += zero;
            s = s.replace("0", "");
            s = Integer.toBinaryString(s.length());
            count++;
        }

        answer[0] = count;
        answer[1] = remove;

        return answer;
    }
}
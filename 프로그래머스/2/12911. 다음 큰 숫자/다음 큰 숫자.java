class Solution {
    public int solution(int n) {
        int answer = 0;

        String s = Integer.toBinaryString(n);
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count1++;
            }
        }
        int idx = n+1;
        while (true) {
            String tmp = Integer.toBinaryString(idx);

            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == '1') {
                    count2++;
                }
            }


            if (count2 == count1) {
                answer = idx;
                return answer;
            } else {
                idx++;
                count2 = 0;
            }


        }
    }
}
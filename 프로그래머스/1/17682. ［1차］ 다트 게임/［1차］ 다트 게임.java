import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];

        Pattern p = Pattern.compile("(\\d{1,2})([SDT])([*#]?)");
        Matcher m = p.matcher(dartResult);
        int idx = 0;
        while (m.find()) {
            int n = Integer.parseInt(m.group(1));  //점수
            String s = m.group(2); //보너스
            String o = m.group(3); // 옵션

            if (s.equals("S")) {
                score[idx] += (int) Math.pow(n, 1);
            } else if (s.equals("D")) {
                score[idx] += (int) Math.pow(n, 2);
            } else if (s.equals("T")) {
                score[idx] += (int) Math.pow(n, 3);
            }

            if (o.equals("#")) {
                score[idx] *= - 1;
            }else if (o.equals("*")) {
                score[idx] *= 2;
                if (idx > 0) score[idx - 1] *= 2;
            }
            idx++;
        }

        for (int i = 0; i < 3; i++) {
            answer+=score[i];

        }
        return answer;
    }
}
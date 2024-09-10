import java.util.ArrayList;

class Solution {
    public int[] solution(int l, int r) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            String str = String.valueOf(i);
            String[] strArr = str.split("");
            int len = strArr.length;
            int count = 0;
            for (int j = 0; j < strArr.length; j++) {
                if (strArr[j].equals("0") || strArr[j].equals("5")) {
                    count++;
                }
            }
            if (count == len) {
                list.add(Integer.parseInt(str));
            }
            answer = list.stream().mapToInt(Integer::intValue).toArray();
        }

        if (answer.length == 0) {
            answer = new int[] { -1 };
            return answer;
        }
        return answer;
    }
}
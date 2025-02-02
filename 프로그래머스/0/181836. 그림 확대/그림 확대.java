import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] picture, int k) {
        List<String> answer = new ArrayList<>();

        for (String row : picture){
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < row.length(); i++) {
                char ch = row.charAt(i);

                for (int j = 0; j < k; j++) {
                    sb.append(ch);

                }

            }
            String newRow = sb.toString();
            for (int i = 0; i < k; i++) {
                answer.add(newRow);

            }

        }

        return answer.toArray(new String[0]);
    }
}
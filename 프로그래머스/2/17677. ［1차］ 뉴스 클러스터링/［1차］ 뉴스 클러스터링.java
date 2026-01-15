import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
        int TIME = 65536;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();


        for (int i = 0; i < str1.length() - 1; i++) {
            String word = str1.substring(i, i + 2);
            if (word.matches("[A-Z]{2}")) {
                list1.add(word);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String word = str2.substring(i, i + 2);
            if (word.matches("[A-Z]{2}")) {
                list2.add(word);
            }
        }

        int a = 0;

        for (String s : list1) {
            if (list2.remove(s)) {
                a++;
            }
        }

        int b = list1.size() + list2.size();
            
        if (b == 0) return TIME;
        return a * TIME / b;
    }
}
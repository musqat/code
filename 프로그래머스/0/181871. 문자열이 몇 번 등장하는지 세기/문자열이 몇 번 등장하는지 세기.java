import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int solution(String myString, String pat) {
        String patternString = "(?=" + Pattern.quote(pat) + ")";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(myString);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }
}
class Solution {
    static int count = 0;
    static String target;
    static boolean found;

    public int solution(String word) {
        target = word;
        count = 0;
        found = false;

        dfs("");

        return count - 1;
    }

    private void dfs(String cur) {
        if (found) return;
        if (cur.length() > 5) return;

        count++;

        if (cur.equals(target)) {
            found = true;
            return;
        }

        for (char c : new char[]{'A', 'E', 'I', 'O', 'U'}) {
            dfs(cur + c);
        }
    }

}
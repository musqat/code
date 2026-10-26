class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            if (is_possible(skill_trees[i], skill)){
                answer++;
            }
        }

        return answer;
    }

    private  boolean is_possible(String s, String skill) {
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (skill.indexOf(c) == -1) {
                continue;
            }

            if (skill.charAt(idx) == c){
                idx++;
            }else  {
                return false;
            }
        }

        return true;
    }
}

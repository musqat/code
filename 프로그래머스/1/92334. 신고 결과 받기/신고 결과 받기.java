import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, List<String>> reportPerson = new HashMap<>();
        Set<String> unique = new HashSet<>(Arrays.asList(report));

        for (String r : unique) {
            String[] ids = r.split(" ");
            String a_id = ids[0];
            String b_id = ids[1];
            reportPerson.putIfAbsent(a_id, new ArrayList<>());
            reportPerson.get(a_id).add(b_id);
            reportCount.put(b_id, reportCount.getOrDefault(b_id, 0) + 1);
        }

        for (int i = 0; i < id_list.length; i++) {
            int mailCount = 0;
            List<String> person = reportPerson.getOrDefault(id_list[i], new ArrayList<>());
            for (int j = 0; j < person.size(); j++) { // 신고한 사람들 count 횟수 조회
                if (reportCount.getOrDefault(person.get(j), 0) >= k) {
                    mailCount++;
                }
            }
            answer.add(mailCount);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
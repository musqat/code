import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> cache = new LinkedList<>();
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        
        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.remove(city)) {
                cache.addLast(city);
                answer += 1;
            } else {
                if (cache.size() >= cacheSize) {
                    cache.removeFirst();
                }
                if (cacheSize > 0) cache.addLast(city);
                answer += 5;
            }
        }


        return answer;
    }
}
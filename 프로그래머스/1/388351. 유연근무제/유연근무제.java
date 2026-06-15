class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < timelogs.length; i++) {
            boolean isRightTime = true;
            int day = startday;
            for (int j = 0; j < timelogs[i].length; j++) {
                if (day != 6 && day != 7) {
                    if (timelogs[i][j] > getLimitTime(schedules[i])) {
                        isRightTime = false;
                        break;
                    }
                }
                day = day % 7 + 1;

            }

            if (isRightTime) {
                answer++;
            }
        }

        return answer;
    }

    private int getLimitTime(int time) {
        int hour = time / 100;
        int minute = time % 100;

        minute += 10;

        if (minute >= 60) {
            hour++;
            minute -= 60;
        }

        return hour * 100 + minute;
    }
}
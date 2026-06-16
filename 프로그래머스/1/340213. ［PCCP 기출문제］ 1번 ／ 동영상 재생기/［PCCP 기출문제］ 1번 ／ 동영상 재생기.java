class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoTime = getTime(video_len);
        int posTime = getTime(pos);
        int opsTime = getTime(op_start);
        int opeTime = getTime(op_end);

        // 초기값 확인
        if (isOpening(posTime, opsTime, opeTime)) {
            posTime = opeTime;
        }

        for (String command : commands) {
            // 커맨드
            if (command.equals("prev")) {
                posTime = Math.max(posTime - 10, 0);
            } else if (command.equals("next")) {
                posTime = Math.min(posTime + 10, videoTime);
            }
            // 마무리 확인
            if (isOpening(posTime, opsTime, opeTime)) {
                posTime = opeTime;
            }

        }

        int minute = posTime / 60;
        int second = posTime % 60;

        return String.format("%02d:%02d", minute, second);
    }

    private int getTime(String time) {
        String[] split = time.split(":");

        int minute = Integer.parseInt(split[0]);
        int second = Integer.parseInt(split[1]);

        return minute * 60 + second;
    }

    private boolean isOpening(int pos, int start, int end) {
        return start <= pos && pos <= end;
    }


}




package programmers;

import java.util.HashMap;
import java.util.Map.Entry;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println("완주하지 못한 자 : " + solution(participant, completion));

    }

    /* 해시 - 완주하지 못한 선수 */
    public static String solution(String[] participant, String[] completion) {

        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        // participant 배열의 모든 값을 해시 맵에 넣어줌
        for (String part : participant) {

            // key = 문자열, value = 현재 맵에 저장된 문자열 갯수에 + 1
            map.put(part, map.getOrDefault(part, 0) + 1);   //getOrDefault = part 의 value 가 입력값이 없으면 0을 넣어주고 있으면 + 1 을 해줘라
        }

        // completion 배열의 모든 값을 해시 맵에 넣어줌
        for (String comp : completion) {

            // 같은 문자열을 찾아 value 의 값을 -1해줌
            map.put(comp, map.get(comp) - 1);
        }

        for (Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("entry : " + map.entrySet());
            if (entry.getValue() > 0) {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }


}

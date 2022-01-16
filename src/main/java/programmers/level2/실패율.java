package programmers.level2;

import java.util.*;
import java.util.Map.Entry;

public class 실패율 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println("result : " + Arrays.toString(solution(N, stages)));
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        /*각 스테이지 별 도착인원 수 저장 key : stage, value : peopleNum*/
        Map<Integer, Integer> stageMap = new HashMap<>();
        /*스테이지 별 탈락율 저장 key : stage, value : 탈락율*/
        Map<Integer, Double> failRateMap = new HashMap<>();

        /*각 스테이지 별 도착인원 수 저장*/
        for (int i : stages) {
            //stageMap i 번째에 stageMap i 번째의 value 를 넣을건데 없으면 0을 넣어라
            stageMap.put(i, stageMap.getOrDefault(i, 0) + 1);
        }
        //스테이지별 도전자 수 체크 초기값 1라운드는 전체 도전자 수
        int challengeUsers = stages.length;
        //현재 스테이지
        int nowStage = 1;

        //while 1단계 부터 최종단계 + 1(최종단계 클리어시 + 1 값이 저장됌) 까지 반복
        while (nowStage <= N + 1) {
            //key 와 value 사용을 위한 Entry 인터페이스 활용
            for (Entry<Integer, Integer> e : stageMap.entrySet()) {
                //각 스테이지 별로 차례대로 실패확율을 저장하기 위한 조건문
                if (e.getKey() == nowStage) {
                    //nowStage(현재스테이지), 현재스테이지의 값 / 도전자 수(실패확율 비교를 위한 실수형변환 계산)
                    failRateMap.put(nowStage, e.getValue() / Double.valueOf(challengeUsers));
                    //전체 도전자 수 - 스테이지에 남아있던 사람 수
                    challengeUsers -= e.getValue();
                    break;
                }
            }
            //다음 단계로 이동
            nowStage++;
        }//while

        //스테이지별 실패확율이 없는 스테이지는 0으로 처리 (ex:1,4,2,4,5)
        for (int i = 1; i <= N; i++) {
            failRateMap.put(i, failRateMap.getOrDefault(i, 0.0));
        }
        System.out.println("failRateMap.toString() : " + failRateMap.toString());

        //마지막 스테이지 까지 도달한 유저는 실패율에서 제외
        failRateMap.remove(N + 1);

        List<Integer> keySetList = new ArrayList<>(failRateMap.keySet());
        System.out.println("keySetList : " + keySetList.toString());
        //실패율 내림차순 정렬
        Collections.sort(keySetList, (o1, o2) -> (failRateMap.get(o2).compareTo(failRateMap.get(o1))));
        System.out.println("keySetList2 : " + keySetList.toString());
        System.out.println("failRateMap.get(1) : " +failRateMap.get(1));
        //실패율 스테이지 저장
        answer = keySetList.stream().mapToInt(i -> i).toArray();

        return answer;
    }

}//class

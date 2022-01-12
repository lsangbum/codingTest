package programmers.level2;

public class 실패율 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 5, 2, 4, 3, 3};
        System.out.println("확룰 : " + solution(N, stages).toString());

    }

    //N = 스테이지 총 수, stages = 각 유저가 머물러 있는 스테이지
    public static Double[][] solution(int N, int[] stages) {
        //스테이지 도전 인원
        int challengeUsers = stages.length;
        //스테이지 별 확률을 담을 배열
        Double[][] stageProbability = new Double[N][1];
        //스테이지 별 확률을 구하자
        for (int i = 1; i <= N; i++) {

            Double count = 0.0;

            for (int j = 0; j < stages.length; j++)
                if (stages[j] == i) count++;
            stageProbability[i][1] = count / challengeUsers;
            challengeUsers -= count;

        }
        return stageProbability;
    }

}

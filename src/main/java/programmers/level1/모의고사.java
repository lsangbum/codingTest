package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {

    public int[] solution(int[] answers) {

        //수포자 1, 2, 3 번의 정답 패턴
        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        //수포자 1, 2, 3 번의 정답 수
        int[] score = new int[pattern.length];
        //수포자 1, 2, 3 번의 정답 정렬
        int[] scoreSort = new int[pattern.length];
        //가장문제를 많이 맞춘 수포자
        List<Integer> scoreRankList = new ArrayList<>();

        //각각의 패턴을 정답과 비교하여 score 점수 증가
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern[0][i % pattern[0].length]) score[0]++;
            if (answers[i] == pattern[1][i % pattern[1].length]) score[1]++;
            if (answers[i] == pattern[2][i % pattern[2].length]) score[2]++;
        }

        //배열 정렬을 위한 배열 복사
        scoreSort = score.clone();
        //가장 높은 점수를 추출하기 위한 정렬
        Arrays.sort(scoreSort);
        //오름차순 정렬로 가장 뒷 값이 최대값  /  최대 값이 2개 이상일 경우를 대비하여 비교변수 max 생성
       int max = scoreSort[scoreSort.length - 1];

        //가장문제를 많이 맞춘 학생 찾기 복수 일 경우를 대비하여 List 에 저장
        for (int j = 0; j < score.length; j++) {
            if (score[j] == max) scoreRankList.add(j+1);
        }

        //최다점 학생 수 만큼의 배열크기 생성
        int[] result = new int[scoreRankList.size()];

        //리스트의 최다점 학생들을 배열에 저장
       for (int k = 0; k < result.length; k++) {
            result[k] = scoreRankList.get(k);
        }

        return result;
    }

}//class

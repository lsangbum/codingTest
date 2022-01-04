package programmers;

import java.util.Arrays;

public class K번째선수 {

    public static void main(String[] args) {
        
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println("정렬배열 : " + Arrays.toString(solution(array, commands)));

    }//main

    public static int[] solution(int[] array, int[][] commands) {
        //이중 배열의 길이
        int len = commands.length;
        //기존 배열을 원하는 위치값으로 재생성 후 정렬할 배열
        int[] answer = new int[len];
        //정렬한 배열의 특정위치 값을 담을 배열
        int[] result = new int[len];

        /**
         * 기존 배열을 특정범위만 재생성 후 정렬 -> 정렬 된 배열의 특정 index위치 값 추출
         */
        for(int i = 0; i < len; i++) {
            answer = Arrays.copyOfRange(array, commands[i][0] -1, commands[i][1]);
            Arrays.sort(answer);
            result[i] = answer[commands[i][2] - 1];
        }

        return result;
    }
}//class

package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 로또최고순위최저순위 {

    //Arrays 를 사용하지 않고 for 만 사용
    public static int[] solution(int[] lottos, int[] win_nums) {
        //맞은 수 체크
        int count = 0;
        //지워진 수 체크
        int zeroCount = 0;
        //적은 수를 하나씩 비교 0일 경우 zeroCount++, 정답과 같을 경우 count++
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }
            for (int win_num : win_nums) {
                if (win_num == lotto) {
                    count++;
                    break;
                }
            }
        }
        //맞은 수와 지워진 수를 계산하여 최고 순위와 맞은 수만 계산한 최저 순위 리턴
        return new int[]{7 - Math.max(count + zeroCount, 1), 7 - Math.max(count, 1)};
    }//solution

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int[] check = solution(lottos, win_nums);
        System.out.println("최고등수와 최저등수 : " + Arrays.toString(check));
    }//main

}//class
/*

    //Arrays 사용
    //stream 사용
    public static int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int zeroCount = 0;
        for (int lotto : lottos) {
            if (lotto == 0)
                zeroCount++;
            else if (IntStream.of(win_nums).anyMatch(x -> x == lotto))
                count++;
        }
        return new int[]{7 - Math.max(count + zeroCount, 1), 7 - Math.max(count, 1)};
    }//solution
*/




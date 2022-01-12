package programmers.level1;

import java.util.Arrays;

public class 없는숫자더하기 {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
        System.out.println("없는 수의 합 : " + solution(numbers));
    }


    public static int solution(int[] numbers) {

        int result = 0;

        if (numbers.length >= 1 && numbers.length <= 9) {               //제한사항 1 ≤ numbers 의 길이 ≤ 9

            for (int i = 0; i <= 9; i++) {                              //제한사항 0 ≤ numbers 의 모든 수 ≤ 9, numbers 의 모든 수는 서로 다릅니다.
                int key = i;
                if (!Arrays.stream(numbers).anyMatch(x -> x == key)) {
                    result += key;
                }
            }

        } else {
            System.out.println("제한사항을 확인해주세요.");
        }

        return result;

    }//solution
}//class
/**
 * return 45-Arrays.stream(numbers).sum(); 다른 사람 풀이 중 하나 인데 리턴 값 코드 한줄로 끝내버렸다... 노력이 더욱 필요하다! 격차가 너무 느껴진다!!
 */

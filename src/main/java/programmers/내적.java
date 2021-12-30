package programmers;

import java.util.stream.IntStream;

public class 내적 {
    public static void main(String[] args) {

        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};
        System.out.println("a 와 b 의 내적 : " + solution(a, b));
    }//main

    /**
     * a 와 b 의 내적 구하기
     */
    public static int solution(int[] a, int[] b) {
        /*int result = 0;

        for (int i = 0; i < a.length; i++){         //공식 = 각 배열의 같은 인덱스의 값을 곱한 뒤 나온 값들을 모두 더해준다.
            result += a[i] * b[i];
        }*/

        return IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();
    }//solution

}//class

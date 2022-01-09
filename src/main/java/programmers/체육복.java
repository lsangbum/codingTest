package programmers;

import java.util.*;

public class 체육복 {

    public int solution(int n, int[] lost, int[] reserve) {
        //학생 전체 n - 체육복분식학생 lost = 1차적인 체육가능학생 수
        int result = n - lost.length;

        //반복문을 돌리며 원하는 값에 빠르게 접근하기 위함
        Arrays.sort(lost);
        Arrays.sort(reserve);

        //체육복분실 집단 lost 와 여분체육복 집단 reserve 둘다 포함 되어 있는 경우 둘다 제외
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    result++;
                    break;
                }
            }
        }

        //분실 학생의 전 번호와 후 번호를 찾아 같은 번호가 있으면 result 를 올리고 여분학생 제거
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if ((lost[i] - 1 == reserve[j]) || (lost[i] + 1 == reserve[j])) {
                    reserve[j] = -1;
                    result++;
                    break;
                }
            }
        }

        return result;

    }//solution

}//class

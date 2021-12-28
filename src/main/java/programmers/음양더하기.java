package programmers;

public class 음양더하기 {

    public int solution(int[] absolutes, boolean[] signs) {

        int result = 0;

        /**
         * signs[i] 가 참이면 absolutes[i] 의 실제 정수가 양수임을, 그렇지 않으면 음수임을 의미합니다.
         */
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i])                              //ture 일 경우 +
                result += absolutes[i];
            else                                       //false 일 경우 -
                result -= absolutes[i];
        }
        return result;

    }//solution

}//class

/**
 * result += signs[i] ? absolutes[i] : -absolutes[i];      //삼항식 처리
 */
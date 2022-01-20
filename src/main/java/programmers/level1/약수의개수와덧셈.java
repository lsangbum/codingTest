package programmers.level1;

public class 약수의개수와덧셈 {

    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        System.out.println("약수의개수와 덧셈뺄셈 : " + solution(left, right));
    }

    public static int solution(int left, int right) {
        //결과값 변수
        int result = 0;
        //주어진 left 부터 right 까지 하나 씩 검사
        for (int i = left; i <= right; i++) {
            //약수의 개수를 담을 변수
            int count = 0;
            //left 부터 right 까지의 수를 하나 씩 1부터 해당 수까지 계산 후 count++
            for (int j = 1; j <= i; j++) if (i % j == 0) count++;
            //약수의 개수가 짝 / 홀 인지 검사 후 + - 연산
            if (count % 2 == 0) result += i;
            else result -= i;
        }

        return result;
        
    }//solution

}//class

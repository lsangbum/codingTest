package programmers.level1;

public class 소수만들기 {

    public int solution(int[] nums) {
        //만들 수 있는 소수의 갯수
        int result = 0;
        //비교를 위한 숫자들의 합
        int sum = 0;

        //1, 2, 3~, 1, 3, 4~ 식으로 전체 합 비교 반복문
        for (int i = 0; i < nums.length; i++) {
            for (int j = ++i; j < nums.length; j++) {
                for (int h = ++j; h < nums.length; h++) {
                    sum += nums[i] + nums[j] + nums[h];
                    //primeNumber 메소드를 만들어 소수확인 맞을 시 result + 1
                    if (primeNumber(sum) == true) result++;
                }
            }
        }

        return result;

    }//solution

    //합이 소수인지 확인하는 메소스
    public boolean primeNumber(int sum) {

        boolean booleanPrimeNumber = true;

        //sum 이 2일 경우 바로 true return 후 메소드 종료
        if (sum == 2) return booleanPrimeNumber;
        //1과 본인을 제외하고 나누었을 때 나머지가 0일 경우 소수가 아니다. false
        for (int i = 2; i < sum; i++) {
            if(sum % i == 0) {
                booleanPrimeNumber = false;
                break;
            }
        }
        return booleanPrimeNumber;
    }//primeNumber

}//class


    /*public boolean primeNumber(int sum) {

        int count = 0;

        for (int i = 1; i <= sum; i++) {
            if(sum % i == 0) count++;
        }

        return count == 2;
    }//primeNumber*/
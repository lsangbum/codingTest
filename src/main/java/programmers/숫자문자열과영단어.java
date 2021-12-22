package programmers;

public class 숫자문자열과영단어 {

    //방법 1.
    public int solution(String s) {

        //비교를 위한 숫자배열
        String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        //비교를 위한 문자배열
        String[] numWord = {"zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"};

        //매개변수에 문자배열의 값이 있을 경우 숫자배열의 값으로 변환 0 ~ 9 까지 체크
        for (int i = 0; i < nums.length; i++)
            s = s.replace(numWord[i], nums[i]);

        //추출한 값을 리턴값에 맞추어 변환
        return Integer.parseInt(s);

    }//solution

    //방법 2. 숫자 배열하나를 제거 반복문의 i 값으로 비교하여 추후에 문자배열의 값이 추가 삭제 되더라도 코드 수정x
    public int solution2(String s) {

        //비교를 위한 문자배열
        String[] numWord = {"zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"};

        //매개변수에 문자배열의 값이 있을 경우 숫자배열의 값으로 변환 0 ~ 9 까지 체크
        for (int i = 0; i < numWord.length; i++)
            s = s.replace(numWord[i], Integer.toString(i));

        //추출한 값을 리턴값에 맞추어 변환
        return Integer.parseInt(s);

    }//solution2


}//class

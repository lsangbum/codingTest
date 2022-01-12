package programmers.level1;

public class 신규아이디추천 {
    public static String solution(String id) {

        // 모든 대문자를 소문자로 변환
        String new_id = id.toLowerCase();

        //-,_,.,a~z,0~9 제외 "" 공백처리
        new_id = new_id.replaceAll("[^-_.a-z0-9]", "");

        //. 이 2번 이상 있을 경우 . 1 개로 변환
        new_id = new_id.replaceAll("[.]{2,}", ".");

        //. 으로 시작하거나 . 으로 끝날 경우 해당 문자 공백처리
        new_id = new_id.replaceAll("^[.]|[.]$", "");

        //id가 공백일때 a 추가
        if (new_id.equals("")) new_id += "a";

        //id 가 15자 보다 클 경우 그 외 문자 삭제 및 마지막. 삭제
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("^[.]|[.]$", "");
        }

        //id 가 3자 보다 적을 경우 마지막 문자와 동일문자 삽입
        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }


        return new_id;

    }//solution

    public static void main(String[] args) {

        String id = ".aWERTRS.";
        String new_id = solution(id);
        System.out.println("변환 전 아이디 : " + id);
        System.out.println("변환 후 아이디 : " + new_id);

    }//main

}//class

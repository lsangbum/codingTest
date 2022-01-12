package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class 폰켓몬 {

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        //System.out.println("최대 수 : " + solution(nums));
        HashSet<Integer> hs = new HashSet();
        Integer i = 3;
        int j = 3;
        System.out.println("equals : " + i.equals(j));
        System.out.println("== : " + (i == j));
        for (int num : nums) {
            hs.add(num);
        }

        System.out.println("해쉬셋 : " + hs);
    }

    public static int solution(int[] nums) {

        //서로 다른 종류
        int result = 0;

        //서로 다른 종류 중 가져갈 수 있는 max 값
        int answer = nums.length / 2;

        //원활한 비교를 위한 배열정리
        Arrays.sort(nums);

        //중복제거 포켓몬 배열
        List<Integer> removeDuplication = new ArrayList<>();

        //모두 같은 포켓몬 일 경우 대비 첫 번째 포켓몬 넣어두기
        removeDuplication.add(nums[0]);

        //중복제거
        for (int i = 0; i < nums.length-1; i++) if (nums[i] != nums[i+1]) removeDuplication.add(nums[i+1]);

        //중복제거 포켓몬의 수
        result = removeDuplication.size();

        if (result > answer) return answer;

        return result;

    }//solution

}//class

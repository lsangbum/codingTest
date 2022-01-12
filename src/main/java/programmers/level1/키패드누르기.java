package programmers.level1;

public class 키패드누르기 {
    public static void main(String[] args) {
        //입력 번호
        int[] nums = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        //주요 사용 손
        String hand = "right";
        String result = solution(nums, hand);
        System.out.println("입력한 손잡이의 순서는 : " + result);

    }//main

    public static String solution(int[] numbers, String hand) {
        //입력 손 위치값 저장 StringBuffer 보다 속도가 빠르다.
        StringBuilder sb = new StringBuilder();
        //처음 위치값 * = 10
        int leftNumber = 10;
        //처음 위치값 # = 12
        int rightNumber = 12;
        //왼손 현재 위치
        int leftDistance;
        //오른손 현재 위치
        int rightDistance;
        //입력 번호 하나씩 입력
        for (int num : numbers) {
            //1, 4, 7 일 경우 왼손 입력 후 현재 위치 저장
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                leftNumber = num;
            //3, 6, 9 일 경우 오른손 입력 후 현재 위치 저장
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                rightNumber = num;
            //1, 4, 7, 3, 6, 9 가 아니면서 0일경우 11 대입
            } else {
                if (num == 0) {
                    num += 11;
                }
                //(입력값 - 양손의 현재 위치) / 3 + (입력값 - 양손의 현재 위치) % 3 = 현재 위치와 입력값의 거리
                leftDistance = (Math.abs(num - leftNumber)) / 3 + (Math.abs(num - leftNumber)) % 3;
                rightDistance = (Math.abs(num - rightNumber)) / 3 + (Math.abs(num - rightNumber)) % 3;
                //거리가 같을 경우 주 사용 손으로 입력 후 현재 위치 저장
                if (leftDistance == rightDistance) {
                    if (hand.equals("right")) {
                        sb.append("R");
                        rightNumber = num;
                    //주 사용 손이 right가 아닐 경우 left 추가 후 현재 위치 저장
                    } else {
                        sb.append("L");
                        leftNumber = num;
                    }
                //오른쪽 거리가 더 작을 경우 입력값과의 거리가 더 가깝기 때문에 right 추가 현재 위치 저장
                } else if (leftDistance > rightDistance) {
                    sb.append("R");
                    rightNumber = num;
                //왼쪽 거리가 더 작을 경우 입력값과의 거리가 더 가깝기 때문에 left 추가 현재 위치 저장
                } else {
                    sb.append("L");
                    leftNumber = num;
                }
            }
        }

        return sb.toString();
    }

}//class

package programmers;

public class 키패드누르기 {
    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String result = solution(nums, hand);
        System.out.println("입력한 손잡이의 순서는 : " + result);

    }//main

    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int leftNumber = 10;
        int rightNumber = 12;
        int leftDistance;
        int rightDistance;

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                leftNumber = num;
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                rightNumber = num;
            } else {
                if (num == 0) {
                    num += 11;
                }
                leftDistance = (Math.abs(num - leftNumber)) / 3 + (Math.abs(num - leftNumber)) % 3;
                rightDistance = (Math.abs(num - rightNumber)) / 3 + (Math.abs(num - rightNumber)) % 3;
                if (leftDistance == rightDistance) {
                    if (hand.equals("right")) {
                        sb.append("R");
                        rightNumber = num;
                    } else {
                        sb.append("L");
                        leftNumber = num;
                    }
                } else if (leftDistance > rightDistance) {
                    sb.append("R");
                    rightNumber = num;
                } else {
                    sb.append("L");
                    leftNumber = num;
                }
            }
        }

        return sb.toString();
    }

}//class

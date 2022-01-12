package programmers.level1;

import java.sql.SQLException;
import java.util.Stack;

public class 크레인인형뽑기게임 {
    public static void main(String[] args) {

        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4,3,2,7,8,10};

        System.out.println("터진 인형의 수 : " + solution(board, moves));

    }//main

    public static int solution(int[][] board, int[] moves) {

       int popCount = 0;                                        //터진 인형의 수
       Stack<Integer> stack = new Stack<>();                    //뽑은 인형 보관함 stack = 후입선출 LIFO

        for (int move : moves) {                                //입력 수 만큼 반복하겠다.
            if (move > 5) continue;                             //입력 값이 5보다 클 경우 아무일도 일어나지 않는다.
            for (int i = 0; i < board.length; i++) {            //각 배열의 해당 위치의 값을 비교하겠다.
                if (board[i][move - 1] != 0) {                  //비교 대상이 0일 경우 아무일도 일어나지 않는다.
                    if (stack.isEmpty()) {                      //보관함이 비어 있을 경우 바로 저장
                        stack.push(board[i][move - 1]);         //뽑은 인형을 보관함에 저장
                        board[i][move - 1] = 0;                 //뽑은 인형의 자리를 0으로 변환
                        break;
                    }
                    if (board[i][move - 1] == stack.peek()) {   //비어있지 않을 경우 입력값과 보관함의 가장 상위 값(peek 로 확인)을 비교
                        stack.pop();                            //같을 경우 push 없이 후입데이터 pop
                        popCount += 2;                          //popCount + 2
                    } else {
                        stack.push(board[i][move - 1]);         //같지 않을 경우 보관함에 저장
                    }
                    board[i][move - 1] = 0;                     //사용된 위치의 값은 0으로 변환
                    break;
                }
            }
        }

        return popCount;

    }//solution
}//class

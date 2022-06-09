import java.util.ArrayList;
import java.util.List;

public class CodingTest9 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] != 0) {
                    if (!temp.isEmpty() && temp.get(temp.size()-1) == board[j][moves[i] - 1]) {
                        answer++;
                        temp.remove(temp.size()-1);
                    } else {
                        temp.add(board[j][moves[i] - 1]);
                    }
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }

        }

        return answer*2;
    }

    public static void main(String[] args) {
        CodingTest9 codingTest9 = new CodingTest9();
        int[][] board = {
                {0, 0, 0, 0, 0}
                , {0, 0, 1, 0, 3}
                , {0, 2, 5, 0, 1}
                , {4, 2, 4, 4, 2}
                , {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(codingTest9.solution(board, moves));
    }
}

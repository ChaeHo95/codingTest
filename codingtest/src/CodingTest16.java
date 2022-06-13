import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodingTest16 {

    public int[] solution(int[] answers) {
        List<Integer> studebtsNum = new ArrayList<>();
        int[][] students = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] counts = new int[3];


        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == students[0][i % students[0].length]) {
                counts[0]++;
            }
            if (answers[i] == students[1][i % students[1].length]) {
                counts[1]++;
            }
            if (answers[i] == students[2][i % students[2].length]) {
                counts[2]++;
            }
            // 나머지 연산으로 계산 시 나머지는 반복되는 수의 해당되는 번호에서 다시 0이 되기때문에
        }
        int max = Arrays.stream(counts).max().getAsInt();
        System.out.println(Arrays.toString(counts));

        int index = 0;

        for (int i = 0; i < counts.length; i++) {
            System.out.println(counts[i]);
            if (max == counts[i]) {
                studebtsNum.add( i + 1);
                index++;
            }
        }
        return studebtsNum.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        CodingTest16 codingTest16 = new CodingTest16();

        int[] test1 = {1, 2, 3, 4, 5};
        int[] test2 = {1, 3, 2, 4, 2};

        System.out.println(Arrays.toString(codingTest16.solution(test1)));
        System.out.println(Arrays.toString(codingTest16.solution(test2)));
    }
}

import java.util.Arrays;

public class CodingTest15 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int[] arrayCopy = Arrays.copyOfRange(array, commands[i][0] -1, commands[i][1]);
            // Arrays.copyOfRange() 메소드는 원본 배열를 시작점에서 끝점을 지정해서 복사하는 메소드
            Arrays.sort(arrayCopy);
            answer[i] = arrayCopy[commands[i][2] - 1];
        }
        return answer;
    }


    public static void main(String[] args) {
        CodingTest15 codingTest15 = new CodingTest15();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(codingTest15.solution(array,commands)));
    }
}

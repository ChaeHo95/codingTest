import java.util.Arrays;

public class CodingTest10 {
    public int solution(int[] numbers) {
        int answer = 0;
        int index = 0;

        Arrays.sort(numbers);

        for(int i=0; i<10; i++){

            if(numbers.length > index && numbers[index] == i){
                index++;
            }else {
                answer += i;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        CodingTest10 codingTest10 = new CodingTest10();

        int[] numbers1 = {1,2,3,4,6,7,8,0};
        int[] numbers2 = {5,8,4,0,6,7,9};

        System.out.println(codingTest10.solution(numbers1));
        System.out.println(codingTest10.solution(numbers2));
    }
}

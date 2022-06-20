import java.util.*;
public class CodingTest19 {
    public int[] solution(int N, int[] stages) {
        Integer[] answer = new Integer[N];

        for(int i=0; i<N;i++){
            answer[i] = i+1;
        }

        Map<Integer, Float> failRate = new HashMap<>();

        Arrays.sort(stages);

        for (int i = 1; i <= N; i++) {
            int success = stages.length;
            int fail = 0;
            for (int j=0; j<stages.length; j++) {
                if(i == stages[j]){
                    fail++;
                }
                if(i > stages[j]){
                    success--;
                }
                if(i < stages[j]){
                    break;
                }
            }
            float rate = fail != 0 ? (float) fail/success : 0;
            failRate.put(i,rate);
        }

        Arrays.sort(answer,(s1,s2)->{
            float value1 = failRate.get(s1);
            float value2 = failRate.get(s2);
            if(value1 > value2){
                return -1;
            }
            if(value1 == value2){
                if(s1 > s2){
                    return 1;
                }else {
                    return -1;
                }
            }else {
                return 1;
            }
        });
        return Arrays.stream(answer).mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        CodingTest19 codingTest19 = new CodingTest19();

        int N1 = 5;
        int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};

        int N2 = 4;
        int[] stages2 = {4, 4, 4, 4, 4};

        System.out.println(Arrays.toString(codingTest19.solution(N1, stages1)));
        System.out.println(Arrays.toString(codingTest19.solution(N2, stages2)));
    }

}

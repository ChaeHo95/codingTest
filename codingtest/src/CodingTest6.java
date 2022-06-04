import java.util.Arrays;

public class CodingTest6 {

    public int solution(int[] budgets, int M) {
        Arrays.sort(budgets);

        int preMoney = 0;
        int answer = budgets[budgets.length - 1];
        int startIndex = 0;
        Boolean maxMoney = true;

        while (maxMoney) {
            int total = preMoney;

            for (int i = startIndex; i < budgets.length; i++) {
                if(budgets[i] < answer){
                    total += budgets[i];
                    startIndex = i;
                }else {
                    total += answer;
                }
                if(total > M ){
                    answer -= (total - M)/2 == 0? 1: (total - M)/2;
                    break;
                }
                if(total- budgets[i] > preMoney ){
                    preMoney = total;
                }
            }

            if(total <= M){
                maxMoney = false;
            }
        }


        return answer;

    }

    public static void main(String[] args) {
        CodingTest6 codingTest6 = new CodingTest6();

        int[] budgets = {120, 110, 140, 150};
        int M = 485;

        System.out.println(codingTest6.solution(budgets, M));
    }
}

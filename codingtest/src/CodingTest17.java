import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CodingTest17 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        List<Integer> lends = new ArrayList<>();
        List<Integer> losts = new ArrayList<>();

        for (int num : reserve) {
            lends.add(num);
        }

        Arrays.sort(lost);

        for (int num : lost){
            if(lends.contains(num)){
                sameRemove(num,lends);
                answer++;
            }else {
                losts.add(num);
            }
        }

        for (int num : losts) {
            if (check(num, lends)) {
                answer++;
            }
        }
        return answer;
    }
    private void sameRemove(int num, List lends){
        int index = lends.indexOf(num);
        lends.remove(index);
    }
    private boolean check(int num, List lends) {
        int index = -1;

        if (lends.contains(num + 1)) {
            index = lends.indexOf(num + 1);
        }
        if (lends.contains(num + -1)) {
            index = lends.indexOf(num + -1);
        }

        if (index != -1) {
            lends.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CodingTest17 codingTest17 = new CodingTest17();

        int n1 = 5;
        int[] lost1 = {2, 4};
        int[] reserve1 = {1, 3, 5};

        int n2 = 5;
        int[] lost2 = {2, 4};
        int[] reserve2 = {3};

        int n3 = 3;
        int[] lost3 = {2, 4};
        int[] reserve3 = {1};

        System.out.println(codingTest17.solution(n1, lost1, reserve1));
        System.out.println(codingTest17.solution(n2, lost2, reserve2));
        System.out.println(codingTest17.solution(n3, lost3, reserve3));

    }
}

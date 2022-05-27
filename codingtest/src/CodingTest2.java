import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CodingTest2 {
    public int checkRank(int num) {
        int rank;
        switch (num) {
            case 6:
                rank = 1;
                break;
            case 5:
                rank = 2;
                break;
            case 4:
                rank = 3;
                break;
            case 3:
                rank = 4;
                break;
            case 2:
                rank = 5;
                break;
            default:
                rank = 6;
        }
        return rank;
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> wins = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        int unKnown = Math.toIntExact(Arrays.stream(lottos).filter(num -> num==0).count());
        // 알수 없는 갯수
        int sucess = Math.toIntExact(Arrays.stream(lottos).filter(num -> wins.contains(num)).count());
        // 맞은 갯수 최저 등수
        System.out.println(unKnown);
        System.out.println(sucess);
        return new int[]{checkRank(sucess+unKnown), checkRank(sucess)};
    }


    public static void main(String[] args) {
        CodingTest2 codingTest2 = new CodingTest2();


        int[] lottos1 = {44, 1, 0, 0, 31, 25};
        int[] win_nums1 = {31, 10, 45, 1, 6, 19};

        int[] lottos2 = {0, 0, 0, 0, 0, 0};
        int[] win_nums2 = {38, 19, 20, 40, 15, 25};

        int[] lottos3 = {45, 4, 35, 20, 3, 9};
        int[] win_nums3 = {20, 9, 3, 45, 4, 35};

        System.out.println(Arrays.toString(codingTest2.solution(lottos1, win_nums1)));

        System.out.println(Arrays.toString(codingTest2.solution(lottos2, win_nums2)));

        System.out.println(Arrays.toString(codingTest2.solution(lottos3, win_nums3)));
    }
}

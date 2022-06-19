import java.util.*;

public class CodingTest18 {
//    public int solution(int[] nums) {
//        int answer = nums.length/2;
//        int result = (int) Arrays.stream(nums).distinct().count();
//        return answer >= result ? result:answer;
//    }
    public int solution(int[] nums) {
        int answer = nums.length/2;
        Set<Integer> duplicate = new HashSet<>();
        for (int num:nums) {
            duplicate.add(num);
        }
        int result = duplicate.size();
        return answer >= result ? result:answer;
    }

    public static void main(String[] args) {
        CodingTest18 codingTest18 = new CodingTest18();
        int[] nums1 = {3,1,2,3};
        int[] nums2 = {3,3,3,2,2,4};
        int[] nums3 = {3,3,3,2,2,2};

        System.out.println(codingTest18.solution(nums1));
        System.out.println(codingTest18.solution(nums2));
        System.out.println(codingTest18.solution(nums3));
    }
}

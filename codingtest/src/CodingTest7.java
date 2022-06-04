import com.sun.jdi.IntegerValue;

import java.util.*;

public class CodingTest7 {
//    public int solution(int[] A, int[] B) {
//        HashSet<Long> countList = new HashSet<>();
//        Arrays.stream(B).forEach(n ->{
//            final int[] copyA = A;
//            final int bsNum = n;
//            Long count = Arrays.stream(copyA).filter( num -> num < bsNum).count();
//            if(count != 0){
//                countList.add(count);
//            }
//        });
//        return countList.size();
//    }

//    public int solution(int[] A, int[] B) {
//        int answer = 0;
//        Long aSize = Arrays.stream(A).distinct().count();
//        if(aSize==1){
//            Long bSize = Arrays.stream(B).distinct().count();
//            if(bSize==1 && A[0] > B[0]){
//                return 0;
//            }
//            if(bSize==1 && A[0] < B[0]){
//                return A.length;
//            }
//        };
//        Arrays.sort(B);
//        Arrays.sort(A);
//
//        for (int i = B.length-1; i > 0; i--) {
//            int count = 0;
//            for (int j =0; j < A.length; j++) {
//                if (B[i] > A[j]) {
//                    count++;
//                }
//            }
//            if (count > 0) {
//                answer++;
//            }else {
//                break;
//            }
//        }
//        return answer;
//    }
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int bEnd = B.length-1;

        for (int i = A.length-1; i > -1; i--) {
            // B가 이겼을시 값만 구하기 위해
            // 배열 끝 부터 순차적으로 접근

            if(B[bEnd] > A[i]){
                // B의 값이 A의 값보다 클 시
                answer++;
                // 승리가능 수 증가
                bEnd--;
                // B의 값 중 하나가 사용 되었기 때문에 감소;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        CodingTest7 codingTest7 = new CodingTest7();


        int[] a1 = {5, 1, 3, 7};
        int[] B1 = {2, 2, 6, 8};

        int[] a2 = {2, 2, 2, 2};
        int[] B2 = {1, 1, 1, 1};


        System.out.println(codingTest7.solution(a1, B1));
        System.out.println(codingTest7.solution(a2, B2));
    }
}

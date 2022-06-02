import java.util.*;

class CodingTest5{

    public String solution(int[] numbers) {
        String answer = "";
        String[] testNums =  new String[numbers.length];

        for (int i=0; i< numbers.length; i++) {
            testNums[i] = String.valueOf(numbers[i]);
        }

        String temp = "";
        for(int i=0; i < testNums.length-1; i++){
            int index = i;
            for(int j= i+1; j < testNums.length; j++){
                if(Integer.parseInt(testNums[index]+testNums[j]) < Integer.parseInt(testNums[j] + testNums[index])){
                    index = j;
                }
                temp = testNums[i];
                testNums[i] = testNums[index];
                testNums[index] = temp;
            }

        }
//        Arrays.sort(testNums, new Comparator<String>() {
//            // sort()메소드를 이용하여 순차적으로 비교하여 정렬
//            // sort()메소드의 인자 중  Comparator부분을 재정의할 수 있어
//            // new Comparator<String>(){}
//            @Override
//            public int compare(String o1, String o2) {
//                String a = o2 + o1;
//                String b = o1 + o2;
//                return a.compareTo(b);
//                // compareTo()함수는 두개의 값을 비교하여 int 값으로 반환해주는 함수
//                // a가 b보다 크면 뒤쪽으로
//                // a가 b랑 같으면 그대로
//                // a가 b보다 작으면 앞쪽으로
//            }
//        });
//        Arrays.sort(testNums, (o1, o2) -> {
//            String a = o2 + o1;
//            String b = o1 + o2;
//            return a.compareTo(b);
//            // compareTo()함수는 두개의 값을 비교하여 int 값으로 반환해주는 함수
//            // a가 b보다 크면 뒤쪽으로
//            // a가 b랑 같으면 그대로
//            // a가 b보다 작으면 앞쪽으로
//        });
//        for(String test :testNums){
//            answer += test;
//        }
//        if(answer.charAt(0) < 1){
//            answer = "0";
//        }
//        return answer;
        if(Integer.parseInt(String.join("",testNums)) < 1){
            return "0";
        }
        return String.join("",testNums);
    }

    public static void main(String[] args) {
        CodingTest5 solutions = new CodingTest5();

        int[] testNum1 = {6,10,2};
        int[] testNum2 = {3,30,34,5,9};

        System.out.println(solutions.solution(testNum1));
        System.out.println(solutions.solution(testNum2));
    }
}
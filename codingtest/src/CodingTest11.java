public class CodingTest11 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i=0; i< absolutes.length;i++){
            answer = signs[i] ? answer + absolutes[i] : answer - absolutes[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        CodingTest11 codingTest11 = new CodingTest11();

        int[] absolutes1 = {4,7,12};
        boolean[] signs1 = {true,false,true};

        int[] absolutes2 = {1,2,3};
        boolean[] signs2 = {false,false,true};

        System.out.println(codingTest11.solution(absolutes1,signs1));
        System.out.println(codingTest11.solution(absolutes2,signs2));
    }
}

import java.util.Arrays;

public class CodingTest14 {
    /*public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        int index = 0;

        for (String name : participant) {
            if (index < completion.length && name.equals(completion[index])) {
                index++;
            } else {
                answer = name;
            }
        }

        return answer;
    }*/
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        int index = 0;

        for (String name : participant) {
            if (index < completion.length && name.equals(completion[index])) {
                index++;
            } else {
                answer = name;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        CodingTest14 CodingTest14 = new CodingTest14();

        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};

        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};

        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};

        System.out.println(CodingTest14.solution(participant1, completion1));
        System.out.println(CodingTest14.solution(participant2, completion2));
        System.out.println(CodingTest14.solution(participant3, completion3));
    }
}

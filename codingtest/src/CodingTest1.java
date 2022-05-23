import java.util.*;


public class CodingTest1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        answer = new int[id_list.length];
        HashMap<String,HashSet<String>> report_content = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();

        for(String name : id_list){
            report_content.put(name,new HashSet<>());
        }
        for(String reported : report){
            String[] reported_names = reported.split(" ");
            report_content.get(reported_names[0]).add(reported_names[1]);
            if(count.containsKey(reported_names[1])){
                count.put(reported_names[1],count.get(reported_names[1])+1);
            }else {
                count.put(reported_names[1],1);
            }
        }
        for(int i=0; i<id_list.length; i++){
            for (String reported:report_content.get(id_list[i])) {
                if(count.get(reported) == k){
                    answer[i]++;
                }
            }
        }

        return answer;

    }
    public static void main(String[] args) {
        CodingTest1 codingTest1 = new CodingTest1();

        String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report1 = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int count1 = 2;

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int count2 = 3;

        System.out.println(Arrays.toString(codingTest1.solution(id_list1, report1, count1)));
        System.out.println(Arrays.toString(codingTest1.solution(id_list2, report2, count2)));
    }
}

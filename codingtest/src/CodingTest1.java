import java.util.*;
import java.util.stream.Collectors;

public class CodingTest1 {
    public int[] beforSolution1(String[] id_list, String[] report, int k) { // 8.3
        int[] answer = {};
        answer = new int[id_list.length];
        HashMap<String, HashSet<String>> report_content = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();

        for (String name : id_list) {
            report_content.put(name, new HashSet<>());
        }
        for (String reported : report) {
            String[] reported_names = reported.split(" ");
            report_content.get(reported_names[0]).add(reported_names[1]);
            if (count.containsKey(reported_names[1])) {
                count.put(reported_names[1], count.get(reported_names[1]) + 1);
            } else {
                count.put(reported_names[1], 1);
            }
        }
        for (int i = 0; i < id_list.length; i++) {
            for (String reported : report_content.get(id_list[i])) {
                if (count.get(reported) == k) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
    public int[] beforSolution2(String[] id_list, String[] report, int k) { // 12.5
        int[] answer = new int[id_list.length];

        for(int i=0; i<id_list.length; i++){
            int index = i;
            Arrays.asList(report).stream().distinct().filter(name -> name.contains(id_list[index] + " ")).forEach(counts ->{
                String reporter = counts.replaceAll(id_list[index] + " ","");
                if (Arrays.asList(report).stream().distinct().filter(name -> name.contains(" "+reporter)).count() == k){
                    answer[index]++;
                };
            });
        }
        return answer;
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> reportDocuments = Arrays.stream(report).distinct().collect(Collectors.toList());
        Map<String,Integer> counts = new HashMap<>();
        for(String name : reportDocuments){
            String reportUser = name.split(" ")[1];
            counts.put(reportUser,counts.getOrDefault(reportUser,0)+1);
            // 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
        }

        return Arrays.stream(id_list).map(name -> {
            String user = name;
            List<String> reportMaps = reportDocuments.stream().filter(reported -> reported.startsWith(user+" ")).collect(Collectors.toList());
            return reportMaps.stream().filter(reportMap-> counts.getOrDefault(reportMap.split(" ")[1],0) >=k).count();
        }).mapToInt(Long::intValue).toArray();
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
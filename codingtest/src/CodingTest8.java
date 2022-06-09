class CodingTest8 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int LPoint = 12; // #이 존재하는 위치가 12번째
        int RPoint = 10; // *이 존재하는 위치가 10번째

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                answer += "L";
                LPoint = num;
            }
            else if (num == 3 || num == 6 || num == 9) {
                answer += "R";
                RPoint = num;
            }else {
                if (num == 0) {
                    num = 11;
                }
                int Ldis = Math.abs(num - LPoint)/3 + Math.abs(num - LPoint)%3;
                int Rdis = Math.abs(RPoint - num)/3 + Math.abs(RPoint - num)%3;

                if(Ldis == Rdis){
                    if(hand.equals("right")){
                        answer += "R";
                        RPoint = num;
                    }else {
                        answer += "L";
                        LPoint = num;
                    }
                }
                if(Ldis < Rdis){
                    answer += "L";
                    LPoint = num;
                }
                if(Ldis > Rdis){
                    answer += "R";
                    RPoint = num;
                }

            }

        }
        return answer;
    }

    public static void main(String[] args) {
        CodingTest8 sol = new CodingTest8();

        int[] nums1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand1 = "right";

        int[] nums2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand2 = "left";

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand3 = "right";

        System.out.println(sol.solution(nums1, hand1));
        System.out.println(sol.solution(nums2, hand2));
        System.out.println(sol.solution(nums3, hand3));
    }
}
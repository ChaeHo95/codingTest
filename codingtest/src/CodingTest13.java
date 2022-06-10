public class CodingTest13 {
    private boolean checkIsPrimeNumber(int num)
    {
        // 참조 https://st-lab.tistory.com/81
        // Math.sqrt() 메소드는 인수의 제곱근
        for (int i = 2; i <= Math.sqrt(num); i++)
        {
            // 나눠 떨어질 경우
            if (num % i == 0)
            {
                return false;
            }
        }

        return true;
    }
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                for (int k = j + 1; k < nums.length; k++)
                {
                    int sum = nums[i] + nums[j] + nums[k];
                    answer += checkIsPrimeNumber(sum) ? 1 : 0;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CodingTest13 codingTest13 = new CodingTest13();

        int[] a1 = {1, 2, 3, 4};

        int[] a2 = {1, 2, 7, 6, 4};

        System.out.println(codingTest13.solution(a1));
        System.out.println(codingTest13.solution(a2));
    }
}

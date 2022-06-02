import java.util.Arrays;

public class CodingTest4 {

    public int[] listPush(int num, int[] baseStation, int w) {
        for (int i = num - w; i <= num + w; i++) {
            if (i < 1) {
                continue;
            }
            baseStation[i - 1] = i;
            if (i == baseStation.length) {
                break;
            }
        }
        return baseStation;
    }

    public int beforSolution(int n, int[] stations, int w) {
        int answer = 0;
        int[] baseStation = new int[n];

        for (int num : stations) {
            baseStation = listPush(num, baseStation, w);
        }
        for (int i = 0; i < baseStation.length; i++) {
            if (baseStation[i] == 0) {
                answer++;
                if (i + w < baseStation.length && baseStation[i + w] == 0) {
                    ++i;
                    baseStation = listPush(i + w, baseStation, w);
                    continue;
                }
                baseStation = listPush(i + w, baseStation, w);
            } else {
                continue;
            }
        }
        return answer;
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int station = 1;//기지국을 설치할 현재 위치
        int idx = 0;//설치된 기지국 인덱스

        while(station <= n) {//위치가 전체 갯수보다 작거나 같을 때까지

            //설치된 기지국 범위 안에 있으면서, 현재 위치가 설치된 기지국의 범위보다 클 때,
            if (idx < stations.length && station >= stations[idx]-w) {
                station = stations[idx]+w+1;//설치된 기지국의 범위보다 +1 큰 위치로 이동
                idx++;//다음 인덱스로 이동
            } else {//설치된 기지국 범위 밖일 때,
                station += 2*w+1;//양쪽으로 범위를 가질 최댓값 +1을 해준다.
                answer++;//기지국을 설치했으므로, 결과값을 추가
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        CodingTest4 codingTest4 = new CodingTest4();

        int numberOfApartments1 = 11;
        int[] whereTheBaseStationIsInstalled1 = {4, 11};
        int propagationDistance1 = 1;

        int numberOfApartments2 = 16;
        int[] whereTheBaseStationIsInstalled2 = {9};
        int propagationDistance2 = 2;

        System.out.println(codingTest4.solution(numberOfApartments1, whereTheBaseStationIsInstalled1, propagationDistance1));
        System.out.println(codingTest4.solution(numberOfApartments2, whereTheBaseStationIsInstalled2, propagationDistance2));
    }
}

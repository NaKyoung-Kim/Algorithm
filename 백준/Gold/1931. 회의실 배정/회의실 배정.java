import java.io.*;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args) throws IOException {

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine()); // 회의 수
        int[][] meeting = new int[N][2];

        for (int i = 0; i < N; i++) {
            meeting[i] = toIntArray(br.readLine());
        }

        // 종료시간 기준 오름차순 정렬 & 종료시간이 같으면 시작시간 기준 오름차순 정렬
        Arrays.sort(meeting, (int[] a, int[] b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        

        int T = 0;
        int cnt = 0;

        for (int[] meet: meeting) {
            if (meet[0] >= T) {
                T = meet[1];
                cnt += 1;
            }
        }
        System.out.print(cnt);
	}

    static int[] toIntArray(String input) {
        int[] result = new int[2];
        String[] parts = input.split(" ");
        result[0] = Integer.parseInt(parts[0]);
        result[1] = Integer.parseInt(parts[1]);
        return result;
    }

}

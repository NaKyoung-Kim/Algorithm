import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
       
        int[] result = new int[M];
        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);

        permutation(result, visited, N, M, 0);
        
    }

    static void permutation(int[] result, boolean[] visited, int range, int length, int depth) {
        if (length == depth) {
            for (int i = 0; i < length; i++) {
                System.out.print(result[i] + 1 + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < range; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                permutation(result, visited, range, length, depth+1);
                visited[i] = false;
            }
        }
    }
}

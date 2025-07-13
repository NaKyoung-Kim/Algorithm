import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class Main
{
    static int[] dx = {1, 2, -1, -2, -1, -2, 1, 2};
    static int[] dy = {2, 1, 2, 1, -2, -1, -2, -1};
    static boolean[][] visited;
    static Queue<int[]> queue;
    
	public static void main(String[] args) throws IOException {

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine()); // 테케 수

        for (int i = 0; i < T; i++) {
            int L = Integer.parseInt(br.readLine()); // 한 변의 길이
            visited = new boolean[L][L];
            queue = new LinkedList<>();

	        int[] temp = new int[2];
	        int[] target = new int[2];
            temp = toIntArray(br.readLine());
            target = toIntArray(br.readLine());


            queue.add(new int[]{temp[0], temp[1], 0});
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1], cnt = cur[2];
    
                if( x == target[0] && y == target[1] ) {
                    System.out.println(cnt);
                    break;
                }

                int nx, ny;
                for (int d = 0; d < 8; d++) {
                    nx = x + dx[d];
                    ny = y + dy[d];
                    
                    if (canMove(L, nx, ny, visited)) {
                        queue.add(new int[]{nx, ny, cnt+1});
                        visited[nx][ny] = true; // 큐에서 꺼낼 때가 아니라 넣을 때 방문 체크 해야 중복 막을 수 있음
                    }
                }
            }
        }
	}

    static int[] toIntArray(String input) {
        int[] result = new int[2];
        String[] parts = input.split(" ");
        result[0] = Integer.parseInt(parts[0]);
        result[1] = Integer.parseInt(parts[1]);
        return result;
    }
    
    static boolean canMove(int L, int nx, int ny, boolean[][] visited) {
	    return 0 <= nx && nx < L && 0 <= ny && ny < L && visited[nx][ny] == false;
	}

}

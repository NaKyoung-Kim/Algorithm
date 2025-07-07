import java.io.*;
import java.util.*;

public class Main
{
    static int N;
    static char[][] grid; // 그림
    static boolean[][] visited; // 방문 체크용
    	    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    grid = new char[N][N]; 

	    
	    for (int i = 0; i < N; i++) {
	        grid[i] = br.readLine().toCharArray();
	    }
	    
	    // 적록색약이 아닌 사람
	    visited = new boolean[N][N]; // 방문 체크
	    int cntNormal = 0;
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	            if (!visited[i][j]) {
	                dfs(i, j, grid[i][j], false);
	                cntNormal++;
	            }
	        }
	    } 
	    
	    // 적록색약인 사람
	    visited = new boolean[N][N]; // 방문 체크
	    int cntColor = 0;
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	            if (!visited[i][j]) {
	                dfs(i, j, grid[i][j], true);
	                cntColor++;
	            }
	        }
	    }
		
		System.out.println(cntNormal+" "+cntColor);
	}
	
	static void dfs(int x, int y, char color, boolean isBlind) {
	    visited[x][y] = true; // 방문처리
	    
	    for (int d = 0; d < 4; d++) {
	        int nx = x + dx[d];
	        int ny = y + dy[d];
	        
	        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
	        if (visited[nx][ny]) continue;
	        
	        // 처음 방문한 곳
	        if (isSameColor(color, grid[nx][ny], isBlind)){
	            dfs(nx, ny, color, isBlind);
	        }
	    }
	}
	
	static boolean isSameColor(char tempColor, char newColor, boolean isBlind) {
	    if (isBlind) {
	        if (tempColor == 'R' || tempColor == 'G') {
	            return newColor == 'R' || newColor == 'G';
	        }
	    }
	    return tempColor == newColor;
	}
}

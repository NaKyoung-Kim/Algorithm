import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] T = new int[N]; // 걸리는 날짜
		int[] P = new int[N]; // 금액
		for(int i=0;i<N;i++) {
			T[i] = sc.nextInt();	
			P[i] = sc.nextInt();	
		}
		
		int[] result = new int[N+1];
		
		for(int i=0;i<N;i++) {
			 if(i+T[i] <= N) { 
				 result[i+T[i]] = Math.max(result[i+T[i]], result[i]+P[i]);	
			 }
			 result[i+1] = Math.max(result[i+1], result[i]);
		}
		System.out.println(result[N]);
	}
}
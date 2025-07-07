import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
		
		int cntA = 0;
		int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (str.charAt(i) == 'a') {
                cntA++;
            }
        }
		
		int minB = strLen;
		for(int i = 0; i < strLen; i++) {
		    int tempB = 0;
		    
		    for(int j = 0; j < cntA; j++) {
		        
		        int idx = i+j;
		        if (idx >= strLen) {
		            idx -= strLen;
		        }
		        
		        if (str.charAt(idx) == 'b') {
		            tempB++;   
		        }

		    }
		    if (tempB < minB) {
	            minB = tempB;
	        }
		}
		
		System.out.println(minB);
	}
}
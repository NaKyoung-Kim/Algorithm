import java.io.*;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 수강 가능 인원
        int L = Integer.parseInt(st.nextToken()); // 대기목록 길이
        
        LinkedHashSet<String> inputs = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
            String temp = br.readLine();
            inputs.remove(temp);
            inputs.add(temp);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (String id : inputs) {
            if (cnt >= K) break;
            sb.append(id).append("\n");
            cnt++;
        }
        System.out.println(sb);

    }
    
}

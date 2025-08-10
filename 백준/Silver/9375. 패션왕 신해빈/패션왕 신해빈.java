import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            result = 1;
            int n = Integer.parseInt(br.readLine());    // 의상의 수
            HashMap<String, Integer> clothes = new HashMap<>();
            for (int j = 0; j < n; j++) {   // 의상 정보 입력받기
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                if (clothes.containsKey(type)) {
                    int temp = clothes.get(type);
                    clothes.put(type, temp+1);
                } else {
                    clothes.put(type, 1);
                }
            }
            clothes.forEach((key, value) -> {
                result *= (value + 1);
            });
            System.out.println(result - 1);
        }
    }
}

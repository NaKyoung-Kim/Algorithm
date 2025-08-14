import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int L, C;
    static char[] inputs;
    static char[] output;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        inputs = new char[C];
        output = new char[L];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            inputs[i] = st2.nextToken().charAt(0);
        }
        Arrays.sort(inputs);

        // C개 중 L개를 뽑아 사전순으로 나열. 순열이 아니라 조합
        combination(0, 0);
    }

    static void combination(int start, int depth) {
        if (depth == L) {
            if (canUse(output)) {
                System.out.println(new String(output));
            }
            return;
        }

        for (int i = start; i < C; i++) {
            output[depth] = inputs[i];
            combination(i+1, depth+1);
        }
    }
    
    static boolean canUse(char[] output) {
        int vowel = 0;
        int consonants = 0;
        
        for (char c : output) {
            if ("aeiou".contains(String.valueOf(c))) {
                vowel += 1;
            } else consonants += 1;
        }
        return vowel >= 1 && consonants >= 2;
    }
}

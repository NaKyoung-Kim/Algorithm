import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Task {
        int dueDate;
        int score;
        public Task(int dueDate, int score) {
            this.dueDate = dueDate;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tasks.add(new Task(d, w));
        }
        tasks.sort((a, b) -> a.dueDate - b.dueDate);

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 점수만 저장
        for (Task t : tasks) {
            pq.add(t.score);
            if(pq.size() > t.dueDate) {
                pq.poll(); // 점수 제일 낮은 거 삭제
            }
        }

        int maxScore = 0;
        while (!pq.isEmpty()) {
            maxScore += pq.poll();
        }
        System.out.println(maxScore);
    }
}

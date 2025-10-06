package Leetcode;

import Commonss.FastReader;
import java.io.IOException;
import java.util.*;

public class LeetCode417 {

    private static final int[] rowD = {-1, 0, 1, 0};
    private static final int[] colD = {0, 1, 0, -1};

    private void bfs(int[][] heights, boolean[][] visited, Queue<int[]> q) {
        int m = heights.length;
        int n = heights[0].length;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            for(int d = 0; d < 4; d++){
                int nr = r + rowD[d];
                int nc = c + colD[d];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (heights[nr][nc] < heights[r][c]) continue;
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            pacQueue.offer(new int[]{i, 0});
            atlQueue.offer(new int[]{i, n - 1});
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }
        for(int j = 0; j < n; j++){
            pacQueue.offer(new int[]{0, j});
            atlQueue.offer(new int[]{m - 1, j});
            pacific[0][j] = true;
            atlantic[m - 1][j] = true;
        }

        bfs(heights, pacific, pacQueue);
        bfs(heights, atlantic, atlQueue);

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader("Leetcode/input.txt");
        int m = fs.nextInt();
        int n = fs.nextInt();
        int[][] heights = fs.twoDInput(m, n);

        LeetCode417 lt = new LeetCode417();
        List<List<Integer>> points = lt.pacificAtlantic(heights);

        System.out.println("Number of reachable cells: " + points.size());
        for (var pair : points) {
            System.out.print("[" + pair.get(0) + "," + pair.get(1) + "],");
        }
    }
}

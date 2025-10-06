package Leetcode;

import Commonss.FastReader;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leet778 {
    public static int swimInWater(int[][] grid){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n = grid.length;
        int m = grid[0].length;
        int time = 0;
        // (value, row, col)
        pq.offer(new int[]{grid[0][0],0,0});
        int[] rowD = {-1, 0, 1, 0};
        int[] colD = {0, 1, 0, -1};
        boolean[][] vis = new boolean[n][m];
        while(!pq.isEmpty()){
            int[] data = pq.poll();
            int v = data[0],r = data[1], c = data[2];
            time = Math.max(time, v);
            if(r == n - 1 && c == m - 1) return  time;
            if(vis[r][c]) continue;
            vis[r][c] = true;
            for(int d=0; d<4; d++){
                int nRow = r + rowD[d];
                int nCol = c + colD[d];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !vis[nRow][nCol]){
                    pq.offer(new int[]{grid[nRow][nCol], nRow, nCol});
                }
            }
        }
        return  -1;
    }
    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader("Leetcode/input.txt");
        int m = fs.nextInt();
        int n = fs.nextInt();
        int[][] grid = fs.twoDInput(m, n);
        int ans = swimInWater(grid);
        System.out.println("ANS :"+ ans);
    }

}

package xiongyali;
//输入数据的第一行是三个整数K , M , N，分别表示可能的组合数目，女生的人数，男生的人数。接下来的K行，每行有两个数，分别表示女生Ai只愿意和男生Bj配对。最后一个0结束输，求最多少种组合（一对算一种）
//6 3 3 
//1 1 
//1 2
//1 3
//2 1
//2 3
//3 1
//0
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static int n = 0, m = 0; // 二分图的左边和右边顶点数目
    public boolean dfs(int[][] map, boolean[] used, int[] linked, int start) {
        for (int i = 0; i < m; i++) {
            if (used[i] == false && map[start][i] == 1) {
                used[i] = true;
                if (linked[i] == -1 || dfs(map, used, linked, linked[i])) {
                    linked[i] = start;
                    return true;
                }
            }
        }
        return false;
    }

    public int getMaxNum(int[][] map) {
        int count = 0;
        int[] linked = new int[m];
        for (int i = 0; i < m; i++)
            linked[i] = -1;
        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[m]; // 初始化m部分顶点均为被访问            if (dfs(map, used, linked, i)) // 从顶点i出发能够得到一条增广路径                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Main test = new Main();

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int k = in.nextInt(); // 二分图中边的数目        
            if(k==0){
                break;
            }
            n = in.nextInt()+1;
            m = in.nextInt()+1;
            int[][] map = new int[n][m];
            
            for (int i = 0; i < k; i++) {
                int a = in.nextInt(); // n部分中的顶点                int b = in.nextInt(); // m部分中顶点                map[a][b] = 1;
            }
            System.out.println(test.getMaxNum(map));
        }
    }
}

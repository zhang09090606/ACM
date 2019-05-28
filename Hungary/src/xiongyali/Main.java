package xiongyali;
//�������ݵĵ�һ������������K , M , N���ֱ��ʾ���ܵ������Ŀ��Ů������������������������������K�У�ÿ�������������ֱ��ʾŮ��AiֻԸ�������Bj��ԡ����һ��0�����䣬�����������ϣ�һ����һ�֣�
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
    public static int n = 0, m = 0; // ����ͼ����ߺ��ұ߶�����Ŀ
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
            boolean[] used = new boolean[m]; // ��ʼ��m���ֶ����Ϊ������            if (dfs(map, used, linked, i)) // �Ӷ���i�����ܹ��õ�һ������·��                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Main test = new Main();

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int k = in.nextInt(); // ����ͼ�бߵ���Ŀ        
            if(k==0){
                break;
            }
            n = in.nextInt()+1;
            m = in.nextInt()+1;
            int[][] map = new int[n][m];
            
            for (int i = 0; i < k; i++) {
                int a = in.nextInt(); // n�����еĶ���                int b = in.nextInt(); // m�����ж���                map[a][b] = 1;
            }
            System.out.println(test.getMaxNum(map));
        }
    }
}

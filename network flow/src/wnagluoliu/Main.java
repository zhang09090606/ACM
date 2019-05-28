package wnagluoliu;

//题意：就是由于下大雨的时候约翰的农场就会被雨水给淹没，
//无奈下约翰不得不修建水沟，而且是网络水沟，
//并且聪明的约翰还控制了水的流速，本题就是让你求出最大流速，
//无疑要运用到求最大流了。题中N为水沟数，M为水沟的顶点，注意先输入M后输入n
//接下来Si,Ei,Ci分别是水沟的起点，终点以及其容量。求源点1到终点M的最大流速。注意重边
//输入
//5 4 1 2 40 1 4 20 2 4 20 2 3 30 3 4 10
// 输出
//50

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int map[][];
    static int sum,n,m;
    static int sign[];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            sum=0;
            m=in.nextInt();
            n=in.nextInt();
            map=new int[n+1][n+1];
            for (int i = 0; i <m; i++) {
                    int a=in.nextInt();
                    int b=in.nextInt();
                    int c=in.nextInt();
                    map[a][b]+=c;
            }
            while(bfs()){
                
                int value;
                do {
                    
                    value=dfs(1,Integer.MAX_VALUE);
                    sum+=value;
                } while(value!=0);
            }
            System.out.println(sum);
        }
    }
    public static int dfs(int i,int min){
        if (i==n) {
            return min;
        }
        for (int j = 1; j <=n; j++) {
            if (sign[j]==sign[i]+1&&map[i][j]>0) {
                int k=dfs(j,Math.min(min,map[i][j]));
                if (k>0) {
                    map[i][j]-=k;
                    map[j][i]+=k;
                    return k;
                }
            }
        }
        return 0;
    }
    public static boolean bfs() {
        sign=new int[n+1];
        LinkedList<Integer> link =new LinkedList<Integer>();
        link.push(1);
        sign[1]=1;
        while(!link.isEmpty()){
            
            int top=link.pop();
            for (int i = 1; i <=n; i++) {
                if (sign[i]==0&&map[top][i]>0) {
                    sign[i]=sign[top]+1;
                    link.push(i);
                }
            }
        }
        return sign[n]>0?true:false;
    }
}

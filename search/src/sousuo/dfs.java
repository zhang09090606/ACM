package sousuo;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class dfs {
    static char map[][];
    static int min[][];
    static int x1,x2,y1,y2,time,n,m,turn;
    static boolean sum,sign[][];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            int T=scanner.nextInt();
            for(int j=0;j<T;j++) {
                sum=false;
                m=scanner.nextInt();
                n=scanner.nextInt();
                map=new char[m][n];
                sign=new boolean[m][n];
                min=new int[m][n];
                turn=-1;
                for(int i=0;i<m;i++) {
                    Arrays.fill(min[i],10000);
                }
                
                for(int i=0;i<m;i++) {
                    String string=scanner.next();
                    map[i]=string.toCharArray();
                }
                time=scanner.nextInt();
                y1=scanner.nextInt()-1;
                x1=scanner.nextInt()-1;
                y2=scanner.nextInt()-1;
                x2=scanner.nextInt()-1;
                
                for(int i=1;i<=4;i++) {
                    turn++;
                    dfs(x1, y1, i);
                    turn--;
                }
                if(sum) {
                    System.out.println("yes");
                }else {
                    System.out.println("no");
                }
            }
            
        }
            
            
        
    }
    static void dfs(int x,int y,int k) {

        if(sum||x>=m||x<0||y<0||y>=n||map[x][y]=='*'||sign[x][y]==true||turn>time) {
            return;
        }
        if(x==x2&&y==y2) {
            sum=true;
            return;
        }
        if(turn>min[x][y]) {
            return;
        }
        min[x][y]=turn;
        sign[x][y]=true;
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<m;j++) {
//                System.out.print(sign[i][j]);
//            }System.out.println();
//        }System.out.println();
        for(int i=1;i<=4;i++) {
                if(i!=k) {
                    turn++;
                }
                if(i==1) {
                    dfs(x-1, y, i);
                }else if(i==2) {
                    dfs(x, y-1, i);
                }else if(i==3){
                    dfs(x+1, y, i);
                }else {
                    dfs(x, y+1, i);
                }
                if(i!=k) {
                    turn--;
                }
        }
        sign[x][y]=false;
        
    }
}
package sousuo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
/*　　第1行为一个整数t (1 ≤ t ≤ 100),表示测试数据的个数，接下来为t组测试数据，每组测试数据中，
　　第1行为两个整数m, n (1 ≤ m, n ≤ 100),分别表示迷宫的行数和列数，接下来m行，每行包括n个字符，其中字符'.'表示该位置为空地，字符'*'表示该位置为障碍，输入数据中只有这两种字符，每组测试数据的最后一行为5个整数k, x1, y1, x2, y2 (1 ≤ k ≤ 10, 1 ≤ x1, x2 ≤ n, 1 ≤ y1, y2 ≤ m),其中k表示gloria最多能转的弯数，(x1, y1), (x2, y2)表示两个位置，其中x1，x2对应列，y1, y2对应行。
 
 * bfs 标记节点，计入最小节点   优先队列优化
 */
//2
//5 5
//...**
//*.**.
//.....
//.....
//*....
//1 1 1 1 3
//5 5
//...**
//*.**.
//.....
//.....
//*....
//2 1 1 1 3

public class bfs {
    static int a[][]= {{-1,0},{0,1},{1,0},{0,-1}};//左 上  右 下
    static boolean judgle=false;
    public static void main(String[] args) {    
           Scanner sc=new Scanner(System.in);
           int t=sc.nextInt();  //测试数据      
           for(int t1=0;t1<t;t1++)
           {               
                   int m=sc.nextInt();//行数  Y
                   int n=sc.nextInt();//列数 X
                   sc.nextLine();
                   char[] []b=new char[m][n];//粗存数据
                   boolean c[][]=new boolean[m][n];//是否可走（障碍物记录）
                   int e[][]=new int[m][n];//粗存砖头数
                   for(int i=0;i<m;i++)//输入
                   {
                       String a=sc.nextLine();
                       b[i]=a.toCharArray();
                   }
                   for(int i=0;i<m;i++)//判断
                   {
                       for(int j=0;j<n;j++)
                       {
                           if(b[i][j]=='.')
                           {c[i][j]=true;}
                       }
                   }
                   int k, x1, y1, x2, y2;//转弯数   xy
                   k=sc.nextInt();x1=sc.nextInt();y1=sc.nextInt();x2=sc.nextInt();y2=sc.nextInt();
                   bfs(e,c,x1-1,y1-1,x2-1,y2-1,m,n,k);
                   if(judgle)
                   {System.out.println("yes");judgle=false;}
                   else
                    {System.out.println("no");}
           }           
    }
    private static void bfs(int e[][],boolean[][] c,int x, int y, int x2, int y2,int m,int n,int k) {
        Queue<zuobiao> q1=new PriorityQueue<>(timecomepare);
        e[y][x]=-1;
        q1.add(new zuobiao(x,y));       
        while(!q1.isEmpty())
        {
            zuobiao exa=q1.peek();//头坐标
            q1.poll();
            int x1=exa.x;int y1=exa.y;
            if(x1==x2&&y1==y2){if(exa.time<=k) {judgle=true;break;}}    
            else
            for(int i=0;i<4;i++)
            {
              if(x1+a[i][0]<0||x1+a[i][0]>n-1||y1+a[i][1]<0||y1+a[i][1]>m-1||c[y1+a[i][1]][x1+a[i][0]]==false){}//不能走或者走过   
                else                                        
                    {
                    zuobiao zuo=new zuobiao(x1+a[i][0],y1+a[i][1],exa.time,exa.fangxiang);
                    zuo.fangxiang=i;
                    if(zuo.fangxiang!=exa.fangxiang) {zuo.time++;}
                    if(e[y1+a[i][1]][x1+a[i][0]]>=zuo.time)//转头次数小于等于，入队
                        {q1.add(zuo);e[y1+a[i][1]][x1+a[i][0]]=zuo.time;}                                                                   
                    else if(e[y1+a[i][1]][x1+a[i][0]]==0){//初始的没用过，入队
                    q1.add(zuo);
                    e[y1+a[i][1]][x1+a[i][0]]=zuo.time;         
                    }                    
                }          
            }

        }
    }
    public static Comparator<zuobiao> timecomepare =new Comparator<zuobiao>()//实现comparator接口
            {
                   public int compare(zuobiao a1,zuobiao a2)
                   {
                       return (int)(a1.time-a2.time);
                   }
            };
}   
class  zuobiao
{
    int x;
    int y;
    int time;
    int fangxiang;
    public zuobiao(int x,int y)
    {
        this.x=x;
        this.y=y;
        this.fangxiang=-1;
        this.time=-1;
    }
    public zuobiao(int x,int y,int time,int fangxiang)
    {
        this.x=x;
        this.y=y;
        this.time=time;
        this.fangxiang=fangxiang;
    }
    }

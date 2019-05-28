package sousuo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
/*������1��Ϊһ������t (1 �� t �� 100),��ʾ�������ݵĸ�����������Ϊt��������ݣ�ÿ����������У�
������1��Ϊ��������m, n (1 �� m, n �� 100),�ֱ��ʾ�Թ���������������������m�У�ÿ�а���n���ַ��������ַ�'.'��ʾ��λ��Ϊ�յأ��ַ�'*'��ʾ��λ��Ϊ�ϰ�������������ֻ���������ַ���ÿ��������ݵ����һ��Ϊ5������k, x1, y1, x2, y2 (1 �� k �� 10, 1 �� x1, x2 �� n, 1 �� y1, y2 �� m),����k��ʾgloria�����ת��������(x1, y1), (x2, y2)��ʾ����λ�ã�����x1��x2��Ӧ�У�y1, y2��Ӧ�С�
 
 * bfs ��ǽڵ㣬������С�ڵ�   ���ȶ����Ż�
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
    static int a[][]= {{-1,0},{0,1},{1,0},{0,-1}};//�� ��  �� ��
    static boolean judgle=false;
    public static void main(String[] args) {    
           Scanner sc=new Scanner(System.in);
           int t=sc.nextInt();  //��������      
           for(int t1=0;t1<t;t1++)
           {               
                   int m=sc.nextInt();//����  Y
                   int n=sc.nextInt();//���� X
                   sc.nextLine();
                   char[] []b=new char[m][n];//�ִ�����
                   boolean c[][]=new boolean[m][n];//�Ƿ���ߣ��ϰ����¼��
                   int e[][]=new int[m][n];//�ִ�שͷ��
                   for(int i=0;i<m;i++)//����
                   {
                       String a=sc.nextLine();
                       b[i]=a.toCharArray();
                   }
                   for(int i=0;i<m;i++)//�ж�
                   {
                       for(int j=0;j<n;j++)
                       {
                           if(b[i][j]=='.')
                           {c[i][j]=true;}
                       }
                   }
                   int k, x1, y1, x2, y2;//ת����   xy
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
            zuobiao exa=q1.peek();//ͷ����
            q1.poll();
            int x1=exa.x;int y1=exa.y;
            if(x1==x2&&y1==y2){if(exa.time<=k) {judgle=true;break;}}    
            else
            for(int i=0;i<4;i++)
            {
              if(x1+a[i][0]<0||x1+a[i][0]>n-1||y1+a[i][1]<0||y1+a[i][1]>m-1||c[y1+a[i][1]][x1+a[i][0]]==false){}//�����߻����߹�   
                else                                        
                    {
                    zuobiao zuo=new zuobiao(x1+a[i][0],y1+a[i][1],exa.time,exa.fangxiang);
                    zuo.fangxiang=i;
                    if(zuo.fangxiang!=exa.fangxiang) {zuo.time++;}
                    if(e[y1+a[i][1]][x1+a[i][0]]>=zuo.time)//תͷ����С�ڵ��ڣ����
                        {q1.add(zuo);e[y1+a[i][1]][x1+a[i][0]]=zuo.time;}                                                                   
                    else if(e[y1+a[i][1]][x1+a[i][0]]==0){//��ʼ��û�ù������
                    q1.add(zuo);
                    e[y1+a[i][1]][x1+a[i][0]]=zuo.time;         
                    }                    
                }          
            }

        }
    }
    public static Comparator<zuobiao> timecomepare =new Comparator<zuobiao>()//ʵ��comparator�ӿ�
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

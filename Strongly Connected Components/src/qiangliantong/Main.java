package qiangliantong;
//����ĵ�һ������������N��M����������M��ÿ����������a��b����ʾ��һ��ͨ�����Դ�A��������B���䡣�ļ����������0���������������ÿ�����ݣ���������������䶼���໥���ӵģ����"Yes"���������"No"��
//��������3 3 1 2 2 3 3 1 3 3 1 2 2 3 3 2 0 0
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
class Main {
  private int numOfNode;  
  private List< ArrayList<Integer> > graph;//ͼ  
  private List< ArrayList<Integer> > result;//���漫��ǿ��ͨͼ  
  private boolean[] inStack;//�ڵ��Ƿ���ջ�ڣ���Ϊ��stack��Ѱ��һ���ڵ㲻���㡣���ַ�ʽ���ҿ�  
  private Stack<Integer> stack;  
  private int[] dfn;  
  private int[] low;  
  private int time;
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      while(in.hasNext()){
          int n=in.nextInt();
          int m=in.nextInt();
          if(n==0&&m==0){
              break;
          }
          List< ArrayList<Integer> > graph = new ArrayList<ArrayList<Integer>>();  
          for(int i=0;i<n;i++){                
              graph.add(new ArrayList<Integer>());  
          }
          for(int i=0;i<m;i++){
              int a=in.nextInt()-1;
              int b=in.nextInt()-1;
              graph.get(a).add(b);
          }
          Main t = new Main(graph, n);  
          List< ArrayList<Integer> > result = t.run();  
                  //��ӡ���  
          int sum=0;//sumΪǿ��ͨ��������
          for(int i=0;i<result.size();i++){
              if(sum<result.get(i).size()){
                  sum=result.get(i).size();  
                
              }  
                
          }  if(sum==n){
              System.out.println("Yes");
          }else{
              System.out.println("No");
          }
      }

          
  }
  public Main(List< ArrayList<Integer> > graph,int numOfNode){  
      this.graph = graph;  
      this.numOfNode = numOfNode;  
      this.inStack = new boolean[numOfNode];  
      this.stack = new Stack<Integer>();  
      dfn = new int[numOfNode];  
      low = new int[numOfNode];  
      Arrays.fill(dfn, -1);//��dfn����Ԫ�ض���Ϊ-1������dfn[i]=-1����i����û�����ʹ���  
      Arrays.fill(low, -1);  
      result = new ArrayList<ArrayList<Integer>>();  
  }  
    
  public List< ArrayList<Integer> > run(){  
      for(int i=0;i<numOfNode;i++){  
          if(dfn[i]==-1){  
              tarjan(i);  
          }  
      }  
      return result;  
  }
    
  public void tarjan(int current){
      dfn[current]=low[current]=time++;  
      inStack[current]=true;  
      stack.push(current);  
        
      for(int i=0;i<graph.get(current).size();i++){  
          int next = graph.get(current).get(i);  
          if(dfn[next]==-1){//-1����û�б�����  
              tarjan(next);  
              low[current]=Math.min(low[current], low[next]);  
          }else if(inStack[next]){  
              low[current]=Math.min(low[current], dfn[next]);  
          }  
      }  
        
      if(low[current]==dfn[current]){  
          ArrayList<Integer> temp =new ArrayList<Integer>();  
          int j = -1;  
          while(current!=j){  
              j = stack.pop();  
              inStack[j]=false;  
              temp.add(j);  
          }  
          result.add(temp);             
      }  
  }
    
}  
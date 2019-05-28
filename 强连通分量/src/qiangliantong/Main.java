package qiangliantong;
//输入的第一行有两个数：N和M，接下来的M行每行有两个数a和b，表示了一条通道可以从A房间来到B房间。文件最后以两个0结束。对于输入的每组数据，如果任意两个房间都是相互连接的，输出"Yes"，否则输出"No"。
//测试数据3 3 1 2 2 3 3 1 3 3 1 2 2 3 3 2 0 0
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
class Main {
  private int numOfNode;  
  private List< ArrayList<Integer> > graph;//图  
  private List< ArrayList<Integer> > result;//保存极大强连通图  
  private boolean[] inStack;//节点是否在栈内，因为在stack中寻找一个节点不方便。这种方式查找快  
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
                  //打印结果  
          int sum=0;//sum为强连通分量个数
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
      Arrays.fill(dfn, -1);//将dfn所有元素都置为-1，其中dfn[i]=-1代表i还有没被访问过。  
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
          if(dfn[next]==-1){//-1代表没有被访问  
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
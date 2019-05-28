package min_lujing;
import java.util.Arrays;
import java.util.Scanner;

public class dijkstra {
	 
    private static int N = 1005;//给邻接矩阵赋的初始值
    private static int[][] Graph=new int[1111][1111];
    private static int[] mindist=new int[1111];//储存到某点的最短路径
    public static void main(String[] args) {
    	Scanner scanner=new Scanner(System.in);    	
    	while (scanner.hasNext()) {
    	for(int i=0;i<1111;i++){
    		Arrays.fill(Graph[i],N);
    	}  	
    		int n=scanner.nextInt()+1;
    		int m=scanner.nextInt();
    		int x=scanner.nextInt();// System.out.println("Sss");
    		for(int i=1;i<n;i++){
    			int q=scanner.nextInt();
    			int p=scanner.nextInt();
    			int o=scanner.nextInt();
    			if(o<Graph[q][p]){
    				Graph[q][p]=o;
    			}
    			if(o<Graph[p][q]){
    				Graph[p][q]=o;
    			}
    			
    		}

    		for(int i=0;i<m;i++){
    			int q=scanner.nextInt();
    			Graph[0][q]=0;
    		} 
    		
    		dijkstra(0, Graph);
    		int min=1005;
    		for(int i=0;i<x;i++){
    			int temp=scanner.nextInt();
    			if(mindist[temp]<min){
    				min=mindist[temp];
    			}
    		}
    		  System.out.println(min);
    		  
		}
    	
       
    }
 //vs为起始点，graph储存数据的邻接矩阵,mindist[]储存到某点的最短路径
    public static void dijkstra(int vs, int[][] Graph) {
    	
        int NUM = Graph[0].length;
        // 前驱节点数组
        int[] prenode = new int[NUM];
        // 最短距离数组
      
        // 该节点是否已经找到最短路径
        boolean[] find = new boolean[NUM];
         
        int vnear = 0;
         
        for (int i = 0; i < mindist.length; i++) {
            prenode[i] = i;
            mindist[i] = Graph[vs][i];
            find[i] = false;
        }
 
        find[vs] = true;
 
        for (int v = 1; v < Graph.length; v++) {
 
            // 每次循环求得距离vs最近的节点vnear和最短距离min
            int min = N;
            for (int j = 0; j < Graph.length; j++) {
                if (!find[j] && mindist[j] < min) {
                    min = mindist[j];
                    vnear = j;
                }
            }
            find[vnear] = true;

            // 根据vnear修正vs到其他所有节点的前驱节点及距离
            for (int k = 0; k < Graph.length; k++) {
                if (!find[k] && (min + Graph[vnear][k]) < mindist[k]) {
                    prenode[k] = vnear;
                    mindist[k] = min + Graph[vnear][k];
                }
            }
        }
         
//        for (int i = 0; i < NUM; i++) {用于测试输出到所有点的最短路径
//            System.out.println("v" + vs + "...v" + prenode[i] + "->v" + i + ", s=" + mindist[i]);
//        }
    }
    }
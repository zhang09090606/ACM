package min_tree;
import java.util.Arrays;
import java.util.Scanner;



public class Kruskal {
    static int fa[],ans;
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            
            int n=sc.nextInt();
            int m= n * (n + 1) / 2;
            fa=new int[n+1];
    
            Node node[]=new Node[m];
            for(int i=0;i<n;i++) {
            	for(int j=0;j<n;j++) {
            		node[i]=new Node(sc.nextInt(),sc.nextInt(), sc.nextInt());
            	}
            }
            Arrays.sort(node,0,m);
            kruskal(node,n,m);
            
        }
    
    static void kruskal(Node node[],int n,int m) {
         for(int i=0;i<=n;i++) {
             fa[i]=i;
         }    
             ans=0;
            for(int i=0;i < m;i++) {
                if(find(node[i].from) != find(node[i].to)) {
                    Merge(node[i].from, node[i].to);
                    ans += node[i].d;
                }
            }
            System.out.println(ans);
    }
    //合并根节点
    static void Merge(int x,int y) {
        int i = find(x);
        int j = find(y);
        if (i != j) {
            fa[i] = j;
        }
    }
    //并查集
    static int find(int x) {
        if(fa[x]==x) {
            return x;
        }
        return fa[x]=find(fa[x]);
    }
}
class Node implements Comparable<Node>{
    int from;
    int to;
    int d;//到当前节点的最短距离
    
    public Node(int from,int to,int d) {
        this.from=from;
        this.to=to;
        this.d=d;
    }



    @Override
    public int compareTo(Node o) {
        // TODO Auto-generated method stub
        return -(o.d-this.d);
    }

    
    
    
}
package min_lujing;
//������һ��ͼ�Ķ�������n����±�s�ͱ�����p��6 1 18
//���������ߵ����ݣ�0 1 6
//0 2 3
//1 2 2
//1 3 5
//2 3 3
//2 4 4
//3 4 2
//3 5 3
//4 5 5
//1 0 6
//2 0 3
//2 1 2
//3 1 5
//3 2 3
//4 2 4
//4 3 2
//5 3 3
//5 4 5
//5 0 2 5 6 8 
import java.util.ArrayList;
import java.util.Scanner;

public class spfa {
    
    public long[] result;         //���ڵõ���s�����㵽��������֮�����̾���
    //�ڲ��࣬���ڴ��ͼ�ľ��������
    class edge {
        public int a;  //�ߵ����
        public int b;  //�ߵ��յ�
        public int value;   //�ߵ�Ȩֵ
        
        edge(int a, int b, int value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }
    }
    /*
     * ����n:����ͼ�Ķ������
     * ����s:��ȡ��s�����㵽�������ж���֮�����̾���
     * ����edge:����ͼ�ľ����
     * �������ܣ��������ͼ������Ȩ��·������Եõ����ս����������и�Ȩ��·�����ܵõ����ս��
     */
    public boolean getShortestPaths(int n, int s, edge[] A) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        result = new long[n];
        boolean[] used = new boolean[n];
        int[] num = new int[n];
        for(int i = 0;i < n;i++) {
            result[i] = Integer.MAX_VALUE;
            used[i] = false;
        }
        result[s] = 0;     //��s�����㵽�������Ϊ0
        used[s] = true;    //��ʾ��s��������������
        num[s] = 1;       //��ʾ��s�������ѱ�����һ��
        list.add(s);      //��s���������
        while(list.size() != 0) {
            int a = list.get(0);   //��ȡ������е�һ��Ԫ��
            list.remove(0);         //ɾ��������е�һ��Ԫ��
            for(int i = 0;i < A.length;i++) {
                //��list����ӵĵ�һ��Ԫ�ص��ڱ�A[i]�����ʱ
                if(A[i] != null &&a == A[i].a && result[A[i].b] > result[A[i].a] + A[i].value) { 
                    result[A[i].b] = result[A[i].a] + A[i].value;
                    if(!used[A[i].b]) {
                        list.add(A[i].b);
                        num[A[i].b]++;
                        if(num[A[i].b] > n)
                            return false;
                        used[A[i].b] = true;   //��ʾ��A[i]���յ�b�ѽ��������
                    }
                }
            }
            used[a] = false;        //����a�������
        }
        return true;
    }
    
    public static void main(String[] args) {
        spfa test = new spfa();
        Scanner in = new Scanner(System.in);
        //��������n����±�s�ͱ�����p    
        int n = in.nextInt();
        int s = in.nextInt();
        int p = in.nextInt();        
        //�����
        edge[] A = new edge[p];
        //�����ڽӾ���
        for(int i = 0;i < p;i++) {
             int a = in.nextInt();
             int b = in.nextInt();
             int value = in.nextInt();
 //��������ر߻��߷���ߵ�ʱ��ǵ�i���ӣ���������
             A[i] = test.new edge(a, b, value);
        
        }
        if(test.getShortestPaths(n, s, A)) {
             for(int i = 0;i < test.result.length;i++){
                //��ӡ���s�㵽i������·��
            	 System.out.print(test.result[i]+" ");
                 }
        } else
             System.out.println("����ͼ���ڸ�����û����̾���");
    }
}
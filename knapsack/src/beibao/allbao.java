package beibao;

public class allbao {

	public static void main(String[] args) {
//		NΪ��Ʒ����
//		���ã�   int f[]=bao(m,w,p);      
//		��ӡ��f[f.length-1]Ϊ�����װ�ļ�ֵ


		
		

	}
	public static int[] bao(int m, int[]w,int []p){
		//m:�����ܴ�С��w����Ʒ�������p����Ʒ��ֵ
		int f[]=new int[m+1];
		for(int i=0;i<p.length;i++){  
		for(int j=w[i];j<f.length;j++){  
		                f[j] = Math.max(f[j], f[j-w[i]]+p[i]);  
		            }  
		        }       
			return f;    
	}
}

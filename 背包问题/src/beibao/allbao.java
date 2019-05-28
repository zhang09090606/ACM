package beibao;

public class allbao {

	public static void main(String[] args) {
//		N为商品个数
//		调用：   int f[]=bao(m,w,p);      
//		打印：f[f.length-1]为最多能装的价值


		
		

	}
	public static int[] bao(int m, int[]w,int []p){
		//m:包的总大小，w：商品的体积，p：商品价值
		int f[]=new int[m+1];
		for(int i=0;i<p.length;i++){  
		for(int j=w[i];j<f.length;j++){  
		                f[j] = Math.max(f[j], f[j-w[i]]+p[i]);  
		            }  
		        }       
			return f;    
	}
}

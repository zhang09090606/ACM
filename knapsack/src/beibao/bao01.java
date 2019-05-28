package beibao;

public class bao01 {
	public static int[][] BackPack(int m, int n, int[] w, int[] p) {
		//m:背包容量  n:商品个数  w:商品体积  p:商品价值	
			//打印：System.out.print(c[i][j]);
		int c[][] = new int[n + 1][m + 1];
		for (int i = 1; i < n + 1; i++) {
		for (int j = 1; j < m + 1; j++){
		if (w[i - 1] <= j) {
		if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1]))
		                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
		else
		                        c[i][j] = c[i - 1][j];
		                } else
		                    c[i][j] = c[i - 1][j];
		            }
		        }
		return c;
		    }
}


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static int[][] LCS(String a, String b) {
		//aΪ�Ӵ�1��bΪ�Ӵ�b
		//����  int[][] dp = LCS(a, b);
		//��ӡ����������еĳ��ȣ�System.out.println(dp[a.length()][b.length()]);
				int dp[][] = new int [a.length()+1][b.length()+1];
				for (int i = 1; i < dp.length; i++) {
				    for (int j = 1; j < dp[i].length; j++) {
				        if (a.charAt(i-1) == b.charAt(j-1)) {
				            dp[i][j] = dp[i-1][j-1] +1; 
				        }else {
				            dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				        }
				    }
				}
				return dp;
			}
}

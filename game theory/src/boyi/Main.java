package boyi;

public class Main {

	
	//1、  本游戏是一个二人游戏 有一堆石子一共有n个,两人轮流进行，每走一步可以取走1…m个石子；  最先取光石子的一方为胜；
	public static int Bash_Game(int n, int m) {
					if (n % (m + 1) != 0)
						return 1;
					return 0;	
				}
	//return 1时先手赢否后手赢
	//n：石子总数m:一次可取的最大值
	
	
	//有两堆石子，数量任意，可以不同。游戏开始由两个人轮流取石子。游戏规定，每次有两种不同的取法，一是可以在任意的一堆中取走任意多的石子；二是可以在两堆中同时取走相同数量的石子。最后把石子全部取完者为胜者。现在给出初始的两堆石子的数目，如果轮到你先取，假设双方都采取最好的策略，问最后你是胜者还是败者。
	public static int Wythoff(int n,int m) {
		//1先手赢，0后手赢
		if(n>m) {
			int temp=n;
			n=m;
			m=temp;
		}
		int k=m-n;
		double path=(Math.sqrt(5)+1)/2;
		if(n==Math.floor(path*k)) {
			return 0;
		}else {
			return 1;
		}
	}
	
	
	//n堆物品，两人轮流取，每次取某堆中不少于1个，最后取完者胜。 
	public static int Nimm (int n,int arr[]) {
			//1先手赢，0后手，n为堆的数量，arr存每队的石子个数
			int flag=0;
			for(int i=0;i<n;i++) {
				flag^=arr[i];
			}
			if(flag==0) {
				return 0;
			}else {
				return 1;
			}
		}
	
//	斐波那契博弈（斐波那契额定理）：一堆石子有n个，两人轮流取，先取者第1次可以取任意多个，但不能全部取完，以后每次取的石子数不能超过上次取子数的2倍。取完者胜. 
//	这同样是一个规律：先手胜当且仅当n不是斐波那契数（n为物品总数）；
	
	public static int Fibonacci(int n) {
		//1先手贏
		if(n==1) {
			return 1;
		}
		int f[]=new int[10000];
		f[0]=f[1]=1;
		for(int i=2;f[i-1]<n;i++){
			f[i]=f[i-1]+f[i-2];
			if(f[i]==n) {
				return 0;
			}
		}
		return 1;
	}
}


package treearr;

import java.util.Scanner;
public class Main {
	static int arr[];
	static int n;
	static int maxarr[];
	static int maxsign[];
	static int lowBit(int x) {
		return x & (-x);
	}
	static int getSum(int x) {// ���ۼӺ�
		int sum = 0;
		while (x > 0) {
			sum += arr[x];
			x -= lowBit(x);
		}
		return sum;
	}
	
	static void update(int x, int y) {//����
		while (x < n) {
			arr[x] += y;
			maxarr[x]=maxsign[x];
			
			int lx=lowBit(x);
			for (int i=1; i<lx; i<<=1)
				maxarr[x] = Math.max(maxarr[x], maxarr[x-i]);
			x += lowBit(x);
		}
	}
	static int getmax(int x,int y) {	//��ȡ���ֵ
		int ans=0;
		while (y>=x) {
			ans=Math.max(maxsign[y],ans);
			y--;
			while(y-lowBit(y)>=x) {
				ans=Math.max(maxarr[y], ans);
				y-=lowBit(y);
			}
		}	
		return ans;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
				n = scanner.nextInt();
				int m=scanner.nextInt();
				arr= new int[n+1];
				maxarr=new int[n+1];
				maxsign=new int[n+1];
				for (int i = 1; i <= n; i++) {
					int x = scanner.nextInt();
					maxsign[i]=x;
					update(i, x);
				}
				for(int i=0;i<m;i++) {
					String string=scanner.next();
					int a=scanner.nextInt();
					int b=scanner.nextInt();
					
					if(string.equals("U")) {
						maxsign[a]=b;
						update(a, b-maxsign[a]);
						
					}else {
						System.out.println(getmax(a,b));
					}

				}
			
//�������ӻ����ֵ				
//						int data=scanner.nextInt();
//						int value=scanner.nextInt();
//						maxsign[data]=maxsign[data]+value;
//						update(data, value);

//���������ֵ
//						int left=scanner.nextInt();
//						int right=scanner.nextInt();
//						System.out.println(getmax(left,right));
					
					
//�������					
//						int left=scanner.nextInt();
//						int right=scanner.nextInt();
//						System.out.println(getSum(right)-getSum(left-1));
	
//��ȡ�������ֵ				
//				int left=scanner.nextInt();
//				int right=scanner.nextInt();	
//				System.out.println(getmax(left,right));
				
				
//�������ֵ
//				maxsign[a]=b;
//				update(a, b-maxsign[a]);	
			
			}
		}
	}

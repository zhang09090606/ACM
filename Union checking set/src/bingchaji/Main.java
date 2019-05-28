package bingchaji;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class Main {
	static Map<Integer,Integer> map;
	static int n;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int t=in.nextInt();
			for(int k=0;k<t;k++) {
			n=in.nextInt();
			map=new HashMap<Integer,Integer>();
			for (int i = 0; i < 1000000000; i++) {
				map.put(i, i);
			}

			for (int i = 0; i < n; i++) {
				int a = in.nextInt() - 1;
				int b = in.nextInt() - 1;
				u(a, b);
				u(b, a);

			}
			int sum=0;
			for(int i=1;i<1000000000;i++) {
				if(f(i)==f(1)) {
					sum++;
				}
			}
			System.out.println(sum);

		}}}
	

	private static void u(int a, int b) {
		if (f(a) == f(b)) {
			return;
		} else {
			map.put(f(a), f(b));
		}

	}

	private static int f(int i) {
		if (map.get(i) == i)
			return i;
		return map.put(i, f(map.get(i)));
	}
}
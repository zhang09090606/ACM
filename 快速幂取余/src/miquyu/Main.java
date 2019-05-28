package miquyu;

import java.util.Arrays;

public class Main {
	public static Boolean[] prime(Boolean prime[],int max) {
		//max 为prime最大值
				Arrays.fill(prime, true);
				for (int i = 2; i * i < max; i++) {
					if (prime[i]) {
						for (int j = i + i; j < max; j+=i) {
							prime[j] = false;
						}
					}
				}
				return prime;
	}
}

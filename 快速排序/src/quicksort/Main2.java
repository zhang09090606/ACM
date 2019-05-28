package quicksort;

public class Main2 {
	private static void quick(long[] shu ,long[] arr, int start, int end) {
		//
				int i = start;
				int j = end;
				long temp = shu[i];
				long temp1=arr[i];

				int empty = i;
				while (i < j) {
					while (i < j && temp <= shu[j]) {
						j--;
					}
					if (i < j) {
						shu[empty] = shu[j];
						arr[empty]=arr[j];		
					
						empty = j;
					}
					while (i < j && temp >= shu[i]) {
						i++;
					}
					if (i < j) {
						shu[empty] = shu[i];
						arr[empty]=arr[i];	
						
						empty = i;
					}
				}
				shu[empty] = temp;
				arr[empty]=temp1;

				if (i - start > 1) {
					quick(shu,arr, 0, i - 1);
				}
				if (end - j > 1) {
					quick(shu,arr, j + 1, end);
				}
			}
}

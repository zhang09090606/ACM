
public class Main {
	public static int[] getNext(String desk) {
		int next[] = new int[desk.length() + 1];
		int i = 0;
		next[i] = -1;
		int j = -1;
		while (i < desk.length()) {
			if (j == -1 || desk.charAt(i) == desk.charAt(j)) {
				++i;
				++j;
				next[i] = j;
			} else {
				j = next[j];
			}
		}
		return next;
	}
	/***
	 * 求匹配个数
	 * @param string
	 * @param desk
	 * @param next
	 * @return
	 */
	public static int kmp_match(String string, String desk, int next[]){
		int i = 0;
		int j = 0;
		int cnt = 0;
		while (i < string.length()) {
			if (j < 0 || string.charAt(i) == desk.charAt(j)) {
				i ++;
				j ++;
			} else {
				j = next[j];
			}
			if (j == desk.length()) {
				cnt++;
				j = next[j];
			}
		}
		return cnt;
	}
	/***
	 * 返回第一个索引
	 * @param string
	 * @param desk
	 * @param next
	 * @return
	 */
	public static int kmp_search(String string, String desk, int next[]){
		int i = 0;
		int j = 0;
		int cnt = 0;
		while (i < string.length()) {
			if (j < 0 || string.charAt(i) == desk.charAt(j)) {
				i ++;
				j ++;
			} else {
				j = next[j];
			}
			if (j == desk.length()) {
				return i - desk.length();
			}
		}
		return -1;
	}
}

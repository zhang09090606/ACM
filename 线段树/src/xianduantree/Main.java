package xianduantree;

import java.util.Scanner;

public class Main {
	public static final int N = 201000;
	public static int tot;
	public static int[] a = new int[N];
	static int maxnum[] = new int[201000 << 2];// �������ֵ
	public static int[] tleft = new int[3 * N];
	public static int[] tright = new int[3 * N];
	public static long[] tsum = new long[3 * N];//���ڴ��������
	public static long[] td = new long[3 * N];//


	public static void main(String[] args) {
		tot = 0;
		// nΪ�ڵ���
		String str;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();//n������
			int m = sc.nextInt();//m��ѯ��
			for (int i = 1; i <= n; i++) {
				a[i] = sc.nextInt();//a����������
			}
			creatTree(1, 1, n);
				//	System.out.println(getmax(left, right, 1, n, 1));��ȡ��left					��right���ֵ����left��right
				//	System.out.println(query(1, left, right, 0));
				//modify(now, value, 1, n, 1);//��now�Ļ����ϼ�now
				//	insert(1, left, right, value);//left��right��Χ�����нڵ��					��value
			
			
		}
	}

	static void modify(int p, int v, int l, int r, int rt) {
		if (l == r) {
		maxnum[rt] = v;
			return;
		}
		int mid = l + r >> 1;
		if (p <= mid)
			modify(p, v, l, mid, rt << 1);
		else
			modify(p, v, mid + 1, r, rt << 1 | 1);
		up(rt);
	}

	static void up(int rt) {//���������ֵ

		maxnum[rt] = max(maxnum[rt << 1], maxnum[rt << 1 | 1]);// �����ż���Ƚ������Զ��������Լ�һ������ֱ�ӵ��������Զ�
	}

	static int max(int a, int b) {//�Ƚϴ�С�������ֵʱ�ã�
		return a > b ? a : b;
	}
	public static int getmax(int L, int R, int l, int r, int rt) {//�����ֵ
		if (L <= l && r <= R)
			return maxnum[rt];
		int mid = l + r >> 1;
		int ret = 0;
		if (L <= mid)
			ret = max(ret, getmax(L, R, l, mid, rt << 1));
		if (R > mid)
			ret = max(ret, getmax(L, R, mid + 1, r, rt << 1 | 1));
		return ret;
	}
	public static long creatTree(int now, int left, int right) {
		// �����࣬a[]�������
		if (now > tot) {
			maxnum[now] = a[left];
			tot = now;
		}
		int mid = left + right >> 1;
		tleft[now] = left;
		tright[now] = right;
		long lSum = 0, rSum = 0;
		if (left < right) {
			lSum = creatTree(2 * now, left, mid);
			rSum = creatTree(2 * now + 1, mid + 1, right);
			tsum[now] = lSum + rSum;

		} else {
			tsum[now] = a[left];
		}
		if (left == right) {	//���ڸ��������ֵ�����鸳ֵ
			maxnum[now] = a[left];
		} else {
			up(now);
		}

		return tsum[now];
	}



	public static void insert(int now, int left, int right, int value) {
		// ��left��right�����ڵ�������value
		if (now > tot)
			return;
		if (left <= tleft[now] && right >= tright[now]) {
			td[now] += value;
			return;
		}
		long lSum = 0, rSum = 0;
		if (left <= (tleft[now] + tright[now]) / 2)
			insert(2 * now, left, right, value);
		if (right > (tleft[now] + tright[now]) / 2)
			insert(2 * now + 1, left, right, value);
		if (2 * now <= tot)
			lSum = tsum[2 * now] + td[2 * now] * (tright[2 * now] - tleft[2 * now] + 1);
		if (2 * now + 1 <= tot)
			rSum = tsum[2 * now + 1] + td[2 * now + 1] * (tright[2 * now + 1] - tleft[2 * now + 1] + 1);
		tsum[now] = lSum + rSum;
	}

	public static long query(int now, int left, int right, long d) {
		// ������left��right��ֵ�ú�
		if (now > tot)
			return 0;
		if (left <= tleft[now] && right >= tright[now])
			return tsum[now] + (td[now] + d) * (tright[now] - tleft[now] + 1);
		long lSum = 0, rSum = 0;
		if (left <= (tleft[now] + tright[now]) / 2)
			lSum = query(2 * now, left, right, d + td[now]);
		if (right > (tleft[now] + tright[now]) / 2)
			rSum = query(2 * now + 1, left, right, d + td[now]);
		return lSum + rSum;
	}
}

import java.util.Random;

public class Quick {
	public static int[] list = new int[10];
	int head;
	int end;

	public Quick() {
		Random random = new Random();
		for (int b = 0; b < 10; b++) {
			int a = random.nextInt((100) + 1);
			list[b] = a;
		}
	}

	public void change(int[] num, int head, int end) {
		this.head = head;
		this.end = end;
		int a = num[(head + end) / 2];		
		int i = head;
		int j = end;
		if (head >= end || num == null || num.length <= 1) {
			return;
		}

		while (i <= j) {
//			當i位置的數字小於a(基準值)，則i往後移一位
			while (num[i] < a) {
				i = i + 1;
			}
//			當j位置的數字小於a(基準值)，則j往後前一位
			while (num[j] > a) {
				j = j - 1;
			}
//			交換(比基準值大往右丟，比基準值小往左丟)
			if (i < j) {
				int t = num[i];
				num[i] = num[j];
				num[j] = t;
				i = i + 1;
				j = j - 1;
			} else if(i == j) {
				i = i + 1;
			}
		}
//		更改基準值
//		處理基準值左邊
		change(num, head, j);
//		處理基準值的右邊
		change(num, i, end);
	}


	public void print() {

		for (int b = 0; b < list.length; b++) {
			System.out.print(list[b] + " ");
		}

	}

	public static void main(String[] args) {
		Quick q = new Quick();
//		印出樣本數列
		System.out.print("原始陣列: { ");
		q.print();
		System.out.println("}");
//		交換
		q.change(list, 0, 9);
//		印出交換後的數列
		System.out.print("排列後: { ");
		q.print();
		System.out.println("}");

	}
}

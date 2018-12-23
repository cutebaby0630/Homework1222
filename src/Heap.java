import java.util.Random;

public class Heap {
	public static int[] list = new int[10];
	static int size = 9;

	public Heap() {

	}

	public void list() {
		Random random = new Random();
		for (int b = 0; b < 10; b++) {
			int a = random.nextInt((100) + 1);
			list[b] = a;
		}
	}

	public static void print() {
		for (int b = 0; b < list.length; b++) {
			System.out.print(list[b] + " ");
		}
	}

	public static void tree(int list[], int i, int size) {
		int j = 2 * i;
		int tmp = list[i];
		boolean end = true;
		while (j <= size && end) {
			if (j < size) {
				// 找最大節點
				if (list[j] < list[j + 1]) {
					j = j + 1;
				}
			}
			if (tmp >= list[j]) {
				// 若樹根為最大end 改flase跳出迴圈
				end = false;
				break;
			} else {
				// 若樹根較小，則繼續比較
				list[j / 2] = list[j];
				j = 2 * j;
			}
		}
		// 指定樹根為父節點
		list[j / 2] = tmp;
	}

	public void create(int list[], int size) {
		// 建立堆積樹
		for (int i = (size / 2); i > 0; i--) {
			Heap.tree(list, i, size);
		}
		// 原始堆積樹
		System.out.print("heap tree :{ ");
		Heap.print();
		System.out.println("}");
		// change
		for (int i = size - 2; i > 0; i--) {
			// 頭尾交換
			int tmp = list[i + 1];
			list[i + 1] = list[1];
			list[1] = tmp;
			// 重新排序剩下的節點
			Heap.tree(list, 1, i);
			// System.out.print("\n過程");
			// for(int j=1;j<size;j++) {
			// System.out.print("["+list[j]+"]");
			// }
		}
	}

	public static void main(String[] args) {
		Heap data = new Heap();
//		產生資料
		data.list();
		System.out.print("原始陣列:{ ");
		data.print();
		System.out.println("}");
//		開始排序
		data.create(list, size);
		System.out.print("排序結果:{ ");
		for (int j = 1; j < size; j++) {
			System.out.print(list[j] + " ");
		}
		System.out.println("}");

	}

}

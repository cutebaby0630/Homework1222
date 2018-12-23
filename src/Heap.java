import java.util.Random;

public class Heap {
	public static int[] list = new int[10];
	static int size =9;
	public Heap() {
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

		for (int i = (size / 2); i > 0; i--) {
			Heap.tree(list, i, size);
		}
		System.out.println("heap tree :");
		Heap.print();
		
	}
	public static void change() {
		for(int i = (size/2);i>0;i++) {
			int tmp = list[i+1];
			list[1] = tmp;
			Heap.tree(list, i, size);
		}
	}
	public static void main(String[] args) {
		Heap data = new Heap();
		System.out.print("原始陣列:{ ");
		data.print();
		System.out.println(" }");
		data.create(list, size);
		System.out.print("排序結果:{ ");
		data.print();
		System.out.println(" }");
		
	}

}

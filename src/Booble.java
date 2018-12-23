import java.util.Random;
import java.util.Scanner;

public class Booble {
	public static void main(String[] args) {
		
//			int n[] = { 51, 23, 6, 65, 15 ,89,100,1235,358};
			Random r = new Random();
			int n[] = new int[10];
			for (int i = 0; i < 10; i++) {
				n[i] = (int) r.nextInt((50) + 1);

			}
			System.out.print("原始陣列:{ ");
			for(int num:n){
				System.out.print(num + " ");
			}
			System.out.println("}");
			for (int i = 0; i < n.length - 1; i++) {
				for (int j = (i + 1); j < n.length; j++) {
					if (n[i] > n[j]) {
						int tmp = n[i];
						n[i] = n[j];
						n[j] = tmp;
					}
				}
			}
			System.out.print("排列後:{ ");
			for(int num:n){
				System.out.print(num + " ");
			}
			System.out.println("}");
		}
}

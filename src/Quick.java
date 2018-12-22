import java.util.Random;

public class Quick {
	public static int[] list = new int[10];
	static String out = "";
	public Quick() {
		Random random = new Random();
		for (int b = 0; b < 10; b++) {
			int a = random.nextInt((100) + 1);
			list[b] = a;
		}
	}

		public void change(int[] num, int head, int tail) {
	        if (head >= tail || num == null || num.length <= 1) {
	            return;
	        }
	        int i = head, j = tail, a = num[(head + tail) / 2];
	        while (i <= j) {
	            while (num[i] < a) {
	                i = i+1;
	            }
	            while (num[j] > a) {
	            	j = j-1;
	            }
	            if (i < j) {
	                int t = num[i];
	                num[i] = num[j];
	                num[j] = t;
	                i = i+1;
	                j = j-1;
	            } else if (i == j) {
	            	i = i+1;
	            }
	        }
	        change(num, head, j);
	        change(num, i, tail);
	    }
//		印出一開始的樣本數列
		public void print() {
			
			for (int b = 0; b < list.length; b++) {
				System.out.print(list[b] + " ");
			}
			
		}
	    public static void main(String[] args) {
	    	Quick q = new Quick();
	    	System.out.print("排列前: { ");
	    	q.print();
	    	System.out.println("}");
	    	q.change(list, 0, list.length - 1);
	    	System.out.print("排列後: { ");
	    	q.print();
	    	System.out.println("}");
	       
	    }
	}

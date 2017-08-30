import java.util.*;
import java.lang.*;
class RandomPrint extends Thread {
	int num;
	int[] array;
	int max;
	int id;
	RandomPrint(int num, int id){
		this.id = id;
		this.num = num;
		this.array = new int[num];
		this.max = 0;
	}
	public void run(){
		Random r = new Random();
		try {
			for(int i=0; i<num;i++){
				this.array[i] = r.nextInt(100000) + 1;
				if (this.array[i] > this.max)
					this.max = this.array[i];
			}
			System.out.printf("%d : %d\n",this.id, this.max);
		} catch (Exception e) {
			System.out.println("Failed");
		}
	}
	public int max(){
		return this.max;
	}
	public void joinCall(){
		try {join();} catch (Exception e) {System.out.println(e);}
	}
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		int i = new Integer(args[0]);
		int j = new Integer(args[1]);
		int num = j / i;
		if (j%i > 0) num++;
		RandomPrint[] threads = new RandomPrint[i];
		for (int iter =0;iter < i;iter++){
			threads[iter] = new RandomPrint(num, iter);
			threads[iter].start();
		}
		int max = -99999;
		for(int iter=0; iter < i; iter++){
			threads[iter].joinCall();
		}
		for (int iter=0; iter < i; iter++){
			if (max < threads[iter].max())
				max = threads[iter].max();
		}
		System.out.printf("Final : %d\n",max);
		long dur = System.currentTimeMillis() - start;
		System.out.println(dur);
	}
}

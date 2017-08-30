import java.util.*;
import java.lang.*;

class Print extends Thread {
	int a;
	int sleepcount;
	int id;
	Print(int a, int sleep){
		this.a = a;
		this.id = a;
		this.sleepcount = sleep;
	}
	public void run(){
		try {
		for(int i=1;i > 0;i++){
			System.out.printf("%d : %d\n",this.id,i*this.a);
			sleep(this.sleepcount);
		}
		} catch (Exception e) {
			System.out.println("Failed");
		}
	}
	public static void main(String[] args){
		int a = new Integer(args[0]);
		int b = new Integer(args[1]);
		int c = new Integer(args[2]);
		Print th1 = new Print(a,b);
		Print th2 = new Print(c, ((3*b)/2));
		th1.start();
		th2.start();
	}
};

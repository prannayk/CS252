import java.util.* ;
import java.lang.reflect.*;
public class Exam {
	String title;
	short centre_code;
	public Exam(){
		this.title = new String("");
		this.centre_code = 0;
	}
	public void setTitle(String name){
		this.title = new String(name);
	}
	public void setCode(short code){
		this.centre_code = code;
	}
	public String getTitle(){ return this.title;}
	public short getCode() {return this.centre_code; }
	public void printCentreName() {
		if (this.centre_code == 10){
			System.out.println("LKO");
		} else if (this.centre_code == 20 ){
			System.out.println("CNB");
		} else if (this.centre_code == 30 ){
			System.out.println("AGC");
		} else if (this.centre_code == 40) {
			System.out.println("ALD");
		} else if (this.centre_code == 50) {
			System.out.println("VNS");
		} else {
			System.out.println("Unknown");
		}
	}
	public void printCName(){
		ExamCentres o = new ExamCentres();
		boolean flag = false;
		try {
		for (Field field : o.getClass().getDeclaredFields()) {
			short t = (short) field.get(o);
			if (this.centre_code == t) {
				System.out.println(field.getName());
				flag = true;
			} 
		}
		if (!flag) { System.out.println("Unknown"); }
		} catch (Exception e) {System.out.println("Error");}
	}
	public static boolean isValidCentre(int centreCode){
		ExamCentres o = new ExamCentres();
		try {
		for (Field field : o.getClass().getDeclaredFields()) {
			boolean flag = false;
			short t = (short) field.get(o);
			if (centreCode == t) {
				return true;
			} 
		}
		return false;
		} catch (Exception e){ return false; }
	}
	public static void main(String[] args){
		System.out.println("Started");
		Exam e = new Exam();
		e.setCode((short) 20);
		e.printCName();
		System.out.println(e.isValidCentre(10));
	}
}

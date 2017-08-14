import java.util.*;

public class Movie extends Video implements Comparable {
	String name;
	Rating rating;
	public Movie(){
		super();
		this.name = new String("");
		this.rating = Rating.A;
	}
	public void setName(String name){
		this.name = new String(name);
	}
	public void setRating(Rating rate){
		this.rating = rate;
	}
	public String getName(){return this.name;}
	public Rating getRating(){return this.rating;}
	public boolean equals(Object o) {
		if (!(o instanceof Movie)){
			return false;
		}
		Movie m = (Movie) o;
		boolean flag = m.name.equals(this.name);
		boolean flag2 = m.date.equals(this.date);
		return flag && flag2;
	}
	public int compareTo(Object o){
		Movie M = (Movie) o;
		if (this.equals(M)) {return 0;}
		if (M.name.equals(this.name)) {
			return M.date.compareTo(this.date);
		}
		return M.name.compareTo(this.name);
	}
	public static void main(String [] args){
		System.out.println("hw");
		Movie m = new Movie();
		Movie n = new Movie();
		System.out.println(m == n);
		System.exit(0); // success
	}
}


// import java.util.Date; 
import java.util.*;

public enum Rating {
	A, U, UA
}

public abstract class Video {
	float play_dur;
	Date date; 

	public Video() {
		this.data = new Date();
		this.play_dur = 0;
	}
	public float getDuration() {return this.play_dur;}
	public Date getDater() {return this.date;}
	public void setDate(Date date) {this.date = date;}
	public void setDuration(float duration) {this.play_dur = duration}
}

public class Movie extends Video implements Comparable {
	String name;
	Rating rating;
	public Movie(){
		super();
		this.name = new String("");
		this.rating = A;
	}
	public void setName(String name){
		this.name = new String(name);
	}
	public void setRating(Rating rate){
		this.rating = rate;
	}
	public String getName(){return this.name;}
	public String getRating(){return this.rating;}
	public boolean equals(Object o) {
		if (!(o instanceof Movie))
			return false;
		flag = o.name.equals(this.name);
		flag2 = o.super.date.equals(this.super.date);
		return flag && flag2;
	}
	public int compareTo(Movie M){
		if M.equals(this) {return 0;}
		if M.name.equals(this.name) {
			return M.super.date.compareTo(this.super.date);
		}
		return M.name.compareTo(this.name);
	}
}


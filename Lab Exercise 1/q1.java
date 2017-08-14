// import java.util.Date; 
import java.util.*;

public enum Rating {
	A, UA, U
}

public abstract class Video {
	float play_dur;
	Date date; 

	public Video() {
		this.date = new Date();
		this.play_dur = 0;
	}
	public float getDuration() {return this.play_dur;}
	public Date getDater() {return this.date;}
	public void setDate(Date date) {this.date = date;}
	public void setDuration(float duration) {this.play_dur = duration;}
}

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
	public int compareTo(Movie M){
		if (this.equals(M)) {return 0;}
		if (M.name.equals(this.name)) {
			return M.date.compareTo(this.date);
		}
		return M.name.compareTo(this.name);
	}
}


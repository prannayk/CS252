import java.util.*;
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
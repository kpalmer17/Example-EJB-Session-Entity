package examples.cse769.EJB.Entity;
import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "EVENT")
public class EventEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="EVENTID")
	private int eventid;

	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	@Column(name="NAME")
	private String name;
	public String getName() {return name;}

	public void setName(String Names) 
	{
		this.name = Names;
	}
	
	@Column(name="DESCRIPTION")
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription (String description) {
		this.description = description;
	}
	
	@Column(name="DATE")
	private String date;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Column(name="START")
	private String start;

	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	
	@Column(name="END")
	private String end;

	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	
	@Column(name="BARID")
	private int barid;

	public int getBarid() {
		return barid;
	}
	public void setBarid(int barid) {
		this.barid = barid;
	}
	
	
	
}

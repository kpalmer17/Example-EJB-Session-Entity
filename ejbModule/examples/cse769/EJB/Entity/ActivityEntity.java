package examples.cse769.EJB.Entity;
import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "ACTIVITY")
public class ActivityEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ACTIVITYID")
	
	private int activityid;
	public int getActivityid(){
		return this.activityid;
	}
	public void setActvityid(int actId)
	{
		this.activityid = actId;
	}
	
	@Column(name="NAME")
	private String name;
	public String getName() {return name;}

	public void setName(String Names) 
	{
		this.name = Names;
	}
	
	@Column(name="TYPE")
	private String type;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="DAY")
	private int day;

	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
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
	
	@Column(name="COST")
	private double cost;

	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
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


package examples.cse769.EJB.Service;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;

import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class ActivityManager {

	@PersistenceContext(unitName="examples-769-EJB")
	 EntityManager em;
	
	public List<List<String>> findForBar(int barid) {
		List<List<String>> activitys = new ArrayList<List<String>>();
	
		String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
	String activityid;
	String name ="";
	String type="";
	String day="";
	String start="";
	String end="";
	String cost="";
	
	List<ActivityEntity> BarID;
	
	Query query = em.createNativeQuery
			("select * from Activity where BARID like '" + barid
					+ "'" , ActivityEntity.class);
	
	BarID = query.getResultList();
	if(!BarID.isEmpty())
	{
		int size = BarID.size();
		
		for(int i = 0; i< size ; i++)
		{
			ActivityEntity activityinge = new ActivityEntity();
			activityinge = BarID.get(i);
		
			activityid = String.valueOf(activityinge.getActivityid());
			name = activityinge.getName();
			type = activityinge.getType();
			day = weekdays[activityinge.getDay()];
			start = activityinge.getStart();
			end = activityinge.getEnd();
			cost = String.valueOf(activityinge.getActivityid());

			List<String> activity = new ArrayList<String>();

			activity.add(activityid);
			activity.add(name);
			activity.add(type);
			activity.add(day);
			activity.add(start);
			activity.add(end);
			activity.add(cost);
		}
		return activitys;
	}
	else return activitys;
	}
}

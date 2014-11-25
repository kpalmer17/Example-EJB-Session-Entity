package examples.cse769.EJB.Service;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;

import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class EventManager {

	@PersistenceContext(unitName="examples-769-EJB")
	 EntityManager em;
	
	public List<List<String>> findForBar(int barid) {
		List<List<String>> events = new ArrayList<List<String>>();

		String eventid; 
		String name; 
		String description; 
		String date;
		String start; 
		String end; 
		
		List<EventEntity> foundevents;
		
		Query query = em.createNativeQuery
				("select * from EVENT where BARID like '" + barid
						+ "'" , EventEntity.class);
		
		foundevents = query.getResultList();
	
		if(!foundevents.isEmpty())
		{
			int size = foundevents.size();
			
			for(int i = 0; i< size ; i++)
			{
				EventEntity eventinge = new EventEntity();
				eventinge = foundevents.get(i);
			
				eventid = String.valueOf(eventinge.getEventid());
				name = eventinge.getName();
				description = eventinge.getDescription();
				date = eventinge.getDate();
				start = eventinge.getStart();
				end = eventinge.getEnd();
				eventid = String.valueOf(eventinge.getEventid());

				List<String> event = new ArrayList<String>();

				event.add(eventid);
				event.add(name);
				event.add(description);
				event.add(date);
				event.add(start);
				event.add(end);
			
				events.add(event);
			}
			
			return events;
		
		}
    	
    	else return events;
	}
	
	
	
	
public String add(int eventid, String name, String description, String date, String start, String end, int barid) {
		
		EventEntity event = new EventEntity();
		
	
		event.setEventid(eventid);
		event.setName(name);
		event.setDescription(description);
		event.setDate(date);
		event.setStart(start);
		event.setEnd(end);
		
		try
		{
		em.persist(event);
		em.flush();
		}
		catch(EntityExistsException e)
		{
			return "fail";
		}
		
		catch(ConstraintViolationException e)
		{
			return "fail";
		}
		
		catch(Exception e)
		{
			return "fail";
		}
		
		return event.getDate();
	}
	
	
	
}

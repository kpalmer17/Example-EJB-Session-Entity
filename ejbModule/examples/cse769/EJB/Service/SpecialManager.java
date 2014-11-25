package examples.cse769.EJB.Service;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class SpecialManager {

	@PersistenceContext(unitName="examples-769-EJB")
	 EntityManager em;
	
	public List<List<String>> findForBar(int barid) {
		
		List<List<String>> specials = new ArrayList<List<String>>();
		
		String day = "";
		String end = "";
		String specialid = "";
		String start = "";
		String title = "";
		
		List<SpecialEntity> foundspecials;
		
		Query query = em.createNativeQuery
				("select * from SPECIAL where BARID like '" + barid
						+ "'" , SpecialEntity.class);
		
		foundspecials = query.getResultList();
		
		if(!foundspecials.isEmpty())
		{
			int size = foundspecials.size();
			
			for(int i = 0; i< size ; i++)
			{
				SpecialEntity speciale = new SpecialEntity();
				speciale = foundspecials.get(i);
				
				day = String.valueOf(speciale.getDay());
				end = speciale.getEnd();
				specialid = String.valueOf(speciale.getSpecialid());
				start = speciale.getStart();
				title = speciale.getTitle();
				
				List<String> special = new ArrayList<String>();
				
				special.add(specialid);
				special.add(title);
				special.add(day);
				special.add(start);
				special.add(end);
				
				specials.add(special);
			}
			
			return specials;
		}
		else return specials;
	}
}

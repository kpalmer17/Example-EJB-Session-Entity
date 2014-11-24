package examples.cse769.EJB.Service;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import examples.cse769.EJB.*;
import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class BarManager {
    @PersistenceContext(unitName="examples-769-EJB")
	EntityManager em;
    
    public List<List<String>> find(String label, String searchtext) {
    	
    	List<List<String>> bars = new ArrayList<List<String>>();
    	int baridnum,pricenum;
    	String name = "";
    	String type = "";
    	String address = "";
    	String open = "";
    	String close = "";
    	String price = "";
    	String barid = "";
    	
    	List<BarEntity> foundbars;
    	
    	Query query = null;
    	
    	switch (label) {
    	case "bar":
    		query = em.createNativeQuery
			("select * from BAR where NAME like '" + searchtext
					+ "'" , BarEntity.class);
    		break;

    	case "item":
    		//needs query, I need to figure out the table joining
    		break;
    	case "activity":
    		//needs query, I need to figure out the table joining
    		break;
    	case "event":
    		//needs query, I need to figure out the table joining
    		break;
    	default: 
            System.out.println("ERROR in BarManager label switch");
            return bars;   
    	}
    	
    	foundbars = query.getResultList();
    	
    	if(!foundbars.isEmpty())
		{
			int size = foundbars.size();
			
			for(int i = 0; i< size ; i++)
			{
				BarEntity be = new BarEntity();
				be = foundbars.get(i);
			
				name = be.getName();
				type = be.getType();
				address = be.getAddress();
				open = be.getOpen();
				close = be.getClose();
				price = String.valueOf(be.getPrice());
				barid = String.valueOf(be.getBarid());

				List<String> bar = new ArrayList<String>();

				bar.add(name);
				bar.add(type);
				bar.add(address);
				bar.add(open);
				bar.add(close);
				bar.add(price);
				bar.add(barid);
			
				bars.add(bar);
			}
			
			return bars;
		
		}
    	
    	else return bars;
    }
}

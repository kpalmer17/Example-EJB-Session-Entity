package examples.cse769.EJB.Service;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class ItemManager {

	@PersistenceContext(unitName="examples-769-EJB")
	 EntityManager em;
	
	public List<List<String>> findForMenu(int menuid) {
		
		List<List<String>> items = new ArrayList<List<String>>();
		String itemid = "";
		String name = "";
		String price = "";
		String type = "";
		
		List<ItemEntity> founditems;
		
		Query query = em.createNativeQuery
				("select * from ITEM where MENUID like '" + menuid
						+ "'" , ItemEntity.class);
		
		founditems = query.getResultList();
		
		if(!founditems.isEmpty())
		{
			int size = founditems.size();
			
			for(int i = 0; i< size ; i++)
			{
				ItemEntity iteme = new ItemEntity();
				iteme = founditems.get(i);
				
				itemid = String.valueOf(iteme.getItemid());
				name = iteme.getName();
				price = String.valueOf(iteme.getPrice());
				type = iteme.getType();
				
				List<String> item = new ArrayList<String>();
				
				item.add(itemid);
				item.add(name);
				item.add(price);
				item.add(type);
				
				items.add(item);
			}
			
			return items;
		}
		else return items;
	}
	
	public List<List<String>> findForSpecial(int specialid) {
		
		List<List<String>> items = new ArrayList<List<String>>();
		String itemid = "";
		String name = "";
		String price = "";
		String type = "";
		
		List<ItemEntity> founditems;
		
		Query query = em.createNativeQuery
				("select * from ITEM where SPECIALID like '" + specialid
						+ "'" , ItemEntity.class);
		
		founditems = query.getResultList();
		
		if(!founditems.isEmpty())
		{
			int size = founditems.size();
			
			for(int i = 0; i< size ; i++)
			{
				ItemEntity iteme = new ItemEntity();
				iteme = founditems.get(i);
				
				itemid = String.valueOf(iteme.getItemid());
				name = iteme.getName();
				price = String.valueOf(iteme.getPrice());
				type = iteme.getType();
				
				List<String> item = new ArrayList<String>();
				
				item.add(itemid);
				item.add(name);
				item.add(price);
				item.add(type);
				
				items.add(item);
			}
			
			return items;
		}
		else return items;
	}
}

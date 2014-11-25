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

		String[] cashMoney = {"", "$", "$$", "$$$", "$$$$", "$$$$$"};
		
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
			("select * from BAR where UPPER(NAME) like '%" + searchtext
					+ "%'" , BarEntity.class);
    		break;

    	case "food":
    		//needs query, I need to figure out the table joining
    		query = em.createNativeQuery
			("SELECT BAR.BARID, BAR.NAME, BAR.TYPE, BAR.PRICE, BAR.ADDRESS , BAR.OPEN , BAR.CLOSE " +
					"FROM BAR, MENU, ITEM " +
					"WHERE BAR.BARID = MENU.BARID AND MENU.MENUID = ITEM.MENUID AND UPPER(ITEM.NAME) LIKE '%" + searchtext.toUpperCase()
					+ "%'" , BarEntity.class);
    		
    		break;
    		
    	case "drink":
    		//needs query, I need to figure out the table joining
    		query = em.createNativeQuery
			("SELECT BAR.BARID, BAR.NAME, BAR.TYPE, BAR.PRICE, BAR.ADDRESS , BAR.OPEN , BAR.CLOSE " +
					"FROM BAR, SPECIAL, ITEM " +
					"WHERE BAR.BARID = SPECIAL.BARID AND SPECIAL.SPECIALID = ITEM.SPECIALID AND UPPER(ITEM.NAME) LIKE '%" + searchtext.toUpperCase()
					+ "%'" , BarEntity.class);
    		
    		break;
    	case "activity":
    		//needs query, I need to figure out the table joining
    		query = em.createNativeQuery
			("SELECT BAR.BARID, BAR.NAME, BAR.TYPE, BAR.PRICE, BAR.ADDRESS , BAR.OPEN , BAR.CLOSE " +
    		"FROM BAR, ACTIVITY " + 
			"WHERE BAR.BARID = ACTIVITY.BARID AND UPPER(ACTIVITY.NAME) LIKE '%" + searchtext.toUpperCase()
					+ "%'" , BarEntity.class);
    		break;
    	case "event":
    		//needs query, I need to figure out the table joining
    		query = em.createNativeQuery
			("SELECT BAR.BARID, BAR.NAME, BAR.TYPE, BAR.PRICE, BAR.ADDRESS , BAR.OPEN , BAR.CLOSE " +
    		"FROM BAR, EVENT " + 
			"WHERE BAR.BARID = EVENT.BARID AND UPPER(EVENT.NAME) LIKE '%" + searchtext.toUpperCase()
					+ "%'" , BarEntity.class);
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
				price = cashMoney[be.getPrice()];
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

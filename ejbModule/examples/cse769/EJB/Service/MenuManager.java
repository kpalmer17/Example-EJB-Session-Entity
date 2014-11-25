package examples.cse769.EJB.Service;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;

import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class MenuManager {

	@PersistenceContext(unitName="examples-769-EJB")
	 EntityManager em;
	
	public List<List<String>> findForBar(int barid) {
		List<List<String>> menus = new ArrayList<List<String>>();
		
		String menuid;
		String title;
		String day;
		String start;
		String end;
	
		List<MenuEntity> foundmenu;
		
		Query query = em.createNativeQuery
				("select * from MENU where BARID like '" + barid
						+ "'" , MenuEntity.class);
		
		foundmenu = query.getResultList();
		
		if(!foundmenu.isEmpty())
		{
			int size = foundmenu.size();
			
			for(int i = 0; i< size ; i++)
			{
				MenuEntity menuinge = new MenuEntity();
				menuinge = foundmenu.get(i);
			
				menuid = String.valueOf(menuinge.getMenuid());
				title = menuinge.getTitle();
				day = String.valueOf(menuinge.getDay());
				start = menuinge.getStart();
				end  = menuinge.getEnd();
				
				List<String> menu = new ArrayList<String>();

				menu.add(menuid);
				menu.add(title);
				menu.add(day);
				menu.add(start);
				menu.add(end);
			
				menus.add(menu);
			}
			
			return menus;
		
		}
    	
    	else return menus;
	}
		
	public String add(int menuid, String title, int day, String start, String end, int barid) {
		
	MenuEntity menu = new MenuEntity();
	
	menu.setMenuid(menuid);
	menu.setTitle(title);
	menu.setDay(day);
	menu.setStart(start);
	menu.setEnd(end);

	try
	{
	em.persist(menu);
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
	
	return menu.getTitle();
	}
	
}

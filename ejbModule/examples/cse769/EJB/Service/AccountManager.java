package examples.cse769.EJB.Service;
import java.util.List;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;

import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class AccountManager {
	
	 @PersistenceContext(unitName="examples-769-EJB")
	 EntityManager em;
	 
	 public String login (String username, String password){
		 
		 List<AccountEntity> loginList;		//create list to hold query results
		 
		 try
			{
				Query query = em.createNativeQuery	//create query using this syntax
				("SELECT * FROM ACCOUNT WHERE USERNAME like '" + username
				+ "'" +  " and PASSWORD like '" + password + "'" 
				, AccountEntity.class);
				
				loginList = query.getResultList();	//gets results from query and puts into a list of that object type
				
				if(!loginList.isEmpty())			//if user actually exists
				{
					AccountEntity acc = new AccountEntity();
					acc = loginList.get(0);
					return String.valueOf(acc.getUserid());
				}
			}
			
			catch(Exception e)
			{
				return "fail";
			}
			
			return "fail";	//return fail if user not found and handle appropriately in Backing Bean
	 }
	 
	 public String register (String username, String password){
		 
		 AccountEntity account = new AccountEntity();
		 
		 account.setUserName(username);
		 account.setPassword(password);
		 
			try
			{
			em.persist(account);
			em.flush();
			}
			catch(EntityExistsException e)
			{
				return "Exists";
			}
			
			catch(ConstraintViolationException e)
			{
				return "Exists";
			}
			
			catch(Exception e)
			{
				return "Exists";
			}
			String UserName = account.getUserName();
			return UserName;
	 }
	 
}

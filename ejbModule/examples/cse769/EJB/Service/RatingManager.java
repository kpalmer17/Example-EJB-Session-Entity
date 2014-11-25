package examples.cse769.EJB.Service;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;

import examples.cse769.EJB.Entity.*;

import javax.ejb.Stateless;

@Stateless
public class RatingManager {

	@PersistenceContext(unitName="examples-769-EJB")
	 EntityManager em;
	
	public List<List<String>> findForBar(int barid) {
		List<List<String>> ratings = new ArrayList<List<String>>();

		String ratingid = "";
		String rating = "";
		String comment = "";
		String date = "";
		String userid = "";
		
		List<RatingEntity> foundratings;
		
		Query query = em.createNativeQuery
				("select * from RATING where BARID like '" + barid
						+ "'" , RatingEntity.class);
		
		foundratings = query.getResultList();
		
		if(!foundratings.isEmpty())
		{
			int size = foundratings.size();
			
			for(int i = 0; i< size ; i++)
			{
				RatingEntity rateinge = new RatingEntity();
				rateinge = foundratings.get(i);
			
				ratingid = String.valueOf(rateinge.getRatingid());
				rating = String.valueOf(rateinge.getRating());
				comment = rateinge.getComment();
				date = rateinge.getDate();
				userid = String.valueOf(rateinge.getUserid());

				List<String> rate = new ArrayList<String>();

				rate.add(ratingid);
				rate.add(rating);
				rate.add(comment);
				rate.add(date);
				rate.add(userid);
			
				ratings.add(rate);
			}
			
			return ratings;
		
		}
    	
    	else return ratings;
	}
	
	public List<List<String>> findForUser(int userid) {
		List<List<String>> ratings = new ArrayList<List<String>>();
		String ratingid = "";
		String rating = "";
		String comment = "";
		String date = "";
		String barid = "";
		
		List<RatingEntity> foundratings;
		
		Query query = em.createNativeQuery
				("select * from RATING where USERID like '" + userid
						+ "'" , RatingEntity.class);
		
		foundratings = query.getResultList();
		
		if(!foundratings.isEmpty())
		{
			int size = foundratings.size();
			
			for(int i = 0; i< size ; i++)
			{
				RatingEntity rateinge = new RatingEntity();
				rateinge = foundratings.get(i);
			
				ratingid = String.valueOf(rateinge.getRatingid());
				rating = String.valueOf(rateinge.getRating());
				comment = rateinge.getComment();
				date = rateinge.getDate();
				barid = String.valueOf(rateinge.getBarid());

				List<String> rate = new ArrayList<String>();

				rate.add(ratingid);
				rate.add(rating);
				rate.add(comment);
				rate.add(date);
				rate.add(barid);
			
				ratings.add(rate);
			}
			
			return ratings;
		
		}
    	
    	else return ratings;

	}
	
	public String add(int rating, String comment, String date, int barid, int userid) {
		
		RatingEntity rate = new RatingEntity();
		
		rate.setRating(rating);
		rate.setComment(comment);
		rate.setDate(date);
		rate.setBarid(barid);
		rate.setUserid(userid);
		
		try
		{
		em.persist(rate);
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
		
		return rate.getDate();
	}
}

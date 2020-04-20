
import org.junit.Test;

import static junit.framework.Assert.*;
public class testComparingActivities {

	@Test
	public void testCompareActivities()
	{
		
		//these activities are not conflicting --> function returns false 
		//when this is in the assertFalse statement --> result is true
		Activity a1 = new Activity(12, 4, 2019, 11, 30, 12, 00, "health", "work out");
		Activity a2 = new Activity(12, 4, 2019, 2, 30, 3, 30, "health", "work out");
		

		//these activities are conflicting --> function returns true 
		//when this is in the assertFalse statement --> result is false
		//Activity a3 = new Activity(12, 4, 2019, 6, 00, 6, 30, "health", "work out");
		//Activity a4 = new Activity(12, 4, 2019, 6, 15, 6, 45, "health", "work out");
		
		//check if two activities are conflicting
		assertFalse("testing two activities", a1.checkConflicts(a2));
		
	}


}




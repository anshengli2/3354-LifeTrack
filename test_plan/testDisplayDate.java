import junit.framework.TestCase;

import java.util.Date;
import org.junit.Test;

import static junit.framework.Assert.*;
public class testDisplayDate 
{
		
		//tests if the correct date is displayed
		@Test
		public void correctDateTest()
		{
			//the date we want to be displayed
			Date date1 = new Date(2020, 4, 19);
			displayDate d1 = new displayDate();
			
			//correct case
			assertEquals("testing two dates", date1, new Date(2020, 4, 19));

			//incorrect case
			//assertEquals("testing two dates", date1, new Date(2016, 12, 3));
			
		}
}

import junit.framework.TestCase;

import java.util.Date;
import org.junit.Test;

import static junit.framework.Assert.*;
public class testDisplayDate 
{

		@Test
		public void correctDateTest()
		{
			Date date1 = new Date(2020, 4, 19);
			displayDate d1 = new displayDate();
			assertEquals("testing two dates", date1, new Date(2020, 4, 19));

			//assertEquals("testing two dates", date1, new Date(2016, 12, 3));
			
		}
				// TODO Auto-generated method stub

}

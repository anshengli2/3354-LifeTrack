
public class Activity 
{ 

		int month;
		int year;
		int day;
		int startHour; 
		int startMinute;
		int endHour;
		int endMinute;
		String category;
		String description;
		
		
		public Activity()
		{
			
		}
		
		public Activity(int m, int d, int y, int sh, int smin, int eh, int emin, String c, String desc)
		{
			month = m;
			day = d;
			year = y;
			startHour = sh;
			startMinute = smin;
			endHour = eh;
			endMinute = emin;
			category = c;
			description = desc;
		}
		
		
		public boolean checkConflicts(Activity event2)
		{
			int conflicts = 0;
			
			if(this.year == event2.year)
				conflicts++;
			
			
			if(this.month == event2.month)
				conflicts++;
			
			
			if(this.day == event2.day)
				conflicts++;
			
			
			if(this.startHour == event2.startHour)
			{
				if(this.startMinute <= event2.startMinute)
				{
					if(this.endHour > event2.startHour)
						conflicts++;
					
					if(this.endHour == event2.startHour)
					{
						if(this.endMinute > event2.startMinute)
						{
							conflicts++;
						}
					}			
				}
			}
			
			if(event2.startHour > this.startHour)
			{
				if(this.endHour == event2.startHour)
				{
					if(event2.startMinute < this.endMinute)
					{
						conflicts++;
					}
				}
				
				if(this.endHour > event2.startHour)
					conflicts++;
			}
			
			if(this.startHour > event2.startHour || (this.startHour == event2.startHour && this.startMinute > event2.startMinute))
			{
				if(event2.startHour > this.startHour || (this.startHour == event2.endHour && this.startMinute < event2.endMinute))
					conflicts++;
			}
			
			
			if(conflicts >= 4)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		
		public String toString()
		{
			return this.month + "/" + this.day + "/" + this.year + " " + this.startHour + ":" + this.startMinute + 
					"-" + this.endHour + ":" + this.endMinute + " category: " + 
					this.category + ", description: " + this.description + " -";
		}
	}



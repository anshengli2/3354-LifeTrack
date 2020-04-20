
public class Activity 
{ 
	//month, day, and year of the event
	int month;
	int year;
	int day;
	
	//starting time of the event
	int startHour; 
	int startMinute;
	
	//ending time of the event
	int endHour;
	int endMinute;
	
	//category of the event, example: health
	String category;
	
	//description of the event
	String description;
		
	//default constructor
	public Activity()
	{
			
	}
		
	//creates an activity on a specific date and time with a category and description
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
		
	//checking if two activities are conflicting
	public boolean checkConflicts(Activity event2)
	{
		//keeps track of the number of conflicts
		int conflicts = 0;
			
		//if the two events are occurring in the same year
		if(this.year == event2.year)
			conflicts++;
			
		//if the two events are occurring in the same month	
		if(this.month == event2.month)
			conflicts++;
			
		//if the two events are occurring on the same day
		if(this.day == event2.day)
			conflicts++;
			
		//if the two events are starting in the same hour
		//example: event 1 - 6:00-6:30
		//event 2 - 6:15-6:45
		if(this.startHour == event2.startHour)
		{
			//if event 2 starts after event 1
			if(this.startMinute <= event2.startMinute)
			{
				//if the first event ends after the second event starts (different hours)
				//this is a conflict
				if(this.endHour > event2.startHour)
					conflicts++;
					
				//if the first event ends in the same hour as the second event 
				if(this.endHour == event2.startHour)
				{
					//if the first event ends after the second event starts 
					//this is a conflict
					if(this.endMinute > event2.startMinute)
					{
						conflicts++;
					}
				}			
			}
		}
		
		//if the second event starts after the first event (different hours)
		//example: event 1 - 6:30-7:30
		//event 2 - 7:00-7:45
		if(event2.startHour > this.startHour)
		{
			//if the first event ends in the same hour as the second event
			if(this.endHour == event2.startHour)
			{
				//if the second event starts before the first event ends
				//this is a conflict
				if(event2.startMinute < this.endMinute)
				{
					conflicts++;
				}
			}
			
			//if the first event ends after the second event starts
			//this is a conflict
			if(this.endHour > event2.startHour)
				conflicts++;
		}
		
		//if the first event starts after the second event (different hours) OR
		//the first event and second event start during the same hour AND the first event starts after the second event 
		//example: event 1 - 6:15-6:30
		//event 2 - 6:00-6:45
		if(this.startHour > event2.startHour || (this.startHour == event2.startHour && this.startMinute > event2.startMinute))
		{
			//if the second event starts after the first event (different hours) OR
			//the first event starts before the second event 
			//this is a conflict
			if(event2.startHour > this.startHour || (this.startHour == event2.endHour && this.startMinute < event2.endMinuteee))
				conflicts++;
		}
			
		//the two events conflict
		if(conflicts >= 4)
		{
			return true;
		}
		
		//the two events do not conflict
		else
		{
			return false;
		}
			
	}
		
	//returns the activity as a string
	public String toString()
	{
		return this.month + "/" + this.day + "/" + this.year + " " + this.startHour + ":" + this.startMinute + 
			"-" + this.endHour + ":" + this.endMinute + " category: " + 
			this.category + ", description: " + this.description;
	}
}



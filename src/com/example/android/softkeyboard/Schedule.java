package com.example.android.softkeyboard;

import android.content.Intent;
import android.provider.CalendarContract.Events;

public class Schedule {
	// Schedule me lunch with Tim at 7:00 on Tuesday
	public static String schedule(String params){
		params = " " + params + " ";
		int time_index = params.indexOf(" at ");
		int day_index = params.indexOf(" on  ");
		
		String title = params;
		String time;
		String day;
		
		if(time_index >-1 || day_index > -1){
			time_index = time_index<0 ? params.length()-1 : time_index;
			day_index = day_index<0 ? params.length()-1 : day_index;
			if (time_index < day_index){
				time = params.substring(time_index+2,day_index);
				title = params.substring(time_index);
			}
			else if (time_index < day_index){
				day = params.substring(day_index+2,time_index);
				title = params.substring(day_index);
			}
		}
		
		
		Intent calIntent = new Intent(Intent.ACTION_INSERT); 
		calIntent.setType("vnd.android.cursor.item/event");    
		calIntent.putExtra(Events.TITLE, title); 
		 
//		GregorianCalendar calDate = new GregorianCalendar(2012, 7, 15);
//		calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, 
//		     calDate.getTimeInMillis()); 
//		calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, 
//		     calDate.getTimeInMillis()); 
		 
		LatinKeyboardView.mContext.startActivity(calIntent);
		
		return "Event Scheduled";
	}
}

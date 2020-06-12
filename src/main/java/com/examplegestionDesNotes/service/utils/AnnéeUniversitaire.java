package com.examplegestionDesNotes.service.utils;

import java.util.Calendar;
import java.util.Date;

public class AnnéeUniversitaire {
	public static String formater() {
		String année=" ";
		Calendar calendar = Calendar.getInstance();
		int years= calendar.get(Calendar.YEAR);
		if(calendar.get(Calendar.MONTH)==7 || calendar.get(Calendar.MONTH)==8 || calendar.get(Calendar.MONTH)==9 || calendar.get(Calendar.MONTH)==10 || calendar.get(Calendar.MONTH)==11) {
			année=years+"/"+(years+1);
		}else {
			année=years-1+"/"+years;
		}
		return année;
	}

}

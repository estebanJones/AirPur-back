package fr.airpure.main.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DateUtils {
	
	public DateUtils() {
		
	}
	/**
	 * LA DATE ARRIVE AVEC LES MILLISECONDES AU FORMAT 
	 * 2021/01/10 21:00:00+00
	 * JE LA VEUX EN 2021/01/10 21:00:00
	 * @param date
	 * @return
	 */
	public String parseDate(String dateAtraiter) {
		Integer indexFin = dateAtraiter.indexOf("+");
		return dateAtraiter.substring(0, indexFin);
	}
}

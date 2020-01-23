package de.gallas_it.baseutilities;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




/**
 * Eine Bibliotheks Klasse die verschiedene Methoden enthält um Datum oder Zeit abzufragen oder zu manipulieren
 * 
 * 
 * @author u991712
 * @version 1.0
 *
 */
public class DateAndTime {
     
	
	private static final Logger logger = LogManager.getLogger(DateAndTime.class);
	
	private static String year;
	private static String month;
	
	
	/**
	 * Constructor erzeugt bei nicht statischer Verwendung
	 */
	
	public DateAndTime() {
		
		
		logger.traceEntry("DateAndTime Constructor startet");
		
		
		//Get current date time
	    LocalDateTime now = LocalDateTime.now();  

	    System.out.println("Before : " + now);

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	    String formatDateTime = now.format(formatter);

	    System.out.println("After : " + formatDateTime);
	    
	    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy");
	    year = now.format(formatter1);
	     
	    logger.traceExit(true);

	}
	
	/**
	 * Liefert das Jahr des aktuellen Datums
	 *  
	 * @return The actual date as String
	 */
	
	public static String getYear() {
		
		
		logger.traceEntry("getYear startet");
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
	    year = now.format(formatter);
	    
	    logger.traceExit(year);
		return year;
	}


	/**
	 * Liefert das aktuellen Datum in der From: dd:mm:yyyy
	 *
	 * 
	 * @return Returns the actual date as string. format dd:mm:yyy
	 */
	
	public static String getActualDateAsString() {
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	    
		String aktDate = now.format(formatter);
		return  aktDate;
	
	}
	
	
	/**
	 * Returns the creation date of a file
	 *
	 * @param fileName The filename of the file to be investigate
	 * @throws IOException File not available
	 * @throws ParseException Could not parse
	 * @return Creation date of the the file as string. Format dd:mm:yyy
	 */
	public static String getActualDateAsString(String fileName) throws IOException, ParseException {
		
		Path path = Paths.get(fileName);
		DateFormat df=new SimpleDateFormat("dd.MM.yyyy");

		        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
		        Date d1 = df.parse(df.format(attr.creationTime().toMillis()));
		        //System.out.println("File time  : " +d1);
	            String help = new String();
	            
	            help = help + d1.toString();
		        
	            System.out.println("File time  : " + help);
	            help =  new SimpleDateFormat("yyyy").format(attr.creationTime().toMillis());
	            
	            
		        return help;  

		
	}
	
	
	
	
	/**
	 * Return the the actual month of a file
	 * @return Returns the month as string. Format mm 

	 */
	
public static String getMonth() {
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
	    month = now.format(formatter);
		return month;
	}


/**
 * 
 * @param fileName Datum als String in der Form yyyy-mm-dd
 * @return Returns the month as string. Format mm 
 * @throws IOException File not found
 * @throws ParseException Could not interpret argument as dateString
 */
public static String getMonth(String fileName) throws IOException, ParseException {
	
	Path path = Paths.get(fileName);
	DateFormat df=new SimpleDateFormat("dd/MM/yy");

	        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
	        Date d1 = df.parse(df.format(attr.creationTime().toMillis()));
	        //System.out.println("File time  : " +d1);
            String help = new String();
            
            help = help + d1.toString();
	        
            System.out.println("File time  : " + help);
            help =  new SimpleDateFormat("yyyy").format(attr.creationTime().toMillis());
            
            
	        return help;  

	
}


/**
 * 
 * @param dateString Datum als String in der Form yyyy-mm-dd 
 * @throws  IllegalArgumentException Could not find - in parameter
 * @return Actual year
 */

public static String getYearByString(String dateString) {
 	
	 int extensionIndex = dateString.indexOf("-"); 
	    if (extensionIndex == -1) throw new IllegalArgumentException("Date String not in correct format dd.mm.yyyy: "+ dateString);

	    return dateString.substring(0, extensionIndex);

	
}

/**
 * @param dateString: Datum als String in der Form dd?mm?yyyy  
 * @param delimiter Delimiter
 * @return Returns year as String
 * 
 */

public static String getYearByString(String dateString,String delimiter) {
	
	 int extensionIndex = dateString.lastIndexOf(delimiter); 
	  
	
	 
	 if (extensionIndex == -1) throw new IllegalArgumentException("Date String not in correct format dd.mm.yyyy: "+ dateString);

	    return dateString.substring(extensionIndex+1,extensionIndex+5);

	
}





/**
 * @param dateString: Datum als String in der Form yyyy-mm-dd  
 * 
 * @return Returns the month as string. Format mm 
 * @throws IllegalArgumentException Could not interpret argument as dateString
 */

public static String getMonthByString(String dateString) {
	
	 int extensionIndex = dateString.indexOf("-"); 
	 int extensionIndex1 = dateString.lastIndexOf("-"); 
	 
	    if (extensionIndex == -1) throw new IllegalArgumentException("Date String not in correct format dd-mm-yyyy: "+ dateString);

	    return dateString.substring(extensionIndex+1, extensionIndex1);

	
}


/**
 * @param dateString: Datum als String in der Form yyyy?mm?dd  
 * @param delimiter Delimeter between yyyy and  mm
 * 
 * @return Returns the month as string. Format mm 
 * @throws IllegalArgumentException Could not interpret argument as dateString
 */

public static String getMonthByString(String dateString,String delimiter ) {
	
	 int extensionIndex = dateString.indexOf(delimiter); 
	 int extensionIndex1 = dateString.lastIndexOf(delimiter); 
	 
	    if (extensionIndex == -1) throw new IllegalArgumentException("Date String not in correct format dd.mm.yyyy: "+ dateString);
	        

	    return dateString.substring(extensionIndex+1, extensionIndex1);

	
}

/**
 * @param dateString: Datum als String in der Form "UTC dd-mm-yyyy 12:23:30"
 * @return Date string: format: dd.MM.yyyy 
 */

public static String convertUTC_timeToLocalTime(String dateString ) {
	
	String oriDateString = new String (dateString);
	
	dateString = dateString.replace("UTC ", "");
	dateString = dateString.replace(" ", "T");
	
	

	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	//Date zeitstempel;
	try {
		//zeitstempel = simpleDateFormat.parse (dateString);	    
		LocalDateTime now =  LocalDateTime.parse(dateString);
		
		return now.format(formatter);
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
	   System.out.println("Could not read valid time from Media Info object: " + oriDateString);
		
		//e.printStackTrace();
	} 		
	
    return "";
	
	
	
}



	
}


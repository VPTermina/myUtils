package myOwnUtilLibrary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class myDateandTimeUtil {

	private static String year;
	private static String month;
	
	public myDateandTimeUtil() {
		
		//Get current date time
	    LocalDateTime now = LocalDateTime.now();  

	    System.out.println("Before : " + now);

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	    String formatDateTime = now.format(formatter);

	    System.out.println("After : " + formatDateTime);
	    
	    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy");
	    year = now.format(formatter1);
	     
		
	}
	
	/**
	 * Liefert das Jahr des aktuellen Datums
	 *  
	 * @return
	 */
	
	public static String getYear() {
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
	    year = now.format(formatter);
		return year;
	}


	/**
	 * Liefert das aktuellen Datum in der From: dd:mm:yyyy
	 * @param null
	 * @param Filename
	 * 
	 * @return
	 */
	
	public static String getActualDateAsString() {
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	    
		String aktDate = now.format(formatter);
		return  aktDate;
	
	}
	
	
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
	 * 
	 * Liefert den Monat des aktuellen Datums
	 * @return
	 */
	
	
public static String getMonth() {
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
	    month = now.format(formatter);
		return month;
	}

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
 * @param dateString: Datum als String in der Form yyyy-mm-dd  
 * 
 */

public static String getYearByString(String dateString) {
	
	 int extensionIndex = dateString.indexOf("-"); 
	    if (extensionIndex == -1) throw new IllegalArgumentException("Date String not in correct format dd.mm.yyyy: "+ dateString);

	    return dateString.substring(0, extensionIndex);

	
}

/**
 * @param dateString: Datum als String in der Form dd?mm?yyyy  
 * 
 */

public static String getYearByString(String dateString,String delimiter) {
	
	 int extensionIndex = dateString.lastIndexOf(delimiter); 
	  
	
	 
	 if (extensionIndex == -1) throw new IllegalArgumentException("Date String not in correct format dd.mm.yyyy: "+ dateString);

	    return dateString.substring(extensionIndex+1,extensionIndex+5);

	
}





/**
 * @param dateString: Datum als String in der Form yyyy/mm/dd  
 * @Return 
 */

public static String getMonthByString(String dateString) {
	
	 int extensionIndex = dateString.indexOf("-"); 
	 int extensionIndex1 = dateString.lastIndexOf("-"); 
	 
	    if (extensionIndex == -1) throw new IllegalArgumentException("Date String not in correct format dd.mm.yyyy: "+ dateString);

	    return dateString.substring(extensionIndex+1, extensionIndex1);

	
}

/**
 * @param dateString: Datum als String in der Form dd?mm?yyyy
 * @param delimiter: Trennzeichen  
 * @Return 
 */

public static String getMonthByString(String dateString,String delimiter ) {
	
	 int extensionIndex = dateString.indexOf(delimiter); 
	 int extensionIndex1 = dateString.lastIndexOf(delimiter); 
	 
	    if (extensionIndex == -1) throw new IllegalArgumentException("Date String not in correct format dd.mm.yyyy: "+ dateString);
	        

	    return dateString.substring(extensionIndex+1, extensionIndex1);

	
}

/**
 * @param dateString: Datum als String in der Form "UTC dd-mm-yyyy 12:23:30"
 * @param  
 * @Return Date String: format: dd.MM.yyyy 
 */

public static String convertUTC_timeToLocalTime(String dateString ) {
	
	String oriDateString = new String (dateString);
	
	dateString = dateString.replace("UTC ", "");
	dateString = dateString.replace(" ", "T");
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	
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

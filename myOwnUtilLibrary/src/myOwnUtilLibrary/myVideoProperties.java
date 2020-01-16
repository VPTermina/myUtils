package myOwnUtilLibrary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class myVideoProperties {

	// CheckBoxTableCell, ChoiceBoxTableCell, ComboBoxTableCell, ProgressBarTableCell, TextFieldTableCell
	
	
	private SimpleStringProperty fileName,title,genre,plot,remarks,newFilename,creationDate,selectEdit,newFolder,newThumbnailName,episode;
	
	
	
	
	/**
	 * @return the episode
	 */
	public String getEpisode() {
		return episode.get();
	}


	/**
	 * @param episode the episode to set
	 */
	public void setEpisode(String episode) {
		this.episode = new SimpleStringProperty(episode);
	}


	/**
	 * @return the newFolder
	 */
	public String getNewFolder() {
		return newFolder.get();
	}


	/**
	 * @param newFolder the newFolder to set
	 */
	public void setNewFolder(String newFolder) {
		this.newFolder = new SimpleStringProperty(newFolder);
	}


	/**
	 * @return the newThumbnailName
	 */
	public String getNewThumbnailName() {
		return newThumbnailName.get();
	}


	/**
	 * @param newThumbnailName the newThumbnailName to set
	 */
	public void setNewThumbnailName(String newThumbnailName) {
		this.newThumbnailName = new SimpleStringProperty(newThumbnailName);
	}


	/**
	 * @return the newFilename
	 */
	public String getNewFilename() {
		return newFilename.get();
	}


	/**
	 * @param newFilename the newFilename to set
	 */
	public void setNewFilename(String newFilename) {
		
		
		this.newFilename = new SimpleStringProperty(newFilename);
	}




	
	/**
	 * 
	 * @param fileName
	 * @param title
	 
	 * @param genre
	 * @param plot
	 * @param remarks
	 * @param creationDate
	 * param selected  automatisch auf true
	 */
	
	public myVideoProperties(String selectEdit, String fileName, String title,  String genre, 
			String plot, String remarks, String creationDate) {
		super();
		
		
        
        
        
        
		
		this.fileName = new SimpleStringProperty(fileName);
		this.title = new SimpleStringProperty(title);
		this.genre = new SimpleStringProperty(genre);		
		this.plot = new SimpleStringProperty(plot);
		this.remarks = new SimpleStringProperty(remarks);
		this.creationDate = new SimpleStringProperty(creationDate);
		this.selectEdit = new SimpleStringProperty(selectEdit);
		
		
		
	}


	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName.get();
	}


	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = new SimpleStringProperty(fileName);
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title.get();
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = new SimpleStringProperty(title);
	}


	/**
	 * @return the year
	 */
	public String getYear() {
		
		

		return myDateandTimeUtil.getYearByString(getCreationDate(),".");
		
		
		
	}




	/**
	 * @return the month
	 */
	public String getMonth() {
		
		
		
		
		return myDateandTimeUtil.getMonthByString(getCreationDate(),".");

	
 
	}




	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre.get();
	}


	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = new SimpleStringProperty(genre);
	}

   
	/**
	 * @return the SelectEdit
	 */
	public String isSelectEdit1() {
		
		String help;
		
		if (selectEdit.get()=="1") 
			help = "1"; 
			
			else 
				help= "0";
		
		
		
		return help;
	}


	/**
	 * @return the genre
	 */
	public String getSelectEdit() {
		return selectEdit.get();
	}
	
	
	/**
	 * @param Selected the genre to set
	 */
	public void setSelectEdit(String select) {
		this.selectEdit = new SimpleStringProperty(select);
	}
	
	
	


	/**
	 * @return the plot
	 */
	public String getPlot() {
		return plot.get();
	}


	/**
	 * @param plot the plot to set
	 */
	public void setPlot(String plot) {
		this.plot = new SimpleStringProperty(plot);
	}


	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks.get();
	}


	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = new SimpleStringProperty(remarks);
	}


	/**
	 * @return the selected
	 */
	

	
	
  
	
	
	
	/**
	 * @return the selected
	 */
	public String getSelectedEdit() {
		
		
		return selectEdit.get();
	}
	
	
	
	
	
	/**
	 * @return the remarks
	 */
	public String getCreationDate() {
		return creationDate.get();
	}


	/**
	 * @param remarks the remarks to set
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = new SimpleStringProperty(creationDate);
	}
	
	
	
	

	/**
	 * @return the Season base on the month
	 */
	public String getSeason() {
				
		//myDateandTimeUtil.getMonth();
		
		String help = myDateandTimeUtil.getMonthByString(getCreationDate(),".");
		if (help.length()==1) {
			help = "0" + help;
		}
		
		return help;
		
	}
	

	
	
	/**
	 * Print all values in console
	 */
	
	public void printAll() {
				
		System.out.println("################");
		System.out.println("Filename:" +getFileName());
		System.out.println("Creation Date:" +getCreationDate());
		System.out.println("Genre:" +getGenre());
		System.out.println("Month:" +getMonth());
		System.out.println("Plot:" +getPlot());
		System.out.println("New Folder Name:" + getNewFolder());
		System.out.println("New Thumbnail  File Name:" +getNewThumbnailName());
		System.out.println("New File Name:" +getNewFilename());
		System.out.println("Season:" +getSeason());
		System.out.println("Episode:" +getEpisode());
		System.out.println("Selected:" +getSelectEdit());
		System.out.println("Title:" +getTitle());
		System.out.println("Year:" +getYear());
		System.out.println("Remarks:" +getRemarks());
		System.out.println("################");
		
		
		
		
		
	}
	
	
	
}

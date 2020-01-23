package myOwnUtilLibrary;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class myXmlUtil { 
/**
 * 
 * Constructor
 *  
 */
	Element root;
	Document doc; 
	String XmlFileName;
	
/*
 * @param 	
 */
public myXmlUtil(String rootName, String XMLFileName) {
		
		this.root = new Element(rootName);
    	this.doc = new Document(root);
	    this.XmlFileName=XMLFileName;
        
    
}

   public void closeXMLfile() {
	
	   try {
	    	// XML-Dokument erzeugen


	    	XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
	    	
	    	FileOutputStream writer = new FileOutputStream(XmlFileName);
	    	out.output(doc, writer);
	    	
	    	writer.flush();
            writer.close();
	  
	        } 
	        catch (IOException e) { 
	            e.printStackTrace(); 
	        } 
	        
	    }
	 


   
   /**
    * Add a new value to XML
    * @param title XML Tag
    * @param value new value
    */
	public void writeXML(String title,String value){
		root.addContent(new Element(title).addContent(value));
	}
	
	
	 public void writeXMLfileEpisode(String f) { 
	        try {
	    	// XML-Dokument erzeugen

	        	
	    	Element root = new Element("episodedetails");
	    	Document doc = new Document(root);
	   
	    	root.addContent(new Element("title").addContent("titel"));
	    	root.addContent(new Element("year").addContent("year"));    	
	    	root.addContent(new Element("season").addContent("season"));		
	    	root.addContent(new Element("episode").addContent("episode"));

	    	// XML-Dokument in Datei speichern
	    	XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
	    	out.output(doc, new FileOutputStream(f));
	    	
	      	
	  
	        } 
	        catch (IOException e) { 
	            e.printStackTrace(); 
	        } 
	        
	    } 
	    
	    public void writeXMLfileSeason(String f) { 
	        try {
	    	// XML-Dokument erzeugen

	        	
	    	Element root = new Element("tvshow");
	    	Document doc = new Document(root);
	    	//root.addContent(new Element("title");
	    	root.addContent(new Element("title").addContent("titel"));
	    	root.addContent(new Element("year").addContent("year"));    	
	    	root.addContent(new Element("season").addContent("season"));		
	    	root.addContent(new Element("episode").addContent("episode"));
//	    	.addContent(new Element("alter").addContent("17")));
//	    	root.addContent(new Element("person").setAttribute("email", "berta@gmx.de")
//	    	.addContent(new Element("name").addContent("Berta"))
//	    	.addContent(new Element("alter").addContent("71")));
	    	// XML-Dokument in Datei speichern
	    	XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
	    	out.output(doc, new FileOutputStream(f));
	    	
	      	
	  
	        } 
	        catch (IOException e) { 
	            e.printStackTrace(); 
	        } 
	        
	    } 
	    
		

}

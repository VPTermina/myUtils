package myOwnUtilLibrary;
/**
 * 
 * http://filecopylibrary.sourceforge.net/
 * 
 * 
 */


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths; 
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import ch.fhnw.filecopier.CopyJob;
import ch.fhnw.filecopier.FileCopier;
import ch.fhnw.filecopier.FileCopierPanel;
import ch.fhnw.filecopier.Source;


public class myFileOperationUtil {
	
/**
 * Constructor
 * 
 */

	Source[] sources = new Source[]{,};	
	String[] destinations = new String[]{};	
	
	/*Source[] sources1 = new Source[]{
    // all files from directory /home/user/source1/
    new Source("C:/daten/video/test_nfo/test/source/", ".*\\.m2ts"),
    //all *.java files from directory /home/user/source2/
    new Source("/home/user/source2/", ".*\\.java")
};



String[] destinations1 = new String[]{
    "C:/daten/video/test_nfo/test/destination"
    
    
};*/
	
	
public myFileOperationUtil() {
	
		
	}


/**
 * 
 * Kopiert ein einzelnes File von source nach destination
 * 
 * Achtung: Ziel directory muss existieren!
 * 
 * 
 * 
 * @param src  Quell Directory  zB: C:\daten\video\test_nfo\test\source
 * @param dest Ziel Directory   zB: C:\daten\video\test_nfo\test\destination
 * @param pattern zb filename 
 * 
 * @serialData myFileOperationUtil.doSingleFileCopy("C:/daten/video/test_nfo/test/source/", "C:/daten/video/test_nfo/test/destination/","BurgBreuberg.m2ts");	
 * 
 */
	
	
	public static void doSingleFileCopy(String src, String pattern,String dest) {
		
		Source[] sources = new Source[]{
		       new Source(src, pattern),
		    };
		
		
		
		    String[] destinations = new String[]{dest        
		    
		    };
		
		
		CopyJob copyJob = new CopyJob(sources, destinations);
	    
	    
	    FileCopier fileCopier = new FileCopier();
		try {
			
			
			//new FileCopierPanel().setFileCopier(fileCopier);
						
			fileCopier.copy(copyJob);
					
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		
		
	}
	
public static void doSingleFileCopy(String src,String dest) {
		
	String pattern="";	
	Source[] sources = new Source[]{
		       new Source(src),
		    };
		
		
		
		    String[] destinations = new String[]{dest        
		    
		    };
		
		
		CopyJob copyJob = new CopyJob(sources, destinations);
		
	    //Source help = new Source(pattern); 
	 
	    
	    FileCopier fileCopier = new FileCopier();
		try {
			
			
			//new FileCopierPanel().setFileCopier(fileCopier);
						
			fileCopier.copy(copyJob);
					
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		
		
	}
	
	
	

/**
 * Hilfsfunktion Wird verwendet um das array zu füllen welches bei doMultifilecopy and Move verwendet wird! 
 * @param src Source path
 * @param src_pattern Pattern to identify the fileslike *.*
 * @param dest Destination 
 */
	public  void addfileForMultifileCopy(String src, String src_pattern,String dest ) {	
	
        
		//System.out.println(Arrays.toString(destinations));
		int newPos=destinations.length;
		newPos++;
		destinations = 	Arrays.copyOf(destinations, newPos);
		destinations[newPos-1]= new String(dest);
		//System.out.println(Arrays.toString(destinations));
		
		
		//System.out.println(Arrays.toString(sources));
		newPos=sources.length;
		newPos++;
		sources = 	Arrays.copyOf(sources, newPos);
		sources[newPos-1]= new Source(src, src_pattern,false);
		//System.out.println(Arrays.toString(sources));
		
		
	
	}
	/**
 * 
 * Kopiert alle Daten aus sources nach destination
 * Muss vorher befüllt werden mit addfileForMultifileCopy()
 * 	
 */
	
	
	
public void doMultiFileCopy() {
	
	
	CopyJob copyJob = new CopyJob(sources, destinations);
    
    
    FileCopier fileCopier = new FileCopier();
	try {
		
		
		//new FileCopierPanel().setFileCopier(fileCopier);
		fileCopier.copy(copyJob);
			
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	
}	

/*
 * 
 * 
 * 
 */
 public static void createDir (String t){
    	
        File target = new File(t);

             if(!target.exists()) target.mkdirs();
        

            }

/*
 * Liefert die Attribute eines Files und gibt sie in der console aus.
 * 
 */
public String getAttributes(String folder, String fileName) {
	Path file = Paths.get(folder, fileName);
	 BasicFileAttributes basicAttr;
	try {
		basicAttr = Files.readAttributes(file, BasicFileAttributes.class);
	
	 FileTime creationTime = basicAttr.creationTime();
	 System.out.println(creationTime);
	 FileTime lastAccessTime = basicAttr.lastAccessTime();
	 System.out.println(lastAccessTime);
	 FileTime lastModifiedTime = basicAttr.lastModifiedTime();
	 
	 
	 
	 System.out.println(lastModifiedTime);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return "";
	
}


/**
 * 
 * @param fullFileName The full path name of the file
 * @return Returns the fiel creation date
 */

public static String getFileCreationtime(String fullFileName) {
	Path file = Paths.get(fullFileName);
	 BasicFileAttributes basicAttr;
	try {
		basicAttr = Files.readAttributes(file, BasicFileAttributes.class);
	
	 FileTime creationTime = basicAttr.creationTime();
	
	 FileTime lastAccessTime = basicAttr.lastAccessTime();
	
	 FileTime lastModifiedTime = basicAttr.lastModifiedTime();
	 
	 return creationTime.toString();
	 
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return "";
	
}

/**
 * Returns the last modify date of a file
 * @param fullFileName The full filename of the file
 * @return Returns the last modify of the file
 * 
 * 
 */

public static String getFileLastModifiedTime(String fullFileName) {
	Path file = Paths.get(fullFileName);
	 BasicFileAttributes basicAttr;
	try {
		basicAttr = Files.readAttributes(file, BasicFileAttributes.class);
	
	 FileTime creationTime = basicAttr.creationTime();
	
	 FileTime lastAccessTime = basicAttr.lastAccessTime();
	
	 FileTime lastModifiedTime = basicAttr.lastModifiedTime();
	 
	 return lastModifiedTime.toString();
	 
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return "";
	
}

/** 
 * Copy Files recursivly. Work both for files and directories. 
 * If a file is given then copyFiles is called 
 * If a dir is given then copyFilesRecursive is called recursivly 
 * 
 * @param src Source
 * @param tar Target Dir
 * @throws IOException when: src doesn't exist, tar doesn't exist and  can't be created,  
 * a dir down the tar path doesn't exist and can't be created, or when copyFiles or 
 * IO operation fail. 
 *
 */ 
static public void copyFilesRecursive(File src, File tar) throws IOException { 


        if (!src.exists()) { 
                throw new IOException("Can't find source path: " + src); 
        } 
        if (!tar.exists()) { 
                if (!tar.mkdirs()) { 
                        throw new IOException("Failed creating target dir: " + tar); 
                } 
        } 
        String[] files = src.list(); 


        for (int j = 0; j < files.length; j++) { 
                File tmpSrc = new File(src, files[j]); 
                File tmpTar = new File(tar, files[j]); 


                if (tmpSrc.isDirectory()) { 
                        if (!tmpTar.exists()) { 
                                if (!tmpTar.mkdirs()) { 
                                        throw new IOException("Failed creating dir: " + tmpTar); 
                                } 
                        } 
                        copyFilesRecursive(tmpSrc, tmpTar); 
                } else { 
                        copyFiles(tmpSrc, tmpTar); 
                } 
        } // endfor() 
} 








/** 
 * Copy src to tar. 
 * Use only on files (for directory use copyFilesRecursive 
 * @param src Source file
 * @param tar  Destination file name
 * @throws IOException When: src or tar are directories, or IO operation throws exception 
 */ 
static public void copyFiles(File src, File tar) throws IOException { 
        if (src.isDirectory()) { 
                throw new IOException("Source file is a directory: " + src); 
        } 
        if (tar.isDirectory()) { 
                throw new IOException("Target file is a directory: " + tar); 
        } 
        //Open a stream to read in bytes from the file 
        //              FileInputStream myFis = new FileInputStream(src); 
        BufferedInputStream myFis = new BufferedInputStream(new FileInputStream(src)); 


        //make a destination byte stream to your copy 
        if (!tar.exists()) { 
                //trace("Creating file: "+tar); 
                tar.createNewFile(); 
        } 
        //              FileOutputStream myFos = new FileOutputStream(tar); 
        BufferedOutputStream myFos = 
                new BufferedOutputStream(new FileOutputStream(tar)); 


        byte[] buffer = new byte[1000]; 
        int len; 
        while ((len = myFis.read(buffer)) != -1) { 
                myFos.write(buffer, 0, len); 
        } 


        myFis.close(); 
        myFos.flush(); 
        myFos.close(); 
} 


/** 
 * Method deleteFilesRecursive. 
 * @param workDir Working dir
 * @throws IOException when delete fail 
 */ 
static public void deleteFilesRecursive(File workDir) throws IOException { 
        boolean res; 
        if (workDir.isFile()) { 
                res = workDir.delete(); 
                if (!res) { 
                        new IOException("Can not delete file: " + workDir.getName()).printStackTrace(); 
                } 
        } 
        String[] files = workDir.list(); 
        for (int j = 0; j < files.length; j++) { 
                File tmp = new File(workDir, files[j]); 
                if (tmp.isDirectory()) { 
                        deleteFilesRecursive(tmp); 
                } else { 
                        res = tmp.delete(); 
                        if (!res) { 
                                new IOException("Can not delete file: " + tmp.getName()).printStackTrace(); 
                        } 
                } 
        } // endfor() 
        workDir.delete(); 
} // end clearFilesRecursive(File)   




/** 
 * Try to use File.renameto(). 
 * If fail than a two step move: 
 * 1. call copyFilesRecursive, if fail than deleteFilesRecursive the tar 
 * 2. call deleteFilesRecursive the src 
 * @param src source
 * @param tar target
 * @throws IOException Could not copy
 */  


static public void move(File src, File tar) throws IOException { 
        if (src.renameTo(tar)) { 
                return; 
        } 
        try { 
                copyFilesRecursive(src, tar);                   
        } catch(IOException e) { 
                deleteFilesRecursive(tar); 
                throw e; 
        } 
        deleteFilesRecursive(src); 
} 


static public void trace(String str) { 
        System.out.println(str); 
        System.out.flush(); 
}

void printFileInfo(File fil)
{
   System.out.println("Name= "+fil.getName());
   System.out.println("Path= "+fil.getPath());
   System.out.println("AbsolutePath= "+fil.getAbsolutePath());
   System.out.println("Parent= "+fil.getParent());
   System.out.println("exists= "+fil.exists());
   System.out.println("canWrite= "+fil.canWrite());
   System.out.println("canRead= "+fil.canRead());
   System.out.println("isFile= "+fil.isFile());
   System.out.println("isDirectory= "+fil.isDirectory());
   if (fil.isDirectory()) {
      String fils[] = fil.list();
      for (int i=0; i<fils.length; ++i) {
         System.out.println("  "+fils[i]);
      }
   }
   System.out.println("isAbsolute= "+fil.isAbsolute());
   System.out.println(
      "lastModified= "+(new Date(fil.lastModified()))
   );
   System.out.println("length= "+fil.length());
   System.out.println("");
}


/**
 * Löschte die File Erweiterung und den Path 
 * @param s Filename
 * @return Filename without  path and extension
 */

static public String removeFilePathAndExtension(String s) {

    String separator = System.getProperty("file.separator");
    String filename;

    // Remove the path upto the filename.
    int lastSeparatorIndex = s.lastIndexOf(separator);
    if (lastSeparatorIndex == -1) {
        filename = s;
    } else {
        filename = s.substring(lastSeparatorIndex + 1);
    }

    // Remove the extension.
    int extensionIndex = filename.lastIndexOf(".");
    if (extensionIndex == -1)
        return filename;

    return filename.substring(0, extensionIndex);
}




/**
 * Removing file extension
 * @param s Filename without path as string
 * @return Filename without path and extension
 */
static public String removeFileExtension(String s) {

    // Remove the extension.
    int extensionIndex = s.lastIndexOf(".");
    if (extensionIndex == -1)
        return s;

    return s.substring(0, extensionIndex);
}



/**
 * Run a external programm with parameters
 * 
 * 
 * @param parameter 1. Parameter: Name und Pfad des Programmes/ 2... n : Parameter 
 */


static public void runExternalProgramm(String[] parameter) {
try {
	
	
	
	

	Process p =Runtime.getRuntime().exec(parameter);
	
    String line;
    //Process p = Runtime.getRuntime().exec("cmd /c dir");
    
    
    BufferedReader bri = new BufferedReader
      (new InputStreamReader(p.getInputStream()));
    BufferedReader bre = new BufferedReader
      (new InputStreamReader(p.getErrorStream()));
    while ((line = bri.readLine()) != null) {
      System.out.println(line);
    }
    bri.close();
    while ((line = bre.readLine()) != null) {
      System.out.println(line);
    }
    bre.close();
    p.waitFor();
    System.out.println("Done.");
  }
  catch (Exception err) {
    err.printStackTrace();
  }
}

 


/**
 *  Show the system properties in console window
 */
public void showSystemProperties() {
	
	Properties props = System.getProperties();
    Enumeration names = props.propertyNames();
    while (names.hasMoreElements()) {
       String name = (String)names.nextElement();
       System.out.println(name + "=" + System.getProperty(name));
	
}
}

}






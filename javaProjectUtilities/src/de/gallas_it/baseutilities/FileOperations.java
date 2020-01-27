package de.gallas_it.baseutilities;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStreamReader;
import java.nio.file.CopyOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import ch.fhnw.filecopier.CopyJob;
import ch.fhnw.filecopier.FileCopier;
import ch.fhnw.filecopier.Source;


/**
 * 
 * Die Bibliothek stell verschiedene Methoden zum kopieren/bewegen/löschen von Files und Dir zur Verfuegung 
 * 
 * Verschiedene Möglichkeiten werden eingesetzt
 * CoreJava: Verwendung der Standard Java Methoden Input stream/output stream
 * ChFhnw:   Verwendet die externe Bibliothek ch.fhnw.filecopier
 * JavaNio:	Verwendet die Java NIO  http://tutorials.jenkov.com/java-nio/files.html
 * 
 * 
 * @author u991712
 *
 */

public class FileOperations {
	
/**
 * Constructor
 * 
 */
	
	
	
public FileOperations() {
	
			}


// JavaNio:	Verwendet die Java NIO  http://tutorials.jenkov.com/java-nio/files.html
/**
 * Check if a file or Dir exists. Sym Link will be not followed
 * Method is using Java NIO  http://tutorials.jenkov.com/java-nio/files.html
 * Example of using: System.out.println(FileOperations.checkFileExistsJavaNio("C:\\data\\1.mp4")); 
 * @param fullPath  fullPath to file or folder, Wildcards are not allowed
 * @return True/False if File exist
 */
public static boolean checkFileExistsJavaNio(String fullPath)
{


Path path = Paths.get(fullPath);

boolean pathExists =
        Files.exists(path,
            new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});
return pathExists;

}

/**
 * Copies a file from one path to another. 
 * You can copy a file or directory by using the copy(Path, Path, CopyOption...) method. The copy fails if the target file exists, unless the REPLACE_EXISTING option is specified.
 * Directories can be copied. However, files inside the directory are not copied, so the new directory is empty even when the original directory contains files.
 * When copying a symbolic link, the target of the link is copied. If you want to copy the link itself, and not the contents of the link, specify either the NOFOLLOW_LINKS or REPLACE_EXISTING option.
 * This method takes a varargs argument. The following StandardCopyOption and LinkOption enums are supported:
 * Method is using Java NIO  http://tutorials.jenkov.com/java-nio/files.html
 * Example of using: System.out.println(FileOperations.checkFileExistsJavaNio("C:\\data\\1.mp4")); 
 * @param fullPath  fullPath to file or folder, Wildcards are not allowed
 * @param destPath  full FileNAme of copied file 
 * @return Filename of new created (copied) File
 */
public static String copyFileJavaNio(String srcPath, String destPath)
{                    
	
	
	Path sourcePath      = Paths.get(srcPath);
	Path destinationPath = Paths.get(destPath);

	try {
	    return Files.copy(sourcePath, destinationPath).toString();
	} catch(FileAlreadyExistsException e) {
		e.printStackTrace();
		return "FileAllreadyExist";
	    //destination file already exists
	} catch (IOException e) {
	    //something else went wrong		
	    e.printStackTrace();
	    return "IOExeption";
	}

	
	
}

/**
 * Move a file from one path to another. 
 * You can move a folder by using the move(Path, Path, CopyOption...) method. The copy fails if the target file exists, unless the REPLACE_EXISTING option is specified.
 * Directories can also be moved:  
 * <pre>
 * {@code System.out.println(FileOperations.moveFileJavaNio("C:\\data\\", "C:\\data1\\",false));}
 * {@code System.out.println(FileOperations.moveFileJavaNio("C:\\data\\1.mp4", "C:\\data1\\2.mp4",false));}
 * 
 * </pre>
 * When copying a symbolic link, the target of the link is copied. If you want to copy the link itself, and not the contents of the link, specify either the NOFOLLOW_LINKS or REPLACE_EXISTING option.
 * This method takes a varargs argument. The following StandardCopyOption and LinkOption enums are supported:
 * Method is using Java NIO  http://tutorials.jenkov.com/java-nio/files.html
 * Example of using: System.out.println(FileOperations.checkFileExistsJavaNio("C:\\data\\1.mp4")); 

 * @param srcPathullPath to file or folder, Wildcards are not allowed
 * @param destPath fullPath to file or folder, Wildcards are not allowed
 * @param replace  true if replace existing files without asking
 * @return Filename of new created (moved) File

 */


public static String moveFileJavaNio(String srcPath, String destPath, Boolean replace)
{                    
	
	StandardCopyOption option = StandardCopyOption.REPLACE_EXISTING;

	Path sourcePath      = Paths.get(srcPath);
	Path destinationPath = Paths.get(destPath);

	try {
		
		if (replace==true) { 
	    return Files.move(sourcePath, destinationPath,option).toString();
		}else
		{
			return Files.move(sourcePath, destinationPath).toString();
		}
	} catch(FileAlreadyExistsException e) {
		e.printStackTrace();
		return "FileAllreadyExist";
	    //destination file already exists
	} catch (IOException e) {
	    //something else went wrong		
	    e.printStackTrace();
	    return "IOExeption";
	}

	
	
}


/**
 * Removes a directory recursivly without confirmation!
 * * <pre>
 * {@code FileOperations.deleteDirectoriesRecursivlyJavaNio("c:\\data1\\");}
 * 
 * </pre>
 *  * @param srcPath to file or folder, all Files and sub folders will be removed

 * @return Filename of new created (moved) File

 */


public static void deleteDirectoriesRecursivlyJavaNio(String srcPath)
{                    
	Path rootPath = Paths.get(srcPath);

	try {
	  Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
	    @Override
	    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
	      System.out.println("delete file: " + file.toString());
	      Files.delete(file);
	      return FileVisitResult.CONTINUE;
	    }

	    @Override
	    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
	      Files.delete(dir);
	      System.out.println("delete dir: " + dir.toString());
	      return FileVisitResult.CONTINUE;
	    }
	  });
	} catch(IOException e){
		e.printStackTrace();
		
	  
	}
	
	
}






// CORE Java

/**
 * Copy src file  to destination tar with CoreJava 
 * Use only on files (for directory use copyFilesRecursive 
 * @param src Source file
 * @param tar  Destination file name
 * @return Succesfully copied or not
 * @throws IOException rc or tar are directories, or IO operation throws exception 
 */

public boolean doSingleFileCopyCoreJava(File src, File tar) throws IOException {
	
	
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
	
return true;
}



	

}

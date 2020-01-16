package myOwnUtilLibrary;

public class myMediaInfo {
  
	
	MediaInfo mediaInfo;

	
	
	public void setMetaInfo(String fullFileName){
	
		
		mediaInfo    = new MediaInfo();
    
	
	    int i = mediaInfo.Open(fullFileName);
   
	}
	
    

}

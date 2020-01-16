package myOwnUtilLibrary;


import java.util.ArrayList;
import java.util.UUID;




public class myVideoInfo {
	
	/**
	 * @return all Version Infos for Mediainfo.dll
	 */
	public String getMediaInfoDLLVersionInfo() {
		
		String help = MediaInfo.getInfoAboutMediaInfoVersion();
		
		
		return help;
	}
	
	
	
	/**
	 * @return the myGeneral
	 */
	public generalInformation getMyGeneral() {
		return myGeneral;
	}


	/**
	 * @return the allVideoStreams
	 */
	public ArrayList<streamInformation> getAllVideoStreams() {
		return allVideoStreams;
	}


	/**
	 * @return the allAudioStreams
	 */
	public ArrayList<audioInformation> getAllAudioStreams() {
		return allAudioStreams;
	}


	/**
	 * @return the allSubtitleStreams
	 */
	public ArrayList<subtitleInformation> getAllSubtitleStreams() {
		return allSubtitleStreams;
	}

	// Generall Information
	generalInformation myGeneral = new generalInformation();
	
	
	public class generalInformation{
		private String UniqueID;	
		private String movieName;
		private String fullPathName;  // 
		private String destinationPathname; // 
		private String videoFormat;    //
		private String fileSize; // 
	    private int countVideoStreams; // Count of video streams inside file
		private int countAudioStreams;
		private int countSubtitleStreams;
		private int countImageStreams;
		private String idMovieDB;    // http://www.imdb.com/ 
		private String idTheMovieDB;    //http://www.themoviedb.org/ http://docs.themoviedb.apiary.io/
		private String idTheTVDB;    //
		private String encodedDate;    //
		private String movie_more;    //
		
		
		
		
		
		/**
		 * @return the movie_more
		 */
		public String getMovie_more() {
			return movie_more;
		}

		/**
		 * @param movie_more the movie_more to set
		 */
		public void setMovie_more(String movie_more) {
			this.movie_more = movie_more;
		}

		public String getEncodedDate() {
			
			return myDateandTimeUtil.convertUTC_timeToLocalTime(encodedDate);
			
		
		}

		public void setEncodedDate(String encodedDate) {
			this.encodedDate = encodedDate;
		}

		/**
		 * @return the idMovieDB
		 */
		public String getIdMovieDB() {
			return idMovieDB;
		}

		/**
		 * @param idMovieDB the idMovieDB to set
		 */
		public void setIdMovieDB(String idMovieDB) {
			this.idMovieDB = idMovieDB;
		}

		/**
		 * @return the idTheMovieDB
		 */
		public String getIdTheMovieDB() {
			return idTheMovieDB;
		}

		/**
		 * @param idTheMovieDB the idTheMovieDB to set
		 */
		public void setIdTheMovieDB(String idTheMovieDB) {
			this.idTheMovieDB = idTheMovieDB;
		}

		/**
		 * @return the idTheTVDB
		 */
		public String getIdTheTVDB() {
			return idTheTVDB;
		}

		/**
		 * @param idTheTVDB the idTheTVDB to set
		 */
		public void setIdTheTVDB(String idTheTVDB) {
			this.idTheTVDB = idTheTVDB;
		}

		/**
		 * @return the uniqueID
		 */
		public String getUniqueID() {
			return UniqueID;
		}
		
		/**
		 * @return the movieName
		 */
		public String getMovieName() {
			return movieName;
		}
		/**
		 * @param movieName the movieName to set
		 */
		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}
		/**
		 * @return the fullPathName
		 */
		public String getFullPathName() {
			return fullPathName;
		}
		/**
		 * @param fullPathName the fullPathName to set
		 */
		public void setFullPathName(String fullPathName) {
			this.fullPathName = fullPathName;
		}
		/**
		 * @return the destinationPathname
		 */
		public String getDestinationPathname() {
			return destinationPathname;
		}
		/**
		 * @param destinationPathname the destinationPathname to set
		 */
		public void setDestinationPathname(String destinationPathname) {
			this.destinationPathname = destinationPathname;
		}
		/**
		 * @return the videoFormat
		 */
		public String getVideoFormat() {
			return videoFormat;
		}
		/**
		 * @param videoFormat the videoFormat to set
		 */
		public void setVideoFormat(String videoFormat) {
			this.videoFormat = videoFormat;
		}
		/**
		 * @return the fileSize
		 */
		public String getFileSize() {
			return fileSize;
		}
		/**
		 * @param fileSize the fileSize to set
		 */
		public void setFileSize(String fileSize) {
			this.fileSize = fileSize;
		}
		/**
		 * @return the countVideoStreams
		 */
		public int getCountVideoStreams() {
			return countVideoStreams;
		}
		/**
		 * @param countVideoStreams the countVideoStreams to set
		 */
		public void setCountVideoStreams(int countVideoStreams) {
			this.countVideoStreams = countVideoStreams;
		}
		/**
		 * @return the countAudioStreams
		 */
		public int getCountAudioStreams() {
			return countAudioStreams;
		}
		/**
		 * @param countAudioStreams the countAudioStreams to set
		 */
		public void setCountAudioStreams(int countAudioStreams) {
			this.countAudioStreams = countAudioStreams;
		}
		/**
		 * @return the countSubtitleStreams
		 */
		public int getCountSubtitleStreams() {
			return countSubtitleStreams;
		}
		/**
		 * @param countSubtitleStreams the countSubtitleStreams to set
		 */
		public void setCountSubtitleStreams(int countSubtitleStreams) {
			this.countSubtitleStreams = countSubtitleStreams;
		}
		/**
		 * @return the countImageStreams
		 */
		public int getCountImageStreams() {
			return countImageStreams;
		}
		/**
		 * @param countImageStreams the countImageStreams to set
		 */
		public void setCountImageStreams(int countImageStreams) {
			this.countImageStreams = countImageStreams;
		}
		
		
		
		}
	
	
	//Video Stream  Information
		public class streamInformation{
		private String UniqueID;
		private String  videoStreamFormat;  // 
		private String 	videoCodec;   //VC-1, MPEG-1, Matroska       Format/Codec/Codec_Description
		private String 	videoDuration;   //Duration/String
		private String 	videoSize; // Width   + Height in pixel
		private String videoAspectRatio;      //DisplayAspectRatio/String
		private String 	videoFrameRate; // FrameRate   in fps
		private String 	videoResolution; //Resolution
		private String 	videoEncodedDate; //Encoded date
		private String videoEncodedMovieMore;//Kamera Modell
		
		public String getVideoEncodedDate() {
			return videoEncodedDate;
		}
		public void setVideoEncodedDate(String videoEncodedDate) {
			this.videoEncodedDate = videoEncodedDate;
		}
		/**
		 * @return the uniqueID
		 */
		public String getUniqueID() {
			return UniqueID;
		}
		/**
		 * @param uniqueID the uniqueID to set
		 */
		public void setUniqueID(String uniqueID) {
			UniqueID = uniqueID;
		}
		/**
		 * @return the videoStreamFormat
		 */
		public String getVideoStreamFormat() {
			return videoStreamFormat;
		}
		/**
		 * @param videoStreamFormat the videoStreamFormat to set
		 */
		public void setVideoStreamFormat(String videoStreamFormat) {
			this.videoStreamFormat = videoStreamFormat;
		}
		/**
		 * @return the videoCodec
		 */
		public String getVideoCodec() {
			return videoCodec;
		}
		/**
		 * @param videoCodec the videoCodec to set
		 */
		public void setVideoCodec(String videoCodec) {
			this.videoCodec = videoCodec;
		}
		/**
		 * @return the videoDuration
		 */
		public String getVideoDuration() {
			return videoDuration;
		}
		/**
		 * @param videoDuration the videoDuration to set
		 */
		public void setVideoDuration(String videoDuration) {
			this.videoDuration = videoDuration;
		}
		/**
		 * @return the videoSize
		 */
		public String getVideoSize() {
			return videoSize;
		}
		/**
		 * @param videoSize the videoSize to set
		 */
		public void setVideoSize(String videoSize) {
			this.videoSize = videoSize;
		}
		/**
		 * @return the videoAspectRatio
		 */
		public String getVideoAspectRatio() {
			return videoAspectRatio;
		}
		/**
		 * @param videoAspectRatio the videoAspectRatio to set
		 */
		public void setVideoAspectRatio(String videoAspectRatio) {
			this.videoAspectRatio = videoAspectRatio;
		}
		/**
		 * @return the videoFrameRate
		 */
		public String getVideoFrameRate() {
			return videoFrameRate;
		}
		/**
		 * @param videoFrameRate the videoFrameRate to set
		 */
		public void setVideoFrameRate(String videoFrameRate) {
			this.videoFrameRate = videoFrameRate;
		}
		/**
		 * @return the videoResolution
		 */
		public String getVideoResolution() {
			return videoResolution;
		}
		/**
		 * @param videoResolution the videoResolution to set
		 */
		public void setVideoResolution(String videoResolution) {
			this.videoResolution = videoResolution;
		}
		
		
		
		
		}
		
		
		 
		//Audio information 
		
		public class audioInformation{
		private String audioFormat; //DTS, AC-3, MPEG Audio, AAC   Line 1 Spalte 1
		private String audioLanguage; //German, Englisch    Line 14 Spalte  3         
		private String audioChannels;  // 2 -channels, mono, 6- channels    Line 9, Spalte 3

		/*
		<AudioTrack>
	    <AudioContent>German</AudioContent>
	    <AudioFormat>Dolby Digital</AudioFormat>
	    <AudioChannels>Mono</AudioChannels>
	    </AudioTrack>
	 */
		}
		
		public class subtitleInformation{
			private String subtitleLanguage;
		}
			
	
	private  ArrayList<streamInformation> allVideoStreams;
	private  ArrayList<audioInformation> allAudioStreams;
	private  ArrayList<subtitleInformation> allSubtitleStreams;

	
   

 /**
	 * 
	 */
	public myVideoInfo() {

		
		allVideoStreams = new  ArrayList<streamInformation>();
		allAudioStreams = new  ArrayList<audioInformation>();
		allSubtitleStreams = new  ArrayList<subtitleInformation>();
		
	}


/*
 * Retrieve  all Metainfos and stores it in local variables
 * 
 */
public void setMetaInfo(String location){
	
	
	
	MediaInfo mediaInfo    = new MediaInfo();
    int i = mediaInfo.Open(location);
   
        
    
    int j;
    
    /* *****************************  Set all General infos *****************/
    
    allVideoStreams.clear();
    allAudioStreams.clear();
    allSubtitleStreams.clear();
    
    
    
    myGeneral.UniqueID = mediaInfo.getInfo("General", 0, "UniqueID");
    
    if (myGeneral.UniqueID.equals("")){
    	UUID idOne = UUID.randomUUID();
    	myGeneral.UniqueID = idOne.toString();
    };
    		
    //myGeneral.DatabaseCreationTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
    	
    //myGeneral.DatabaseCreationTime ="rocco";
    
    myGeneral.movieName = mediaInfo.getInfo("General", 0, "Movie");    
    if (myGeneral.movieName.equals("")){
    	myGeneral.movieName = mediaInfo.getInfo("General", 0, "FileName");
    };
    
    
    myGeneral.fullPathName = mediaInfo.getInfo("General", 0, "CompleteName");
	
myGeneral.destinationPathname =""; // 
myGeneral.videoFormat="";
myGeneral.videoFormat = mediaInfo.getInfo("General", 0, "Format");  
	
	
	
myGeneral.fileSize = mediaInfo.getInfo("General", 0, "FileSize");     
myGeneral.encodedDate = mediaInfo.getInfo("General", 0, "Encoded_Date");

myGeneral.movie_more = mediaInfo.getInfo("General", 0, "Movie_More");  


myGeneral.countVideoStreams = 0;
myGeneral.countAudioStreams = 0;
myGeneral.countSubtitleStreams = 0;
myGeneral.countImageStreams = 0;
	
    		
				
myGeneral.countVideoStreams = mediaInfo.getInfoInt("General", 0, "VideoCount") ; // Count of video streams inside file
myGeneral.countAudioStreams = mediaInfo.getInfoInt("General", 0, "AudioCount");
myGeneral.countSubtitleStreams = mediaInfo.getInfoInt("General", 0, "TextCount");
myGeneral.countImageStreams = mediaInfo.getInfoInt("General", 0, "ImageCount");
    
    
    
    
   	
	
    
	/* *****************************  Set all Video infos *****************/
    
    for (j = 0; j < myGeneral.countVideoStreams; j++) { 
    	
    	streamInformation myStream = new streamInformation();
    	
    	myStream.videoStreamFormat =  mediaInfo.getInfo("Video", j, "Format");  // 
		myStream.videoCodec=  mediaInfo.getInfo("Video", j, "Codec");;   //VC-1, MPEG-1, Matroska       Format/Codec/Codec_Description
		myStream.videoDuration=  mediaInfo.getInfo("Video", j, "Duration/String3");;   //Duration/String
		myStream.videoSize=  mediaInfo.getInfo("Video", j, "Width") + " x " + mediaInfo.getInfo("Video", j, "Height"); // Width   + Height in pixel
		myStream.videoAspectRatio=  mediaInfo.getInfo("Video", j, "DisplayAspectRatio/String");      //DisplayAspectRatio/String
		myStream.videoFrameRate=  mediaInfo.getInfo("Video", j, "FrameRate"); // FrameRate   in fps
		myStream.videoResolution=  mediaInfo.getInfo("Video", j, "Resolution"); //Resolution
        myStream.videoEncodedDate= mediaInfo.getInfo("Video", j, "Encoded_Date"); //Resolution
    	myStream.videoEncodedMovieMore = mediaInfo.getInfo("Video", j, "Movie"); //Kamera Modell
        
        allVideoStreams.add(myStream);
    }
    	 /* *****************************  Set all Video infos *****************/
        allAudioStreams.clear();
        
        for (j = 0; j < myGeneral.countAudioStreams; j++) { 
        	
        	audioInformation myAudio = new audioInformation();
        	
        	myAudio.audioFormat =  mediaInfo.getInfo("Audio", j, "Format");  // 
    		myAudio.audioLanguage=  mediaInfo.getInfo("Audio", j, "Language/String");   //
    		myAudio.audioChannels=  mediaInfo.getInfo("Audio", j, "Channel(s)");   //
    		
           	
        	allAudioStreams.add(myAudio);	

        }
	
    mediaInfo.Close(); 
   
	
}

/*
 * Retrieve  all Metainfos and stores it in local variables
 * 
 */
public String getMetaInfo(String location){
	
	String output;
	setMetaInfo(location);
	
	output = " MediaInfo Moviename: " + myGeneral.movieName + "\n";
	output += " MediaInfo Video Format: " +myGeneral.videoFormat+ "\n";
	output += " MediaInfo Encoded Date: " +myGeneral.getEncodedDate()+ "\n";
	output += " MediaInfo Camera model: " + myGeneral.movie_more+ "\n";
	
	
	
	//output += myGeneral.+ "\n";
	
	
	//myStream=allVideoStreams.get(0); 
	
	for (int j = 0; j < myGeneral.countVideoStreams; j++) { 
	output += " MediaInfo Video Steramformat: " +allVideoStreams.get(j).videoStreamFormat + " \n";
	output += " MediaInfo Video Codec: " + allVideoStreams.get(j).videoCodec+ " \n";
	output += " MediaInfo Video duration: " +allVideoStreams.get(j).videoDuration+ " ms\n";
	output += " MediaInfo Video Size: " +allVideoStreams.get(j).videoSize+ " \n";
	output += " MediaInfo Video Aspect Ratio: " +allVideoStreams.get(j).videoAspectRatio+ " \n";
	output += " MediaInfo Video Frame Rate: " +allVideoStreams.get(j).videoFrameRate+ " \n";
	output += " MediaInfo Video Resolution: " +allVideoStreams.get(j).videoResolution+ " Bit\n";
	}
	
	return (output);
	
	
}

public String getMetaInfoAsHTML (String location){
	String output;
	setMetaInfo(location);
	
	StringBuilder message = new StringBuilder(300);
	
	//message.append("<span style=\"color:red\">" + "************** Generall information *************" + "</span>");
   // message.append("<html><TABLE border=1>");
    
	
    message.append("<TR align=center><TD>");
    
   
    message.append(myGeneral.movieName);
    message.append("</TD><TD>");
    

    message.append(myGeneral.videoFormat);
    message.append("</TD><TD>");
    	
	for (int j = 0; j < myGeneral.countVideoStreams; j++) { 
		 message.append(allVideoStreams.get(j).videoStreamFormat + "</TD><TD>");
		 message.append(allVideoStreams.get(j).videoCodec+ "</TD><TD>");
		 message.append(allVideoStreams.get(j).videoDuration+ "</TD><TD>");
		 message.append(allVideoStreams.get(j).videoSize+ "</TD><TD>");
		 message.append( allVideoStreams.get(j).videoAspectRatio+ "</TD><TD>");
		 message.append(allVideoStreams.get(j).videoFrameRate+ "</TD><TD>");
		 message.append(allVideoStreams.get(j).videoResolution+ "</TD><TD>");
	}
	
	for (int j = 0; j < myGeneral.countAudioStreams; j++) { 
		 message.append(allAudioStreams.get(j).audioFormat + "***");
		 message.append(allAudioStreams.get(j).audioLanguage+ "<***");
		 message.append(allAudioStreams.get(j).audioChannels+ "</TD><TD>");
		 
	}
	
	
	
	message.append("</TD></TR>");
	 //message.append("</TABLE>");
	
	

	 /*   
    for (int j = 0; j < video_general.length; j++) { 
    	if (video_general[j][0].trim().length() != 0){
    		message.append("<TR align=center><TD>");
            message.append(video_general[j][1]);
            message.append("</TD><TD>");
            message.append(video_general[j][0]);
            message.append("</TD><TD>");
            message.append(video_general[j][2]);
            message.append("</TD></TR>");
    	}            	
    }
    message.append("</TABLE>");
    
    */
    return message.toString();
	}
	


/*
 * Loads all meta information for video file
 */



public String loadAllMetaInfos(String location)
 {
     
	   MediaInfo mediaInfo    = new MediaInfo();
       int i = mediaInfo.Open(location);
      
       mediaInfo.setVideo_allMetaInfos();
       
       //return mediaInfo.getAllMetaInfos();  
       return mediaInfo.getAllMetaInfosAsHTML();  

     //mediaInfo.Close();
 
     
 }


public String loadSummaryInfos(String location)
{
    
	   MediaInfo mediaInfo    = new MediaInfo();
      int i = mediaInfo.Open(location);
     
      mediaInfo.setVideo_allMetaInfos();
     
      
      //return mediaInfo.getAllMetaInfos();  
      return mediaInfo.getSummaryAsHTML();  

    //mediaInfo.Close();

    
}

public String loadSpecificMetaInfos(String location, String type)
{
    
	   MediaInfo mediaInfo    = new MediaInfo();
      int i = mediaInfo.Open(location);
      String value;
      mediaInfo.setVideo_allMetaInfos();
      
      value = mediaInfo.getInfo("General", 0, type);
      value += "\r\n";
      
      value += mediaInfo.getInfo("Video", 0, type);
      value += "\r\n";
      value += mediaInfo.getInfo("Audio", 0, type);
      value += "\r\n";
      value += mediaInfo.getInfo("Text", 0, type);
      value += "\r\n";
      
      //return mediaInfo.getAllMetaInfos();  
     
      
      return value;

    //mediaInfo.Close();

    
}

	 
	

}

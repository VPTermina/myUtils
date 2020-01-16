package myOwnUtilLibrary;



import java.util.HashMap;
import java.util.Map;
import java.util.Set;


//import MyXmlUtil.myXmlUtil;

public class episodeNFO {

	/*
	 * 
	 * https://kodi.wiki/view/NFO_files/TV_shows#TV_nfo_Tags
	 * 
	Naming & Saving conventions for your TV Episode *.nfo files:

		Saved Episodes as						File Name				Save Location
		BluRay Structure:						index.nfo				f:\MyTVShows\iZombie\iZombie S01E01\BDMV\index.nfo
		DVD Structure:							VIDEO_TS.nfo			f:\MyTVShows\iZombie\iZombie S01E01\VIDEO_TS\VIDEO_TS.nfo
		Single Episode file in directory:		<EpisodeFileName>.nfo	f:\MyTVShows\iZombie\iZombie S01E01\<EpisodeFileName>.nfo
		All episodes in TV Show directory:		<EpisodeFileName>.nfo	f:\MyTVShows\iZombie\<EpisodeFileName>.nfo

...\Paul (2011)\Paul (2011).4K.HDR.Atmos.mkv

Wie erzeuge ich eigen Thumbnails: https://kodi.wiki/view/HOW-TO:Create_video-preview_thumbnails_manually

<EpisodeFileName>-thumb.jpg
1280x720

for %i in (*.m2ts) do ffmpeg -i "%i" -f mjpeg -t 0.001 -ss 20 -s 1280x720 -y "%~ni-thumb.jpg"

*
*/		
	
	
	
	Map<String,String> myEpisodeNFOStructure;
	
	
	public episodeNFO(){
		// Struktur für die nfo Datei der Episode	
		myEpisodeNFOStructure = new HashMap<String,String>();
		myEpisodeNFOStructure.put("title","initTitle");
		myEpisodeNFOStructure.put("year","2016");
		myEpisodeNFOStructure.put("episode","1");
		myEpisodeNFOStructure.put("season","1");
		myEpisodeNFOStructure.put("plot","initPlot");
		myEpisodeNFOStructure.put("outline","initOutline");
		myEpisodeNFOStructure.put("premiered","2016-12-31");
		myEpisodeNFOStructure.put("aired","2016-12-30");
		myEpisodeNFOStructure.put("genre","Urlaub");
		myEpisodeNFOStructure.put("tag","Urlaub");
		
		
	}
/*
 * 
 */
 public void setNfoValue(String key, String value){
	 myEpisodeNFOStructure.replace(key, value);
	 
 }
	
/*
 * Liefert ein Array mit allen Namen und Werten zurück
 * 
 */
public void printAllValues() {
	for (Map.Entry<String, String> entry : myEpisodeNFOStructure.entrySet()) {
		System.out.println("Item: " + entry.getKey() + " Value: " + entry.getValue());
	}	 

}

public void createNFOFileEpisode(String fileName) {
	
	fileName = myFileOperationUtil.removeFileExtension(fileName) + ".nfo";
	myXmlUtil nfoFile = new myXmlUtil("episodedetails",fileName); 	
	Set keySet = myEpisodeNFOStructure.keySet();
	
			
	for (Map.Entry<String, String> entry : myEpisodeNFOStructure.entrySet()) {
		nfoFile.writeXML(entry.getKey(),entry.getValue());
		
	}
	
	nfoFile.closeXMLfile();
	
    
}	
	
	
}

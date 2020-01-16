package myOwnUtilLibrary;



/**
 * MediaInfoDLL - All info about media files, for DLL (JNA version)
 *
 * Copyright (C) 2009-2009 Jerome Martinez, Zen@MediaArea.net
 *
 * This library is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library. If not, see <http://www.gnu.org/licenses/>.
 *
 **/

// Note: the original stuff was well packaged with Java style,
// but I (the main developer) prefer to keep an easiest for me
// way to have all sources and example in the same place
// Removed stuff:
// "package net.sourceforge.mediainfo;"
// directory was /net/sourceforge/mediainfo



import static java.util.Collections.singletonMap;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

 

import com.sun.jna.FunctionMapper;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.WString;


public class MediaInfo {
	private static final Logger LOGGER = LogManager.getLogger(MediaInfo.class);
	
	
	static String libraryName;

	static {
		if (Platform.isWindows() && Platform.is64Bit()) {
			//libraryName = "MediaInfo64_v7_63";
			//Anpassen um die korrekte mediainfo.dll anzusprechen!
			/*------------------------------------------------------------------------------
			javaw.exe pid: 3448
			Command line: "C:\Program Files\Java\jre1.8.0_51\bin\javaw.exe" -Dfile.encoding=Cp1252 -classpath "C:\Program Files\Java\jre1.8.0_51\lib\resources.jar;C:\Program Files\Java\jre1.8.0_51\lib\rt.jar;C:\Program Files\Java\jre1.8.0_51\lib\jsse.jar;C:\Program Files\Java\jre1.8.0_51\lib\jce.jar;C:\Program Files\Java\jre1.8.0_51\lib\charsets.jar;C:\Program Files\Java\jre1.8.0_51\lib\jfr.jar;C:\Program Files\Java\jre1.8.0_51\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jre1.8.0_51\lib\ext\cldrdata.jar;C:\Program Files\Java\jre1.8.0_51\lib\ext\dnsns.jar;C:\Program Files\Java\jre1.8.0_51\lib\ext\jaccess.jar;C:\Program Files\Java\jre1.8.0_51\lib\ext\jfxrt.jar;C:\Program Files\Java\jre1.8.0_51\lib\ext\localedata.jar;C:\Program Files\Java\jre1.8.0_51\lib\ext\nashorn.jar;C:\Program Files\Java\jre1.8.0_51\lib\ext\sunec.jar;C:\Program Files\Java\jre1.8.0_51\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jre1.8.0_51\lib\ext\sunmscapi.jar;C:\Program Files\Java\jre1.8.0_51\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jre1.8.0_51\lib\ext\zipfs.jar;C:\Users\rocco\OneDrive\WorkspaceTermina\myVideoRenamer\bin;C:\Users\rocco\OneDrive\WorkspaceTermina\myUtilClass\bin;C:\Users\rocco\OneDrive\WorkspaceTermina\libraries\java_file_copy_library-0.9.7_all.jar;C:\Users\rocco\.p2\pool\plugins\org.junit.jupiter.api_5.0.0.v20170910-2246.jar;C:\Users\rocco\.p2\pool\plugins\org.junit.jupiter.engine_5.0.0.v20170910-2246.jar;C:\Users\rocco\.p2\pool\plugins\org.junit.jupiter.migrationsupport_5.0.0.v20170910-2246.jar;C:\Users\rocco\.p2\pool\plugins\org.junit.jupiter.params_5.0.0.v20170910-2246.jar;C:\Users\rocco\.p2\pool\plugins\org.junit.platform.commons_1.0.0.v20170910-2246.jar;C:\Users\rocco\.p2\pool\plugins\org.junit.platform.engine_1.0.0.v20170910-2246.jar;C:\Users\rocco\.p2\pool\plugins\org.junit.platform.launcher_1.0.0.v20170910-2246.jar;C:\Users\rocco\.p2\pool\plugins\org.junit.platform.runner_1.0.0.v20170910-2246.jar;C:\Users\rocco\.p2\pool\plugins\org.junit.platform.suite.api_1.0.0.v20170910-2246.jar;C:\Users\rocco\.p2\pool\plugins\org.junit.vintage.engine_4.12.0.v20170910-2246.jar;C:\Users\rocco\.p2\pool\plugins\org.opentest4j_1.0.0.v20170910-2246.jar;C:\Users\rocco\.p2\pool\plugins\org.apiguardian_1.0.0.v20170910-2246.jar;C:\Users\rocco\.p2\pool\plugins\org.junit_4.12.0.v201504281640\junit.jar;C:\Users\rocco\.p2\pool\plugins\org.hamcrest.core_1.3.0.v201303031735.jar;C:\Users\rocco\OneDrive\WorkspaceTermina\libraries\jdom-2.0.6\jdom-2.0.6.jar;C:\Users\rocco\OneDrive\WorkspaceTermina\libraries\jna-4.0.0.jar\jna-4.0.0.jar;C:\Users\rocco\OneDrive\WorkspaceTermina\libraries\slf4j-1.7.25\slf4j-1.7.25\slf4j-jdk14-1.7.25.jar;C:\Users\rocco\OneDrive\WorkspaceTermina\libraries\slf4j-1.7.25\slf4j-1.7.25\jcl-over-slf4j-1.7.25.jar;C:\Users\rocco\OneDrive\WorkspaceTermina\libraries\slf4j-1.7.25\slf4j-1.7.25\log4j-over-slf4j-1.7.25.jar;C:\Users\rocco\OneDrive\WorkspaceTermina\libraries\slf4j-1.7.25\slf4j-1.7.25\slf4j-api-1.7.25.jar;C:\Users\rocco\OneDrive\WorkspaceTermina\libraries\slf4j-1.7.25\slf4j-1.7.25\slf4j-ext-1.7.25.jar" VideoRenamer

			Base                Size      Path
			0x00000000bd860000  0x5c0000  C:\WINDOWS\SYSTEM32\MediaInfo.dll
			        Verified:       MediaArea.net
			        Publisher:      MediaArea.net
			        Description:    Most relevant technical and tag data for video and audio files
			        Product:        MediaInfo
			        Version:        18.3.0.0
			        File version:   18.3.0.0
			        Create time:    Tue Mar 20 01:01:46 2018

			
			*/
			
			
			
			
			
			libraryName = "MediaInfo";
			
			LOGGER.warn("Windows 64 bit");
			LOGGER.warn(MediaInfo.getInfoAboutMediaInfoVersion());
		} else {
			libraryName = "MediaInfo_v7_63";
			LOGGER.warn("Windows 32 bit");
		}

		// libmediainfo for Linux depends on libzen
		if (!Platform.isWindows() && !Platform.isMac()) {
			try {
				// We need to load dependencies first, because we know where our native libs are (e.g. Java Web Start Cache).
				// If we do not, the system will look for dependencies, but only in the library path.
				NativeLibrary.getInstance("zen");
			} catch (LinkageError e) {

             LOGGER.warn("Error loading libzen: " + e.getMessage());
			}
		}
	}
	
	
	/*
	 * Contains all meta information which a provided by Mediainfo.DLL for gereral
	 * Unique ID : 196137776039699535144058465802620754152 (0x938EC2F8E01B374CB5EE68B2D057D8E8) 
* Complete name : C:\Daten\workspace\test\Sherlock.mkv 
Format : Matroska 
Format version : Version 2 
File size : 9.14 GiB 
Duration : 2h 8mn 
Overall bit rate : 10.2 Mbps 
Encoded date : UTC 2010-03-11 08:15:15 
Writing application : mkvmerge v3.2.0 ('Beginnings') gebaut am Feb 12 2010 16:46:17 
Writing library : 



        To_Display += MI.Get(MediaInfo.StreamKind.General, 0, 2, MediaInfo.InfoKind.Text);


        To_Display += MI.Count_Get(MediaInfo.StreamKind.Audio, -1);

     
        To_Display += MI.Get(MediaInfo.StreamKind.Audio, 0, "StreamCount", MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);


	 */
		
	private String  video_general[][] = { 
	
	{"noInfo","Count","noInfo"},
	{"noInfo","Status","noInfo"},
	{"noInfo","StreamCount","noInfo"},
	{"noInfo","StreamKind","noInfo"},
	{"noInfo","StreamKind/String","noInfo"},
	{"noInfo","StreamKindID","noInfo"},
	{"noInfo","StreamKindPos","noInfo"},
	{"noInfo","StreamOrder","noInfo"},
	{"noInfo","FirstPacketOrder","noInfo"},
	//{"noInfo","Inform","noInfo"},
	{"noInfo","ID","noInfo"},
	{"noInfo","ID/String","noInfo"},
	{"noInfo","UniqueID","noInfo"},
	{"noInfo","UniqueID/String","noInfo"},
	{"noInfo","MenuID","noInfo"},
	{"noInfo","MenuID/String","noInfo"},
	{"noInfo","GeneralCount","noInfo"},
	{"noInfo","VideoCount","noInfo"},
	{"noInfo","AudioCount","noInfo"},
	{"noInfo","TextCount","noInfo"},
	{"noInfo","OtherCount","noInfo"},
	{"noInfo","ImageCount","noInfo"},
	{"noInfo","MenuCount","noInfo"},
	{"noInfo","Video_Format_List","noInfo"},
	{"noInfo","Video_Format_WithHint_Lis","noInfo"},
	{"noInfo","Video_Codec_List","noInfo"},
	{"noInfo","Video_Language_List","noInfo"},
	{"noInfo","Audio_Format_List","noInfo"},
	{"noInfo","Audio_Format_WithHint_Lis","noInfo"},
	{"noInfo","Audio_Codec_List","noInfo"},
	{"noInfo","Audio_Language_List","noInfo"},
	{"noInfo","Text_Format_List","noInfo"},
	{"noInfo","Text_Format_WithHint_List","noInfo"},
	{"noInfo","Text_Codec_List","noInfo"},
	{"noInfo","Text_Language_List","noInfo"},
	{"noInfo","Other_Format_List","noInfo"},
	{"noInfo","Other_Format_WithHint_Lis","noInfo"},
	{"noInfo","Other_Codec_List","noInfo"},
	{"noInfo","Other_Language_List","noInfo"},
	{"noInfo","Image_Format_List","noInfo"},
	{"noInfo","Image_Format_WithHint_Lis","noInfo"},
	{"noInfo","Image_Codec_List","noInfo"},
	{"noInfo","Image_Language_List","noInfo"},
	{"noInfo","Menu_Format_List","noInfo"},
	{"noInfo","Menu_Format_WithHint_List","noInfo"},
	{"noInfo","Menu_Codec_List","noInfo"},
	{"noInfo","Menu_Language_List","noInfo"},
	{"noInfo","CompleteName","noInfo"},
	{"noInfo","FolderName","noInfo"},
	{"noInfo","FileName","noInfo"},
	{"noInfo","FileExtension","noInfo"},
	{"noInfo","CompleteName_Last","noInfo"},
	{"noInfo","FolderName_Last","noInfo"},
	{"noInfo","FileName_Last","noInfo"},
	{"noInfo","FileExtension_Last","noInfo"},
	{"noInfo","Format","noInfo"},
	{"noInfo","Format/String","noInfo"},
	{"noInfo","Format/Info","noInfo"},
	{"noInfo","Format/Url","noInfo"},
	{"noInfo","Format/Extensions","noInfo"},
	{"noInfo","Format_Commercial","noInfo"},
	{"noInfo","Format_Commercial_IfAny","noInfo"},
	{"noInfo","Format_Version","noInfo"},
	{"noInfo","Format_Profile","noInfo"},
	{"noInfo","Format_Compression","noInfo"},
	{"noInfo","Format_Settings","noInfo"},
	{"noInfo","InternetMediaType","noInfo"},
	{"noInfo","CodecID","noInfo"},
	{"noInfo","CodecID/String","noInfo"},
	{"noInfo","CodecID/Info","noInfo"},
	{"noInfo","CodecID/Hint","noInfo"},
	{"noInfo","CodecID/Url","noInfo"},
	{"noInfo","CodecID_Description","noInfo"},
	{"noInfo","Interleaved","noInfo"},
	{"noInfo","Codec","noInfo"},
	{"noInfo","Codec/String","noInfo"},
	{"noInfo","Codec/Info","noInfo"},
	{"noInfo","Codec/Url","noInfo"},
	{"noInfo","Codec/Extensions","noInfo"},
	{"noInfo","Codec_Settings","noInfo"},
	{"noInfo","Codec_Settings_Automatic","noInfo"},
	{"noInfo","FileSize","noInfo"},
	{"noInfo","FileSize/String","noInfo"},
	{"noInfo","FileSize/String1","noInfo"},
	{"noInfo","FileSize/String2","noInfo"},
	{"noInfo","FileSize/String3","noInfo"},
	{"noInfo","FileSize/String4","noInfo"},
	{"noInfo","Duration","noInfo"},
	{"noInfo","Duration/String","noInfo"},
	{"noInfo","Duration/String1","noInfo"},
	{"noInfo","Duration/String2","noInfo"},
	{"noInfo","Duration/String3","noInfo"},
	{"noInfo","Duration_Start","noInfo"},
	{"noInfo","Duration_End","noInfo"},
	{"noInfo","OverallBitRate_Mode","noInfo"},
	{"noInfo","OverallBitRate_Mode/Strin","noInfo"},
	{"noInfo","OverallBitRate","noInfo"},
	{"noInfo","OverallBitRate/String","noInfo"},
	{"noInfo","OverallBitRate_Minimum","noInfo"},
	{"noInfo","OverallBitRate_Minimum/St","noInfo"},
	{"noInfo","OverallBitRate_Nominal","noInfo"},
	{"noInfo","OverallBitRate_Nominal/St","noInfo"},
	{"noInfo","OverallBitRate_Maximum","noInfo"},
	{"noInfo","OverallBitRate_Maximum/St","noInfo"},
	{"noInfo","Delay","noInfo"},
	{"noInfo","Delay/String","noInfo"},
	{"noInfo","Delay/String1","noInfo"},
	{"noInfo","Delay/String2","noInfo"},
	{"noInfo","Delay/String3","noInfo"},
	{"noInfo","StreamSize","noInfo"},
	{"noInfo","StreamSize/String","noInfo"},
	{"noInfo","StreamSize/String1","noInfo"},
	{"noInfo","StreamSize/String2","noInfo"},
	{"noInfo","StreamSize/String3","noInfo"},
	{"noInfo","StreamSize/String4","noInfo"},
	{"noInfo","StreamSize/String5","noInfo"},
	{"noInfo","StreamSize_Proportion","noInfo"},
	{"noInfo","HeaderSize","noInfo"},
	{"noInfo","DataSize","noInfo"},
	{"noInfo","FooterSize","noInfo"},
	{"noInfo","IsStreamable","noInfo"},
	{"noInfo","Album_ReplayGain_Gain","noInfo"},
	{"noInfo","Album_ReplayGain_Gain/String","noInfo"},
	{"noInfo","Album_ReplayGain_Peak","noInfo"},
	{"noInfo","Encryption","noInfo"},
	{"noInfo","Title","noInfo"},
	{"noInfo","Title/More","noInfo"},
	{"noInfo","Title/Url","noInfo"},
	{"noInfo","Domain","noInfo"},
	{"noInfo","Collection","noInfo"},
	{"noInfo","Season","noInfo"},
	{"noInfo","Season_Position","noInfo"},
	{"noInfo","Season_Position_Total","noInfo"},
	{"noInfo","Movie","noInfo"},
	{"noInfo","Movie/More","noInfo"},
	{"noInfo","Movie/Country","noInfo"},
	{"noInfo","Movie/Url","noInfo"},
	{"noInfo","Album","noInfo"},
	{"noInfo","Album/More","noInfo"},
	{"noInfo","Album/Sort","noInfo"},
	{"noInfo","Album/Performer","noInfo"},
	{"noInfo","Album/Performer/Sort","noInfo"},
	{"noInfo","Album/Performer/Url","noInfo"},
	{"noInfo","Comic","noInfo"},
	{"noInfo","Comic/More","noInfo"},
	{"noInfo","Comic/Position_Total","noInfo"},
	{"noInfo","Part","noInfo"},
	{"noInfo","Part/Position","noInfo"},
	{"noInfo","Part/Position_Total","noInfo"},
	{"noInfo","Track","noInfo"},
	{"noInfo","Track/More","noInfo"},
	{"noInfo","Track/Url","noInfo"},
	{"noInfo","Track/Sort","noInfo"},
	{"noInfo","Track/Position","noInfo"},
	{"noInfo","Track/Position_Total","noInfo"},
	{"noInfo","Grouping","noInfo"},
	{"noInfo","Chapter","noInfo"},
	{"noInfo","SubTrack","noInfo"},
	{"noInfo","Original/Album","noInfo"},
	{"noInfo","Original/Movie","noInfo"},
	{"noInfo","Original/Part","noInfo"},
	{"noInfo","Original/Track","noInfo"},
	{"noInfo","Compilation","noInfo"},
	{"noInfo","Compilation/String","noInfo"},
	{"noInfo","Performer","noInfo"},
	{"noInfo","Performer/Sort","noInfo"},
	{"noInfo","Performer/Url","noInfo"},
	{"noInfo","Original/Performer","noInfo"},
	{"noInfo","Accompaniment","noInfo"},
	{"noInfo","Composer","noInfo"},
	{"noInfo","Composer/Nationality","noInfo"},
	{"noInfo","Arranger","noInfo"},
	{"noInfo","Lyricist","noInfo"},
	{"noInfo","Original/Lyricist","noInfo"},
	{"noInfo","Conductor","noInfo"},
	{"noInfo","Director","noInfo"},
	{"noInfo","AssistantDirector","noInfo"},
	{"noInfo","DirectorOfPhotography","noInfo"},
	{"noInfo","SoundEngineer","noInfo"},
	{"noInfo","ArtDirector","noInfo"},
	{"noInfo","ProductionDesigner","noInfo"},
	{"noInfo","Choregrapher","noInfo"},
	{"noInfo","CostumeDesigner","noInfo"},
	{"noInfo","Actor","noInfo"},
	{"noInfo","Actor_Character","noInfo"},
	{"noInfo","WrittenBy","noInfo"},
	{"noInfo","ScreenplayBy","noInfo"},
	{"noInfo","EditedBy","noInfo"},
	{"noInfo","CommissionedBy","noInfo"},
	{"noInfo","Producer","noInfo"},
	{"noInfo","CoProducer","noInfo"},
	{"noInfo","ExecutiveProducer","noInfo"},
	{"noInfo","MusicBy","noInfo"},
	{"noInfo","DistributedBy","noInfo"},
	{"noInfo","OriginalSourceForm/Distri","noInfo"},
	{"noInfo","MasteredBy","noInfo"},
	{"noInfo","EncodedBy","noInfo"},
	{"noInfo","RemixedBy","noInfo"},
	{"noInfo","ProductionStudio","noInfo"},
	{"noInfo","ThanksTo","noInfo"},
	{"noInfo","Publisher","noInfo"},
	{"noInfo","Publisher/URL","noInfo"},
	{"noInfo","Label","noInfo"},
	{"noInfo","Genre","noInfo"},
	{"noInfo","Mood","noInfo"},
	{"noInfo","ContentType","noInfo"},
	{"noInfo","Subject","noInfo"},
	{"noInfo","Description","noInfo"},
	{"noInfo","Keywords","noInfo"},
	{"noInfo","Summary","noInfo"},
	{"noInfo","Synopsis","noInfo"},
	{"noInfo","Period","noInfo"},
	{"noInfo","LawRating","noInfo"},
	{"noInfo","LawRating_Reason","noInfo"},
	{"noInfo","ICRA","noInfo"},
	{"noInfo","Released_Date","noInfo"},
	{"noInfo","Original/Released_Date","noInfo"},
	{"noInfo","Recorded_Date","noInfo"},
	{"noInfo","Encoded_Date","noInfo"},
	{"noInfo","Tagged_Date","noInfo"},
	{"noInfo","Written_Date","noInfo"},
	{"noInfo","Mastered_Date","noInfo"},
	{"noInfo","File_Created_Date","noInfo"},
	{"noInfo","File_Created_Date_Local","noInfo"},
	{"noInfo","File_Modified_Date","noInfo"},
	{"noInfo","File_Modified_Date_Local","noInfo"},
	{"noInfo","Recorded_Location","noInfo"},
	{"noInfo","Written_Location","noInfo"},
	{"noInfo","Archival_Location","noInfo"},
	{"noInfo","Encoded_Application","noInfo"},
	{"noInfo","Encoded_Application/Url","noInfo"},
	{"noInfo","Encoded_Library","noInfo"},
	{"noInfo","Encoded_Library/String","noInfo"},
	{"noInfo","Encoded_Library/Name","noInfo"},
	{"noInfo","Encoded_Library/Version","noInfo"},
	{"noInfo","Encoded_Library/Date","noInfo"},
	{"noInfo","Encoded_Library_Settings","noInfo"},
	{"noInfo","Cropped","noInfo"},
	{"noInfo","Dimensions","noInfo"},
	{"noInfo","DotsPerInch","noInfo"},
	{"noInfo","Lightness","noInfo"},
	{"noInfo","OriginalSourceMedium","noInfo"},
	{"noInfo","OriginalSourceForm","noInfo"},
	{"noInfo","OriginalSourceForm/NumCol","noInfo"},
	{"noInfo","OriginalSourceForm/Name","noInfo"},
	{"noInfo","OriginalSourceForm/Croppe","noInfo"},
	{"noInfo","OriginalSourceForm/Sharpn","noInfo"},
	{"noInfo","Tagged_Application","noInfo"},
	{"noInfo","BPM","noInfo"},
	{"noInfo","ISRC","noInfo"},
	{"noInfo","ISBN","noInfo"},
	{"noInfo","BarCode","noInfo"},
	{"noInfo","LCCN","noInfo"},
	{"noInfo","CatalogNumber","noInfo"},
	{"noInfo","LabelCode","noInfo"},
	{"noInfo","Owner","noInfo"},
	{"noInfo","Copyright","noInfo"},
	{"noInfo","Copyright/Url","noInfo"},
	{"noInfo","Producer_Copyright","noInfo"},
	{"noInfo","TermsOfUse","noInfo"},
	{"noInfo","ServiceName","noInfo"},
	{"noInfo","ServiceChannel","noInfo"},
	{"noInfo","Service/Url","noInfo"},
	{"noInfo","ServiceProvider","noInfo"},
	{"noInfo","ServiceProviderr/Url","noInfo"},
	{"noInfo","ServiceType","noInfo"},
	{"noInfo","NetworkName","noInfo"},
	{"noInfo","OriginalNetworkName","noInfo"},
	{"noInfo","Country","noInfo"},
	{"noInfo","TimeZone","noInfo"},
	{"noInfo","Cover","noInfo"},
	{"noInfo","Cover_Description","noInfo"},
	{"noInfo","Cover_Type","noInfo"},
	{"noInfo","Cover_Mime","noInfo"},
	//{"noInfo","Cover_Data","noInfo"},
	{"noInfo","Lyrics","noInfo"},
	{"noInfo","Comment","noInfo"},
	{"noInfo","Rating","noInfo"},
	{"noInfo","Added_Date","noInfo"},
	{"noInfo","Played_First_Date","noInfo"},
	{"noInfo","Played_Last_Date","noInfo"},
	{"noInfo","Played_Count","noInfo"},
	{"noInfo","EPG_Positions_Begin","noInfo"},
	{"noInfo","EPG_Positions_End","noInfo"},

	};
	
	
	/*
	 * Contains all meta information which a provided by Mediainfo.DLL for gereral
	 * ID : 1 
Format : AVC 
Format/Info : Advanced Video Codec 
Format profile : High@L4.1 
Format settings, CABAC : Yes 
Format settings, ReFrames : 4 frames 
Codec ID : V_MPEG4/ISO/AVC 
Duration : 2h 8mn 
Bit rate : 8 238 Kbps 
Width : 1 920 pixels 
Height : 1 080 pixels 
Display aspect ratio : 16:9 
Frame rate mode : Constant 
Frame rate : 23.976 fps 
Color space : YUV 
Chroma subsampling : 4:2:0 
Bit depth : 8 bits 
Scan type : Progressive 
Bits/(Pixel*Frame) : 0.166 
Stream size : 7.21 GiB (79%) 
Title : Dubbed von HD-Area.org 
Writing library : x264 core 88 r1471 1144615 
Encoding settings : cabac=1 / ref=4 / deblock=1:0:0 / analyse=0x3:0x133 / me=umh / subme=8 / psy=1 / psy_rd=1.00:0.00 / mixed_ref=1 / me_range=16 / chroma_me=1 / trellis=1 / 8x8dct=1 / cqm=0 / deadzone=21,11 / fast_pskip=1 / chroma_qp_offset=-2 / threads=24 / sliced_threads=0 / nr=0 / decimate=1 / mbaff=0 / constrained_intra=0 / bframes=3 / b_pyramid=2 / b_adapt=1 / b_bias=0 / direct=3 / wpredb=1 / wpredp=2 / keyint=250 / keyint_min=25 / scenecut=40 / intra_refresh=0 / rc=2pass / mbtree=0 / bitrate=8238 / ratetol=1.0 / qcomp=0.60 / qpmin=10 / qpmax=51 / qpstep=4 / cplxblur=20.0 / qblur=0.5 / ip_ratio=1.40 / pb_ratio=1.30 / aq=1:1.00 
Language : English 
Default : No 
Forced : No 

	 * 
	 * 
	 * 
	 */
	
	
	String  video_video[][] = { 
			{"noInfo","Video","noInfo"},
			{"noInfo","Count","noInfo"},
			{"noInfo","Status","noInfo"},
			{"noInfo","StreamCount","noInfo"},
			{"noInfo","StreamKind","noInfo"},
			{"noInfo","StreamKind/String","noInfo"},
			{"noInfo","StreamKindID","noInfo"},
			{"noInfo","StreamKindPos","noInfo"},
			{"noInfo","StreamOrder","noInfo"},
			{"noInfo","FirstPacketOrder","noInfo"},
			//{"noInfo","Inform","noInfo"},
			{"noInfo","ID","noInfo"},
			{"noInfo","ID/String","noInfo"},
			{"noInfo","UniqueID","noInfo"},
			{"noInfo","UniqueID/String","noInfo"},
			{"noInfo","MenuID","noInfo"},
			{"noInfo","MenuID/String","noInfo"},
			{"noInfo","Format","noInfo"},
			{"noInfo","Format/Info","noInfo"},
			{"noInfo","Format/Url","noInfo"},
			{"noInfo","Format_Commercial","noInfo"},
			{"noInfo","Format_Commercial_IfAny","noInfo"},
			{"noInfo","Format_Version","noInfo"},
			{"noInfo","Format_Profile","noInfo"},
			{"noInfo","Format_Compression","noInfo"},
			{"noInfo","MultiView_BaseProfile","noInfo"},
			{"noInfo","MultiView_Count","noInfo"},
			{"noInfo","MultiView_Layout","noInfo"},
			{"noInfo","Format_Settings","noInfo"},
			{"noInfo","Format_Settings_BVOP","noInfo"},
			{"noInfo","Format_Settings_BVOP/Stri","noInfo"},
			{"noInfo","Format_Settings_QPel","noInfo"},
			{"noInfo","Format_Settings_QPel/Stri","noInfo"},
			{"noInfo","Format_Settings_GMC","noInfo"},
			{"noInfo","Format_Settings_GMC/String","noInfo"},
			{"noInfo","Format_Settings_Matrix","noInfo"},
			{"noInfo","Format_Settings_Matrix/St","noInfo"},
			{"noInfo","Format_Settings_Matrix_Da","noInfo"},
			{"noInfo","Format_Settings_CABAC","noInfo"},
			{"noInfo","Format_Settings_CABAC/Str","noInfo"},
			{"noInfo","Format_Settings_RefFrames","noInfo"},
			{"noInfo","Format_Settings_RefFrames","noInfo"},
			{"noInfo","Format_Settings_Pulldown","noInfo"},
			{"noInfo","Format_Settings_FrameMode","noInfo"},
			{"noInfo","Format_Settings_GOP","noInfo"},
			{"noInfo","Format_Settings_FrameStru","noInfo"},
			{"noInfo","Format_Settings_Wrapping","noInfo"},
			{"noInfo","InternetMediaType","noInfo"},
			{"noInfo","MuxingMode","noInfo"},
			{"noInfo","CodecID","noInfo"},
			{"noInfo","CodecID/String","noInfo"},
			{"noInfo","CodecID/Info","noInfo"},
			{"noInfo","CodecID/Hint","noInfo"},
			{"noInfo","CodecID/Url","noInfo"},
			{"noInfo","CodecID_Description","noInfo"},
			{"noInfo","Codec","noInfo"},
			{"noInfo","Codec/String","noInfo"},
			{"noInfo","Codec/Family","noInfo"},
			{"noInfo","Codec/Info","noInfo"},
			{"noInfo","Codec/Url","noInfo"},
			{"noInfo","Codec/CC","noInfo"},
			{"noInfo","Codec_Profile","noInfo"},
			{"noInfo","Codec_Description","noInfo"},
			{"noInfo","Codec_Settings","noInfo"},
			{"noInfo","Codec_Settings_PacketBitS","noInfo"},
			{"noInfo","Codec_Settings_BVOP","noInfo"},
			{"noInfo","Codec_Settings_QPel","noInfo"},
			{"noInfo","Codec_Settings_GMC","noInfo"},
			{"noInfo","Codec_Settings_GMC/String","noInfo"},
			{"noInfo","Codec_Settings_Matrix","noInfo"},
			{"noInfo","Codec_Settings_Matrix_Dat","noInfo"},
			{"noInfo","Codec_Settings_CABAC","noInfo"},
			{"noInfo","Codec_Settings_RefFrames","noInfo"},
			{"noInfo","Duration","noInfo"},
			{"noInfo","Duration/String","noInfo"},
			{"noInfo","Duration/String1","noInfo"},
			{"noInfo","Duration/String2","noInfo"},
			{"noInfo","Duration/String3","noInfo"},
			{"noInfo","Duration/String4","noInfo"},
			{"noInfo","Duration_FirstFrame","noInfo"},
			{"noInfo","Duration_FirstFrame/Strin","noInfo"},
			{"noInfo","Duration_FirstFrame/Strin","noInfo"},
			{"noInfo","Duration_FirstFrame/Strin","noInfo"},
			{"noInfo","Duration_FirstFrame/Strin","noInfo"},
			{"noInfo","Duration_LastFrame","noInfo"},
			{"noInfo","Duration_LastFrame/String","noInfo"},
			{"noInfo","Duration_LastFrame/String","noInfo"},
			{"noInfo","Duration_LastFrame/String","noInfo"},
			{"noInfo","Duration_LastFrame/String","noInfo"},
			{"noInfo","Source_Duration","noInfo"},
			{"noInfo","Source_Duration/String","noInfo"},
			{"noInfo","Source_Duration/String1","noInfo"},
			{"noInfo","Source_Duration/String2","noInfo"},
			{"noInfo","Source_Duration/String3","noInfo"},
			{"noInfo","Source_Duration_FirstFram","noInfo"},
			{"noInfo","Source_Duration_FirstFram","noInfo"},
			{"noInfo","Source_Duration_FirstFram","noInfo"},
			{"noInfo","Source_Duration_FirstFram","noInfo"},
			{"noInfo","Source_Duration_FirstFram","noInfo"},
			{"noInfo","Source_Duration_LastFrame","noInfo"},
			{"noInfo","Source_Duration_LastFrame","noInfo"},
			{"noInfo","Source_Duration_LastFrame","noInfo"},
			{"noInfo","Source_Duration_LastFrame","noInfo"},
			{"noInfo","Source_Duration_LastFrame","noInfo"},
			{"noInfo","BitRate_Mode","noInfo"},
			{"noInfo","BitRate_Mode/String","noInfo"},
			{"noInfo","BitRate","noInfo"},
			{"noInfo","BitRate/String","noInfo"},
			{"noInfo","BitRate_Minimum","noInfo"},
			{"noInfo","BitRate_Minimum/String","noInfo"},
			{"noInfo","BitRate_Nominal","noInfo"},
			{"noInfo","BitRate_Nominal/String","noInfo"},
			{"noInfo","BitRate_Maximum","noInfo"},
			{"noInfo","BitRate_Maximum/String","noInfo"},
			{"noInfo","BitRate_Encoded","noInfo"},
			{"noInfo","BitRate_Encoded/String","noInfo"},
			{"noInfo","Width","noInfo"},
			{"noInfo","Width/String","noInfo"},
			{"noInfo","Width_Offset","noInfo"},
			{"noInfo","Width_Offset/String","noInfo"},
			{"noInfo","Width_Original","noInfo"},
			{"noInfo","Width_Original/String","noInfo"},
			{"noInfo","Height","noInfo"},
			{"noInfo","Height/String","noInfo"},
			{"noInfo","Height_Offset","noInfo"},
			{"noInfo","Height_Offset/String","noInfo"},
			{"noInfo","Height_Original","noInfo"},
			{"noInfo","Height_Original/String","noInfo"},
			{"noInfo","PixelAspectRatio","noInfo"},
			{"noInfo","PixelAspectRatio/String","noInfo"},
			{"noInfo","PixelAspectRatio_Original","noInfo"},
			{"noInfo","PixelAspectRatio_Original","noInfo"},
			{"noInfo","DisplayAspectRatio","noInfo"},
			{"noInfo","DisplayAspectRatio/String","noInfo"},
			{"noInfo","DisplayAspectRatio_Origin","noInfo"},
			{"noInfo","DisplayAspectRatio_Origin","noInfo"},
			{"noInfo","ActiveFormatDescription","noInfo"},
			{"noInfo","ActiveFormatDescription/S","noInfo"},
			{"noInfo","ActiveFormatDescription_M","noInfo"},
			{"noInfo","Rotation","noInfo"},
			{"noInfo","Rotation/String","noInfo"},
			{"noInfo","FrameRate_Mode","noInfo"},
			{"noInfo","FrameRate_Mode/String","noInfo"},
			{"noInfo","FrameRate_Mode_Original","noInfo"},
			{"noInfo","FrameRate_Mode_Original/S","noInfo"},
			{"noInfo","FrameRate","noInfo"},
			{"noInfo","FrameRate/String","noInfo"},
			{"noInfo","FrameRate_Original","noInfo"},
			{"noInfo","FrameRate_Original/String","noInfo"},
			{"noInfo","FrameRate_Minimum","noInfo"},
			{"noInfo","FrameRate_Minimum/String","noInfo"},
			{"noInfo","FrameRate_Nominal","noInfo"},
			{"noInfo","FrameRate_Nominal/String","noInfo"},
			{"noInfo","FrameRate_Maximum","noInfo"},
			{"noInfo","FrameRate_Maximum/String","noInfo"},
			{"noInfo","FrameCount","noInfo"},
			{"noInfo","Source_FrameCount","noInfo"},
			{"noInfo","Standard","noInfo"},
			{"noInfo","Resolution","noInfo"},
			{"noInfo","Resolution/String","noInfo"},
			{"noInfo","Colorimetry","noInfo"},
			{"noInfo","ColorSpace","noInfo"},
			{"noInfo","ChromaSubsampling","noInfo"},
			{"noInfo","BitDepth","noInfo"},
			{"noInfo","BitDepth/String","noInfo"},
			{"noInfo","ScanType","noInfo"},
			{"noInfo","ScanType/String","noInfo"},
			{"noInfo","ScanType_Original","noInfo"},
			{"noInfo","ScanType_Original/String","noInfo"},
			{"noInfo","ScanOrder","noInfo"},
			{"noInfo","ScanOrder/String","noInfo"},
			{"noInfo","ScanOrder_Original","noInfo"},
			{"noInfo","ScanOrder_Original/String","noInfo"},
			{"noInfo","Interlacement","noInfo"},
			{"noInfo","Interlacement/String","noInfo"},
			{"noInfo","Compression_Mode","noInfo"},
			{"noInfo","Compression_Mode/String","noInfo"},
			{"noInfo","Compression_Ratio","noInfo"},
			{"noInfo","Bits-(Pixel*Frame)","noInfo"},
			{"noInfo","Delay","noInfo"},
			{"noInfo","Delay/String","noInfo"},
			{"noInfo","Delay/String1","noInfo"},
			{"noInfo","Delay/String2","noInfo"},
			{"noInfo","Delay/String3","noInfo"},
			{"noInfo","Delay/String4","noInfo"},
			{"noInfo","Delay_Settings","noInfo"},
			{"noInfo","Delay_DropFrame","noInfo"},
			{"noInfo","Delay_Source","noInfo"},
			{"noInfo","Delay_Source/String","noInfo"},
			{"noInfo","Delay_Original","noInfo"},
			{"noInfo","Delay_Original/String","noInfo"},
			{"noInfo","Delay_Original/String1","noInfo"},
			{"noInfo","Delay_Original/String2","noInfo"},
			{"noInfo","Delay_Original/String3","noInfo"},
			{"noInfo","Delay_Original/String4","noInfo"},
			{"noInfo","Delay_Original_Settings","noInfo"},
			{"noInfo","Delay_Original_DropFrame","noInfo"},
			{"noInfo","Delay_Original_Source","noInfo"},
			{"noInfo","TimeStamp_FirstFrame","noInfo"},
			{"noInfo","TimeStamp_FirstFrame/Stri","noInfo"},
			{"noInfo","TimeStamp_FirstFrame/Stri","noInfo"},
			{"noInfo","TimeStamp_FirstFrame/Stri","noInfo"},
			{"noInfo","TimeStamp_FirstFrame/Stri","noInfo"},
			{"noInfo","TimeCode_FirstFrame","noInfo"},
			{"noInfo","TimeCode_Settings","noInfo"},
			{"noInfo","TimeCode_Source","noInfo"},
			{"noInfo","StreamSize","noInfo"},
			{"noInfo","StreamSize/String","noInfo"},
			{"noInfo","StreamSize/String1","noInfo"},
			{"noInfo","StreamSize/String2","noInfo"},
			{"noInfo","StreamSize/String3","noInfo"},
			{"noInfo","StreamSize/String4","noInfo"},
			{"noInfo","StreamSize/String5","noInfo"},
			{"noInfo","StreamSize_Proportion","noInfo"},
			{"noInfo","Source_StreamSize","noInfo"},
			{"noInfo","Source_StreamSize/String","noInfo"},
			{"noInfo","Source_StreamSize/String1","noInfo"},
			{"noInfo","Source_StreamSize/String2","noInfo"},
			{"noInfo","Source_StreamSize/String3","noInfo"},
			{"noInfo","Source_StreamSize/String4","noInfo"},
			{"noInfo","Source_StreamSize/String5","noInfo"},
			{"noInfo","Source_StreamSize_Proport","noInfo"},
			{"noInfo","StreamSize_Encoded","noInfo"},
			{"noInfo","StreamSize_Encoded/String","noInfo"},
			{"noInfo","StreamSize_Encoded/String1","noInfo"},
			{"noInfo","StreamSize_Encoded/String2","noInfo"},
			{"noInfo","StreamSize_Encoded/String3","noInfo"},
			{"noInfo","StreamSize_Encoded/String4","noInfo"},
			{"noInfo","StreamSize_Encoded/String","noInfo"},
			{"noInfo","StreamSize_Encoded_Propor","noInfo"},
			{"noInfo","Source_StreamSize_Encoded","noInfo"},
			{"noInfo","Source_StreamSize_Encoded","noInfo"},
			{"noInfo","Source_StreamSize_Encoded/String1","noInfo"},
			{"noInfo","Source_StreamSize_Encoded/String2","noInfo"},
			{"noInfo","Source_StreamSize_Encoded/String3","noInfo"},
			{"noInfo","Source_StreamSize_Encoded/String4","noInfo"},
			{"noInfo","Source_StreamSize_Encoded","noInfo"},
			{"noInfo","Source_StreamSize_Encoded","noInfo"},
			{"noInfo","Alignment","noInfo"},
			{"noInfo","Alignment/String","noInfo"},
			{"noInfo","Title","noInfo"},
			{"noInfo","Encoded_Application","noInfo"},
			{"noInfo","Encoded_Application/Url","noInfo"},
			{"noInfo","Encoded_Library","noInfo"},
			{"noInfo","Encoded_Library/String","noInfo"},
			{"noInfo","Encoded_Library/Name","noInfo"},
			{"noInfo","Encoded_Library/Version","noInfo"},
			{"noInfo","Encoded_Library/Date","noInfo"},
	      //{"noInfo","Encoded_Library_Settings","noInfo"},
			{"noInfo","Language","noInfo"},
			{"noInfo","Language/String","noInfo"},
			{"noInfo","Language/String1","noInfo"},
			{"noInfo","Language/String2","noInfo"},
			{"noInfo","Language/String3","noInfo"},
			{"noInfo","Language/String4","noInfo"},
			{"noInfo","Language_More","noInfo"},
			{"noInfo","Default","noInfo"},
			{"noInfo","Default/String","noInfo"},
			{"noInfo","Forced","noInfo"},
			{"noInfo","Forced/String","noInfo"},
			{"noInfo","Encoded_Date","noInfo"},
			{"noInfo","Tagged_Date","noInfo"},
			{"noInfo","Encryption","noInfo"},
			{"noInfo","BufferSize","noInfo"},

			
			
			
	};
	/*
	 * Contains all meta information which a provided by Mediainfo.DLL for general
	 * ID : 2 
Format : AC-3 
Format/Info : Audio Coding 3 
Mode extension : CM (complete main) 
Format settings, Endianness : Big 
Codec ID : A_AC3 
Duration : 2h 8mn 
Bit rate mode : Constant 
Bit rate : 448 Kbps 
Channel(s) : 6 channels 
Channel positions : Front: L C R, Side: L R, LFE 
Sampling rate : 48.0 KHz 
Bit depth : 16 bits 
Compression mode : Lossy 
Stream size : 411 MiB (4%) 
Title : Deutsch 
Language : German 
Default : Yes 
Forced : No 

	 * 
	 */
	
	String  video_audio[][] = { 
	
			{"noInfo","Count","noInfo"},
			{"noInfo","Status","noInfo"},
			{"noInfo","StreamCount","noInfo"},
			{"noInfo","StreamKind","noInfo"},
			{"noInfo","StreamKind/String","noInfo"},
			{"noInfo","StreamKindID","noInfo"},
			{"noInfo","StreamKindPos","noInfo"},
			{"noInfo","StreamOrder","noInfo"},
			{"noInfo","FirstPacketOrder","noInfo"},
	//      {"noInfo","Inform","noInfo"},
			{"noInfo","ID","noInfo"},
			{"noInfo","ID/String","noInfo"},
			{"noInfo","UniqueID","noInfo"},
			{"noInfo","UniqueID/String","noInfo"},
			{"noInfo","MenuID","noInfo"},
			{"noInfo","MenuID/String","noInfo"},
			{"noInfo","Format","noInfo"},
			{"noInfo","Format/Info","noInfo"},
			{"noInfo","Format/Url","noInfo"},
			{"noInfo","Format_Commercial","noInfo"},
			{"noInfo","Format_Commercial_IfAny","noInfo"},
			{"noInfo","Format_Version","noInfo"},
			{"noInfo","Format_Profile","noInfo"},
			{"noInfo","Format_Compression","noInfo"},
			{"noInfo","Format_Settings","noInfo"},
			{"noInfo","Format_Settings_SBR","noInfo"},
			{"noInfo","Format_Settings_SBR/String","noInfo"},
			{"noInfo","Format_Settings_PS","noInfo"},
			{"noInfo","Format_Settings_PS/String","noInfo"},
			{"noInfo","Format_Settings_Mode","noInfo"},
			{"noInfo","Format_Settings_ModeExtension","noInfo"},
			{"noInfo","Format_Settings_Emphasis","noInfo"},
			{"noInfo","Format_Settings_Floor","noInfo"},
			{"noInfo","Format_Settings_Firm","noInfo"},
			{"noInfo","Format_Settings_Endianness","noInfo"},
			{"noInfo","Format_Settings_Sign","noInfo"},
			{"noInfo","Format_Settings_Law","noInfo"},
			{"noInfo","Format_Settings_ITU","noInfo"},
			{"noInfo","Format_Settings_Wrapping","noInfo"},
			{"noInfo","InternetMediaType","noInfo"},
			{"noInfo","MuxingMode","noInfo"},
			{"noInfo","MuxingMode_MoreInfo","noInfo"},
			{"noInfo","CodecID","noInfo"},
			{"noInfo","CodecID/String","noInfo"},
			{"noInfo","CodecID/Info","noInfo"},
			{"noInfo","CodecID/Hint","noInfo"},
			{"noInfo","CodecID/Url","noInfo"},
			{"noInfo","CodecID_Description","noInfo"},
			{"noInfo","Codec","noInfo"},
			{"noInfo","Codec/String","noInfo"},
			{"noInfo","Codec/Family","noInfo"},
			{"noInfo","Codec/Info","noInfo"},
			{"noInfo","Codec/Url","noInfo"},
			{"noInfo","Codec/CC","noInfo"},
			{"noInfo","Codec_Description","noInfo"},
			{"noInfo","Codec_Profile","noInfo"},
			{"noInfo","Codec_Settings","noInfo"},
			{"noInfo","Codec_Settings_Automatic","noInfo"},
			{"noInfo","Codec_Settings_Floor","noInfo"},
			{"noInfo","Codec_Settings_Firm","noInfo"},
			{"noInfo","Codec_Settings_Endianness","noInfo"},
			{"noInfo","Codec_Settings_Sign","noInfo"},
			{"noInfo","Codec_Settings_Law","noInfo"},
			{"noInfo","Codec_Settings_ITU","noInfo"},
			{"noInfo","Duration","noInfo"},
			{"noInfo","Duration/String","noInfo"},
			{"noInfo","Duration/String1","noInfo"},
			{"noInfo","Duration/String2","noInfo"},
			{"noInfo","Duration/String3","noInfo"},
			{"noInfo","Duration_FirstFrame","noInfo"},
			{"noInfo","Duration_FirstFrame/Strin","noInfo"},
			{"noInfo","Duration_FirstFrame/Strin","noInfo"},
			{"noInfo","Duration_FirstFrame/Strin","noInfo"},
			{"noInfo","Duration_FirstFrame/Strin","noInfo"},
			{"noInfo","Duration_LastFrame","noInfo"},
			{"noInfo","Duration_LastFrame/String","noInfo"},
			{"noInfo","Duration_LastFrame/String","noInfo"},
			{"noInfo","Duration_LastFrame/String","noInfo"},
			{"noInfo","Duration_LastFrame/String","noInfo"},
			{"noInfo","Source_Duration","noInfo"},
			{"noInfo","Source_Duration/String","noInfo"},
			{"noInfo","Source_Duration/String1","noInfo"},
			{"noInfo","Source_Duration/String2","noInfo"},
			{"noInfo","Source_Duration/String3","noInfo"},
			{"noInfo","Source_Duration_FirstFram","noInfo"},
			{"noInfo","Source_Duration_FirstFram","noInfo"},
			{"noInfo","Source_Duration_FirstFram","noInfo"},
			{"noInfo","Source_Duration_FirstFram","noInfo"},
			{"noInfo","Source_Duration_FirstFram","noInfo"},
			{"noInfo","Source_Duration_LastFrame","noInfo"},
			{"noInfo","Source_Duration_LastFrame","noInfo"},
			{"noInfo","Source_Duration_LastFrame","noInfo"},
			{"noInfo","Source_Duration_LastFrame","noInfo"},
			{"noInfo","Source_Duration_LastFrame","noInfo"},
			{"noInfo","BitRate_Mode","noInfo"},
			{"noInfo","BitRate_Mode/String","noInfo"},
			{"noInfo","BitRate","noInfo"},
			{"noInfo","BitRate/String","noInfo"},
			{"noInfo","BitRate_Minimum","noInfo"},
			{"noInfo","BitRate_Minimum/String","noInfo"},
			{"noInfo","BitRate_Nominal","noInfo"},
			{"noInfo","BitRate_Nominal/String","noInfo"},
			{"noInfo","BitRate_Maximum","noInfo"},
			{"noInfo","BitRate_Maximum/String","noInfo"},
			{"noInfo","BitRate_Encoded","noInfo"},
			{"noInfo","BitRate_Encoded/String","noInfo"},
			{"noInfo","Channel(s)","noInfo"},
			{"noInfo","Channel(s)/String","noInfo"},
			{"noInfo","ChannelPositions","noInfo"},
			{"noInfo","ChannelPositions/String2","noInfo"},
			{"noInfo","ChannelLayout","noInfo"},
			{"noInfo","SamplingRate","noInfo"},
			{"noInfo","SamplingRate/String","noInfo"},
			{"noInfo","SamplingCount","noInfo"},
			{"noInfo","Source_SamplingCount","noInfo"},
			{"noInfo","FrameRate","noInfo"},
			{"noInfo","FrameRate/String","noInfo"},
			{"noInfo","FrameCount","noInfo"},
			{"noInfo","Source_FrameCount","noInfo"},
			{"noInfo","Resolution","noInfo"},
			{"noInfo","Resolution/String","noInfo"},
			{"noInfo","BitDepth","noInfo"},
			{"noInfo","BitDepth/String","noInfo"},
			{"noInfo","Compression_Mode","noInfo"},
			{"noInfo","Compression_Mode/String","noInfo"},
			{"noInfo","Compression_Ratio","noInfo"},
			{"noInfo","Delay","noInfo"},
			{"noInfo","Delay/String","noInfo"},
			{"noInfo","Delay/String1","noInfo"},
			{"noInfo","Delay/String2","noInfo"},
			{"noInfo","Delay/String3","noInfo"},
			{"noInfo","Delay/String4","noInfo"},
			{"noInfo","Delay_Settings","noInfo"},
			{"noInfo","Delay_DropFrame","noInfo"},
			{"noInfo","Delay_Source","noInfo"},
			{"noInfo","Delay_Source/String","noInfo"},
			{"noInfo","Delay_Original","noInfo"},
			{"noInfo","Delay_Original/String","noInfo"},
			{"noInfo","Delay_Original/String1","noInfo"},
			{"noInfo","Delay_Original/String2","noInfo"},
			{"noInfo","Delay_Original/String3","noInfo"},
			{"noInfo","Delay_Original/String4","noInfo"},
			{"noInfo","Delay_Original_Settings","noInfo"},
			{"noInfo","Delay_Original_DropFrame","noInfo"},
			{"noInfo","Delay_Original_Source","noInfo"},
			{"noInfo","Video_Delay","noInfo"},
			{"noInfo","Video_Delay/String","noInfo"},
			{"noInfo","Video_Delay/String1","noInfo"},
			{"noInfo","Video_Delay/String2","noInfo"},
			{"noInfo","Video_Delay/String3","noInfo"},
			{"noInfo","Video_Delay/String4","noInfo"},
			{"noInfo","Video0_Delay","noInfo"},
			{"noInfo","Video0_Delay/String","noInfo"},
			{"noInfo","Video0_Delay/String1","noInfo"},
			{"noInfo","Video0_Delay/String2","noInfo"},
			{"noInfo","Video0_Delay/String3","noInfo"},
			{"noInfo","Video0_Delay/String4","noInfo"},
			{"noInfo","ReplayGain_Gain","noInfo"},
			{"noInfo","ReplayGain_Gain/String","noInfo"},
			{"noInfo","ReplayGain_Peak","noInfo"},
			{"noInfo","StreamSize","noInfo"},
			{"noInfo","StreamSize/String","noInfo"},
			{"noInfo","StreamSize/String1","noInfo"},
			{"noInfo","StreamSize/String2","noInfo"},
			{"noInfo","StreamSize/String3","noInfo"},
			{"noInfo","StreamSize/String4","noInfo"},
			{"noInfo","StreamSize/String5","noInfo"},
			{"noInfo","StreamSize_Proportion","noInfo"},
			{"noInfo","Source_StreamSize","noInfo"},
			{"noInfo","Source_StreamSize/String","noInfo"},
			{"noInfo","Source_StreamSize/String1","noInfo"},
			{"noInfo","Source_StreamSize/String2","noInfo"},
			{"noInfo","Source_StreamSize/String3","noInfo"},
			{"noInfo","Source_StreamSize/String4","noInfo"},
			{"noInfo","Source_StreamSize/String5","noInfo"},
			{"noInfo","Source_StreamSize_Proport","noInfo"},
			{"noInfo","StreamSize_Encoded","noInfo"},
			{"noInfo","StreamSize_Encoded/String","noInfo"},
			{"noInfo","StreamSize_Encoded/String1","noInfo"},
			{"noInfo","StreamSize_Encoded/String2","noInfo"},
			{"noInfo","StreamSize_Encoded/String3","noInfo"},
			{"noInfo","StreamSize_Encoded/String4","noInfo"},
			{"noInfo","StreamSize_Encoded/String","noInfo"},
			{"noInfo","StreamSize_Encoded_Propor","noInfo"},
			{"noInfo","Source_StreamSize_Encoded","noInfo"},
			{"noInfo","Source_StreamSize_Encoded","noInfo"},
			{"noInfo","Source_StreamSize_Encoded/String1","noInfo"},
			{"noInfo","Source_StreamSize_Encoded/String2","noInfo"},
			{"noInfo","Source_StreamSize_Encoded/String3","noInfo"},
			{"noInfo","Source_StreamSize_Encoded/String4","noInfo"},
			{"noInfo","Source_StreamSize_Encoded","noInfo"},
			{"noInfo","Source_StreamSize_Encoded","noInfo"},
			{"noInfo","Alignment","noInfo"},
			{"noInfo","Alignment/String","noInfo"},
			{"noInfo","Interleave_VideoFrames","noInfo"},
			{"noInfo","Interleave_Duration","noInfo"},
			{"noInfo","Interleave_Duration/Strin","noInfo"},
			{"noInfo","Interleave_Preload","noInfo"},
			{"noInfo","Interleave_Preload/String","noInfo"},
			{"noInfo","Title","noInfo"},
			{"noInfo","Encoded_Library","noInfo"},
			{"noInfo","Encoded_Library/String","noInfo"},
			{"noInfo","Encoded_Library/Name","noInfo"},
			{"noInfo","Encoded_Library/Version","noInfo"},
			{"noInfo","Encoded_Library/Date","noInfo"},
			{"noInfo","Encoded_Library_Settings","noInfo"},
			{"noInfo","Language","noInfo"},
			{"noInfo","Language/String","noInfo"},
			{"noInfo","Language/String1","noInfo"},
			{"noInfo","Language/String2","noInfo"},
			{"noInfo","Language/String3","noInfo"},
			{"noInfo","Language/String4","noInfo"},
			{"noInfo","Language_More","noInfo"},
			{"noInfo","Default","noInfo"},
			{"noInfo","Default/String","noInfo"},
			{"noInfo","Forced","noInfo"},
			{"noInfo","Forced/String","noInfo"},
			{"noInfo","Encoded_Date","noInfo"},
			{"noInfo","Tagged_Date","noInfo"},
			{"noInfo","Encryption","noInfo"},
			{"noInfo","","noInfo"},
			
			
	};
	
	
	String  video_audio_spur2[][] = { 
			{"noInfo","ID","noInfo"},
			{"noInfo","Format","noInfo"},
			{"noInfo","Format/Info","noInfo"}, 
			{"noInfo","ModeExtension","noInfo"},
			{"noInfo","FormatSettings","noInfo"},  			
			{"noInfo","CodecID","noInfo"}, 
			{"noInfo","Codec","noInfo"},
			{"noInfo","Duration","noInfo"},    
			{"noInfo","BitRate","noInfo"},
			{"noInfo","Channel(s)","noInfo"},
			{"noInfo","SamplingRate","noInfo"},
			{"noInfo","BitDepth","noInfo"},    
			{"noInfo","CompressionMode","noInfo"},   
			{"noInfo","Title","noInfo"},   
			{"noInfo","Language","noInfo"},   
			{"noInfo","StreamSize","noInfo"},  
			{"noInfo","Count","noInfo"},  
			
	};
	
	String  video_audio_1[][][] = {{ 
			{"noInfo","ID","noInfo"},
			{"noInfo","Format","noInfo"},
			{"noInfo","Format/Info","noInfo"}, 
			{"noInfo","ModeExtension","noInfo"},
			{"noInfo","FormatSettings","noInfo"},  			
			{"noInfo","CodecID","noInfo"}, 
			{"noInfo","Codec","noInfo"},
			{"noInfo","Duration","noInfo"},    
			{"noInfo","BitRate","noInfo"},
			{"noInfo","Channel(s)","noInfo"},
			{"noInfo","SamplingRate","noInfo"},
			{"noInfo","BitDepth","noInfo"},    
			{"noInfo","CompressionMode","noInfo"},   
			{"noInfo","Title","noInfo"},   
			{"noInfo","Language","noInfo"},   
			{"noInfo","StreamSize","noInfo"},   
			{"noInfo","Count","noInfo"},  
			
	}};
	
	
	
	/**
	 * @param video_general the video_general to set
	 */
	private void setVideo_general() {
		
		
		for (int j = 0; j < video_general.length; j++) { 
		
			 video_general[j][0] = (Get(StreamKind.General, 0, video_general[j][1], InfoKind.Text, InfoKind.Name));
			 video_general[j][2] = (Get(StreamKind.General, 0, video_general[j][1], InfoKind.Name_Text, InfoKind.Name));
			
			 
			}
		
		
		
				
	}
	
	
	/** 
	 * Analyze the Video file and stores the "video" meta informations 
	 * @param video_video the video_video to set
	 */
	private void setVideo_video() {
		
		
		for (int j = 0; j < video_video.length; j++) { 
			
		
		
			 video_video[j][0] = (Get(StreamKind.Video, 0, video_video[j][1], InfoKind.Text, InfoKind.Name));
			 video_video[j][2] = (Get(StreamKind.Video, 0, video_video[j][1], InfoKind.Name_Text, InfoKind.Name));
			}
		
		
		
				
	}
	
	/** 
	 * Analyce the Video file and stores the "audio" meta informations 
	 * @param video_video the video_video to set
	 */
	private void setVideo_audio() {
		
		
		for (int j = 0; j < video_audio.length; j++) { 
		
			 video_audio[j][0] = (Get(StreamKind.Audio, 0, video_audio[j][1], InfoKind.Text, InfoKind.Name));
			 video_audio[j][2] = (Get(StreamKind.Audio, 0, video_audio[j][1], InfoKind.Name_Text, InfoKind.Name));
			}
		
		
		
				
	}
	
	/** 
	 * Analyce the Video file and stores the "audio" meta informations 
	 * @param video_video the video_video to set
	 */
	private void video_audio_spur2() {
		
		
		for (int j = 0; j < video_audio_spur2.length; j++) { 
		
			 video_audio_spur2[j][0] = (Get(StreamKind.Audio, 1, video_audio_spur2[j][1], InfoKind.Text, InfoKind.Name));
			 video_audio_spur2[j][2] = (Get(StreamKind.Audio, 1, video_audio_spur2[j][1], InfoKind.Name_Text, InfoKind.Name));
			}
		
				
	}

	/**
	 * @param -
	 */

	public void setVideo_allMetaInfos() {
	this.setVideo_general();
	this.setVideo_video();
	this.setVideo_audio();
	this.video_audio_spur2();
	}
	

	
	// Internal stuff
	interface MediaInfoDLL_Internal extends Library {
		MediaInfoDLL_Internal INSTANCE = (MediaInfoDLL_Internal) Native.loadLibrary(
			libraryName,
			MediaInfoDLL_Internal.class,
			singletonMap(OPTION_FUNCTION_MAPPER, new FunctionMapper() {

			@Override
			public String getFunctionName(NativeLibrary lib, Method method) {
				// e.g. MediaInfo_New(), MediaInfo_Open() ...
				return "MediaInfo_" + method.getName();
			}
		}));

		// Constructor/Destructor
		Pointer New();

		void Delete(Pointer Handle);

		// File
		int Open(Pointer Handle, WString file);

		void Close(Pointer Handle);

		// Info
		WString Inform(Pointer Handle);

		WString Get(Pointer Handle, int StreamKind, int StreamNumber, WString parameter, int infoKind, int searchKind);

		WString GetI(Pointer Handle, int StreamKind, int StreamNumber, int parameterIndex, int infoKind);

		int Count_Get(Pointer Handle, int StreamKind, int StreamNumber);

		// Options
		WString Option(Pointer Handle, WString option, WString value);
	}
	private Pointer Handle;

	public enum StreamKind {
		General,
		Video,
		Audio,
		Text,
		Chapters,
		Image,
		Menu;
	}

	// Enums
	public enum InfoKind {
		/**
		 * Unique name of parameter.
		 */
		Name,
		/**
		 * Value of parameter.
		 */
		Text,
		/**
		 * Unique name of measure unit of parameter.
		 */
		Measure,
		Options,
		/**
		 * Translated name of parameter.
		 */
		Name_Text,
		/**
		 * Translated name of measure unit.
		 */
		Measure_Text,
		/**
		 * More information about the parameter.
		 */
		Info,
		/**
		 * How this parameter is supported, could be N (No), B (Beta), R (Read only), W
		 * (Read/Write).
		 */
		HowTo,
		/**
		 * Domain of this piece of information.
		 */
		Domain;
	}

	// Constructor/Destructor
	public MediaInfo() {
		try {
			LOGGER.warn("Loading MediaInfo library");
			Handle = MediaInfoDLL_Internal.INSTANCE.New();
			LOGGER.warn("Loaded " + Option_Static("Info_Version"));
			
			
			
			
		} catch (Throwable e) {
			if (e != null) {
				LOGGER.info("Error loading MediaInfo library: " + e.getMessage());
			}
			if (!Platform.isWindows() && !Platform.isMac()) {
				LOGGER.info("Make sure you have libmediainfo and libzen installed");
			}
			LOGGER.info("The server will now use the less accurate ffmpeg parsing method");
		}
	}

	public boolean isValid() {
		return Handle != null;
	}

	public void dispose() {
		if (Handle == null) {
			throw new IllegalStateException();
		}

		MediaInfoDLL_Internal.INSTANCE.Delete(Handle);
		Handle = null;
	}

	@Override
	protected void finalize() throws Throwable {
		if (Handle != null) {
			dispose();
		}
	}

	// File
	/**
	 * Open a file and collect information about it (technical information and tags).
	 *
	 * @param File_Name full name of the file to open
	 * @return 1 if file was opened, 0 if file was not not opened
	 */
	public int Open(String File_Name) {
		return MediaInfoDLL_Internal.INSTANCE.Open(Handle, new WString(File_Name));
	}

	/**
	 * Close a file opened before with Open().
	 *
	 */
	public void Close() {
		MediaInfoDLL_Internal.INSTANCE.Close(Handle);
	}

	// Information
	/**
	 * Get all details about a file.
	 *
	 * @return All details about a file in one string
	 */
	public String Inform() {
		return MediaInfoDLL_Internal.INSTANCE.Inform(Handle).toString();
	}

	/**
	 * Get a piece of information about a file (parameter is a string).
	 *
	 * @param StreamKind Kind of Stream (general, video, audio...)
	 * @param StreamNumber Stream number in Kind of Stream (first, second...)
	 * @param parameter Parameter you are looking for in the Stream (Codec, width, bitrate...),
	 *            in string format ("Codec", "Width"...)
	 * @return a string about information you search, an empty string if there is a problem
	 */
	public String Get(StreamKind StreamKind, int StreamNumber, String parameter) {
		return Get(StreamKind, StreamNumber, parameter, InfoKind.Text, InfoKind.Name);
	}

	/**
	 * Get a piece of information about a file (parameter is a string).
	 *
	 * @param StreamKind Kind of Stream (general, video, audio...)
	 * @param StreamNumber Stream number in Kind of Stream (first, second...)
	 * @param parameter Parameter you are looking for in the Stream (Codec, width, bitrate...),
	 *            in string format ("Codec", "Width"...)
	 * @param infoKind Kind of information you want about the parameter (the text, the measure,
	 *            the help...)
	 */
	public String Get(StreamKind StreamKind, int StreamNumber, String parameter, InfoKind infoKind) {
		return Get(StreamKind, StreamNumber, parameter, infoKind, InfoKind.Name);
	}

	/**
	 * Get a piece of information about a file (parameter is a string).
	 *
	 * @param StreamKind Kind of Stream (general, video, audio...)
	 * @param StreamNumber Stream number in Kind of Stream (first, second...)
	 * @param parameter Parameter you are looking for in the Stream (Codec, width, bitrate...),
	 *            in string format ("Codec", "Width"...)
	 * @param infoKind Kind of information you want about the parameter (the text, the measure,
	 *            the help...)
	 * @param searchKind Where to look for the parameter
	 * @return a string about information you search, an empty string if there is a problem
	 */
	public String Get(StreamKind StreamKind, int StreamNumber, String parameter, InfoKind infoKind, InfoKind searchKind) {
		return MediaInfoDLL_Internal.INSTANCE.Get(
			Handle,
			StreamKind.ordinal(),
			StreamNumber,
			new WString(parameter),
			infoKind.ordinal(),
			searchKind.ordinal()).toString();
	}

	/**
	 * Get a piece of information about a file (parameter is an integer).
	 *
	 * @param StreamKind Kind of Stream (general, video, audio...)
	 * @param StreamNumber Stream number in Kind of Stream (first, second...)
	 * @param parameterIndex Parameter you are looking for in the Stream (Codec, width, bitrate...),
	 *            in integer format (first parameter, second parameter...)
	 * @return a string about information you search, an empty string if there is a problem
	 */
	public String get(StreamKind StreamKind, int StreamNumber, int parameterIndex) {
		return Get(StreamKind, StreamNumber, parameterIndex, InfoKind.Text);
	}

	/**
	 * Get a piece of information about a file (parameter is an integer).
	 *
	 * @param StreamKind Kind of Stream (general, video, audio...)
	 * @param StreamNumber Stream number in Kind of Stream (first, second...)
	 * @param parameterIndex Parameter you are looking for in the Stream (Codec, width, bitrate...),
	 *            in integer format (first parameter, second parameter...)
	 * @param infoKind Kind of information you want about the parameter (the text, the measure,
	 *            the help...)
	 * @return a string about information you search, an empty string if there is a problem
	 */
	public String Get(StreamKind StreamKind, int StreamNumber, int parameterIndex, InfoKind infoKind) {
		return MediaInfoDLL_Internal.INSTANCE.GetI(
			Handle,
			StreamKind.ordinal(),
			StreamNumber,
			parameterIndex,
			infoKind.ordinal()).toString();
	}

	/**
	 * Count of Streams of a Stream kind (StreamNumber not filled), or count of piece of
	 * information in this Stream.
	 *
	 * @param StreamKind Kind of Stream (general, video, audio...)
	 * @return number of Streams of the given Stream kind
	 */
	public int Count_Get(StreamKind StreamKind) {
		return MediaInfoDLL_Internal.INSTANCE.Count_Get(Handle, StreamKind.ordinal(), -1);
	}

	/**
	 * Count of Streams of a Stream kind (StreamNumber not filled), or count of piece of
	 * information in this Stream.
	 *
	 * @param StreamKind Kind of Stream (general, video, audio...)
	 * @param StreamNumber Stream number in this kind of Stream (first, second...)
	 * @return number of Streams of the given Stream kind
	 */
	public int Count_Get(StreamKind StreamKind, int StreamNumber) {
		return MediaInfoDLL_Internal.INSTANCE.Count_Get(Handle, StreamKind.ordinal(), StreamNumber);
	}

	// Options
	/**
	 * Configure or get information about MediaInfo.
	 *
	 * @param Option The name of option
	 * @return Depends on the option: by default "" (nothing) means No, other means Yes
	 */
	public String Option(String Option) {
		return MediaInfoDLL_Internal.INSTANCE.Option(Handle, new WString(Option), new WString("")).toString();
	}

	/**
	 * Configure or get information about MediaInfo.
	 *
	 * @param Option The name of option
	 * @param Value The value of option
	 * @return Depends on the option: by default "" (nothing) means No, other means Yes
	 */
	public String Option(String Option, String Value) {
		return MediaInfoDLL_Internal.INSTANCE.Option(Handle, new WString(Option), new WString(Value)).toString();
	}

	/**
	 * Configure or get information about MediaInfo (Static version).
	 *
	 * @param Option The name of option
	 * @return Depends on the option: by default "" (nothing) means No, other means Yes
	 */
	public static String Option_Static(String Option) {
		return MediaInfoDLL_Internal.INSTANCE.Option(
			MediaInfoDLL_Internal.INSTANCE.New(),
			new WString(Option),
			new WString("")).toString();
	}

	/**
	 * Configure or get information about MediaInfo (Static version).
	 *
	 * @param Option The name of option
	 * @param Value The value of option
	 * @return Depends on the option: by default "" (nothing) means No, other means Yes
	 */
	public static String Option_Static(String Option, String Value) {
		return MediaInfoDLL_Internal.INSTANCE.Option(
			MediaInfoDLL_Internal.INSTANCE.New(),
			new WString(Option),
			new WString(Value)).toString();
	}
	
	
	/**
	 * Prints out all meta information to system.out
	 
	 */
	
	public void printMetaInfosToScreen (){
		
		System.out.println("************** Generall information *************");
		for (int j = 0; j < video_general.length; j++) { 
		 System.out.println(video_general[j][1] + ": " + video_general[j][0]+ " ***** " + video_general[j][2]); 
		}
		
		System.out.println("");
		System.out.println("**************Video information******************");
		for (int j = 0; j < video_video.length; j++) { 
			 System.out.println(video_video[j][1] + ": " + video_video[j][0] + " ***** " + video_video[j][2]); 
			}
		
		
		System.out.println("");
		System.out.println("**************Audio information Spur 1******************");
		for (int j = 0; j < video_audio.length; j++) { 
			 System.out.println(video_audio[j][1] + ": " + video_audio[j][0] + " ***** " + video_audio[j][2]); 
			}

		System.out.println("");
		System.out.println("**************Audio information Spur 2******************");
		for (int j = 0; j < video_audio_spur2.length; j++) { 
			 System.out.println(video_audio_spur2[j][1] + ": " + video_audio_spur2[j][0] + " ***** " + video_audio_spur2[j][2]); 
			}
		
		
		
	}
	
	
	public String getSummaryAsHTML (){
		StringBuilder message = new StringBuilder(300);
			
		message.append("<span style=\"color:red\">" + "************** Summary General *************" + "</span>");
		
	    message.append("<html><TABLE border=1>");
	    
	    message.append(getInfo("General", 0,"Inform" ));
	    message.append("<html></TABLE");
	    
	    message.append("<span style=\"color:red\">" + "************** Summary Video information *************" + "</span>");
	    
	    int i;
	    for (i=0;i<getInfoInt("General", 0, "VideoCount");i++){
          message.append("<html><TABLE border=1>");
	    message.append(getInfo("Video", i,"Inform" ));
	    message.append("<html></TABLE"); 
	    }
	    
	    message.append("<span style=\"color:red\">" + "************** Summary Audio information *************" + "</span>");
    
	      //countSubtitleStreams = mediaInfo.getInfoInt("General", 0, "TextCount");
	      //countImageStreams = mediaInfo.getInfoInt("General", 0, "ImageCount");
	  	    
	    for (i=0;i<getInfoInt("General", 0, "AudioCount");i++){
        message.append("<html><TABLE border=1>");
	    message.append(getInfo("Audio", i,"Inform" ));
	    message.append("<html></TABLE"); 
	    }
	    
	    message.append("<span style=\"color:red\">" + "************** Summary Subtitel information *************" + "</span>");
	    
	      //countSubtitleStreams = mediaInfo.getInfoInt("General", 0, "TextCount");
	      //countImageStreams = mediaInfo.getInfoInt("General", 0, "ImageCount");
	  	    
	    for (i=0;i<getInfoInt("General", 0, "TextCount");i++){
      message.append("<html><TABLE border=1>");
	    message.append(getInfo("Text", i,"Inform" ));
	    message.append("<html></TABLE"); 
	    }
	    
	    
	    message.append("<span style=\"color:red\">" + "************** Summary image information *************" + "</span>");
	    
	      //countSubtitleStreams = mediaInfo.getInfoInt("General", 0, "TextCount");
	      //countImageStreams = mediaInfo.getInfoInt("General", 0, "ImageCount");
	  	    
	    for (i=0;i<getInfoInt("General", 0, "imageCount");i++){
      message.append("<html><TABLE border=1>");
	    message.append(getInfo("Image", i,"Inform" ));
	    message.append("<html></TABLE"); 
	    }
	    
	    
	    return message.toString();
		
		
	}
	
	
	
	
	
	public String getAllMetaInfosAsHTML (){
	StringBuilder message = new StringBuilder(300);
		
	message.append("<span style=\"color:red\">" + "************** Generall information *************" + "</span>");
    message.append("<html><TABLE border=1>");
    
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
    
    
    message.append("<span style=\"color:red\">" + "************** Video information *************" + "</span>");
    message.append("<html><TABLE border=1>");
    
    for (int j = 0; j < video_video.length; j++) { 
    	if (video_video[j][0].trim().length() != 0){
    		message.append("<TR align=center><TD>");
            message.append(video_video[j][1]);
            message.append("</TD><TD>");
            message.append(video_video[j][0]);
            message.append("</TD><TD>");
            message.append(video_video[j][2]);
            message.append("</TD></TR>");
    	}            	
    }
    
    message.append("</TABLE>");
    
    message.append("<span style=\"color:red\">" + "************** Audio   information *************" + "</span>");
    message.append("<TABLE border=1>");
    
    for (int j = 0; j < video_audio.length; j++) { 
    	if (video_audio[j][0].trim().length() != 0){
    		message.append("<TR align=center><TD>");
            message.append(video_audio[j][1]);
            message.append("</TD><TD>");
            message.append(video_audio[j][0]);
            message.append("</TD><TD>");
            message.append(video_audio[j][2]);
            message.append("</TD></TR>");
    	}            	
    }
    message.append("</TABLE>");
     
    return message.toString();
	}
	
	/**
	 * Return meta information as string (depreciated)
	 
	 */
	
	public String getAllMetaInfos (){
		String To_Display;
		To_Display ="************** Generall information *************" +"\r\n";
		for (int j = 0; j < video_general.length; j++) { 
			
			if (video_general[j][0].trim().length() != 0){
			
				
			To_Display += video_general[j][1] + ": " + video_general[j][0]+  "\t(" + video_general[j][2] + ")\r\n"; 
			}
		}
		

		To_Display +="**************Video information******************"+"\r\n";
		for (int j = 0; j < video_video.length; j++) { 
			
			if (video_general[j][0].trim().length() != 0){
				To_Display +=video_video[j][1] + ": " + video_video[j][0]+"\r\n"; 
			}
			
			
			}
		

		To_Display +="**************Audio information Spur 1******************"+"\r\n";
		for (int j = 0; j < video_audio.length; j++) { 
			To_Display +=video_audio[j][1] + ": " + video_audio[j][0]+"\r\n"; 
			}

	
		To_Display +="**************Audio information Spur 2******************"+"\r\n";
		for (int j = 0; j < video_audio_spur2.length; j++) { 
			To_Display +=video_audio_spur2[j][1] + ": " + video_audio_spur2[j][0]+"\r\n"; 
			}
		
	return To_Display;	
		
	}
	
  public static String getInfoAboutMediaInfoVersion(){
	  
	  //Information about MediaInfo
	  

	    String To_Display = "";

	    To_Display += "**************Start Information about MediaInfo.dll******************";
	    To_Display += Option_Static("Info_Version") + "\r\n";
	    
	    To_Display += "**************Info Parameters ******************";
	    To_Display += Option_Static("Info_Parameters") + "\r\n";
	    
	    To_Display += "**************Info Capacities******************";
	    To_Display += Option_Static("Info_Capacities") + "\r\n";
	    
	    To_Display += "**************Info Codecs******************";
	    To_Display += Option_Static("Info_Codecs") + "\r\n";
	    
	    To_Display += "**************End Information about MediaInfo.dll******************";
	  	return To_Display;
	  
  }
  
  
  public String getInfo(String type, int index, String info){       //Audio, Video. General
     
	  String help = "noInfo";
	  
	  if (type == "Video")  {
		  help = Get(StreamKind.Video, index, info, InfoKind.Text, InfoKind.Name);
		    	  
	  }
	  
 if (type == "Audio")  {
	 help = Get(StreamKind.Audio, index, info, InfoKind.Text, InfoKind.Name);  
	  }
 
 if (type == "General")  {
	 help = Get(StreamKind.General, index, info, InfoKind.Text);
 }

  
	  return help; 
  }
  
  public int getInfoInt(String type, int index, String info){       //Audio, Video. General
	     
	  String help = "0";
	  int help_int = 0;
	  
	  if (type == "Video")  {
		  help = Get(StreamKind.Video, index, info, InfoKind.Text, InfoKind.Name);
		    	  
	  }
	  
 if (type == "Audio")  {
	 help = Get(StreamKind.Audio, index, info, InfoKind.Text, InfoKind.Name);  
	  }
 
 if (type == "General")  {
	 help = Get(StreamKind.General, index, info, InfoKind.Text,InfoKind.Name);
 }

  
 
 try {
		
	help_int= Integer.parseInt(help);	
	  
		
		
	} catch (Exception e) {

 
		//System.out.println(e.getMessage());
	}		
	
 
 
	  return help_int; 
  }
  
  
  
}


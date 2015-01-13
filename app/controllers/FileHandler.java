package controllers;

import helper.FileType;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.Play;


/*
 * This class is used to handle files.
 */

public class FileHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(FileHandler.class);	
	
	public static boolean savePicture(String vId, String prename, String surename,String event, String base64Code) 
	{		
		String path = pathBuilder(vId, prename, surename, event);
		
		directoryBuilder(path);
		
		saveAsJPG(pictureDecoder(base64Code), path)	;
		return true;
	}
	
	public static String getPicture(String vId, String prename, String surename,String event, FileType fileType) throws IOException
	{		
		if(FileType.THUMBNAIL == fileType)
		{
		//LOGGER.info(pictureDecode("jpg",pathBuilder(vId, prename, surname, event)+"Photo"+File.separator+"thumbnail.jpg"));
		return pictureEncode("jpg",pathBuilder(vId, prename, surename, event)+"Photo"+File.separator+"thumbnail.jpg");
		}
		else if(FileType.PICTURE == fileType)
		{		
		//LOGGER.info(pictureDecode("jpg",pathBuilder(vId, prename, surname, event)+"Photo"+File.separator+"picture.jpg"));		
	    return pictureEncode("jpg",pathBuilder(vId, prename, surename, event)+"Photo"+File.separator+"picture.jpg");
		}
		else if(FileType.PASSPORT == fileType)
		{
		return "";
		}
		else if(FileType.WAIVER == fileType)
		{
		return "";
		}
		else
		{
		return "";
		}
	}
	
	
	public static void deletDirectoriesAndFiles(String path) 
	{
		File f = new File(path);
		
		try
			{
				FileUtils.deleteDirectory(f);
			}
		catch (IOException e) 
			{
				LOGGER.error("File or Directory could not be deleted! Filename: "+f.getName());
			}
		
		File pf = f.getParentFile();
		
		if(pf.isDirectory()){
			 
			if(!(pf.list().length>0)){
	 
				try 
				{
					FileUtils.deleteDirectory(pf);
					LOGGER.info("Parent "+pf.toString()+" removed");
				} 
				catch (IOException e) 
				{
					LOGGER.error("File or Directory could not be deleted! "+ pf.getName());
				}	 
			}
			else
			{	 
				LOGGER.info("Directory is not empty"+pf.list().length);
		   }		
		}
	}
	
	
	/*
	 * Build the Directory path.
	 */
	 static String pathBuilder(String vId, String prename, String surename,String event) {
		String confPath = Play.application().configuration().getString("directory.path");
		String path = FileSystemView.getFileSystemView().getRoots()[0].toString();
		path += File.separator + confPath +File.separator+ event + File.separator + surename + "_"+ prename + "_" + vId + File.separator;
		
		return path;
	}
	
	/*
	 * Build`s the Directories for Volunteer`s
	 */	
	private static void directoryBuilder(String path) {
		File dir = new File(path);

		if (!dir.exists()) 
			{
				LOGGER.info("Try to create Directories");

			if (new File(path).mkdirs() && new File(path + "Passport").mkdir()
					&& new File(path + "Photo").mkdir()
					&& new File(path + "Waiver").mkdir()) {
				LOGGER.info("Directories created");
			}
		} 
		else 
			{
				LOGGER.info("Directory already exist`s" + dir.exists());
			}
	}
	
	/*
	 *Encodes a file into the given type.
	 */	
	
	public static String pictureEncode(String type, String path) {
	        
			BufferedImage image = null;
			 try
			 {
				 image = ImageIO.read(new File(path));
			 }
			 catch (IOException e1)
			 {
				
			 }
			 
			String imageString = null;
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	
	        try {
	            ImageIO.write(image, type, bos);
	            byte[] imageBytes = bos.toByteArray();
	
                    java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
                    imageString = encoder.encodeToString(imageBytes);
                    
	            bos.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return imageString;
	    }

	/*
	 * PictureDecoder decodes an given String to a BufferedImage.
	 */

	private static BufferedImage pictureDecoder(String string)
	{
		byte[] pictureByte = DatatypeConverter.parseBase64Binary(string);
		BufferedImage img;
		try
		{
			img = ImageIO.read(new ByteArrayInputStream(pictureByte));
			return img;
		} 
		catch (IOException e) 
		{
			LOGGER.error("Could not decode byte[] to Image!");
		}		
		return null;
	}
		
	/*
	* Saves BufferedImage as saved.jpg and as thumbnail.jpg to given path.
	*/
	
	private static boolean saveAsJPG(BufferedImage bImage, String savePath)
		{
		File f = new File(savePath+"Photo"+File.separator+"picture.jpg");
		File tf = new File(savePath+"Photo"+File.separator+"thumbnail.jpg");
		
		if(bImage == null)
			{
				LOGGER.info("Image is null");
			}			
		else
			{
			BufferedImage bThumbnailImage = Scalr.resize(bImage, Method.QUALITY,Mode.FIT_EXACT,Play.application().configuration().getInt("thumbnail.height"),Play.application().configuration().getInt("thumbnail.width"), Scalr.OP_ANTIALIAS);
			LOGGER.info(Play.application().configuration().getInt("thumbnail.height")+" "+Play.application().configuration().getInt("thumbnail.width"));
			
			try
				{
					ImageIO.write(bImage, "jpg", f);
					ImageIO.write(bThumbnailImage, "jpg", tf);
				} 
			catch (IOException e)
				{
					LOGGER.error("Writing BufferedImage to filesystem failed!");
				}
			}
		return true;
	}
	
	
	
//	private static void thumbnailBuilder(BufferedImage img,String savePath)
//		{
//		 BufferedImage thumbImg = Scalr.resize(img, Method.QUALITY,Mode.AUTOMATIC,Play.application().configuration().getInt("thumbnail.height"),Play.application().configuration().getInt("thumbnail.width"), Scalr.OP_ANTIALIAS);
//		 File f = new File(savePath+"Photo"+File.separator+"thumbnail.jpg");
//		 
//		 ByteArrayOutputStream os = new ByteArrayOutputStream();
//		 try 
//		 {
//			ImageIO.write(thumbImg,"jpg",os);
//			ImageIO.write(thumbImg, "jpg", f);
//		 } 
//		 catch (IOException e)
//		 {
//			LOGGER.error("Could not write to File! Path: "+savePath );
//		 }  	  
//	  
//		}
//		private static String pictureEncoder(String filePath)
//		{
//			BufferedImage originalImage;
//			try 
//			{
//				originalImage = ImageIO.read(new File(filePath));
//				ByteArrayOutputStream baos = new ByteArrayOutputStream();
//				ImageIO.write(originalImage, "jpg", baos);
//				baos.flush();
//				byte[] imageInByte = baos.toByteArray();
//				baos.close();
//				return imageInByte.toString();
//			} 
//			catch (IOException e)
//			{
//				LOGGER.error("Could not read from File: "+filePath);
//			}
//			return "";		
//		}	
	}

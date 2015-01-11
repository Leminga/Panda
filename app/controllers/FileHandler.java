package controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.FileUtils;
import org.dom4j.datatype.DatatypeAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.Play;

import com.sun.prism.Image;

/*
 * Diese Klasse kümmert sich um die upgeloadeten Files.
 */

public class FileHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(FileHandler.class);

	public static void createNewFile() throws IOException {
		// File f = new File("E:"+File.separator,"Test3.txt");
		// f.createNewFile();
		// LOGGER.info("File created");
		// File f = FileSystemView.getFileSystemView().getHomeDirectory();
	
	}

	/*
	 * Build`s the Directory path´s.
	 */
	public static String pathBuilder(String vId, String prename, String surename,String event) {
		String confPath = Play.application().configuration()
				.getString("directory.path");
		String path = FileSystemView.getFileSystemView().getRoots()[0].toString();
		path += File.separator + confPath +File.separator+ event + File.separator + surename + "_"+ prename + "_" + vId + File.separator;
		
		return path;
	}
	
	/*
	 * Build`s the Directories for Volunteer`s
	 */	
	public static void directoryBuilder(String path) {
		File dir = new File(path);

		if (!dir.exists()) {
			LOGGER.info("Try to create Directories");

			if (new File(path).mkdirs() && new File(path + "Passport").mkdir()
					&& new File(path + "Photo").mkdir()
					&& new File(path + "Waiver").mkdir()) {
				LOGGER.info("Directories created");
			}
		} else {
			LOGGER.info("Directory already exist`s" + dir.exists());
		}
	}

	/*
	 * PictureDecoder erhält einen einen String und erstellt daraus ein Bild.
	 */

	public static BufferedImage PictureDecoder(String string)
			throws IOException {
		byte[] pictureByte = DatatypeConverter.parseBase64Binary(string);
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(pictureByte));
		LOGGER.info("pasrsing Image");
		return img;
	}

	/*
	 * PictureEncoder erhält ein Image und erstellt daraus eine Zeichenkette.
	 */
	private static String PictureEncoder(String filePath) throws IOException {
		BufferedImage originalImage = ImageIO.read(new File(filePath));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(originalImage, "jpg", baos);
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		return imageInByte.toString();
	}

	public static boolean SaveAsJPG(BufferedImage bImage, String savePath)
			throws IOException {
		File outputfile = new File(savePath+"Photo"+File.separator+"saved.jpg");
		outputfile.createNewFile();
		
		if(bImage == null){
			LOGGER.info("Image is null");
		}
		ImageIO.write(bImage, "jpg", outputfile);
		
		LOGGER.info(savePath+outputfile.toString()+bImage);
		
		BufferedImage thumbImg = Scalr.resize(bImage, Method.QUALITY,Mode.AUTOMATIC,50,50, Scalr.OP_ANTIALIAS);
		//convert bufferedImage to outpurstream 
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(thumbImg,"jpg",os);  
	  		  //or wrtite to a file
		  
		File f = new File(savePath+"Photo"+File.separator+"thumbnail.jpg");
		 		  
		ImageIO.write(thumbImg, "jpg", f);	
		
		return true;
	}
	
	public static void thumbnailBuilder(BufferedImage img,String savePath) throws IOException
		{
		 BufferedImage thumbImg = Scalr.resize(img, Method.QUALITY,Mode.AUTOMATIC,50,50, Scalr.OP_ANTIALIAS);
		 //convert bufferedImage to outpurstream 
		 ByteArrayOutputStream os = new ByteArrayOutputStream();
		 ImageIO.write(thumbImg,"jpg",os);  
	  
		  //or wrtite to a file
		  
		  File f = new File(savePath+"Photo"+File.separator+"thumbnail.jpg");
		  		  
		  ImageIO.write(thumbImg, "jpg", f);	  
	  
		} 	
	public static void deletDirectoriesAndFiles(String path) throws IOException
	{
		File f = new File(path);	
		FileUtils.deleteDirectory(f);
		
		File pf = f.getParentFile();
		
		if(pf.isDirectory()){
			 
			if(!(pf.list().length>0)){
	 
				FileUtils.deleteDirectory(pf);
				LOGGER.info("Parent "+pf.toString()+" removed");
	 
			}else{
	 
				LOGGER.info("Directory is not empty"+pf.list().length);
		   }		
		}
	}
}

package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.filechooser.FileSystemView;

import com.fasterxml.jackson.databind.JsonNode;

import play.Play;
import play.libs.Json;




public class JSONHelper {

	public static String objectToJsonAndPlot(Object obj)
	{
		JsonNode json = Json.toJson(obj);
		String output = Json.stringify(json);
			
		byte dataToWrite[] = output.getBytes();
		FileOutputStream out;
		try {
			out = new FileOutputStream(pathBuilder(obj));
			out.write(dataToWrite);
			out.close();
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	private static String pathBuilder(Object obj) {
		String confPath = Play.application().configuration().getString("directory.path");
		String path = FileSystemView.getFileSystemView().getRoots()[0].toString();
		path += File.separator + confPath +File.separator+ "JsonOutputs";
		new File(path).mkdirs();
		path += File.separator+ obj.getClass().getName().toString();
		
		return path;
	}
}

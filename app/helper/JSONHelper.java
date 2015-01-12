package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.filechooser.FileSystemView;

import play.Play;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class JSONHelper {

	public static String objectToJsonAndPlot(Object obj)
	{
	
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		String jsonOut = json;
		
		JsonParser parser = new JsonParser();
		gson = new GsonBuilder().setPrettyPrinting().create();
		
		JsonElement el = parser.parse(json);
		json = gson.toJson(el);
		
		byte dataToWrite[] = json.getBytes();
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
		return jsonOut;
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

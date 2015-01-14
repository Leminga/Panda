package helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.*;

public class Global extends GlobalSettings {
	/** Logger to log SecurityController events. */
	private static Logger LOGGER = LoggerFactory.getLogger(Global.class);
	
	@Override
	public void onStart(Application app) {
		// Deploy Activiti services.
		//ServicesTimer.deployProcess();
		// TESTING : Fills database with some default values.
		Starter.start();
		
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Application has started");
		}
	  }  

	@Override
	public void onStop(Application app) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Application shutdown...");
		}
	}  
}

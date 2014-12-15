package helper;

import activiti.ServicesTimer;
import play.*;

public class Global extends GlobalSettings {
	
	@Override
	  public void onStart(Application app) {
		// Deploy Activiti services.
		ServicesTimer.deployProcess();
	    Logger.info("Application has started");
	  }  

	  @Override
	  public void onStop(Application app) {
	    Logger.info("Application shutdown...");
	  }  
	  
}

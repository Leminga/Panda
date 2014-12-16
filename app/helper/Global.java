package helper;

import org.apache.commons.mail.EmailException;

import activiti.ServicesTimer;
import play.*;

public class Global extends GlobalSettings {
	
	@Override
	  public void onStart(Application app) {
		// Deploy Activiti services.
		//ServicesTimer.deployProcess();
		// Für Email-Präsentationsprozess starten
		// ServicesTimer.startProcess();
		
		//mailer test
		/*try {
			mailer.Mail.sendMail();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		
	    Logger.info("Application has started");
	  }  

	  @Override
	  public void onStop(Application app) {
	    Logger.info("Application shutdown...");
	  }  
	  
}

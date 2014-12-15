package activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.commons.mail.EmailException;



public class StepOneTwo implements JavaDelegate{

	//public final static Object Test;
	
	
	@Override
	public void execute(DelegateExecution execution) throws Exception,EmailException {
		// TODO Auto-generated method stub
		
		//mailer.mail.sendMail();
		//System.out.println("Mail versandt");
		
		System.out.println("Das ist Step 1-2 : "+(System.currentTimeMillis())/1000);
	   
		
	    System.out.println("Activiti ID ist: "+execution.getCurrentActivityId());
	    System.out.println("Activiti Name ist: "+execution.getCurrentActivityName());
		
	}

}

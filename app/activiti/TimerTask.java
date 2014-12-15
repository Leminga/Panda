package activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.commons.mail.EmailException;

public class TimerTask implements JavaDelegate {

	

	@Override
	public void execute(DelegateExecution execution) throws EmailException {
		// TODO Auto-generated method stub

/*
		System.out.println("Timer ID ist: "
				+ execution.getCurrentActivityId());
		System.out.println("Activiti Name ist: "
				+ execution.getCurrentActivityName());
*/
		
		
		System.out.println("Mail Task follows");
		mailer.Mail.sendMail();
		System.out.println("Mail Task done");
		
	}

}

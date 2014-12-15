package activiti;

import org.activiti.engine.delegate.DelegateExecution;
import controllers.SecurityController;
import org.activiti.engine.delegate.JavaDelegate;

public class Logout implements JavaDelegate {

	

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub


		System.out.println("Pre-Logout");
		SecurityController.logout();
		System.out.println("Logout");
	
		
		
	}

}

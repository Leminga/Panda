package activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class StepOne implements JavaDelegate {

	

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Das ist Step1 : " + (System.currentTimeMillis())
				/ 1000);


		System.out.println("Activiti ID ist: "
				+ execution.getCurrentActivityId());
		System.out.println("Activiti Name ist: "
				+ execution.getCurrentActivityName());

		int now = (int) System.currentTimeMillis();
		int then = (int) System.currentTimeMillis()+30000;
		int i =0;
		System.out.println("vorher "+ now);
		System.out.println("danach "+ then);
		
		while (then >= now) {
			Thread.sleep(2000);
			i++;
			now = (int) System.currentTimeMillis();
			System.out.println("while schleife : "+ i+" ---jetzt ist: "+now);
		}
		System.out.println("Step ONE done");
	
		
		
	}

}

package activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;



public class StepTwo implements JavaDelegate{

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		// TODO Auto-generated method stub
		
		Thread.sleep(2000);
		System.out.println("Das ist Step 2 : "+(System.currentTimeMillis())/1000);
		
		
	}

}

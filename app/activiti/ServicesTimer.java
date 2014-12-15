package activiti;



import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;



public class ServicesTimer {
	
	static ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti/resources/activiti.cfg.xml").buildProcessEngine();

		public static void startProcess() {

	
			RuntimeService runtimeService = processEngine.getRuntimeService();
			ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("TimeProcess");
			
			System.out.println("Die id des Timer-Processes ist aktuell " + processInstance.getId() + " "	+ processInstance.getProcessDefinitionId());
			
		}
		
		public static void deployProcess(){
			
			RepositoryService repositoryService = processEngine.getRepositoryService();
			repositoryService.createDeployment().addClasspathResource("activiti/resources/diagrams/TimeProcess3.bpmn20.xml").deploy();
		}
		
}

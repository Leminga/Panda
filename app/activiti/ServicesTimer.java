package activiti;



import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ServicesTimer {
	/** Logger to log SecurityController events. */
	private static Logger LOGGER = LoggerFactory.getLogger(ServicesTimer.class);
	
	static ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti/resources/activiti.cfg.xml").buildProcessEngine();

	public static void startProcess() {
		RuntimeService runtimeService = processEngine.getRuntimeService();
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("TimeProcess");
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("ServicesTimer started with process instance id: " + processInstance.getId());
		}
	}
		
	public static void deployProcess(){
		RepositoryService repositoryService = processEngine.getRepositoryService();
		repositoryService.createDeployment().addClasspathResource("activiti/resources/diagrams/TimeProcess3.bpmn20.xml").deploy();
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("ServicesTimer deployed");
		}
	}	
}

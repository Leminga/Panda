package activiti;

import static org.junit.Assert.*;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

public class ServicesTimerTest {
	@Test
	public void startProcess()  {
		
		ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti/resources/activiti.cfg.xml").buildProcessEngine();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		RepositoryService repositoryService = processEngine
				.getRepositoryService();
		repositoryService.createDeployment()
				.addClasspathResource("activiti/resources/diagrams/TimeProcess3.bpmn20.xml").deploy();
		ProcessInstance processInstance =runtimeService.startProcessInstanceByKey("TimeProcess");	
		assertNotNull(processInstance.getId());
		System.out.println("Die Time id des Processes ist aktuell " + processInstance.getId() + " "
				+ processInstance.getProcessDefinitionId());
		
	
	}

}

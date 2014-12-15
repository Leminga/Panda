package activiti;

//import static org.junit.Assert.assertNotNull;

import org.activiti.engine.FormService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;



public class Services {
	
	private static ProcessEngine processEngine;
    private final static boolean DEPLOY_PROCESS = true;
    private final static String process="activiti/resources/diagrams/process.bpmn20.xml";

    static {
        instantiateProcessEngine();
    }

     
    private synchronized static void instantiateProcessEngine() {
        setProcessEngine(ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault().buildProcessEngine());

     

            if (DEPLOY_PROCESS) {
                for (ProcessDefinition definition : getRepositoryService().createProcessDefinitionQuery().processDefinitionName(process).list()) {
                    if (!definition.isSuspended()) {
                        getRepositoryService().suspendProcessDefinitionById(definition.getId());
                        System.err.println("Processdefintion " + definition.getName() + "(" + definition.getId() + ")" + " suspended");
                    }
                }

                deployProcess(process);
                //RuntimeService runtimeService = processEngine.getRuntimeService();
                //ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("ProcessOne");

        }
    }
   
     
    public synchronized static void deployProcess(String processDefinition) {
        getRepositoryService().createDeployment()
                .addClasspathResource(process)
                .name(processDefinition)
                .deploy();

        System.out.println("Deployment " + processDefinition + " created");
    }
    
     
    public static void testProcess() {
        Services.getRuntimeService().createProcessInstanceQuery().processInstanceId("ProcessOne").singleResult();
        
        System.out.println("Process tested");
    }

     
    public synchronized static RuntimeService getRuntimeService() {
        if (getProcessEngine() == null) {
            instantiateProcessEngine();
        }
        return getProcessEngine().getRuntimeService();
    }

     
    public synchronized static RepositoryService getRepositoryService() {
        if (getProcessEngine() == null) {
            instantiateProcessEngine();
        }
        return getProcessEngine().getRepositoryService();
    }

     
    public synchronized static TaskService getTaskService() {
        if (getProcessEngine() == null) {
            instantiateProcessEngine();
        }
        return getProcessEngine().getTaskService();
    }

     
    public synchronized static FormService getFormService() {
        if (getProcessEngine() == null) {
            instantiateProcessEngine();
        }
        return getProcessEngine().getFormService();
    }

    /**
     * @return the processEngine
     */
     
    public synchronized static ProcessEngine getProcessEngine() {
        return processEngine;
    }

    /**
     * @param aProcessEngine the processEngine to set
     */
     
    public synchronized static void setProcessEngine(ProcessEngine aProcessEngine) {
        processEngine = aProcessEngine;
    }
   
    
   

}

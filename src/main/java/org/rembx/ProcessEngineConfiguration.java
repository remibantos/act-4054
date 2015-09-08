package org.rembx;


import org.activiti.cdi.CdiStandaloneProcessEngineConfiguration;
import org.activiti.cdi.spi.ProcessEngineLookup;
import org.activiti.engine.ProcessEngine;

public class ProcessEngineConfiguration  implements ProcessEngineLookup{
    private ProcessEngine processEngine;

    public int getPrecedence() {
        return 10;
    }



    public ProcessEngine getProcessEngine() {
        CdiStandaloneProcessEngineConfiguration processEngineConfiguration = new CdiStandaloneProcessEngineConfiguration();
        processEngineConfiguration.setProcessEngineName("cdiStandaloneEngine1");
        processEngineConfiguration
                .setJdbcUrl("jdbc:h2:mem:activiti;DB_CLOSE_DELAY=1000");
        processEngineConfiguration.setJdbcDriver("org.h2.Driver");
        processEngineConfiguration.setJdbcUsername("sa");
        processEngineConfiguration.setJdbcPassword("");
        processEngineConfiguration.setDatabaseSchemaUpdate("true");
        
        processEngineConfiguration.setTransactionsExternallyManaged(false);
        // DISABLE JOB EXECUTOR AS THERE IS ANOTHER ProcessEngine INSTANCE WITH ENABLED ONE THROUGH ACTIVITI-REST
        processEngineConfiguration.setJobExecutorActivate(false);
        processEngineConfiguration.setAsyncExecutorEnabled(false);
        processEngineConfiguration.setAsyncExecutorActivate(false);
        processEngine = processEngineConfiguration.buildProcessEngine();
        return processEngine;
    }

    public void ungetProcessEngine() {
        processEngine.close();
        processEngine = null;
    }

}

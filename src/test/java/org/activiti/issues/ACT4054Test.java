package org.activiti.issues;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ACT4054Test {

    protected static Weld weld;
    protected static WeldContainer container;

    @Rule
    public ActivitiRule activitiRule = new ActivitiRule();

    @BeforeClass
    public static void initWeldContainer() {
        weld = new Weld();
        container = weld.initialize();
    }


    @AfterClass
    public static void close() {
        weld.shutdown();
    }


    @Test
    @Deployment(resources = {"fake-process.bpmn20.xml"})
    public void shouldReproduceIssueACT4054_givenProcessWithAsyncTasks() throws InterruptedException {

        ProcessInstance processInstance = activitiRule.getRuntimeService().startProcessInstanceByKey("act-4054");

        assertNotNull(processInstance);

/*        Task task = activitiRule.getTaskService().createTaskQuery().singleResult();

        assertEquals("Activiti is awesome!", task.getName());*/
    }

}


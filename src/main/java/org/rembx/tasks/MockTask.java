package org.rembx.tasks;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;

@Named
public class MockTask implements JavaDelegate {
    Logger LOG = LoggerFactory.getLogger(JavaDelegate.class);
    
	@Override public void execute(DelegateExecution delegateExecution) throws Exception {
        LOG.debug("Executing mock task - thread ID: {} ...",Thread.currentThread().getId());
	}
}

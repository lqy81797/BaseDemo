package com.ie.test;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class ActivitiTest {
	ProcessEngineConfiguration configuration=null;
	ProcessEngine processEngine = null;
	{
		configuration=ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti_test.cfg.xml");
		processEngine=configuration.buildProcessEngine();
	}

	@Test
	public void deploymentProcessDefinition() {
		Deployment deploy = processEngine.getRepositoryService()
				.createDeployment()
				.name("exam")
				.addClasspathResource("diagrams/exam.bpmn")
				.addClasspathResource("diagrams/exam.png")
				.deploy();
		System.out.println(deploy.getId());
		System.out.println(deploy.getName());
	}

	@Test
	public void startProcess() {
		String key = "exam";
		ProcessInstance instance = processEngine.getRuntimeService()
				.startProcessInstanceByKey(key);
		System.out.println(instance.getId());
		System.out.println(instance.getProcessDefinitionId());
	}
	
	@Test
	public void findMyPersonalTask() {
		List<Task> list = processEngine.getTaskService()
				.createTaskQuery()
				.processDefinitionKey("exam")
				.list();
		if(list != null && list.size() > 0){
			for(Task task : list) {
				System.out.println(task.getId());
				System.out.println(task.getName());
			}
		}
	}
}

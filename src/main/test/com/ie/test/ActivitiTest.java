package com.ie.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskInfoQuery;
import org.activiti.engine.task.TaskQuery;
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
		assert(deploy.getName() == "exam");
	}

	@Test
	public void startProcess() {
		String key = "exam";
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("inputUser", "userName");
		String objId = key + "." + "id";
		variables.put("objId", objId);
		ProcessInstance instance = processEngine.getRuntimeService().startProcessInstanceByKey(key, objId, variables);
		assert(instance.getProcessVariables().get("inputUser") == "userName");
		assert(instance.getProcessVariables().get("objId") == "exam.id");
	}
	
	@Test
	public void findMyPersonalTask() {
		List<Task> list = processEngine.getTaskService()
				.createTaskQuery()
				.processDefinitionKey("exam")
				.list();
		if(list != null && list.size() > 0){
			for(Task task : list) {
				assert(task.getName() == "申请考试");
			}
		}
	}
	
	@Test
	public void complete() {
		List<Task> list = processEngine.getTaskService()
				.createTaskQuery()
				.processDefinitionKey("exam")
				.list();
		if(list != null && list.size() > 0){
			for(Task task : list) {
				processEngine.getTaskService().complete(task.getId());
				assert(task.getName() == "审批考试");
				assert((processEngine.getTaskService()
						.createTaskQuery()
						.taskAssignee("teacher")
						.list().size() > 0));
			}
		}
	}
}

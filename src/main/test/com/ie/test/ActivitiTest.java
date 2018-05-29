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
	/**使用代码创建工作流需要的23张表*/
	@Test
	public void createTable(){
		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		//连接数据库的配置
		processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
		processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/activiti?useUnicode=true&characterEncoding=utf8");
		processEngineConfiguration.setJdbcUsername("root");
		processEngineConfiguration.setJdbcPassword("admin");
		
		/**
		 	public static final String DB_SCHEMA_UPDATE_FALSE = "false";不能自动创建表，需要表存在
  			public static final String DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop";先删除表再创建表
  			public static final String DB_SCHEMA_UPDATE_TRUE = "true";如果表不存在，自动创建表
		 */
		processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		//工作流的核心对象，ProcessEnginee对象
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		System.out.println("processEngine:"+processEngine);
	}
	//使用配置文件创建23张表
	@Test
	public void createTable_2() {
		ProcessEngineConfiguration configuration=ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
		ProcessEngine engine=configuration.buildProcessEngine();
		System.out.println(engine);
	}

	/**部署流程定义*/
	@Test
	public void deploymentProcessDefinition(){
		Deployment deployment = processEngine.getRepositoryService()//与流程定义和部署对象相关的Service
						.createDeployment()//创建一个部署对象
						.name("helloworld入门程序")//添加部署的名称
						.addClasspathResource("diagrams/helloworld.bpmn")//从classpath的资源中加载，一次只能加载一个文件
						.addClasspathResource("diagrams/helloworld.png")//从classpath的资源中加载，一次只能加载一个文件
						.deploy();//完成部署
		System.out.println("部署ID："+deployment.getId());//1
		System.out.println("部署名称："+deployment.getName());//helloworld入门程序  
	}
	/**启动流程实例*/
	@Test
	public void startProcessInstance(){
		//流程定义的key
		String processDefinitionKey = "helloworld";
		ProcessInstance pi = processEngine.getRuntimeService()//与正在执行的流程实例和执行对象相关的Service
						.startProcessInstanceByKey(processDefinitionKey);//使用流程定义的key启动流程实例，key对应helloworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
		System.out.println("流程实例ID:"+pi.getId());//流程实例ID    101
		System.out.println("流程定义ID:"+pi.getProcessDefinitionId());//流程定义ID   helloworld:1:4
	}
	/**查询当前人的个人任务*/
	@Test
	public void findMyPersonalTask(){
		String assignee = "张三";
		List<Task> list = processEngine.getTaskService()//与正在执行的任务管理相关的Service
						.createTaskQuery()//创建任务查询对象
						.taskAssignee(assignee)//指定个人任务查询，指定办理人
						.list();
		if(list!=null && list.size()>0){
			for(Task task:list){
				System.out.println("任务ID:"+task.getId());
				System.out.println("任务名称:"+task.getName());
				System.out.println("任务的创建时间:"+task.getCreateTime());
				System.out.println("任务的办理人:"+task.getAssignee());
				System.out.println("流程实例ID："+task.getProcessInstanceId());
				System.out.println("执行对象ID:"+task.getExecutionId());
				System.out.println("流程定义ID:"+task.getProcessDefinitionId());
				System.out.println("########################################################");
			}
		}
	}
	/**完成我的任务*/
	@Test
	public void completeMyPersonalTask(){
		//任务ID
		String taskId = "7502";
		processEngine.getTaskService()//与正在执行的任务管理相关的Service
					.complete(taskId);
		System.out.println("完成任务：任务ID："+taskId);
	}

}

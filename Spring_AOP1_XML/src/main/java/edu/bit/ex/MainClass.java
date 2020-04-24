package edu.bit.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:root-context.xml");
		Student student = (Student)ctx.getBean("student");
		student.getStudentInfo();
		
		Worker worker = (Worker)ctx.getBean("worker");
		worker.getWorkerInfo();
		
		ctx.close();
	}
}

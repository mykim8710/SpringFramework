package edu.bit.ex;

public class Worker {
	private String name;
	private int age;
	private String job;

	public Worker() {}

	// 핵심기능
	public void getWorkerInfo() {
		System.out.println("이름은 : " + getName());
		System.out.println("나이는 : " + getAge());
		System.out.println("직업은 : " + getJob());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}

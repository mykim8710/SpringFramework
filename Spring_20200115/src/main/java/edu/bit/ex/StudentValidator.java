package edu.bit.ex;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Student.class.isAssignableFrom(arg0); // 검증할 객체의 클래스 타입정보
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("validate() 메서드 실행");

		Student student = (Student) obj;

		String studentName = student.getName();

		if (studentName == null || studentName.trim().isEmpty()) {
			System.out.println("studentName is null or error");
			errors.rejectValue("name", "trouble");
		}

		int studentAge = student.getAge();

		if (studentAge == 0) {
			System.out.println("studentAge is 0");
			errors.rejectValue("age", "trouble");
		}
	}

}

package edu.bit.member;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class MemberValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return Member.class.isAssignableFrom(arg0); // 검증할 객체의 클래스 타입정보
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("validate() 메서드 실행");
		
		Member member = (Member)obj;
		
		String memberId = member.getId();
		
		if(memberId == null || memberId.trim().isEmpty()) {
			System.out.println("아이디가 입력되지않거나 공백이 있습니다.");
			errors.reject("id", "trouble");
		}
		
		String memberPw = member.getPw();
		if(memberPw == null || memberPw.trim().isEmpty()) {
			System.out.println("패스워드가 입력되지않거나 공백이 있습니다.");
			errors.reject("pw", "trouble");
		}
	}

}

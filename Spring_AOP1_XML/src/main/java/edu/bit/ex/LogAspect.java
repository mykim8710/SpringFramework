package edu.bit.ex;

import org.aspectj.lang.ProceedingJoinPoint;

// 공통기능을 가지는 Aspect 클래스 정의
public class LogAspect {

	//  공통기능 Advice 메서드1  정의
	public void printLogging() {
		System.out.println("LogAdvice : printLogging() 메서드 실행");
	}
	
	//  공통기능 Advice 메서드2 정의
	public Object loggerAOP(ProceedingJoinPoint joinPoint) throws Throwable{
		String signatureStr = joinPoint.getSignature().toShortString();
		// joinPoint객체 : 핵심기능 메서드를 담은 객체
		System.out.println(signatureStr +" is Start");
		
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinPoint.proceed(); // 핵심기능을 수행하는 JointPoint 메서드의 호출
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr +" is finished");
			System.out.println(signatureStr + " 구동시간 : " +(et-st)/1000.0 +"s");
		}
	}
}

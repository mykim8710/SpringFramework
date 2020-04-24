package edu.bit.ex;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectClass {
	//  공통기능1 Advice메서드
//	@Pointcut("within(edu.bit.ex.*)")
//	public void publicM() {}
//	
//	@Before("publicM()")
//	public void printLogging() {
//		System.out.println("LogAdvice : printLogging() 메서드 실행");
//	}
//	
	// 공통기능2 Advice메서드
	@Pointcut("within(edu.bit.ex.*)")
	public void publicM2() {}
	
	@Around("publicM2()")
	public Object loggerAOP(ProceedingJoinPoint joinPoint) throws Throwable{ 
		String signatureStr = joinPoint.getSignature().toShortString();
		System.out.println(signatureStr +" is Start");
		
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr +" is finished");
			System.out.println(signatureStr + " 구동시간 : " +(et-st)/1000.0 +"s");
		}
	}
}

package practice.aspects;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import practice.model.Authorization;

public class Logger {
    private ApplicationContext applicationContext;

    public void beforeMethod(JoinPoint joinPoint){
        Authorization authorization = applicationContext.getBean("Authorized", Authorization.class);
        System.out.println("*********************************************");
        System.out.println("Authorized : " + authorization.getAuthorized());
        System.out.println("Log before method: " + joinPoint.getSignature().toShortString());
        System.out.println("*********************************************");
    }

    public void afterReturn(JoinPoint joinPoint, Object result){
        System.out.println("*********************************************");
        System.out.println(joinPoint.getSignature().getName() + " method of " +
                joinPoint.getTarget().toString() + " was invoked!");
        System.out.println("Result of method: " + result);
        System.out.println("Method invoked successfully!");
        System.out.println("*********************************************");
    }

    public void afterThrowing(Exception ex){
        System.out.println("*********************************************");
        System.out.println("Exception: " + ex.getMessage());
        System.out.println("*********************************************");
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}

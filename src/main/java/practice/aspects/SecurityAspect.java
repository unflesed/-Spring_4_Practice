package practice.aspects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import practice.exceptions.NotAuthorizedException;
import practice.model.Authorization;

public class SecurityAspect {
    private ApplicationContext applicationContext;


    public void checkAuthorize(){
        Authorization authorization = applicationContext.getBean("Authorized", Authorization.class);
        if (!authorization.getAuthorized()) {
            throw new NotAuthorizedException("User is not authorized!");
        }
    }
    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}

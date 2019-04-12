package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Auth {

    @Before("execution(* db..*.*(..))")
    public Object authenticate(ProceedingJoinPoint jp) throws Throwable {
        boolean auth = true;
        if(auth) {
            System.out.println(jp.getSignature() + "Authenticated student");
            return jp.proceed();
        } else {
            System.out.println(jp.getSignature() + "Not authenticated student");
            return null ;
        }
    }
}

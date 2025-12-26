package aktar.Employee.Management.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    //this is pointcut define it once use it everywhere it basically meanse this need to perform
    @Pointcut("execution(* aktar.Employee.Management.service.impl.EmployeeService.getAllEmployee(..))")
    public void anyOldTransfer() {

    }

    @Before("execution(* aktar.Employee.Management.service.impl.EmployeeService.getAllEmployee(..))")
    public void beforeLog() {
        logger.info("Before get employee method Aspect log are getting called");
    }

    @After("anyOldTransfer()")
    public void afterLog() {
        logger.info("After get employee method Aspect log are getting called");
    }

    @Around("anyOldTransfer()")
    public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Around BEFORE execution");
        Object message = proceedingJoinPoint.proceed();
        logger.info("Around AFTER execution");
        return message;
    }
}

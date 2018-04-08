package com.asierg.spring.aop;

import com.asierg.spring.annotations.LogSampleMethod;
import com.asierg.spring.model.Action;
import com.asierg.spring.service.ActionService;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogSampleActionAspect {

    private static final Logger LOG = Logger.getLogger(LogSampleActionAspect.class);

    @Autowired
    private ActionService actionService;

    @Around("execution(@com.asierg.spring.annotations.LogSampleMethod * com.asierg.spring.service.impl.*.*(..))")
    public Object logDAOAction(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result = null;
        // start job
        result = joinPoint.proceed();
        // log action
        try {
            Signature signature = joinPoint.getSignature();
            Method method = ((MethodSignature) signature).getMethod();

            for (Object obj : joinPoint.getArgs()) {
                Method objectMethod = null;
                try {
                    objectMethod = joinPoint.getTarget().getClass().getMethod(method.getName(), obj.getClass());
                } catch (NoSuchMethodException nsme) {
                    // If we are working with superclass, we will check it
                    objectMethod = joinPoint.getTarget().getClass().getMethod(method.getName(),
                            obj.getClass().getSuperclass());
                }

                if (objectMethod != null) {
                    createAction(obj, objectMethod);
                }
            }

        } catch (Exception e) {
            LOG.error("There was an error in Log Aspect : ", e);
        }

        return result;
    }

    private void createAction(Object obj, Method objectMethod)
            throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {

        LogSampleMethod limited = objectMethod.getAnnotation(LogSampleMethod.class);
        LogSampleMethod.Action actionParam = limited.action();

        Long entityId = null;

        // search by GET method
        for (Method entityMethod : obj.getClass().getMethods()) {
            if (entityMethod.isAnnotationPresent(javax.persistence.Id.class)) {
                entityId = (Long) entityMethod.invoke(obj, new Object[]{});
            }
        }
        // search by attribute
        for (Field entityField : obj.getClass().getFields()) {
            if (entityField.isAnnotationPresent(javax.persistence.Id.class)) {
                entityId = (Long) entityField.get(obj);
            }
        }
        if (entityId != null) {
            Action action = new Action();
            action.setDate(new Date());
            action.setEntityId(entityId);
            action.setType(actionParam.name());
            actionService.createAction(action);
        }
    }

}

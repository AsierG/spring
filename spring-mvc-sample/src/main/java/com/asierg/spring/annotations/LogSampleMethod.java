package com.asierg.spring.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogSampleMethod {

    enum Action {
        VIEW, CREATE, UPDATE, DELETE
    }

    Action action() default Action.VIEW;

}

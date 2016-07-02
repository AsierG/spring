package com.asierg.spring.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogSampleMethod {

	public enum Action {
		VIEW, CREATE, UPDATE, DELETE
	}

	public Action action() default Action.VIEW;

}

package com.hackbulgaria.programming101.week09;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ClassInformation {
	String author();

	double revision() default 1.;

	boolean checked() default true;

	Class<?>[] relatedClasses();
}

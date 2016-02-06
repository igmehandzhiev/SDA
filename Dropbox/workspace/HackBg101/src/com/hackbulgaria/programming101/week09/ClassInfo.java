package com.hackbulgaria.programming101.week09;

import java.lang.annotation.Annotation;

@ClassInformation(author = "Ivan Mehandzhiev", relatedClasses = { ClassInfo.class })
public class ClassInfo {
	public static void main(String[] args) {
		ClassInfo ci = new ClassInfo();
		for (Annotation annotation : ci.getClass().getAnnotations()) {
			System.out.println(annotation.toString());
		}
		ClassInformation anno = ci.getClass().getAnnotation(
				ClassInformation.class);
		System.out.println(anno.author());
		System.out.println(anno.checked());
		System.out.println(anno.revision());
		System.out.println(anno.relatedClasses());
	}
}

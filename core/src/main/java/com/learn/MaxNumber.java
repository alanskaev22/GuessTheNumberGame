package com.learn;


import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD}) // where it will be applied
@Retention(RetentionPolicy.RUNTIME) // life of annotations
@Qualifier
public @interface MaxNumber {

}

package edu.tju.scs.tinynetbackend.common.Annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: liyuze
 * @Description:
 * @Date: Created in 00:51 18/12/12.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface JWTAuth {
    String value();
}
